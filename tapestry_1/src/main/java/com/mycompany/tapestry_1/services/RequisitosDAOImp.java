/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tapestry_1.services;

import entidades.Requisitos;
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
public class RequisitosDAOImp implements RequisitosDAO{   
    
    public void InsertarRequisito(String nrequisito){
    try {
            Conexion objconexion = new Conexion();
            CallableStatement cstm = objconexion.getConexion().prepareCall("{call sp_insertar_requisitos(?)}");
            cstm.setString(1,nrequisito);    
            cstm.execute();

        } catch (SQLException ex) {
            //Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(""+ex);
        }
}
    
    public void ActualizarRequisito(Integer nidrequisito,String nrequisito){
    try {
            Conexion objconexion = new Conexion();
            CallableStatement cstm = objconexion.getConexion().prepareCall("{call sp_actualizar_requisitos(?,?)}");
            cstm.setInt(1, nidrequisito);
            cstm.setString(2,nrequisito);                      
            cstm.execute();
        } catch (SQLException ex) {
            //Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(""+ex);
        }
}
    
    public void EliminarRequsiito(Integer nidrequisito){
     try {
            Conexion objconexion = new Conexion();
            CallableStatement cstm = objconexion.getConexion().prepareCall("{call sp_eliminar_requisitos(?)}");            
            cstm.setInt(1, nidrequisito);
            cstm.execute();
        } catch (SQLException ex) {
            //Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(""+ex);
        }
}
   
    public Requisitos buscarId(Integer idrequisito)
    {
     Requisitos requisito= new Requisitos();      
     try
     {
       Conexion objconexion= new Conexion();
       PreparedStatement pstm=objconexion.getConexion().prepareStatement("SELECT * FROM requisitos WHERE idrequisito=?");
       pstm.setInt(1, idrequisito);
       ResultSet rs=pstm.executeQuery();
       rs.next();
       requisito.setIdrequisito(rs.getInt(1));
       requisito.setNrequisito(rs.getString(2));       
       rs.close();
       objconexion.cerrarConexion();
     }
     catch(Exception ex)
      {
      System.out.println(""+ex);      
      }
     
     return requisito;
    }
    public List<Requisitos> listarTodos()
    {
       List<Requisitos> lista= new ArrayList<Requisitos>();       
       Requisitos requisito;
     try
     {
       Conexion objConexion=new Conexion();
       PreparedStatement pstm=objConexion.getConexion().prepareCall("SELECT * From requisitos");
       ResultSet rs=pstm.executeQuery();
       while(rs.next())
       {
        requisito = new Requisitos();
        requisito.setIdrequisito(rs.getInt(1));
        requisito.setNrequisito(rs.getString(2));      
        lista.add(requisito);
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
