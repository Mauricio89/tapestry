/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tapestry_1.services;

import entidades.Alumnos;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Mauricio
 */
public interface AlumnosDAO {
    
    public void insertarAlumnos(String ncedula,String nnombres,Date nfnac,String nlnac,String nlibretam,Integer nidestadocivil,
        String nnacionalidad,String nocupacion,Integer nidprovincia,Integer nidcanton,Integer nidciudad,String nsexo,String ndireccion,
        String ntelefono,String ncelular,String ncorreo,String ntelpariente,String ninstproviene,String nnpadre,String nppadre,
        String ndpadre,String nnmadre,String npmadre,String ndmadre);
    
     public void actualizarAlumnos(Integer nidalumno, String ncedula,String nnombres,Date nfnac,String nlnac,String nlibretam,Integer nidestadocivil,
        String nnacionalidad,String nocupacion,Integer nidprovincia,Integer nidcanton,Integer nidciudad,String nsexo,String ndireccion,
        String ntelefono,String ncelular,String ncorreo,String ntelpariente,String ninstproviene,String nnpadre,String nppadre,
        String ndpadre,String nnmadre,String npmadre,String ndmadre);
    
    public void eliminarAlumnos(Integer nidalumno);
    public Alumnos buscarId(Integer idalumno);
    public List <Alumnos> listarTodos(); 
}
