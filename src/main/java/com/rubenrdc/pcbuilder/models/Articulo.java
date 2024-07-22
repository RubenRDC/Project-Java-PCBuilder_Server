package com.rubenrdc.pcbuilder.models;

import java.io.Serializable;
import org.bson.types.ObjectId;

/**
 *
 * @author Ruben
 */
public class Articulo implements Comparable, Serializable {

    private static final long serialVersionUID = 1L;
    private ObjectId id;
    private String title, marca, oficialDocumentation;
    private String imagen;
    private Object row[];

    public Articulo(String title, String marca) {
        this.title = title;
        this.marca = marca;
    }

    public Articulo(ObjectId id, String imagen, String title, String marca) {
        this.id = id;
        this.imagen = imagen;
        this.title = title;
        this.marca = marca;
    }

    public Articulo(ObjectId id, String imagen, String title, String marca, String oficialDocumentation) {
        this.id = id;
        this.imagen = imagen;
        this.title = title;
        this.marca = marca;
        this.oficialDocumentation = oficialDocumentation;
    }

    public ObjectId getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String fileName) {
        this.imagen = fileName;
    }

    public String getOficialDocumentation() {
        return oficialDocumentation;
    }

    public void setOficialDocumentation(String oficialDocumentation) {
        this.oficialDocumentation = oficialDocumentation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o.getClass() == this.getClass()) {
            Articulo art = (Articulo) o;
            if (art.getTitle().equals(this.getTitle()) & art.getMarca().equals(this.getMarca())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int compareTo(Object o) {
        Articulo art = (Articulo) o;
        int compareToIgnoreCase = this.title.compareToIgnoreCase(art.title);
        if (compareToIgnoreCase == 0) {
            return 0;
        } else if (compareToIgnoreCase < 0) {
            return -1;
        }
        return 1;
    }

    public Object[] getRow() {
        row = new Object[2];
        row[0] = title;
        row[1] = marca;
        return row;
    }

    public int getEnergyConsumption() {
        return 0;
    }
}
