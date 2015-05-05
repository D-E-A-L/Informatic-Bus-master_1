package publictransport.DB;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class LectorAndroid {
    public static void main(String[] args) {
        try {
            /* Establece la conexion */
            Socket socket = new Socket("10.0.0.4", 8888);
            /* Stream para enviar objetos */
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            /* Stream para recibir objetos */
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            /* Creamos una instancia de la clase Scanner para leer cadenas desde consola */
            Scanner scanner = new Scanner(System.in);
            /* Enviamos 10 solicitudes al servidor y leemos 10 respuestas*/
            for(int i = 0; i < 10; i++) {
                /* Leemos una linea desde consola */
                String request = scanner.nextLine();
                /* Enviamos la linea al servidor*/
                oos.writeObject(request);
                oos.flush();
                /* Leemos la respuesta del servidor */
                String response = (String) ois.readObject();
                /* Imprimimos la respuesta */
                System.out.println("Response:"+response);
            }
            /* Cerramos los streams y el socket */
            oos.close();
            ois.close();
            socket.close();
        } catch(Exception e) {

        }
    }
}
