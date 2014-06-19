/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sfsg.services;

import entidades.Cantones;
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
public class CantonDAOImp implements CantonDAO{
    
   public void insertarCanton(Integer nidprovincia, String ncanton){
    try {
            Conexion objconexion = new Conexion();
            CallableStatement cstm = objconexion.getConexion().prepareCall("{call sp_insertar_canton(?,?)}");    
            cstm.setInt(1,nidprovincia);
            cstm.setString(2,ncanton);            
            cstm.execute();

        } catch (SQLException ex) {            
            System.out.println(""+ex);
        }
}
    
    public void actualizarCanton(Integer nidcanton, Integer nidprovincia, String ncanton){
    try {
            Conexion objconexion = new Conexion();
            CallableStatement cstm = objconexion.getConexion().prepareCall("{call sp_actualizar_canton(?,?,?)}");
            cstm.setInt(1, nidcanton);
            cstm.setInt(2, nidprovincia);
            cstm.setString(3,ncanton);                      
            cstm.execute();
        } catch (SQLException ex) {            
            System.out.println(""+ex);
        }
}
    
    public void eliminarCanton(Integer nidcanton){
     try {
            Conexion objconexion = new Conexion();
            CallableStatement cstm = objconexion.getConexion().prepareCall("{call sp_eliminar_canton(?)}");            
            cstm.setInt(1, nidcanton);
            cstm.execute();
        } catch (SQLException ex) {            
            System.out.println(""+ex);
        }
}
    
    public Cantones buscarId(Integer idcanton) 
    {
     Cantones cantones= new Cantones();
     try
     {
       Conexion conexion= new Conexion();
       PreparedStatement pstm=conexion.getConexion().prepareStatement("SELECT * FROM cantones WHERE idcanton=?");
       pstm.setInt(1, idcanton);
       ResultSet rs=pstm.executeQuery();
       rs.next();
       cantones.setIdcanton(rs.getInt(1));
       cantones.setIdprovincia(rs.getInt(2));
       cantones.setNcanton(rs.getString(3));       
       rs.close();
       conexion.cerrarConexion();
     }
     catch(Exception ex)
      {
          System.out.println(""+ex);
      }
     
     return cantones;
    }
    
    public List<Cantones> listarTodos()
    {
       List<Cantones> lista= new ArrayList<Cantones>();       
       Cantones cantones;
     try
     {
       Conexion objConexion=new Conexion();
       PreparedStatement pstm=objConexion.getConexion().prepareCall("SELECT * From cantones");
       ResultSet rs=pstm.executeQuery();
       while(rs.next())
       {
        cantones = new Cantones();
        cantones.setIdcanton(rs.getInt(1));
        cantones.setIdprovincia(rs.getInt(2));
        cantones.setNcanton(rs.getString(3));       
        lista.add(cantones);
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
        
    public List<Cantones> listarCantones(Integer idprovincia)
    {
       List<Cantones> lista= new ArrayList<Cantones>();       
       Cantones cantones;
     try
     {
       Conexion objConexion=new Conexion();
       PreparedStatement pstm=objConexion.getConexion().prepareCall("SELECT * From cantones WHERE idprovincia=?");
       pstm.setInt(1, idprovincia);
       ResultSet rs=pstm.executeQuery();
       while(rs.next())
       {
        cantones = new Cantones();
        cantones.setIdcanton(rs.getInt(1));
        cantones.setIdprovincia(rs.getInt(2));
        cantones.setNcanton(rs.getString(3));       
        lista.add(cantones);
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
