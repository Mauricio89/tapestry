/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sfsg.services;

import entidades.Alumno_Pago;
import entidades.Carrera;
import entidades.GeneralAlumnoPago;
import java.util.List;

/**
 *
 * @author Mauricio
 */
public interface AlumnoPagoDAO {
    public void insertarAlumno_Pago(Integer nidalumno,Integer nidpago,Integer nidcarrera,Integer nidsemestre,String nseccion,String nperiodo);
    public void actualizarAlumno_Pago(Integer nidalum_pag,Integer nidalumno,Integer nidpago,Integer nidcarrera,Integer nidsemestre,String nseccion,String nperiodo);
    public void eliminarALumno_Pago(Integer nidalum_pag); 
    public Alumno_Pago buscarId(Integer idalum_pag);
    public List <Alumno_Pago> listarTodos(); 
    public List<Carrera> listarCarreras();
    public GeneralAlumnoPago buscarTodoAP(Integer idalum_pag);
    public List<Alumno_Pago> listarTodosDatos();
}
