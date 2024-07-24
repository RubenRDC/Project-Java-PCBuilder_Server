package com.rubenrdc.pcbuilder.models;

import java.io.Serializable;
import org.bson.types.ObjectId;

/**
 *
 * @author Ruben
 */
public class MotherBoard extends Articulo implements Serializable {

    //Socket AM4/AM5 etc...
    //Family Amd/Intel
    //Chipset A550 etc...
    private static final long serialVersionUID = 1L;
    private String Family, Socket, Chipset, MemoryType, Factor;
    private int EnergyConsumption, SataSlots, PCIEx16Slots, PCIEx1Slots, MemorySlots, M2NvmeSlots, M2SataSlots;
    private Object row[];

    public MotherBoard(String title, String marca) {
        super(title, marca);
    }

    //Basic Information
    public MotherBoard(ObjectId id, String imagen, String title, String marca, String Chipset, String Factor,String MemoryType,int MemorySlots) {
        super(id, imagen, title, marca);
        this.Chipset = Chipset;
        this.Factor = Factor;
        this.MemoryType = MemoryType;
        this.MemorySlots = MemorySlots;
    }

    //Complete Info
    public MotherBoard(ObjectId id, String imagen, String title, String marca, String Chipset, String Factor, String Family, String Socket, String MemoryType, int MemorySlots, int EnergyConsumption, int SataSlots, int PCIEx16Slots, int PCIEx1Slots, int M2NvmeSlots, int M2SataSlots, String oficialDocumentation) {
        super(id, imagen, title, marca, oficialDocumentation);
        this.Family = Family;
        this.Socket = Socket;
        this.Chipset = Chipset;
        this.MemoryType = MemoryType;
        this.Factor = Factor;
        this.EnergyConsumption = EnergyConsumption;
        this.SataSlots = SataSlots;
        this.PCIEx16Slots = PCIEx16Slots;
        this.PCIEx1Slots = PCIEx1Slots;
        this.MemorySlots = MemorySlots;
        this.M2NvmeSlots = M2NvmeSlots;
        this.M2SataSlots = M2SataSlots;
    }

    public String getFamily() {
        return Family;
    }

    public String getSocket() {
        return Socket;
    }

    public String getChipset() {
        return Chipset;
    }

    public String getMemoryType() {
        return MemoryType;
    }

    public String getFactor() {
        return Factor;
    }

    public int getEnergyConsumption() {
        return EnergyConsumption;
    }

    public int getSataSlots() {
        return SataSlots;
    }

    public int getPCIEx16Slots() {
        return PCIEx16Slots;
    }

    public int getPCIEx1Slots() {
        return PCIEx1Slots;
    }

    public int getMemorySlots() {
        return MemorySlots;
    }

    public int getM2NvmeSlots() {
        return M2NvmeSlots;
    }

    public int getM2SataSlots() {
        return M2SataSlots;
    }

    public Object[] getRow() {
        row = new Object[4];
        row[0] = super.getTitle();
        row[1] = super.getMarca();
        row[2] = Chipset;
        row[3] = Factor;
        return row;
    }
}
