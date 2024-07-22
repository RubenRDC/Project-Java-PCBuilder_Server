package com.rubenrdc.pcbuilder.models;

import java.io.Serializable;
import org.bson.types.ObjectId;

/**
 *
 * @author Ruben
 */
public class GPU extends Articulo implements Serializable {

    //Height Altura
    private static final long serialVersionUID = 1L;
    private String Type, ChipsetGpu, TypeMemory;
    private int VGA, DVI, HDMI, DisplayPorts, Height, Length, EnergyConsumption, MemoryVRam, SpeedMemory, RecommMinimWatts;
    private Object row[];

    public GPU(String title, String marca) {
        super(title, marca);
    }

    //Basic Information
    public GPU(ObjectId id, String imagen, String title, String marca, String TypeMemory, int MemoryVRam,int Length) {
        super(id, imagen, title, marca);
        this.TypeMemory = TypeMemory;
        this.MemoryVRam = MemoryVRam;
        this.Length=Length;
    }

    //Complete Info
    public GPU(ObjectId id, String imagen, String title, String marca, String Type, String ChipsetGpu, String TypeMemory, int VGA, int DVI, int HDMI, int DisplayPorts, int Height, int Length, int EnergyConsumption, int MemoryVRam, int SpeedMemory, int RecommMinimWatts, String oficialDocumentation) {
        super(id, imagen, title, marca, oficialDocumentation);
        this.Type = Type;
        this.ChipsetGpu = ChipsetGpu;
        this.TypeMemory = TypeMemory;
        this.VGA = VGA;
        this.DVI = DVI;
        this.HDMI = HDMI;
        this.DisplayPorts = DisplayPorts;
        this.Height = Height;
        this.Length = Length;
        this.EnergyConsumption = EnergyConsumption;
        this.MemoryVRam = MemoryVRam;
        this.SpeedMemory = SpeedMemory;
        this.RecommMinimWatts = RecommMinimWatts;
    }

    public String getType() {
        return Type;
    }

    public String getChipsetGpu() {
        return ChipsetGpu;
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
        row[2] = TypeMemory;
        row[3] = MemoryVRam;
        return row;
    }
}
