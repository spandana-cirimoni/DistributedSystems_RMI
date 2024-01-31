# java RMI Distributed Computing Environment

This project is a Java Remote Method Invocation (RMI) implementation of a distributed computing environment. The system consists of a server and multiple clients, each representing a process (P0, P1, P2, P3). The objective is to showcase the principles of remote method invocations, logical clocks, and clock drifts in a distributed-object computing model.

## Overview

The project simulates a distributed environment with multiple processes, where each process communicates with others using RMI. The communication involves internal events, message sending, and message receiving, each affecting the logical clocks of the processes.

### Components

- Client : The Client class represents a process in the distributed system. It generates internal events, sends messages to other processes, and receives messages. Each client runs as a separate thread.

- Server : The Server class acts as the RMI server. It initializes and exports communication objects (CommunicationC) for each process, making them available for remote invocation. Clients can send messages and receive acknowledgments through these communication objects.

## How to RUN
- Make sure you have installed java before running the code
- Run the program using "make compile" command.
- once the Communication.java, CommunicationC.java, server.java and client.java are compiled.
- Open a separate command prompt and type "start rmiregistry 9999"(this is the portnumber i have given in Line 12 of Server.java) 
- Later "use the command "make server" command.
- Later use the "make client" command to connect with the server.(i have mentioned "in-csci-rrpc01.cs.iupui.edu" machine in line 47 of client.java)

