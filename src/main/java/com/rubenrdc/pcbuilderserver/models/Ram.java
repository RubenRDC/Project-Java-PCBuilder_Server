package com.rubenrdc.pcbuilderserver.models;

import java.io.Serializable;
import javax.swing.ImageIcon;

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
    public Ram(ImageIcon imagen, String title, String marca, int Capacity, int FrequencyRam) {
        super(imagen, title, marca);
        this.Capacity = Capacity;
        this.FrequencyRam = FrequencyRam;
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
