package com.rubenrdc.pcbuilderserver.dao;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import com.rubenrdc.pcbuilder.models.MotherBoard;
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
public class MotherBoardDao {

    private static final DaoConnection dao = new DaoConnection();

    public static List<MotherBoard> getListMothers(String socket) {
        //String Family AMD/INTEL
        //Socket AM4/AM5
        if (dao.EstablecerC()) {
            List<MotherBoard> list = new ArrayList<>();

            Bson filter = Filters.eq("socket", socket);

            FindIterable<Document> genericQuery = dao.genericQuery("MotherBoard", filter);

            MongoCursor<Document> iterator = genericQuery.iterator();

            while (iterator.hasNext()) {
                Document doc = iterator.next();
                list.add(new MotherBoard(doc.getObjectId("_id"), doc.getString("imagen"), doc.getString("title"), doc.getString("marca"),
                        doc.getString("chipset"), doc.getString("factor")));
            }
            sort(list);
            dao.closeCo();
            return list;
        }
        return null;
    }

    public static MotherBoard getMoreInfo(ObjectId id) {
        if (dao.EstablecerC()) {
            MotherBoard mother = null;

            Bson filter = Filters.eq("_id", id);
            FindIterable<Document> genericQuery = dao.genericQuery("MotherBoard", filter);
            Document doc = genericQuery.first();

            if (doc != null) {
                mother = new MotherBoard(doc.getObjectId("_id"),
                        doc.getString("imagen"),
                        doc.getString("title"),
                        doc.getString("marca"),
                        doc.getString("chipset"),
                        doc.getString("factor"),
                        doc.getString("family"),
                        doc.getString("socket"),
                        doc.getString("memoryType"),
                        doc.getInteger("memorySlots"),
                        doc.getInteger("energyConsumption"),
                        doc.getInteger("sataSlots"),
                        doc.getInteger("PCIEx16Slots"),
                        doc.getInteger("PCIEx1Slots"),
                        doc.getInteger("M2NvmeSlots"),
                        doc.getInteger("M2SataSlots"),
                        doc.getString("oficialDocumentation"));
            }
            dao.closeCo();
            return mother;
        }
        return null;
    }
}
