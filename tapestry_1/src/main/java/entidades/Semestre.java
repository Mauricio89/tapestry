/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Mauricio
 */
public class Semestre {
     private Integer idsemestre;     
     private String nsemestre;

    /**
     * @return the idsemestre
     */
    public Integer getIdsemestre() {
        return idsemestre;
    }

    /**
     * @param idsemestre the idsemestre to set
     */
    public void setIdsemestre(Integer idsemestre) {
        this.idsemestre = idsemestre;
    }

    /**
     * @return the nsemestre
     */
    public String getNsemestre() {
        return nsemestre;
    }

    /**
     * @param nsemestre the nsemestre to set
     */
    public void setNsemestre(String nsemestre) {
        this.nsemestre = nsemestre;
    }
}
