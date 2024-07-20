package com.rubenrdc.pcbuilderserver.dao;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import com.rubenrdc.pcbuilderserver.models.Cooler;
import static com.rubenrdc.pcbuilderserver.models.interfaces.Utilities.generateImageIcon;
import java.util.ArrayList;
import static java.util.Collections.sort;
import java.util.HashMap;
import java.util.List;
import javax.swing.ImageIcon;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 *
 * @author Ruben
 */
public class CoolerDao {
     private static final DaoConnection dao = new DaoConnection();

    public static List<Cooler> getListCooler(HashMap socketAndTdpCpu) {
        //String Family AMD/INTEL
        if (dao.EstablecerC()) {
            List<Cooler> list = new ArrayList<>();
            
            Bson filter = Filters.regex("socket", (String)socketAndTdpCpu.get("socketCPU"));
            Bson filter2 = Filters.gte("socket", (String)socketAndTdpCpu.get("TDPCPU"));
            Bson filterAnd = Filters.and(filter,filter2);
            
            FindIterable<Document> genericQuery = dao.genericQuery("Cooler", filterAnd);
            
            MongoCursor<Document> iterator = genericQuery.iterator();

            while (iterator.hasNext()) {
                Document doc = iterator.next();
                ImageIcon imagen = generateImageIcon(doc.getString("imagen"));
                list.add(new Cooler(doc.getObjectId("_id"), imagen, doc.getString("title"), doc.getString("marca"),
                        doc.getString("type"), doc.getInteger("TDP"),doc.getInteger("highCooler"),doc.getInteger("coolersFans"),
                        doc.getInteger("sizeCoolerFans")));
            }
            sort(list);
            dao.closeCo();
            return list;
        }
        return null;
    }

    public static Cooler getMoreInfo(ObjectId id) {
        if (dao.EstablecerC()) {
            Cooler p = null;

            Bson filter = Filters.eq("_id", id);
            FindIterable<Document> genericQuery = dao.genericQuery("Cooler", filter);
            Document doc = genericQuery.first();

            if (doc != null) {
                ImageIcon imagen = generateImageIcon(doc.getString("imagen"));

                p = new Cooler(doc.getObjectId("_id"),
                        imagen, doc.getString("title"),
                        doc.getString("marca"),
                        doc.getInteger("TDP"),
                        doc.getInteger("highCooler"),
                        doc.getInteger("sizeCooler"),
                        doc.getInteger("sizeCoolerFans"),
                        doc.getInteger("energyConsumption"),
                        doc.getInteger("coolersFans"),
                        doc.getString("socket"),
                        doc.getString("type"),
                        doc.getString("oficialDocumentation"));
            }
            dao.closeCo();
            return p;
        }
        return null;
    }
}
