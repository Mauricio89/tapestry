/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tapestry_1.services;

import entidades.Alumnos;
import java.sql.CallableStatement;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import persistencia.Conexion;

/**
 *
 * @author Mauricio
 */
public class AlumnosDAOImp implements AlumnosDAO{
    
    public void insertarAlumnos(String ncedula,String nnombres,Date nfnac,String nlnac,String nlibretam,Integer nidestadocivil,
        String nnacionalidad,String nocupacion,Integer nidprovincia,Integer nidcanton,Integer nidciudad,String nsexo,String ndireccion,
        String ntelefono,String ncelular,String ncorreo,String ntelpariente,String ninstproviene,String nnpadre,String nppadre,
        String ndpadre,String nnmadre,String npmadre,String ndmadre){
    try {
            Conexion objconexion = new Conexion();
            CallableStatement cstm = objconexion.getConexion().prepareCall("{call sp_insertar_alumnos(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");            
            cstm.setString(1,ncedula);
            cstm.setString(2,nnombres);            
            cstm.setDate(3,new java.sql.Date(nfnac.getTime()));
            cstm.setString(4,nlnac);
            cstm.setString(5,nlibretam);
            cstm.setInt(6,nidestadocivil);
            cstm.setString(7,nnacionalidad);
            cstm.setString(8,nocupacion);
            cstm.setInt(9,nidprovincia);
            cstm.setInt(10,nidcanton);
            cstm.setInt(11,nidciudad);
            cstm.setString(12,nsexo);
            cstm.setString(13,ndireccion);
            cstm.setString(14,ntelefono);
            cstm.setString(15,ncelular);
            cstm.setString(16,ncorreo);
            cstm.setString(17,ntelpariente);
            cstm.setString(18,ninstproviene);
            cstm.setString(19,nnpadre);
            cstm.setString(20,nppadre);
            cstm.setString(21,ndpadre);
            cstm.setString(22,nnmadre);
            cstm.setString(23,npmadre);
            cstm.setString(24,ndmadre);
            cstm.execute();

        } catch (SQLException ex) {
            //Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(""+ex);
        }
}
    
    public void actualizarAlumnos(Integer nidalumno,String ncedula,String nnombres,Date nfnac,String nlnac,String nlibretam,Integer nidestadocivil,
        String nnacionalidad,String nocupacion,Integer nidprovincia,Integer nidcanton,Integer nidciudad,String nsexo,String ndireccion,
        String ntelefono,String ncelular,String ncorreo,String ntelpariente,String ninstproviene,String nnpadre,String nppadre,
        String ndpadre,String nnmadre,String npmadre,String ndmadre){
    try {
            Conexion objconexion = new Conexion();
            CallableStatement cstm = objconexion.getConexion().prepareCall("{call sp_actualizar_alumnos(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");            
            cstm.setInt(1,nidalumno);
            cstm.setString(2,ncedula);
            cstm.setString(3,nnombres);
            cstm.setDate(4,new java.sql.Date(nfnac.getTime()));
            cstm.setString(5,nlnac);
            cstm.setString(6,nlibretam);
            cstm.setInt(7,nidestadocivil);
            cstm.setString(8,nnacionalidad);
            cstm.setString(9,nocupacion);
            cstm.setInt(10,nidprovincia);
            cstm.setInt(11,nidcanton);
            cstm.setInt(12,nidciudad);
            cstm.setString(13,nsexo);
            cstm.setString(14,ndireccion);
            cstm.setString(15,ntelefono);
            cstm.setString(16,ncelular);
            cstm.setString(17,ncorreo);
            cstm.setString(18,ntelpariente);
            cstm.setString(19,ninstproviene);
            cstm.setString(20,nnpadre);
            cstm.setString(21,nppadre);
            cstm.setString(22,ndpadre);
            cstm.setString(23,nnmadre);
            cstm.setString(24,npmadre);
            cstm.setString(25,ndmadre);            
            cstm.execute();
        } catch (SQLException ex) {
            //Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(""+ex);
        }
}
    
    public void eliminarAlumnos(Integer nidalumno){
     try {
            Conexion objconexion = new Conexion();
            CallableStatement cstm = objconexion.getConexion().prepareCall("{call sp_eliminar_alumnos(?)}");            
            cstm.setInt(1, nidalumno);
            cstm.execute();
        } catch (SQLException ex) {
            //Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(""+ex);
        }
}
    
    public Alumnos buscarId(Integer idalumno)
    {
     Alumnos alumno= new Alumnos();      
     try
     {
       Conexion conexion= new Conexion();
       PreparedStatement pstm=conexion.getConexion().prepareStatement("SELECT * FROM alumnos WHERE idalumno=?");
       pstm.setInt(1, idalumno);
       ResultSet rs=pstm.executeQuery();
       rs.next();
       alumno.setIdalumno(rs.getInt(1));
       alumno.setCedula(rs.getString(2));
       alumno.setNombres(rs.getString(3));
       alumno.setFnac(rs.getDate(4));
       alumno.setLnac(rs.getString(5));
       alumno.setLibretam(rs.getString(6));
       alumno.setIdestadocivil(rs.getInt(7));
       alumno.setNacionalidad(rs.getString(8));
       alumno.setOcupacion(rs.getString(9));
       alumno.setIdprovincia(rs.getInt(10));
       alumno.setIdcanton(rs.getInt(11));
       alumno.setIdciudad(rs.getInt(12));
       alumno.setSexo(rs.getString(13));
       alumno.setDireccion(rs.getString(14));
       alumno.setTelefono(rs.getString(15));
       alumno.setCelular(rs.getString(16));
       alumno.setCorreo(rs.getString(17));
       alumno.setTelpariente(rs.getString(18));
       alumno.setInstproviene(rs.getString(19));
       alumno.setNpadre(rs.getString(20));
       alumno.setPpadre(rs.getString(21));
       alumno.setDpadre(rs.getString(22));
       alumno.setNmadre(rs.getString(23));
       alumno.setPmadre(rs.getString(24));
       alumno.setDmadre(rs.getString(25));     
       rs.close();
       conexion.cerrarConexion();
     }
     catch(Exception ex)
      {
      System.out.println(""+ex);   
      }
     
     return alumno;
    }
    public List<Alumnos> listarTodos()
    {
       List<Alumnos> lista= new ArrayList<Alumnos>();       
       Alumnos alumnos;
     try
     {
       Conexion objConexion=new Conexion();
       PreparedStatement pstm=objConexion.getConexion().prepareCall("SELECT * From alumnos");
       ResultSet rs=pstm.executeQuery();
       while(rs.next())
       {
        alumnos = new Alumnos();
        alumnos.setIdalumno(rs.getInt(1));
        alumnos.setCedula(rs.getString(2));
        alumnos.setNombres(rs.getString(3));
        alumnos.setFnac(rs.getDate(4));
        alumnos.setLnac(rs.getString(5));
        alumnos.setLibretam(rs.getString(6));
        alumnos.setIdestadocivil(rs.getInt(7));
        alumnos.setNacionalidad(rs.getString(8));
        alumnos.setOcupacion(rs.getString(9));
        alumnos.setIdprovincia(rs.getInt(10));
        alumnos.setIdcanton(rs.getInt(11));
        alumnos.setIdciudad(rs.getInt(12));
        alumnos.setSexo(rs.getString(13));
        alumnos.setDireccion(rs.getString(14));
        alumnos.setTelefono(rs.getString(15));
        alumnos.setCelular(rs.getString(16));
        alumnos.setCorreo(rs.getString(17));
        alumnos.setTelpariente(rs.getString(18));
        alumnos.setInstproviene(rs.getString(19));
        alumnos.setNpadre(rs.getString(20));
        alumnos.setPpadre(rs.getString(21));
        alumnos.setDpadre(rs.getString(22));
        alumnos.setNmadre(rs.getString(23));
        alumnos.setPmadre(rs.getString(24));
        alumnos.setDmadre(rs.getString(25));          
        lista.add(alumnos);
       }
        objConexion.cerrarConexion();
        rs.close();
     }
     catch(Exception ex)
        {
            System.out.println(""+ex);
             //throw new Exception("ERROR LISTAR:" + ex);
        }
     return lista;
    }
    
}
