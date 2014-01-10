/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Mauricio
 */
public class Pagos {
     private Integer idpago;     
     private String npago;
     private Double precio;

    /**
     * @return the idpago
     */
    public Integer getIdpago() {
        return idpago;
    }

    /**
     * @param idpago the idpago to set
     */
    public void setIdpago(Integer idpago) {
        this.idpago = idpago;
    }

    /**
     * @return the npago
     */
    public String getNpago() {
        return npago;
    }

    /**
     * @param npago the npago to set
     */
    public void setNpago(String npago) {
        this.npago = npago;
    }

    /**
     * @return the precio
     */
    public Double getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}
