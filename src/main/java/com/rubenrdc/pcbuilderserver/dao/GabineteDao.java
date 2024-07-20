package com.rubenrdc.pcbuilderserver.dao;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import com.rubenrdc.pcbuilderserver.models.Gabinete;
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
public class GabineteDao {
    private static final DaoConnection dao = new DaoConnection();

    /**
     *
     * @param fptlhl
     * HashMap que contiene los parametros requeridos para la consulta.
     * @return
     */
    public static List<Gabinete> getListGabinete(HashMap fptlhl) {
        if (dao.EstablecerC()) {
            List<Gabinete> list = new ArrayList<>();
            List<Bson> filtsList = new ArrayList<>();
            if (((String)fptlhl.get("TypeCooler")).equalsIgnoreCase("Watercooling")) {
                filtsList.add(Filters.eq("soportWaterRadiator", true));
                filtsList.add(Filters.gt("soportRadiator"+fptlhl.get("lenghtCoolerFans"), 0));
            }
            filtsList.add(Filters.gte("lengthMaxGPU", fptlhl.get("lengthGPU")));
            filtsList.add(Filters.gte("maxSoportCoolerHeight", fptlhl.get("highCooler")));
            filtsList.add(Filters.regex("factorMother", (String)fptlhl.get("factorMother")));
            filtsList.add(Filters.eq("powerFactor", (String)fptlhl.get("powerFactor")));
            
            Bson filts = Filters.and(filtsList);
            
            FindIterable<Document> genericQuery = dao.genericQuery("Gabinete",filts);
            
            MongoCursor<Document> iterator = genericQuery.iterator();

            while (iterator.hasNext()) {
                Document doc = iterator.next();
                ImageIcon imagen = generateImageIcon(doc.getString("imagen"));
                list.add(new Gabinete(doc.getObjectId("_id"), imagen, doc.getString("title"), doc.getString("marca"),
                        doc.getString("factorMother"), doc.getString("powerFactor")));
            }
            sort(list);
            dao.closeCo();
            return list;
        }
        return null;
    }

    public static Gabinete getMoreInfo(ObjectId id) {
        if (dao.EstablecerC()) {
            Gabinete g = null;

            Bson filter = Filters.eq("_id", id);
            FindIterable<Document> genericQuery = dao.genericQuery("Gabinete", filter);
            Document doc = genericQuery.first();

            if (doc != null) {
                ImageIcon imagen = generateImageIcon(doc.getString("imagen"));

                g = new Gabinete(doc.getObjectId("_id"),
                        imagen, doc.getString("title"),
                        doc.getString("marca"),
                        doc.getString("factorMother"),
                        doc.getString("powerFactor"),
                        doc.getBoolean("window"),
                        doc.getString("typeWindow"),
                        doc.getBoolean("soportWaterRadiator"),
                        doc.getInteger("width"),
                        doc.getInteger("height"),
                        doc.getInteger("length"),
                        doc.getInteger("maxSoportCoolerHeight"),
                        doc.getInteger("soportCoolersFan80"),
                        doc.getInteger("soportCoolersFan120"),
                        doc.getInteger("soportCoolersFan140"),
                        doc.getInteger("soportCoolersFan200"),
                        doc.getInteger("soportRadiator240"),
                        doc.getInteger("soportRadiator280"),
                        doc.getInteger("soportRadiator360"),
                        doc.getInteger("soportRadiator420"),
                        doc.getInteger("storageSlots"),
                        doc.getInteger("soportFactor2_5"),
                        doc.getInteger("soportFactor3_25"),
                        doc.getInteger("soportFactor3_5"),
                        doc.getInteger("SoportFactor5_25"),
                        doc.getInteger("lengthMaxGPU"),
                        doc.getString("oficialDocumentation"));
            }
            dao.closeCo();
            return g;
        }
        return null;
    }
}
