package com.rubenrdc.pcbuilderserver.models.interfaces;

import java.net.MalformedURLException;
import javax.swing.ImageIcon;

/**
 *
 * @author Ruben
 */
public interface Utilities {
    public static ImageIcon generateImageIcon(String path) {
        try {
            //Carga la imagen si es que existe caso contrario lanza una excepcion.
            java.net.URL imgURL = new java.net.URL(path);
            if (path != null) {
                return new ImageIcon(imgURL);
            }
        } catch (MalformedURLException ex) {
        }
        return new ImageIcon("pathServerImagenNoEncontrada");
    }
}
