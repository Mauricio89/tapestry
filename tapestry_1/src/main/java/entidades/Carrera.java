/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import org.apache.tapestry5.annotations.Parameter;

/**
 *
 * @author Mauricio
 */
public class Carrera {     
     private Integer idcarrera;     
     private String ncarrera;

    /**
     * @return the idcarrera
     */
    public Integer getIdcarrera() {
        return idcarrera;
    }

    /**
     * @param idcarrera the idcarrera to set
     */
    public void setIdcarrera(Integer idcarrera) {
        this.idcarrera = idcarrera;
    }

    /**
     * @return the ncarrera
     */
    public String getNcarrera() {
        return ncarrera;
    }

    /**
     * @param ncarrera the ncarrera to set
     */
    public void setNcarrera(String ncarrera) {
        this.ncarrera = ncarrera;
    }
}
