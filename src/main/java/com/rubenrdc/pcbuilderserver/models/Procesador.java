package com.rubenrdc.pcbuilderserver.models;

import java.io.Serializable;
import javax.swing.ImageIcon;
import org.bson.types.ObjectId;

/**
 *
 * @author Ruben
 */
public class Procesador extends Articulo implements Serializable {

    private static final long serialVersionUID = 1L;
    private int Ncores, NThreads, TDP, frequencyMaxRam;
    private double frequencyBase, frequencyTurbo;
    private String ChipsetGPU, Socket, TypeMemory, Family;
    private boolean includeCooler;
    private Object row[];

    public Procesador(String title, String marca) {
        super(title, marca);
    }

    //Basic Information
    public Procesador(ObjectId id, ImageIcon imagen, String title, String marca, int Ncores, int NThreads, int frequencyTurbo) {
        super(id, imagen, title, marca);
        this.Ncores = Ncores;
        this.NThreads = NThreads;
        this.frequencyTurbo = frequencyTurbo;
    }

    //Complete Info
    public Procesador(ObjectId id, ImageIcon imagen, String title, String marca, int Ncores, int NThreads, int TDP, int frequencyMaxRam, double frequencyBase, double frequencyTurbo, String ChipsetGPU, String Socket, String TypeMemory, String Family, boolean includeCooler, String oficialDocumentation) {
        super(id, imagen, title, marca, oficialDocumentation);
        this.Ncores = Ncores;
        this.NThreads = NThreads;
        this.TDP = TDP;
        this.frequencyMaxRam = frequencyMaxRam;
        this.frequencyBase = frequencyBase;
        this.frequencyTurbo = frequencyTurbo;
        this.ChipsetGPU = ChipsetGPU;
        this.Socket = Socket;
        this.TypeMemory = TypeMemory;
        this.Family = Family;
        this.includeCooler = includeCooler;
    }

    public int getNcores() {
        return Ncores;
    }

    public int getNThreads() {
        return NThreads;
    }

    public int getTDP() {
        return TDP;
    }

    public int getFrequencyMaxRam() {
        return frequencyMaxRam;
    }

    public double getFrequencyBase() {
        return frequencyBase;
    }

    public double getFrequencyTurbo() {
        return frequencyTurbo;
    }

    public String getChipsetGPU() {
        return ChipsetGPU;
    }

    public String getSocket() {
        return Socket;
    }

    public String getTypeMemory() {
        return TypeMemory;
    }

    public boolean isIncludeCooler() {
        return includeCooler;
    }

    public String getFamily() {
        return Family;
    }

    public Object[] getRow() {
        row = new Object[5];
        row[0] = super.getTitle();
        row[1] = super.getMarca();
        row[2] = Ncores;
        row[3] = NThreads;
        row[4] = frequencyTurbo;
        return row;
    }
}
