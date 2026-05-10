from functools import reduce
from dateutil import parser
import threading
import socket
import time
import datetime

# Dictionary to store client data
client_data = {}

# Receive clock time from clients
def startReceivingClockTime(connector, address):
    while True:
        try:
            clock_time_string = connector.recv(1024).decode()

            if not clock_time_string:
                break

            client_time = parser.parse(clock_time_string)

            # Calculate time difference
            time_difference = client_time - datetime.datetime.now()

            client_data[address] = {
                "clock_time": client_time,
                "time_difference": time_difference,
                "connector": connector
            }

            print(f"Updated client data from {address}")

            time.sleep(5)

        except Exception as e:
            print(f"Connection lost with {address}")
            if address in client_data:
                del client_data[address]
            break


# Accept client connections
def startConnecting(master_server):
    while True:
        master_slave_connector, addr = master_server.accept()

        slave_address = str(addr[0]) + ":" + str(addr[1])

        print(slave_address + " connected successfully")

        current_thread = threading.Thread(
            target=startReceivingClockTime,
            args=(master_slave_connector, slave_address)
        )

        current_thread.daemon = True
        current_thread.start()


# Calculate average clock difference
def getAverageClockDiff():

    if len(client_data) == 0:
        return datetime.timedelta(0)

    time_difference_list = [
        client['time_difference']
        for client in client_data.values()
    ]

    total_difference = reduce(
        lambda x, y: x + y,
        time_difference_list,
        datetime.timedelta(0)
    )

    average_difference = total_difference / len(time_difference_list)

    return average_difference


# Synchronize all clocks using Berkeley Algorithm
def synchronizeAllClocks():

    while True:

        print("\nNew synchronization cycle started")
        print("Clients connected:", len(client_data))

        if len(client_data) > 0:

            average_clock_difference = getAverageClockDiff()

            for client_addr, client in client_data.items():

                try:
                    # Adjustment to be applied by client
                    adjustment = (
                        average_clock_difference -
                        client['time_difference']
                    )

                    adjustment_seconds = adjustment.total_seconds()

                    client['connector'].send(
                        str(adjustment_seconds).encode()
                    )

                    print(
                        f"Sent adjustment {adjustment_seconds} sec to {client_addr}"
                    )

                except Exception as e:
                    print(f"Error synchronizing {client_addr}")

        else:
            print("No client data available")

        time.sleep(5)


# Start Clock Server
def initiateClockServer(port=8080):

    master_server = socket.socket()

    master_server.setsockopt(
        socket.SOL_SOCKET,
        socket.SO_REUSEADDR,
        1
    )

    print("Socket created successfully")

    master_server.bind(('', port))

    master_server.listen(10)

    print(f"Clock Server started on port {port}")

    # Thread for accepting connections
    master_thread = threading.Thread(
        target=startConnecting,
        args=(master_server,)
    )

    master_thread.daemon = True
    master_thread.start()

    # Thread for synchronization
    sync_thread = threading.Thread(
        target=synchronizeAllClocks
    )

    sync_thread.daemon = True
    sync_thread.start()

    while True:
        time.sleep(1)


# Driver Code
if __name__ == '__main__':
    initiateClockServer(port=8080)