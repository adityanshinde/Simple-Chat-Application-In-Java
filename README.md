# ChatAppGUI

A simple chat application with a graphical user interface (GUI) implemented in Java. This project includes both client and server components for real-time messaging over a network.

## Features
- Client-server architecture
- Real-time text messaging
- Simple and intuitive GUI for both client and server
- Written in Java

## Project Structure
```
ChatAppGUI.iml
src/
    chatappgui/
        Client.java
        Server.java
```


## Requirements

- Java Development Kit (JDK) 8 or higher
- Windows, macOS, or Linux
- (Optional) IntelliJ IDEA or any Java IDE for easier development

## How to Run the Project

1. **Clone or Download the Repository**
   - If you haven't already, clone this repository or download the source code to your local machine.

2. **Open a Terminal/Command Prompt**
   - Navigate to the project directory:
     ```
     cd ChatAppGUI/src
     ```

3. **Compile the Java Files**
   - Run the following command to compile both the server and client:
     ```
     javac chatappgui/Server.java chatappgui/Client.java
     ```

4. **Start the Server**
   - In the terminal, run:
     ```
     java chatappgui.Server
     ```

5. **Start the Client(s)**
   - Open a new terminal window for each client you want to run, then execute:
     ```
     java chatappgui.Client
     ```

6. **Chat!**
   - With the server running, clients can connect and exchange messages in real time.

## Usage
- Start the server first.
- Launch one or more clients to connect to the server and begin chatting.

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

## License
This project is open source and available under the MIT License.
