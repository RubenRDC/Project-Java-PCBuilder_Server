package com.rubenrdc.pcbuilderserver.models.paquete;

import com.rubenrdc.pcbuilderserver.models.Articulo;
import java.util.List;
import java.io.Serializable;

/**
 *
 * @author Ruben
 */
public class PaqueteRecepcionClient<T extends Articulo> extends Paquete implements Serializable {

    private static final long serialVersionUID = 1L;
    private final int TYPE_PAQ, TYPE_ART, STATUS_CODE;
    private List<T> listArts;
    private T artCompl;
    
    public PaqueteRecepcionClient(int STATUS_CODE, int TYPE_PAQ, int TYPE_ART, List<T> listArt) {
        this.STATUS_CODE = STATUS_CODE;
        this.TYPE_PAQ = TYPE_PAQ;
        this.TYPE_ART = TYPE_ART;
        this.listArts = listArt;
    }
    
    public PaqueteRecepcionClient(int STATUS_CODE, int TYPE_PAQ, int TYPE_ART) {
        this.STATUS_CODE = STATUS_CODE;
        this.TYPE_PAQ = TYPE_PAQ;
        this.TYPE_ART = TYPE_ART;
    }

    public PaqueteRecepcionClient(int STATUS_CODE, int TYPE_PAQ, int TYPE_ART, T artCompl) {
        this.STATUS_CODE = STATUS_CODE;
        this.TYPE_PAQ = TYPE_PAQ;
        this.TYPE_ART = TYPE_ART;
        this.artCompl = artCompl;
    }

    public int getSTATUS_CODE() {
        return STATUS_CODE;
    }

    public List<T> getListArts() {
        return listArts;
    }

    public T getArtCompl() {
        return artCompl;
    }

    public int getTYPE_PAQ() {
        return TYPE_PAQ;
    }

    public int getTYPE_ART() {
        return TYPE_ART;
    }
    

}
