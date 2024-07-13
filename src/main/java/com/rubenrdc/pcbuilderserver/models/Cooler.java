package com.rubenrdc.pcbuilderserver.models;

import java.io.Serializable;
import javax.swing.ImageIcon;

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
    public Cooler(ImageIcon imagen, String title, String marca, String Type, int TDP) {
        super(imagen, title, marca);
        this.Type = Type;
        this.TDP = TDP;
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
