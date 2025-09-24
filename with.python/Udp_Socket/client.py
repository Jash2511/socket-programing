import socket

socket = socket.socket(socket.AF_INET,socket.SOCK_DGRAM) 

socket.sendto("Hello server".encode() , ("127.0.0.1",12345))