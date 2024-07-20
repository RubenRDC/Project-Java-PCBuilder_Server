package com.rubenrdc.pcbuilderserver.dao;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import com.rubenrdc.pcbuilderserver.models.Procesador;
import com.rubenrdc.pcbuilderserver.models.interfaces.Utilities;
import static com.rubenrdc.pcbuilderserver.models.interfaces.Utilities.generateImageIcon;
import java.util.ArrayList;
import static java.util.Collections.sort;
import java.util.List;
import javax.swing.ImageIcon;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 *
 * @author Ruben
 */
public class ProcesadorDao implements Utilities{
    private static final DaoConnection dao = new DaoConnection();

    public static List<Procesador> getListProcesadores(String family) {
        //String Family AMD/INTEL
        if (dao.EstablecerC()) {
            List<Procesador> list = new ArrayList<>();

            Bson filter = Filters.eq("marca", family);
            
            FindIterable<Document> genericQuery = dao.genericQuery("Procesador", filter);

            MongoCursor<Document> iterator = genericQuery.iterator();

            while (iterator.hasNext()) {
                Document doc = iterator.next();
                ImageIcon imagen = generateImageIcon(doc.getString("imagen"));
                list.add(new Procesador(doc.getObjectId("_id"), imagen, doc.getString("title"), doc.getString("marca"),
                        doc.getInteger("ncores"), doc.getInteger("nThreads"),doc.getDouble("frequencyTurbo"),
                        doc.getString("socket"),doc.getInteger("TDP"),doc.getBoolean("includeCooler")));
            }
            sort(list);
            dao.closeCo();
            return list;
        }
        return null;
    }

    public static Procesador getMoreInfo(ObjectId id) {
        if (dao.EstablecerC()) {
            Procesador p = null;

            Bson filter = Filters.eq("_id", id);
            FindIterable<Document> genericQuery = dao.genericQuery("Procesador", filter);
            Document doc = genericQuery.first();

            if (doc != null) {
                ImageIcon imagen = generateImageIcon(doc.getString("imagen"));

                p = new Procesador(doc.getObjectId("_id"),
                        imagen, doc.getString("title"),
                        doc.getString("marca"),
                        doc.getInteger("ncores"),
                        doc.getInteger("nThreads"),
                        doc.getInteger("TDP"),
                        doc.getInteger("frequencyMaxRam"),
                        doc.getDouble("frequencyBase"),
                        doc.getDouble("frequencyTurbo"),
                        doc.getString("chipsetGPU"),
                        doc.getString("socket"),
                        doc.getString("typeMemory"),
                        doc.getString("family"),
                        doc.getBoolean("includeCooler"),
                        doc.getString("oficialDocumentation"));
            }
            dao.closeCo();
            return p;
        }
        return null;
    }
}
