package com.rubenrdc.pcbuilderserver.dao;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import com.rubenrdc.pcbuilderserver.models.MotherBoard;
import com.rubenrdc.pcbuilderserver.models.interfaces.Utilities;
import static com.rubenrdc.pcbuilderserver.models.interfaces.Utilities.*;
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
public class MotherBoardDao implements Utilities {

    private static final DaoConnection dao = new DaoConnection();

    public static List<MotherBoard> getListMothers(String family, String socket) {
        //String Family AMD/INTEL
        //Socket AM4/AM5
        if (dao.EstablecerC()) {
            List<MotherBoard> list = new ArrayList<>();

            Bson filter1 = Filters.eq("family", family);
            Bson filter2 = Filters.eq("socket", socket);
            Bson filters = Filters.and(filter1, filter2);

            FindIterable<Document> genericQuery = dao.genericQuery("MotherBoard", filters);

            MongoCursor<Document> iterator = genericQuery.iterator();

            while (iterator.hasNext()) {
                Document doc = iterator.next();
                ImageIcon imagen = generateImageIcon(doc.getString("imagen"));
                list.add(new MotherBoard(doc.getObjectId("_id"), imagen, doc.getString("title"), doc.getString("marca"),
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
                ImageIcon imagen = generateImageIcon(doc.getString("imagen"));

                mother = new MotherBoard(doc.getObjectId("_id"),
                        imagen, doc.getString("title"),
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
