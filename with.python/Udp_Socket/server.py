import socket 

socket  = socket.socket(socket.AF_INET , socket.SOCK_DGRAM)
socket.bind(("127.0.0.1",12345))
data, addr = socket.recvfrom(1024)
print(f"client {addr} , Data = {data.decode()}")