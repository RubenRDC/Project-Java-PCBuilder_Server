package com.rubenrdc.pcbuilder.models;

import java.io.Serializable;
import org.bson.types.ObjectId;

/**
 *
 * @author Ruben
 */
public class Ram extends Articulo implements Serializable {

    private static final long serialVersionUID = 1L;
    //Lantencia unidad CL,Frecuencia unidad MHz...
    private int FrequencyRam, Capacity, Latency;
    private String Type;
    private double Voltage;
    private boolean Dissipation;
    private Object row[];

    public Ram(String title, String marca) {
        super(title, marca);
    }

    //Basic Information
    public Ram(ObjectId id, String imagen, String title, String marca, int Capacity, int FrequencyRam) {
        super(id, imagen, title, marca);
        this.Capacity = Capacity;
        this.FrequencyRam = FrequencyRam;
    }

    //Complete Info
    public Ram(ObjectId id, String imagen, String title, String marca, int FrequencyRam, int Capacity, int Latency, String Type, double Voltage, boolean Dissipation, String oficialDocumentation) {
        super(id, imagen, title, marca, oficialDocumentation);
        this.FrequencyRam = FrequencyRam;
        this.Capacity = Capacity;
        this.Latency = Latency;
        this.Type = Type;
        this.Voltage = Voltage;
        this.Dissipation = Dissipation;
    }

    public int getFrequencyRam() {
        return FrequencyRam;
    }

    public int getCapacity() {
        return Capacity;
    }

    public int getLatency() {
        return Latency;
    }

    public String getType() {
        return Type;
    }

    public double getVoltage() {
        return Voltage;
    }

    public boolean isDissipation() {
        return Dissipation;
    }

    public Object[] getRow() {
        row = new Object[4];
        row[0] = super.getTitle();
        row[1] = super.getMarca();
        row[2] = Capacity;
        row[3] = FrequencyRam;
        return row;
    }
}
