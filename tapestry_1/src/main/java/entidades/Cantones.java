/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Mauricio
 */
public class Cantones {
    private Integer idcanton; 
    private Integer idprovincia;
    private String ncanton;

    /**
     * @return the idcanton
     */
    public Integer getIdcanton() {
        return idcanton;
    }

    /**
     * @param idcanton the idcanton to set
     */
    public void setIdcanton(Integer idcanton) {
        this.idcanton = idcanton;
    }

    /**
     * @return the idprovincia
     */
    public Integer getIdprovincia() {
        return idprovincia;
    }

    /**
     * @param idprovincia the idprovincia to set
     */
    public void setIdprovincia(Integer idprovincia) {
        this.idprovincia = idprovincia;
    }

    /**
     * @return the ncanton
     */
    public String getNcanton() {
        return ncanton;
    }

    /**
     * @param ncanton the ncanton to set
     */
    public void setNcanton(String ncanton) {
        this.ncanton = ncanton;
    }
}
