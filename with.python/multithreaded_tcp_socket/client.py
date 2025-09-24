import socket 

socket = socket.socket(socket.AF_INET,socket.SOCK_STREAM)

ip = "192.168.4.28"
port = 65535

socket.connect((ip,port))
print(f"connection with {ip}:{port} is established")


while True :
    message = input()
    socket.send(message.encode())
    message1 = input()
    socket.send(message1.encode())
    if message == 'exit':
        break

socket.close()