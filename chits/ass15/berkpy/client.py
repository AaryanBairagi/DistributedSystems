# =========================================================
# Berkeley Clock Synchronization - Client Process
# =========================================================

# ---------------- IMPORT REQUIRED MODULES ----------------

# Used to parse date-time strings received from server
from dateutil import parser

# Used for multithreading
import threading

# Used for current date and time
import datetime

# Used for socket programming
import socket

# Used to add delay
import time


# =========================================================
# FUNCTION: SEND CLIENT TIME TO SERVER
# =========================================================
# This function continuously sends the client's current
# system time to the server every 5 seconds.
# =========================================================

def startSendingTime(slave_client):

    while True:

        # Get current client time
        current_time = str(datetime.datetime.now())

        # Send encoded time to server
        slave_client.send(current_time.encode())

        print("Recent time sent successfully")

        # Wait for 5 seconds
        time.sleep(5)


# =========================================================
# FUNCTION: RECEIVE SYNCHRONIZED TIME FROM SERVER
# =========================================================
# This function continuously receives the synchronized
# clock time calculated by the server.
# =========================================================

def startReceivingTime(slave_client):

    while True:

        # Receive synchronized time from server
        synchronized_time = slave_client.recv(1024).decode()

        # Convert string into datetime object
        synchronized_time = parser.parse(synchronized_time)

        print("Synchronized time at the client is:",
              synchronized_time)


# =========================================================
# FUNCTION: INITIALIZE CLIENT
# =========================================================
# Creates socket connection with server and starts:
# 1. Sending thread
# 2. Receiving thread
# =========================================================

def initiateSlaveClient(port = 8080):

    # Create client socket
    slave_client = socket.socket()

    # Connect to server
    slave_client.connect(('127.0.0.1', port))

    print("Connected to Clock Server\n")

    # -----------------------------------------------------
    # THREAD 1 -> SEND TIME TO SERVER
    # -----------------------------------------------------

    send_time_thread = threading.Thread(
        target = startSendingTime,
        args = (slave_client,)
    )

    send_time_thread.start()

    print("Started sending time to server\n")


    # -----------------------------------------------------
    # THREAD 2 -> RECEIVE SYNCHRONIZED TIME
    # -----------------------------------------------------

    receive_time_thread = threading.Thread(
        target = startReceivingTime,
        args = (slave_client,)
    )

    receive_time_thread.start()

    print("Started receiving synchronized time\n")


# =========================================================
# DRIVER CODE
# =========================================================

if __name__ == '__main__':

    # Start client process
    initiateSlaveClient(port = 8080)