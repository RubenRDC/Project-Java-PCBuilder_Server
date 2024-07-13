package com.rubenrdc.pcbuilderserver.models;

import java.io.Serializable;
import javax.swing.ImageIcon;

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
    public MotherBoard(ImageIcon imagen, String title, String marca, String Chipset, String Factor) {
        super(imagen, title, marca);
        this.Chipset = Chipset;
        this.Factor = Factor;
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
