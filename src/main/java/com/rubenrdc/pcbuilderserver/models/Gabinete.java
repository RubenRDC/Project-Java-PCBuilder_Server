package com.rubenrdc.pcbuilderserver.models;

import java.io.Serializable;
import javax.swing.ImageIcon;
import org.bson.types.ObjectId;

/**
 *
 * @author Ruben
 */
public class Gabinete extends Articulo implements Serializable {

    private static final long serialVersionUID = 1L;
    private String FactorMother, PowerFactor;
    private boolean Window, SoportWaterRadiator;
    private int TypeWindow, Width, Height, Length, MaxSoportCoolerHeight, SoportCoolersFan80,
            SoportCoolersFan120, SoportCoolersFan140, SoportCoolersFan200, SoportRadiator240, SoportRadiator280,
            SoportRadiator360, SoportRadiator420, StorageSlots, SoportFactor2_5,
            SoportFactor3_25, SoportFactor3_5, SoportFactor5_25;
    private Object row[];

    public Gabinete(String title, String marca) {
        super(title, marca);
    }

    //Basic Information
    public Gabinete(ObjectId id, ImageIcon imagen, String title, String marca, String FactorMother, String PowerFactor) {
        super(id, imagen, title, marca);
        this.FactorMother = FactorMother;
        this.PowerFactor = PowerFactor;
    }

    //Complete Info
    public Gabinete(ObjectId id, ImageIcon imagen, String title, String marca, String FactorMother, String PowerFactor, boolean Window, int TypeWindow, boolean SoportWaterRadiator, int Width, int Height, int Length, int MaxSoportCoolerHeight, int SoportCoolersFan80, int SoportCoolersFan120, int SoportCoolersFan140, int SoportCoolersFan200, int SoportRadiator240, int SoportRadiator280, int SoportRadiator360, int SoportRadiator420, int StorageSlots, int SoportFactor2_5, int SoportFactor3_25, int SoportFactor3_5, int SoportFactor5_25, String oficialDocumentation) {
        super(id, imagen, title, marca, oficialDocumentation);
        this.FactorMother = FactorMother;
        this.PowerFactor = PowerFactor;
        this.Window = Window;
        this.SoportWaterRadiator = SoportWaterRadiator;
        this.TypeWindow = TypeWindow;
        this.Width = Width;
        this.Height = Height;
        this.Length = Length;
        this.MaxSoportCoolerHeight = MaxSoportCoolerHeight;
        this.SoportCoolersFan80 = SoportCoolersFan80;
        this.SoportCoolersFan120 = SoportCoolersFan120;
        this.SoportCoolersFan140 = SoportCoolersFan140;
        this.SoportCoolersFan200 = SoportCoolersFan200;
        this.SoportRadiator240 = SoportRadiator240;
        this.SoportRadiator280 = SoportRadiator280;
        this.SoportRadiator360 = SoportRadiator360;
        this.SoportRadiator420 = SoportRadiator420;
        this.StorageSlots = StorageSlots;
        this.SoportFactor2_5 = SoportFactor2_5;
        this.SoportFactor3_25 = SoportFactor3_25;
        this.SoportFactor3_5 = SoportFactor3_5;
        this.SoportFactor5_25 = SoportFactor5_25;
    }

    public String getFactorMother() {
        return FactorMother;
    }

    public String getPowerFactor() {
        return PowerFactor;
    }

    public boolean isWindow() {
        return Window;
    }

    public boolean isSoportWaterRadiator() {
        return SoportWaterRadiator;
    }

    public int getTypeWindow() {
        return TypeWindow;
    }

    public int getWidth() {
        return Width;
    }

    public int getHeight() {
        return Height;
    }

    public int getLength() {
        return Length;
    }

    public int getSoportCoolersFan80() {
        return SoportCoolersFan80;
    }

    public int getSoportCoolersFan120() {
        return SoportCoolersFan120;
    }

    public int getSoportCoolersFan140() {
        return SoportCoolersFan140;
    }

    public int getSoportCoolersFan200() {
        return SoportCoolersFan200;
    }

    public int getMaxSoportCoolerHeight() {
        return MaxSoportCoolerHeight;
    }

    public int getSoportRadiator240() {
        return SoportRadiator240;
    }

    public int getSoportRadiator280() {
        return SoportRadiator280;
    }

    public int getSoportRadiator360() {
        return SoportRadiator360;
    }

    public int getSoportRadiator420() {
        return SoportRadiator420;
    }

    public int getStorageSlots() {
        return StorageSlots;
    }

    public int getSoportFactor2_5() {
        return SoportFactor2_5;
    }

    public int getSoportFactor3_25() {
        return SoportFactor3_25;
    }

    public int getSoportFactor3_5() {
        return SoportFactor3_5;
    }

    public int getSoportFactor5_25() {
        return SoportFactor5_25;
    }

    public Object[] getRow() {
        row = new Object[4];
        row[0] = super.getTitle();
        row[1] = super.getMarca();
        row[2] = FactorMother;
        row[3] = PowerFactor;
        return row;
    }
}
