package com.rubenrdc.pcbuilderserver.dao;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import com.rubenrdc.pcbuilderserver.models.Fuente;
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
public class FuenteDao {
    private static final DaoConnection dao = new DaoConnection();

    public static List<Fuente> getListFuente(int currentTotalW) {
        if (dao.EstablecerC()) {
            List<Fuente> list = new ArrayList<>();
            
            Bson filt = Filters.gte("realWatts", currentTotalW);
            
            FindIterable<Document> genericQuery = dao.genericQuery("Fuente",filt);
            
            MongoCursor<Document> iterator = genericQuery.iterator();

            while (iterator.hasNext()) {
                Document doc = iterator.next();
                ImageIcon imagen = generateImageIcon(doc.getString("imagen"));
                list.add(new Fuente(doc.getObjectId("_id"), imagen, doc.getString("title"), doc.getString("marca"),
                        doc.getInteger("realWatts"), doc.getString("factor")));
            }
            sort(list);
            dao.closeCo();
            return list;
        }
        return null;
    }

    public static Fuente getMoreInfo(ObjectId id) {
        if (dao.EstablecerC()) {
            Fuente f = null;

            Bson filter = Filters.eq("_id", id);
            FindIterable<Document> genericQuery = dao.genericQuery("Fuente", filter);
            Document doc = genericQuery.first();

            if (doc != null) {
                ImageIcon imagen = generateImageIcon(doc.getString("imagen"));

                f = new Fuente(doc.getObjectId("_id"),
                        imagen, doc.getString("title"),
                        doc.getString("marca"),
                        doc.getInteger("ratedWatts"),
                        doc.getInteger("realWatts"),
                        doc.getInteger("sataConnections"),
                        doc.getString("wiringType"),
                        doc.getString("certification"),
                        doc.getString("factor"),
                        doc.getBoolean("pin24Connector"),
                        doc.getBoolean("includeCable"),
                        doc.getString("oficialDocumentation"));
            }
            dao.closeCo();
            return f;
        }
        return null;
    }
}
