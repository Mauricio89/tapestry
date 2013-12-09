/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tapestry_1.services;

import entidades.EstadoCivil;
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
public class EstadoCivilDAOImp implements EstadoCivilDAO{
    
    public void insertarEstado_Civil(String nestadocivil){
    try {
            Conexion objconexion = new Conexion();
            CallableStatement cstm = objconexion.getConexion().prepareCall("{call sp_insertar_estadocivil(?)}");                       
            cstm.setString(1,nestadocivil);            
            cstm.execute();

        } catch (SQLException ex) {
            //Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(""+ex);
        }
}
    
    public void actualizarEstado_Civil(Integer nidestadocivil,String nestadocivil){
    try {
            Conexion objconexion = new Conexion();
            CallableStatement cstm = objconexion.getConexion().prepareCall("{call sp_actualizar_estadocivil(?,?)}");
            cstm.setInt(1, nidestadocivil);
            cstm.setString(2,nestadocivil);                      
            cstm.execute();
        } catch (SQLException ex) {
            //Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(""+ex);
        }
}
    
    public void eliminarEstado_Civil(Integer nidestadocivil){
     try {
            Conexion objconexion = new Conexion();
            CallableStatement cstm = objconexion.getConexion().prepareCall("{call sp_eliminar_estadocivil(?)}");            
            cstm.setInt(1, nidestadocivil);
            cstm.execute();
        } catch (SQLException ex) {
            //Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(""+ex);
        }
}
    
    public EstadoCivil buscarId(Integer idestadocivil)
    {
     EstadoCivil estadocivil= new EstadoCivil();      
     try
     {
       Conexion conexion= new Conexion();
       PreparedStatement pstm=conexion.getConexion().prepareStatement("SELECT * FROM estado_civil WHERE idestadocivil=?");
       pstm.setInt(1, idestadocivil);
       ResultSet rs=pstm.executeQuery();
       rs.next();
       estadocivil.setIdestadocivil(rs.getInt(1));
       estadocivil.setNestadocivil(rs.getString(2));       
       rs.close();
       conexion.cerrarConexion();
     }
     catch(Exception ex)
      {
      System.out.println(""+ex);      
      }
     
     return estadocivil;
    }
    public List<EstadoCivil> listarTodos()
    {
       List<EstadoCivil> lista= new ArrayList<EstadoCivil>();       
       EstadoCivil estadocivil;
     try
     {
       Conexion objConexion=new Conexion();
       PreparedStatement pstm=objConexion.getConexion().prepareCall("SELECT * From estado_civil");
       ResultSet rs=pstm.executeQuery();
       while(rs.next())
       {
        estadocivil = new EstadoCivil();
        estadocivil.setIdestadocivil(rs.getInt(1));
        estadocivil.setNestadocivil(rs.getString(2));        
        lista.add(estadocivil);
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
