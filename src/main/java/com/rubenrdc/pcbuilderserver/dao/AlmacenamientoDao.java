package com.rubenrdc.pcbuilderserver.dao;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import com.rubenrdc.pcbuilderserver.models.Almacenamiento;
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
public class AlmacenamientoDao {
    private static final DaoConnection dao = new DaoConnection();

    public static List<Almacenamiento> getListAlmacenamiento(String Type) {
        if (dao.EstablecerC()) {
            List<Almacenamiento> list = new ArrayList<>();
            
            FindIterable<Document> genericQuery = dao.genericQuery("Almacenamiento");
            
            MongoCursor<Document> iterator = genericQuery.iterator();

            while (iterator.hasNext()) {
                Document doc = iterator.next();
                ImageIcon imagen = generateImageIcon(doc.getString("imagen"));
                list.add(new Almacenamiento(doc.getObjectId("_id"), imagen, doc.getString("title"), doc.getString("marca"),
                        doc.getString("type"), doc.getString("factor")));
            }
            sort(list);
            dao.closeCo();
            return list;
        }
        return null;
    }

    public static Almacenamiento getMoreInfo(ObjectId id) {
        if (dao.EstablecerC()) {
            Almacenamiento g = null;

            Bson filter = Filters.eq("_id", id);
            FindIterable<Document> genericQuery = dao.genericQuery("Cooler", filter);
            Document doc = genericQuery.first();

            if (doc != null) {
                ImageIcon imagen = generateImageIcon(doc.getString("imagen"));

                g = new Almacenamiento(doc.getObjectId("_id"),
                        imagen, doc.getString("title"),
                        doc.getString("marca"),
                        doc.getString("type"),
                        doc.getString("factor"),
                        doc.getString("connectionType"),
                        doc.getString("interface"),
                        doc.getInteger("capacity"),
                        doc.getInteger("cache"),
                        doc.getInteger("maxReadSquential"),
                        doc.getInteger("maxWriteSquential"),
                        doc.getInteger("energyConsumption"),
                        doc.getInteger("usefulLife"),
                        doc.getString("oficialDocumentation"));
            }
            dao.closeCo();
            return g;
        }
        return null;
    }
}
