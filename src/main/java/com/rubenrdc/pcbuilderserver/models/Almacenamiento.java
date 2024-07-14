package com.rubenrdc.pcbuilderserver.models;

import java.io.Serializable;
import javax.swing.ImageIcon;
import org.bson.types.ObjectId;

/**
 *
 * @author Ruben
 */
public class Almacenamiento extends Articulo implements Serializable {

    //Type SDD/HDD
    //Interface Sata NVMe
    //ConnectionType M2,Sata,Etc
    private static final long serialVersionUID = 1L;

    private String Type, Factor, ConnectionType, Interface;
    private int Capacity, Cache, MaxReadSquential, MaxWriteSquential, EnergyConsumption, UsefulLife;
    private Object row[];

    public Almacenamiento(String title, String marca) {
        super(title, marca);
    }

    //Basic Information
    public Almacenamiento(ObjectId id, ImageIcon imagen, String title, String marca, String Type, String Factor) {
        super(id, imagen, title, marca);
        this.Type = Type;
        this.Factor = Factor;
    }

    public String getType() {
        return Type;
    }

    public String getFactor() {
        return Factor;
    }

    public int getCapacity() {
        return Capacity;
    }

    public int getCache() {
        return Cache;
    }

    public int getMaxReadSquential() {
        return MaxReadSquential;
    }

    public int getMaxWriteSquential() {
        return MaxWriteSquential;
    }

    public int getEnergyConsumption() {
        return EnergyConsumption;
    }

    public String getConnectionType() {
        return ConnectionType;
    }

    public String getInterface() {
        return Interface;
    }

    public int getUsefulLife() {
        return UsefulLife;
    }

    public Object[] getRow() {
        row = new Object[4];
        row[0] = super.getTitle();
        row[1] = super.getMarca();
        row[2] = Type;
        row[3] = Factor;
        return row;
    }
}
