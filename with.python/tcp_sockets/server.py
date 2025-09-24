import socket 

socket = socket.socket(socket.AF_INET,socket.SOCK_STREAM) 

socket.bind(("127.0.0.1" , 12345))

socket.listen() 
conn , adr = socket.accept() 


while True :

    data = conn.recv(1024)
    if data.decode() == "exit":
        break
    print(f"Data = {data.decode()}")


socket.close() 

