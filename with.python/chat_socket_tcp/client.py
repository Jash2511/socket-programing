import socket 

socket = socket.socket(socket.AF_INET , socket.SOCK_STREAM) 

ip = "127.0.0.1"
port = 65535

socket.connect((ip,port)) 
print(f"connected succesfully with {ip}:{port}")

 
while True :
    message = input()
    socket.send(message.encode())
    data = socket.recv(1024)
    print(f"Server : {data.decode()}") 
    if data.decode() == 'bye' and message == 'bye' :
        break 

socket.close() 
