package com.rubenrdc.pcbuilderserver.models;

import java.io.Serializable;
import javax.swing.ImageIcon;
import org.bson.types.ObjectId;

/**
 *
 * @author Ruben
 */
public class GPU extends Articulo implements Serializable {

    //Height Altura
    private static final long serialVersionUID = 1L;
    private String Type, ChipsetGpu, Serie, TypeMemory;
    private int VGA, DVI, HDMI, DisplayPorts, Height, Length, EnergyConsumption, MemoryVRam, SpeedMemory, RecommMinimWatts;
    private Object row[];
    
    public GPU(String title, String marca) {
        super(title, marca);
    }

    //Basic Information
    public GPU(ObjectId id,ImageIcon imagen, String title, String marca, String Serie, int MemoryVRam) {
        super(id,imagen, title, marca);
        this.Serie = Serie;
        this.MemoryVRam = MemoryVRam;
    }

    public String getType() {
        return Type;
    }

    public String getChipsetGpu() {
        return ChipsetGpu;
    }

    public String getSerie() {
        return Serie;
    }

    public String getTypeMemory() {
        return TypeMemory;
    }

    public int getVGA() {
        return VGA;
    }

    public int getDVI() {
        return DVI;
    }

    public int getHDMI() {
        return HDMI;
    }

    public int getDisplayPorts() {
        return DisplayPorts;
    }

    public int getHeight() {
        return Height;
    }

    public int getLength() {
        return Length;
    }

    public int getEnergyConsumption() {
        return EnergyConsumption;
    }

    public int getMemoryVRam() {
        return MemoryVRam;
    }

    public int getSpeedMemory() {
        return SpeedMemory;
    }

    public int getRecommMinimWatts() {
        return RecommMinimWatts;
    }
    public Object[] getRow() {
        row = new Object[4];
        row[0] = super.getTitle();
        row[1] = super.getMarca();
        row[2] = Serie;
        row[3] = MemoryVRam;
        return row;
    }
}
