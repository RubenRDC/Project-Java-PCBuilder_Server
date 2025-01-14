package com.rubenrdc.pcbuilder.models;

import java.io.Serializable;
import org.bson.types.ObjectId;

/**
 *
 * @author Ruben
 */
public class Cooler extends Articulo implements Serializable {

    private static final long serialVersionUID = 1L;
    private int TDP, highCooler, sizeCooler, sizeCoolerFans, EnergyConsumption, CoolersFans;
    private String Socket, Type;
    private Object row[];

    public Cooler(String title, String marca) {
        super(title, marca);
    }

    //Basic Information
    public Cooler(ObjectId id, String imagen, String title, String marca, String Type, int TDP, int highCooler, int CoolersFans, int sizeCoolerFans) {
        super(id, imagen, title, marca);
        this.Type = Type;
        this.TDP = TDP;
        this.highCooler=highCooler;
        this.CoolersFans=CoolersFans;
        this.sizeCoolerFans=sizeCoolerFans;
    }

    //Complete Info
    public Cooler(ObjectId id, String imagen, String title, String marca, int TDP, int highCooler, int sizeCooler, int sizeCoolerFans, int EnergyConsumption, int CoolersFans, String Socket, String Type, String oficialDocumentation) {
        super(id, imagen, title, marca, oficialDocumentation);
        this.TDP = TDP;
        this.highCooler = highCooler;
        this.sizeCooler = sizeCooler;
        this.sizeCoolerFans = sizeCoolerFans;
        this.EnergyConsumption = EnergyConsumption;
        this.CoolersFans = CoolersFans;
        this.Socket = Socket;
        this.Type = Type;
    }

    public int getTDP() {
        return TDP;
    }

    public int getHighCooler() {
        return highCooler;
    }

    public int getSizeCooler() {
        return sizeCooler;
    }

    public int getEnergyConsumption() {
        return EnergyConsumption;
    }

    public int getCoolersFans() {
        return CoolersFans;
    }

    public String getSocket() {
        return Socket;
    }

    public String getType() {
        return Type;
    }

    public int getSizeCoolerFans() {
        return sizeCoolerFans;
    }

    public Object[] getRow() {
        row = new Object[4];
        row[0] = super.getTitle();
        row[1] = super.getMarca();
        row[2] = Type;
        row[3] = TDP;
        return row;
    }
}
