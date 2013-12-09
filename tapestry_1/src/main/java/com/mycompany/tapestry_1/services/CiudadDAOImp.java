/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tapestry_1.services;

import entidades.Ciudades;
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
public class CiudadDAOImp implements CiudadDAO{
    
    public void insertarCiudad(Integer nidprovincia, String nciudad){
    try {
            Conexion objconexion = new Conexion();
            CallableStatement cstm = objconexion.getConexion().prepareCall("{call sp_insertar_ciudad(?,?)}");    
            cstm.setInt(1,nidprovincia);
            cstm.setString(2,nciudad);            
            cstm.execute();

        } catch (SQLException ex) {            
            System.out.println(""+ex);
        }
}
    
    public void actualizarCiudad(Integer nidciudad, Integer nidprovincia, String nciudad){
    try {
            Conexion objconexion = new Conexion();
            CallableStatement cstm = objconexion.getConexion().prepareCall("{call sp_actualizar_ciudad(?,?,?)}");
            cstm.setInt(1, nidciudad);
            cstm.setInt(2, nidprovincia);
            cstm.setString(3,nciudad);                      
            cstm.execute();
        } catch (SQLException ex) {            
            System.out.println(""+ex);
        }
}
    
    public void eliminarCiudad(Integer nidciudad){
     try {
            Conexion objconexion = new Conexion();
            CallableStatement cstm = objconexion.getConexion().prepareCall("{call sp_eliminar_ciudad(?)}");            
            cstm.setInt(1, nidciudad);
            cstm.execute();
        } catch (SQLException ex) {            
            System.out.println(""+ex);
        }
}
    
    public Ciudades buscarId(Integer idciudad) 
    {
     Ciudades ciudades= new Ciudades();      
     try
     {
       Conexion conexion= new Conexion();
       PreparedStatement pstm=conexion.getConexion().prepareStatement("SELECT * FROM ciudades WHERE idciudad=?");
       pstm.setInt(1, idciudad);
       ResultSet rs=pstm.executeQuery();
       rs.next();
       ciudades.setIdciudad(rs.getInt(1));
       ciudades.setIdprovincia(rs.getInt(2));
       ciudades.setNciudad(rs.getString(3));       
       rs.close();
       conexion.cerrarConexion();
     }
     catch(Exception ex)
      {
          System.out.println(""+ex);
      }
     
     return ciudades;
    }
    public List<Ciudades> listarTodos()
    {
       List<Ciudades> lista= new ArrayList<Ciudades>();       
       Ciudades ciudades;
     try
     {
       Conexion objConexion=new Conexion();
       PreparedStatement pstm=objConexion.getConexion().prepareCall("SELECT * From ciudades");
       ResultSet rs=pstm.executeQuery();
       while(rs.next())
       {
        ciudades = new Ciudades();
        ciudades.setIdciudad(rs.getInt(1));
        ciudades.setIdprovincia(rs.getInt(2));
        ciudades.setNciudad(rs.getString(3));       
        lista.add(ciudades);
       }
        objConexion.cerrarConexion();
        rs.close();
     }     
     catch(Exception ex)
        {            
            System.out.println(""+ex);            
        }
     return lista;
    }
}
