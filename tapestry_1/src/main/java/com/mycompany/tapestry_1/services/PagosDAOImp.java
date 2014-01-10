/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tapestry_1.services;

import entidades.Pagos;
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
public class PagosDAOImp implements PagosDAO{   
    
    public void insertarPagos(String npago,Double nprecio){
    try {
            Conexion objconexion = new Conexion();
            CallableStatement cstm = objconexion.getConexion().prepareCall("{call sp_insertar_pagos(?,?)}");                       
            cstm.setString(1,npago);
            cstm.setDouble(2,nprecio);
            cstm.execute();

        } catch (SQLException ex) {
            //Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(""+ex);
        }
}
    
    public void actualizarPago(Integer nidpago,String npago,Double nprecio){
    try {
            Conexion objconexion = new Conexion();
            CallableStatement cstm = objconexion.getConexion().prepareCall("{call sp_actualizar_pagos(?,?,?)}");
            cstm.setInt(1, nidpago);
            cstm.setString(2,npago);                      
            cstm.setDouble(3,nprecio);
            cstm.execute();
        } catch (SQLException ex) {
            //Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(""+ex);
        }
}
    
    public void eliminarPago(Integer nidpago){
     try {
            Conexion objconexion = new Conexion();
            CallableStatement cstm = objconexion.getConexion().prepareCall("{call sp_eliminar_pagos(?)}");            
            cstm.setInt(1, nidpago);
            cstm.execute();
        } catch (SQLException ex) {
            //Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(""+ex);
        }
}
    
    public Pagos buscarId(Integer idpago)
    {
     Pagos pago= new Pagos();      
     try
     {
       Conexion conexion= new Conexion();
       PreparedStatement pstm=conexion.getConexion().prepareStatement("SELECT * FROM pagos WHERE idpago=?");
       pstm.setInt(1, idpago);
       ResultSet rs=pstm.executeQuery();
       rs.next();
       pago.setIdpago(rs.getInt(1));
       pago.setNpago(rs.getString(2));       
       pago.setPrecio(rs.getDouble(3));
       rs.close();
       conexion.cerrarConexion();
     }
     catch(Exception ex)
      {
      System.out.println(""+ex);     
      }
     
     return pago;
    }
    public List<Pagos> listarTodos()
    {
       List<Pagos> lista= new ArrayList<Pagos>();       
       Pagos pago;
     try
     {
       Conexion objConexion=new Conexion();
       PreparedStatement pstm=objConexion.getConexion().prepareCall("SELECT * From pagos");
       ResultSet rs=pstm.executeQuery();
       while(rs.next())
       {
        pago = new Pagos();
        pago.setIdpago(rs.getInt(1));
        pago.setNpago(rs.getString(2));       
        pago.setPrecio(rs.getDouble(3));        
        lista.add(pago);
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
