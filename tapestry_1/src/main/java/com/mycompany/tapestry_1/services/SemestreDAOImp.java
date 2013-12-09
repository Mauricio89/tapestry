/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tapestry_1.services;

import entidades.Semestre;
import java.sql.CallableStatement;
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
public class SemestreDAOImp implements SemestreDAO{    
    
    public void insertarSemestre(String nsemestre){
    try {
            Conexion objconexion= new Conexion();
            CallableStatement cstm = objconexion.getConexion().prepareCall("{call sp_insertar_semestres(?)}"); 
            cstm.setString(1,nsemestre);            
            cstm.execute();

        } catch (SQLException ex) {
            //Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(""+ex);
        }
}
    
    public void actualizarSemestre(Integer nidsemestre,String nsemestre){
    try {
            Conexion objconexion= new Conexion();
            CallableStatement cstm = objconexion.getConexion().prepareCall("{call sp_actualizar_semestres(?,?)}");
            cstm.setInt(1, nidsemestre);
            cstm.setString(2,nsemestre);                      
            cstm.execute();
        } catch (SQLException ex) {
            //Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(""+ex);
        }
}
    
    public void eliminarSemestre(Integer nidsemestre){
     try {
            Conexion objconexion= new Conexion();
            CallableStatement cstm = objconexion.getConexion().prepareCall("{call sp_eliminar_semestres(?)}");            
            cstm.setInt(1, nidsemestre);
            cstm.execute();
        } catch (SQLException ex) {
            //Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(""+ex);
        }
}
    
    public Semestre buscarId(Integer idsemestre)
    {
     Semestre semestre= new Semestre();      
     try
     {
       Conexion objconexion= new Conexion();
       PreparedStatement pstm=objconexion.getConexion().prepareStatement("SELECT * FROM semestres WHERE idsemestre=?");
       pstm.setInt(1, idsemestre);
       ResultSet rs=pstm.executeQuery();
       rs.next();
       semestre.setIdsemestre(rs.getInt(1));
       semestre.setNsemestre(rs.getString(2));       
       rs.close();
       objconexion.cerrarConexion();
     }
     catch(Exception ex)
      {
      System.out.println(""+ex);      
      }
     
     return semestre;
    }
    public List<Semestre> listarTodos()
    {
       List<Semestre> lista= new ArrayList<Semestre>();       
       Semestre semestre;
     try
     {
       Conexion objConexion=new Conexion();
       PreparedStatement pstm=objConexion.getConexion().prepareCall("SELECT * From semestres");
       ResultSet rs=pstm.executeQuery();
       while(rs.next())
       {
        semestre = new Semestre();
        semestre.setIdsemestre(rs.getInt(1));
        semestre.setNsemestre(rs.getString(2));      
        lista.add(semestre);
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
