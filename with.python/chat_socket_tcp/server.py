import socket 

socket = socket.socket(socket.AF_INET , socket.SOCK_STREAM) 


ip = "0.0.0.0"
port = 65535

socket.bind((ip , port)) 
print(f"Socket is binded at {ip}:{port}") 

socket.listen()
print(f"Socket is ready to connect with client")

clss , addr = socket.accept() 
print(f"Socket is connected with client at {addr}")
print(clss)

while True :
    data = clss.recv(1024) 
    print(data)
   
    print(f"Client : {data.decode()}") 
    message = input() 
    clss.send(message.encode())
    if data.decode() == 'bye' and message == 'bye':
        break

clss.close() 
socket.close()
