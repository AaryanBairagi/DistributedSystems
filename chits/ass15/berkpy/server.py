# =========================================================
# Berkeley Clock Synchronization - Server Program
# =========================================================

# ---------------- IMPORT REQUIRED MODULES ----------------

# Used to calculate average using reduce()
from functools import reduce

# Used to parse datetime string received from clients
from dateutil import parser

# Used for multithreading
import threading

# Used for socket programming
import socket

# Used to add delay
import time

# Used for current date and time
import datetime


# =========================================================
# DATA STRUCTURE
# =========================================================
# Dictionary used to store:
# 1. Client address
# 2. Client clock time
# 3. Time difference
# 4. Client socket connector
# =========================================================

client_data = {}


# =========================================================
# FUNCTION: RECEIVE CLOCK TIME FROM CLIENT
# =========================================================
# This function continuously receives current time
# from connected clients/slaves.
# =========================================================

def startReceivingClockTime(connector, address):

    while True:

        # Receive clock time from client
        clock_time_string = connector.recv(1024).decode()

        # Convert string into datetime object
        clock_time = parser.parse(clock_time_string)

        # Calculate time difference between:
        # Server time - Client time
        clock_time_diff = datetime.datetime.now() - clock_time

        # Store client information
        client_data[address] = {

            "clock_time": clock_time,

            "time_difference": clock_time_diff,

            "connector": connector
        }

        print("Client data updated for:", address)

        # Wait for 5 seconds
        time.sleep(5)


# =========================================================
# FUNCTION: ACCEPT CLIENT CONNECTIONS
# =========================================================
# This function continuously accepts clients and
# creates separate thread for each client.
# =========================================================

def startConnecting(master_server):

    while True:

        # Accept new client connection
        master_slave_connector, addr = master_server.accept()

        # Convert address into readable form
        slave_address = str(addr[0]) + ":" + str(addr[1])

        print(slave_address, "connected successfully")

        # Create thread to receive time from this client
        current_thread = threading.Thread(

            target = startReceivingClockTime,

            args = (master_slave_connector, slave_address)
        )

        current_thread.start()


# =========================================================
# FUNCTION: CALCULATE AVERAGE CLOCK DIFFERENCE
# =========================================================
# Finds average difference between:
# Server clock and all client clocks
# =========================================================

def getAverageClockDiff():

    # Create list of all time differences
    time_difference_list = [

        client['time_difference']

        for client_addr, client in client_data.items()
    ]

    # Calculate total clock difference
    sum_of_clock_difference = reduce(

        lambda x, y: x + y,

        time_difference_list,

        datetime.timedelta(0, 0)
    )

    # Calculate average difference
    average_clock_difference = (

        sum_of_clock_difference / len(client_data)
    )

    return average_clock_difference


# =========================================================
# FUNCTION: SYNCHRONIZE ALL CLIENT CLOCKS
# =========================================================
# Sends synchronized time to all connected clients.
# =========================================================

def synchronizeAllClocks():

    while True:

        print("\nNew synchronization cycle started")

        print("Clients connected:", len(client_data))

        # Synchronize only if clients exist
        if len(client_data) > 0:

            # Get average clock difference
            average_clock_difference = getAverageClockDiff()

            # Send synchronized time to each client
            for client_addr, client in client_data.items():

                print("Synchronizing:", client_addr)

                try:

                    # Generate synchronized time
                    synchronized_time = (

                        datetime.datetime.now()

                        + average_clock_difference
                    )

                    # Send synchronized time
                    client['connector'].send(

                        str(synchronized_time).encode()
                    )

                except Exception as e:

                    print(

                        "Error while synchronizing",

                        client_addr
                    )

        else:

            print("No clients connected")

        print("\n")

        # Wait for 5 seconds
        time.sleep(5)


# =========================================================
# FUNCTION: INITIALIZE CLOCK SERVER
# =========================================================
# Creates:
# 1. Server socket
# 2. Connection thread
# 3. Synchronization thread
# =========================================================

def initiateClockServer(port = 8080):

    # Create server socket
    master_server = socket.socket()

    # Reuse socket address
    master_server.setsockopt(

        socket.SOL_SOCKET,

        socket.SO_REUSEADDR,

        1
    )

    print("Socket created successfully\n")

    # Bind socket to port
    master_server.bind(('', port))

    # Start listening
    master_server.listen(10)

    print("Clock Server Started...\n")

    print("Waiting for client connections...\n")


    # -----------------------------------------------------
    # THREAD 1 -> ACCEPT CLIENT CONNECTIONS
    # -----------------------------------------------------

    master_thread = threading.Thread(

        target = startConnecting,

        args = (master_server,)
    )

    master_thread.start()


    # -----------------------------------------------------
    # THREAD 2 -> SYNCHRONIZE CLIENT CLOCKS
    # -----------------------------------------------------

    print("Starting synchronization process...\n")

    sync_thread = threading.Thread(

        target = synchronizeAllClocks,

        args = ()
    )

    sync_thread.start()


# =========================================================
# DRIVER CODE
# =========================================================

if __name__ == '__main__':

    # Start Clock Server
    initiateClockServer(port = 8080)