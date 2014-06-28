/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Mauricio
 */
public class Alumno_Pago {
    private Integer idalum_pag;
    private Integer idalumno;
    private Integer idpago;
    private Integer idcarrera;
    private Integer idsemestre;        
    private String seccion;        
    private String periodo;

    /**
     * @return the idalum_pag
     */
    public Integer getIdalum_pag() {
        return idalum_pag;
    }

    /**
     * @param idalum_pag the idalum_pag to set
     */
    public void setIdalum_pag(Integer idalum_pag) {
        this.idalum_pag = idalum_pag;
    }

    /**
     * @return the idalumno
     */
    public Integer getIdalumno() {
        return idalumno;
    }

    /**
     * @param idalumno the idalumno to set
     */
    public void setIdalumno(Integer idalumno) {
        this.idalumno = idalumno;
    }

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
     * @return the seccion
     */
    public String getSeccion() {
        return seccion;
    }

    /**
     * @param seccion the seccion to set
     */
    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    /**
     * @return the periodo
     */
    public String getPeriodo() {
        return periodo;
    }

    /**
     * @param periodo the periodo to set
     */
    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }
}
