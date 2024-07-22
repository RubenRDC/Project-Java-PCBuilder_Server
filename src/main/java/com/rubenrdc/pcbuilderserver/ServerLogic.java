package com.rubenrdc.pcbuilderserver;

import com.rubenrdc.pcbuilder.models.Almacenamiento;
import com.rubenrdc.pcbuilder.models.Articulo;
import com.rubenrdc.pcbuilder.models.Cooler;
import com.rubenrdc.pcbuilder.models.Fuente;
import com.rubenrdc.pcbuilder.models.GPU;
import com.rubenrdc.pcbuilder.models.Gabinete;
import com.rubenrdc.pcbuilder.models.MotherBoard;
import com.rubenrdc.pcbuilder.models.Procesador;
import com.rubenrdc.pcbuilder.models.Ram;
import com.rubenrdc.pcbuilderserver.dao.AlmacenamientoDao;
import com.rubenrdc.pcbuilderserver.dao.CoolerDao;
import com.rubenrdc.pcbuilderserver.dao.FuenteDao;
import com.rubenrdc.pcbuilderserver.dao.GPUDao;
import com.rubenrdc.pcbuilderserver.dao.GabineteDao;
import com.rubenrdc.pcbuilderserver.dao.MotherBoardDao;
import com.rubenrdc.pcbuilderserver.dao.ProcesadorDao;
import com.rubenrdc.pcbuilderserver.dao.RamDao;
import com.rubenrdc.pcbuilderserver.models.paquete.Paquete;
import com.rubenrdc.pcbuilderserver.models.paquete.PaquetePeticionClient;
import com.rubenrdc.pcbuilderserver.models.paquete.PaqueteRecepcionClient;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Ruben
 */
public class ServerLogic {

    private final int port;//8765

    public ServerLogic(int port) {
        this.port = port;
    }

    public void startServerThread() {

        Thread r = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("-Servidor Iniciado-");
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
                        System.out.println("Accepta la conexion a: " + accept.getInetAddress());

                        generateReply = generateReply(readObject);
                        OutputStream = new ObjectOutputStream(accept.getOutputStream());
                        OutputStream.writeObject(generateReply);

                        System.out.println("Informacion enviada a: " + accept.getInetAddress());
                        accept.close();
                        inputStream.close();
                        OutputStream.close();
                    }

                } catch (IOException | ClassNotFoundException ex) {
                    System.out.println(ex);
                    startServerThread();
                }

            }
        }
        );
        r.start();
    }

    private PaqueteRecepcionClient generateReply(PaquetePeticionClient p) {
        if (PaquetePeticionClient.TYPE_GET_LIST == p.getTYPE_PAQ()) {
            switch (p.getTYPE_ART()) {
                case Paquete.TYPE_CPU:
                    List<Procesador> listProcesadores = ProcesadorDao.getListProcesadores((String) p.getParam());
                    return new PaqueteRecepcionClient(verificContent(listProcesadores), p.getTYPE_PAQ(), p.getTYPE_ART(), listProcesadores);
                case Paquete.TYPE_MOTHER:
                    List<MotherBoard> listMothers = MotherBoardDao.getListMothers((String) p.getParam());
                    return new PaqueteRecepcionClient(verificContent(listMothers), p.getTYPE_PAQ(), p.getTYPE_ART(), listMothers);
                case Paquete.TYPE_COOLER:
                    List<Cooler> listCooler = CoolerDao.getListCooler((HashMap) p.getParam());
                    return new PaqueteRecepcionClient(verificContent(listCooler), p.getTYPE_PAQ(), p.getTYPE_ART(), listCooler);
                case Paquete.TYPE_RAM:
                    List<Ram> listRam = RamDao.getListRam((String) p.getParam());
                    return new PaqueteRecepcionClient(verificContent(listRam), p.getTYPE_PAQ(), p.getTYPE_ART(), listRam);
                case Paquete.TYPE_GPU:
                    List<GPU> listGPU = GPUDao.getListGPU();
                    return new PaqueteRecepcionClient(verificContent(listGPU), p.getTYPE_PAQ(), p.getTYPE_ART(), listGPU);
                case Paquete.TYPE_STORAGE:
                    List<Almacenamiento> listAlmacenamiento = AlmacenamientoDao.getListAlmacenamiento();
                    return new PaqueteRecepcionClient(verificContent(listAlmacenamiento), p.getTYPE_PAQ(), p.getTYPE_ART(), listAlmacenamiento);
                case Paquete.TYPE_POWER:
                    List<Fuente> listFuente = FuenteDao.getListFuente((int) p.getParam());
                    return new PaqueteRecepcionClient(verificContent(listFuente), p.getTYPE_PAQ(), p.getTYPE_ART(), listFuente);
                case Paquete.TYPE_TOWER:
                    List<Gabinete> listGabinete = GabineteDao.getListGabinete((HashMap) p.getParam());
                    return new PaqueteRecepcionClient(verificContent(listGabinete), p.getTYPE_PAQ(), p.getTYPE_ART(), listGabinete);
            }

        } else if (PaquetePeticionClient.TYPE_GET_MORE_INFO == p.getTYPE_PAQ()) {//Get More Info
            switch (p.getTYPE_ART()) {
                case Paquete.TYPE_CPU:
                    Procesador ArtP = ProcesadorDao.getMoreInfo((ObjectId) p.getParam());
                    return new PaqueteRecepcionClient(verificContent(ArtP), p.getTYPE_PAQ(), p.getTYPE_ART(), ArtP);
                case Paquete.TYPE_MOTHER:
                    MotherBoard ArtM = MotherBoardDao.getMoreInfo((ObjectId) p.getParam());
                    return new PaqueteRecepcionClient(verificContent(ArtM), p.getTYPE_PAQ(), p.getTYPE_ART(), ArtM);
                case Paquete.TYPE_COOLER:
                    Cooler ArtC = CoolerDao.getMoreInfo((ObjectId) p.getParam());
                    return new PaqueteRecepcionClient(verificContent(ArtC), p.getTYPE_PAQ(), p.getTYPE_ART(), ArtC);
                case Paquete.TYPE_RAM:
                    Ram ArtR = RamDao.getMoreInfo((ObjectId) p.getParam());
                    return new PaqueteRecepcionClient(verificContent(ArtR), p.getTYPE_PAQ(), p.getTYPE_ART(), ArtR);
                case Paquete.TYPE_GPU:
                    GPU ArtG = GPUDao.getMoreInfo((ObjectId) p.getParam());
                    return new PaqueteRecepcionClient(verificContent(ArtG), p.getTYPE_PAQ(), p.getTYPE_ART(), ArtG);
                case Paquete.TYPE_STORAGE:
                    Almacenamiento ArtAl = AlmacenamientoDao.getMoreInfo((ObjectId) p.getParam());
                    return new PaqueteRecepcionClient(verificContent(ArtAl), p.getTYPE_PAQ(), p.getTYPE_ART(), ArtAl);
                case Paquete.TYPE_POWER:
                    Fuente ArtF = FuenteDao.getMoreInfo((ObjectId) p.getParam());
                    return new PaqueteRecepcionClient(verificContent(ArtF), p.getTYPE_PAQ(), p.getTYPE_ART(), ArtF);
                case Paquete.TYPE_TOWER:
                    Gabinete ArtGa = GabineteDao.getMoreInfo((ObjectId) p.getParam());
                    return new PaqueteRecepcionClient(verificContent(ArtGa), p.getTYPE_PAQ(), p.getTYPE_ART(), ArtGa);
            }
        }
        return new PaqueteRecepcionClient(404, p.getTYPE_PAQ(), p.getTYPE_ART());
    }

    private static <T extends Articulo> int verificContent(List<T> l) {
        if (l != null) {
            if (l.size() >= 1) {
                return Paquete.SCODE_OK;
            } else {
                return Paquete.SCODE_NO_CONTENT;
            }
        } else {
            return Paquete.SCODE_NO_FOUND;
        }
    }

    private static <T extends Articulo> int verificContent(T art) {
        if (art != null) {
            return Paquete.SCODE_OK;
        } else {
            return Paquete.SCODE_NO_FOUND;
        }
    }
    
}
