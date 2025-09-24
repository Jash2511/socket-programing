import socket

socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

socket.bind(("127.0.0.1",12345))
socket.listen() 

conn  , addr = socket.accept()

data = conn.recv(1024)
print(data.decode())

data1 = conn.recv(1024)
print(data.decode())

conn.close() 
 