package com.rubenrdc.pcbuilderserver.dao;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import com.rubenrdc.pcbuilderserver.models.MotherBoard;
import com.rubenrdc.pcbuilderserver.models.interfaces.Utilities;
import static com.rubenrdc.pcbuilderserver.models.interfaces.Utilities.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 *
 * @author Ruben
 */
public class MotherBoardDao implements Utilities{

    private static final DaoConnection dao = new DaoConnection();
    public static final int TYPE_INTEL = 0, TYPE_AMD = 1;

    public static List<MotherBoard> getListMothers(int TYPE) {

        if (dao.EstablecerC()) {
            List<MotherBoard> list = new ArrayList<>();
            String family = "";
            if (TYPE == TYPE_INTEL) {
                family = "INTEL";
            } else if (TYPE == TYPE_AMD) {
                family = "AMD";
            }

            Bson filter = Filters.eq(family, family);
            FindIterable<Document> genericQuery = dao.genericQuery("MotherBoard", filter);

            MongoCursor<Document> iterator = genericQuery.iterator();
            
            while (iterator.hasNext()) {
                Document doc = iterator.next();
                ImageIcon imagen = generateImageIcon(doc.getString("imagen"));
                list.add(new MotherBoard(doc.getObjectId("_id"),imagen, doc.getString("title"), doc.getString("marca"),
                        doc.getString("chipset"), doc.getString("factor")));
            }
            return list;
        }
        dao.closeCo();
        return null;
    }
}
