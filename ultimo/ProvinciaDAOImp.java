/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sfsg.services;

import entidades.Provincias;
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
public class ProvinciaDAOImp implements ProvinciaDAO{
    
    public void insertarProvincia(String nprovincia){
    try {
            Conexion objconexion = new Conexion();
            CallableStatement cstm = objconexion.getConexion().prepareCall("{call sp_insertar_provincia(?)}");    
            cstm.setString(1,nprovincia);            
            cstm.execute();

        } catch (SQLException ex) {            
            System.out.println(""+ex);
        }
}
    
    public void actualizarProvincia(Integer nidprovincia,String nprovincia){
    try {
            Conexion objconexion = new Conexion();
            CallableStatement cstm = objconexion.getConexion().prepareCall("{call sp_actualizar_provincia(?,?)}");
            cstm.setInt(1, nidprovincia);
            cstm.setString(2,nprovincia);                      
            cstm.execute();
        } catch (SQLException ex) {            
            System.out.println(""+ex);
        }
}
    
    public void eliminarProvincia(Integer nidprovincia){
     try {
            Conexion objconexion = new Conexion();
            CallableStatement cstm = objconexion.getConexion().prepareCall("{call sp_eliminar_provincia(?)}");            
            cstm.setInt(1, nidprovincia);
            cstm.execute();
        } catch (SQLException ex) {            
            System.out.println(""+ex);
        }
}
    
    public Provincias buscarId(Integer idprovincia) 
    {
     Provincias provincias= new Provincias();      
     try
     {
       Conexion conexion= new Conexion();
       PreparedStatement pstm=conexion.getConexion().prepareStatement("SELECT * FROM provincias WHERE idprovincia=?");
       pstm.setInt(1, idprovincia);
       ResultSet rs=pstm.executeQuery();
       rs.next();
       provincias.setIdprovincia(rs.getInt(1));
       provincias.setNprovincia(rs.getString(2));       
       rs.close();
       conexion.cerrarConexion();
     }
     catch(Exception ex)
      {
          System.out.println(""+ex);
      }
     
     return provincias ;
    }
    public List<Provincias> listarTodos()
    {
       List<Provincias> lista= new ArrayList<Provincias>();       
       Provincias provincias;
     try
     {
       Conexion objConexion=new Conexion();
       PreparedStatement pstm=objConexion.getConexion().prepareCall("SELECT * From provincias");
       ResultSet rs=pstm.executeQuery();
       while(rs.next())
       {
        provincias = new Provincias();
        provincias.setIdprovincia(rs.getInt(1));
        provincias.setNprovincia(rs.getString(2));       
        lista.add(provincias);
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
