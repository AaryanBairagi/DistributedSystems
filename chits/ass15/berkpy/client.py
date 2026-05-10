from dateutil import parser
import threading
import datetime
import socket
import time

# Simulated client clock offset
client_time_offset = datetime.timedelta(seconds=0)


# Function to get client's local time
def getClientTime():
    return datetime.datetime.now() + client_time_offset


# Send local time to server
def startSendingTime(slave_client):

    while True:

        try:
            current_time = getClientTime()

            slave_client.send(str(current_time).encode())

            print("Time sent to server:", current_time)

            time.sleep(5)

        except Exception as e:
            print("Connection to server lost")
            break


# Receive synchronization adjustment from server
def startReceivingTime(slave_client):

    global client_time_offset

    while True:

        try:
            adjustment = float(
                slave_client.recv(1024).decode()
            )

            # Apply adjustment
            client_time_offset += datetime.timedelta(
                seconds=adjustment
            )

            synchronized_time = getClientTime()

            print("\nClock adjusted by:", adjustment, "seconds")
            print("New synchronized client time:", synchronized_time)

        except Exception as e:
            print("Failed to receive synchronized time")
            break


# Start Client
def initiateSlaveClient(port=8080):

    slave_client = socket.socket()

    slave_client.connect(('127.0.0.1', port))

    print("Connected to Clock Server")

    # Thread for sending time
    send_time_thread = threading.Thread(
        target=startSendingTime,
        args=(slave_client,)
    )

    send_time_thread.daemon = True
    send_time_thread.start()

    # Thread for receiving adjustment
    receive_time_thread = threading.Thread(
        target=startReceivingTime,
        args=(slave_client,)
    )

    receive_time_thread.daemon = True
    receive_time_thread.start()

    while True:
        time.sleep(1)


# Driver Code
if __name__ == '__main__':
    initiateSlaveClient(port=8080)