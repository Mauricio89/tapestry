/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tapestry_1.services;

import entidades.Carrera;
import persistencia.Conexion;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mauricio
 */
public class CarreraDAOImp implements CarreraDAO{
    
    public void insertarCarrera(String ncarrera){
    try {
            Conexion objconexion = new Conexion();
            CallableStatement cstm = objconexion.getConexion().prepareCall("{call sp_insertar_carrera(?)}");    
            cstm.setString(1,ncarrera);            
            cstm.execute();

        } catch (SQLException ex) {            
            System.out.println(""+ex);
        }
}
    
    public void actualizarCarrera(Integer nidcarrera,String ncarrera){
    try {
            Conexion objconexion = new Conexion();
            CallableStatement cstm = objconexion.getConexion().prepareCall("{call sp_actualizar_carrera(?,?)}");
            cstm.setInt(1, nidcarrera);
            cstm.setString(2,ncarrera);                      
            cstm.execute();
        } catch (SQLException ex) {            
            System.out.println(""+ex);
        }
}
    
    public void eliminarCarrera(Integer nidcarrera){
     try {
            Conexion objconexion = new Conexion();
            CallableStatement cstm = objconexion.getConexion().prepareCall("{call sp_eliminar_carrera(?)}");            
            cstm.setInt(1, nidcarrera);
            cstm.execute();
        } catch (SQLException ex) {            
            System.out.println(""+ex);
        }
}
    
    public Carrera buscarId(Integer idcarrera) 
    {
     Carrera carreras= new Carrera();      
     try
     {
       Conexion conexion= new Conexion();
       PreparedStatement pstm=conexion.getConexion().prepareStatement("SELECT * FROM carreras WHERE idcarrera=?");
       pstm.setInt(1, idcarrera);
       ResultSet rs=pstm.executeQuery();
       rs.next();
       carreras.setIdcarrera(rs.getInt(1));
       carreras.setNcarrera(rs.getString(2));       
       rs.close();
       conexion.cerrarConexion();
     }
     catch(Exception ex)
      {
          System.out.println(""+ex);
      }
     
     return carreras ;
    }
    public List<Carrera> listarTodos()
    {
       List<Carrera> lista= new ArrayList<Carrera>();       
       Carrera carreras;
     try
     {
       Conexion objConexion=new Conexion();
       PreparedStatement pstm=objConexion.getConexion().prepareCall("SELECT * From carreras");
       ResultSet rs=pstm.executeQuery();
       while(rs.next())
       {
        carreras = new Carrera();
        carreras.setIdcarrera(rs.getInt(1));
        carreras.setNcarrera(rs.getString(2));       
        lista.add(carreras);
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
