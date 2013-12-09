/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Mauricio
 */
public class Ciudades {
    private Integer idciudad;     
    private Integer idprovincia;
    private String nciudad;

    /**
     * @return the idciudad
     */
    public Integer getIdciudad() {
        return idciudad;
    }

    /**
     * @param idciudad the idciudad to set
     */
    public void setIdciudad(Integer idciudad) {
        this.idciudad = idciudad;
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
     * @return the nciudad
     */
    public String getNciudad() {
        return nciudad;
    }

    /**
     * @param nciudad the nciudad to set
     */
    public void setNciudad(String nciudad) {
        this.nciudad = nciudad;
    }
}
