package com.rubenrdc.pcbuilderserver.dao;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import com.rubenrdc.pcbuilder.models.Ram;
import java.util.ArrayList;
import static java.util.Collections.sort;
import java.util.List;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 *
 * @author Ruben
 */
public class RamDao {
    private static final DaoConnection dao = new DaoConnection();

    public static List<Ram> getListRam(String Type) {
        if (dao.EstablecerC()) {
            List<Ram> list = new ArrayList<>();
            
            Bson filter = Filters.regex("type", Type);
            
            FindIterable<Document> genericQuery = dao.genericQuery("Ram", filter);
            
            MongoCursor<Document> iterator = genericQuery.iterator();

            while (iterator.hasNext()) {
                Document doc = iterator.next();
                list.add(new Ram(doc.getObjectId("_id"), doc.getString("imagen"), doc.getString("title"), doc.getString("marca"),
                        doc.getInteger("capacity"), doc.getInteger("frequencyRam")));
            }
            sort(list);
            dao.closeCo();
            return list;
        }
        return null;
    }

    public static Ram getMoreInfo(ObjectId id) {
        if (dao.EstablecerC()) {
            Ram p = null;

            Bson filter = Filters.eq("_id", id);
            FindIterable<Document> genericQuery = dao.genericQuery("Ram", filter);
            Document doc = genericQuery.first();

            if (doc != null) {
                p = new Ram(doc.getObjectId("_id"),
                        doc.getString("imagen"),
                        doc.getString("title"),
                        doc.getString("marca"),
                        doc.getInteger("frequencyRam"),
                        doc.getInteger("capacity"),
                        doc.getInteger("latency"),
                        doc.getString("type"),
                        doc.getDouble("voltage"),
                        doc.getBoolean("dissipation"),
                        doc.getString("oficialDocumentation"));
            }
            dao.closeCo();
            return p;
        }
        return null;
    }
}
