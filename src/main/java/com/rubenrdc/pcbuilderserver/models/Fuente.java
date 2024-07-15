package com.rubenrdc.pcbuilderserver.models;

import java.io.Serializable;
import javax.swing.ImageIcon;
import org.bson.types.ObjectId;

/**
 *
 * @author Ruben
 */
public class Fuente extends Articulo implements Serializable {

    private static final long serialVersionUID = 1L;
    private int RatedWatts, RealWatts, SataConnections;
    private String WiringType, Certification, Factor;
    private boolean Pin24Connector, IncludeCable;
    private Object row[];
    
    public Fuente(String title, String marca) {
        super(title, marca);
    }
    
    //Basic Information
    public Fuente(ObjectId id,ImageIcon imagen, String title, String marca, int RealWatts, String Factor) {
        super(id,imagen, title, marca);
        this.RealWatts = RealWatts;
        this.Factor = Factor;
    }
    //Complete Info
    public Fuente(ObjectId id, ImageIcon imagen, String title, String marca,int RatedWatts, int RealWatts, int SataConnections, String WiringType, String Certification, String Factor, boolean Pin24Connector, boolean IncludeCable, String oficialDocumentation) {
        super(id, imagen, title, marca, oficialDocumentation);
        this.RatedWatts = RatedWatts;
        this.RealWatts = RealWatts;
        this.SataConnections = SataConnections;
        this.WiringType = WiringType;
        this.Certification = Certification;
        this.Factor = Factor;
        this.Pin24Connector = Pin24Connector;
        this.IncludeCable = IncludeCable;
    }
    

    public int getRatedWatts() {
        return RatedWatts;
    }

    public int getRealWatts() {
        return RealWatts;
    }

    public int getSataConnections() {
        return SataConnections;
    }

    public String getWiringType() {
        return WiringType;
    }

    public String getCertification() {
        return Certification;
    }

    public String getFactor() {
        return Factor;
    }

    public boolean isPin24Connector() {
        return Pin24Connector;
    }

    public boolean isIncludeCable() {
        return IncludeCable;
    }
    public Object[] getRow() {
        row = new Object[4];
        row[0] = super.getTitle();
        row[1] = super.getMarca();
        row[2] = RealWatts;
        row[3] = Factor;
        return row;
    }
}
