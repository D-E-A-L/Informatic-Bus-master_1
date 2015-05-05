package publictransport.DB;

import java.net.ServerSocket;
import java.net.Socket;

public class ServerToAndroid {
    public static void main(String[] args) {
        try {
            /* Levantamos el servidor que escucha en el puerto 8888 */
            ServerSocket server = new ServerSocket(8888);
            int socketId=1;
            while(true) {
                /* Espera solicitud de conexion */
                Socket socket = server.accept();
                /* Creamos un nuevo hilo que atienda al cliente */
                SocketClientThread sct = new SocketClientThread(socket, socketId);
                /* Iniciamos el hilo*/
                sct.start();
                /* Incrementamos el id */
                socketId++;
            }
        } catch(Exception e) {
        }
    }
}
