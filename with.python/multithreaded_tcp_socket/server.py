import threading
import socket 

socket = socket.socket(socket.AF_INET ,socket.SOCK_STREAM) 
print('socket is created')

ip = "0.0.0.0"
port = 65535
socket.bind((ip , port))
print(f'socket is binded with {ip}:{port}')

socket.listen() 
print('socket is ready to connect with clients')

def chat(conn , addr):

    while True :
        data = conn.recv(1024)

        if data.decode() == 'exit' :
            conn.close()
            return 
        print(f"Clinet {addr} = {data.decode()}")

while True :
    conn , addr = socket.accept()

    thread = threading.Thread(target = chat ,args=(conn , addr))

    thread.start()