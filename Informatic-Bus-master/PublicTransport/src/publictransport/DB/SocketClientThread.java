package publictransport.DB;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class SocketClientThread extends Thread {

    private Socket socket;
    private int id;

    /**
     * Constructor
     * @param socket
     * @param id
     */
    public SocketClientThread(Socket socket, int id) {
        this.socket = socket;
        this.id = id;
    }

    /**
     * Sobre-escribimos el metodo run()
     */
    @Override public void run() {
        try {
            /* Stream para enviar objetos */
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            /* Stream para recibir objetos */
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

            /* Leeemos 10 solicitudes del cliente y enviamos 10 respuestas*/
            for(int i = 0; i < 10; i++) {
                String request = (String) ois.readObject();
                System.out.println(id+" Request:"+request);
                String response = "Respuesta "+i;
                oos.writeObject(response);
                oos.flush();
            }
            /* Cerramos los streams y el socket */
            oos.close();
            ois.close();
            socket.close();
        } catch(Exception ex) {
        }
    }
}