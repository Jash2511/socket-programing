import socket 

socket = socket.socket(socket.AF_INET , socket.SOCK_STREAM) 

socket.connect(("127.0.0.1",12345))

while True :
    data = input()
    socket.send(data.encode())
    if data == "exit" :
        break 

socket.close() 
