package com.rubenrdc.pcbuilderserver;

import com.rubenrdc.pcbuilderserver.models.paquete.PaquetePeticionClient;
import com.rubenrdc.pcbuilderserver.models.paquete.PaqueteRecepcionClient;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Ruben
 */
public class ServerLogic {

    private final int port;

    public ServerLogic(int port) {
        this.port = port;
    }

    public void startServerThread() {

        Thread r = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    ServerSocket ServerS = new ServerSocket(port);
                    ObjectInputStream inputStream;
                    ObjectOutputStream OutputStream;
                    Socket accept;
                    PaquetePeticionClient readObject;
                    PaqueteRecepcionClient generateReply;

                    while (true) {
                        accept = ServerS.accept();
                        
                        inputStream = new ObjectInputStream(accept.getInputStream());
                        readObject = (PaquetePeticionClient) inputStream.readObject();

                        generateReply = generateReply(readObject);
                        OutputStream = new ObjectOutputStream(accept.getOutputStream());
                        OutputStream.writeObject(generateReply);

                        accept.close();
                        inputStream.close();
                        OutputStream.close();
                    }

                } catch (IOException | ClassNotFoundException ex) {
                }

            }
        }
        );
        r.start();
    }

    private PaqueteRecepcionClient generateReply(PaquetePeticionClient p) {
        return null;
    }

}
