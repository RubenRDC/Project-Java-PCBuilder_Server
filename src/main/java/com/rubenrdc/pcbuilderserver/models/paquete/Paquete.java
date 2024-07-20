package com.rubenrdc.pcbuilderserver.models.paquete;

/**
 *
 * @author Ruben
 */
public class Paquete {

    public static final int TYPE_GET_MORE_INFO = -2, TYPE_GET_LIST = -1,
            TYPE_STORAGE = 0, TYPE_COOLER = 1,
            TYPE_POWER = 2, TYPE_GPU = 3, TYPE_TOWER = 4,
            TYPE_MOTHER = 5, TYPE_CPU = 6, TYPE_RAM = 7;
    public static final int SCODE_NO_CONTENT=204,SCODE_OK=200,SCODE_NO_FOUND=404;
}
