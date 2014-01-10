/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tapestry_1.services;

import entidades.Usuario;
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
public class UsuarioDAOImp implements UsuarioDAO{
    
    public void insertarUsuario(String ncedula,String nnombres,String ndireccion,String ntelefono,String ncelular,String ncorreo,String ncuenta,String nclave){
    try {
            Conexion objconexion = new Conexion();
            CallableStatement cstm = objconexion.getConexion().prepareCall("{call sp_insertar_usuarios(?,?,?,?,?,?,?,?)}");    
            cstm.setString(1,ncedula); 
            cstm.setString(2,nnombres); 
            cstm.setString(3,ndireccion); 
            cstm.setString(4,ntelefono); 
            cstm.setString(5,ncelular); 
            cstm.setString(6,ncorreo); 
            cstm.setString(7,ncuenta);             
            cstm.setString(8,nclave); 
            cstm.execute();

        } catch (SQLException ex) {            
            System.out.println(""+ex);
        }
}
    
    public void actualizarUsuario(Integer nidusuario,String ncedula,String nnombres,String ndireccion,String ntelefono,String ncelular,String ncorreo,String ncuenta,String nclave){
    try {
            Conexion objconexion = new Conexion();
            CallableStatement cstm = objconexion.getConexion().prepareCall("{call sp_actualizar_usuarios(?,?,?,?,?,?,?,?,?)}");
            cstm.setInt(1, nidusuario);
            cstm.setString(2,ncedula); 
            cstm.setString(3,nnombres); 
            cstm.setString(4,ndireccion); 
            cstm.setString(5,ntelefono); 
            cstm.setString(6,ncelular); 
            cstm.setString(7,ncorreo); 
            cstm.setString(8,ncuenta);             
            cstm.setString(9,nclave); 
            cstm.execute();
        } catch (SQLException ex) {            
            System.out.println(""+ex);
        }
}
    
    public void eliminarUsuario(Integer nidusuario){
     try {
            Conexion objconexion = new Conexion();
            CallableStatement cstm = objconexion.getConexion().prepareCall("{call sp_eliminar_usuarios(?)}");            
            cstm.setInt(1, nidusuario);
            cstm.execute();
        } catch (SQLException ex) {            
            System.out.println(""+ex);
        }
}
    
    public Usuario buscarId(Integer idusuario) 
    {
     Usuario usuarios= new Usuario();      
     try
     {
       Conexion conexion= new Conexion();
       PreparedStatement pstm=conexion.getConexion().prepareStatement("SELECT * FROM usuarios WHERE idusuario=?");
       pstm.setInt(1, idusuario);
       ResultSet rs=pstm.executeQuery();
       rs.next();
       usuarios.setIdusuario(rs.getInt(1));
       usuarios.setCedula(rs.getString(2));       
       usuarios.setNombres(rs.getString(3));
       usuarios.setDireccion(rs.getString(4));
       usuarios.setTelefono(rs.getString(5));
       usuarios.setCelular(rs.getString(6));
       usuarios.setCorreo(rs.getString(7));
       usuarios.setCuenta(rs.getString(8));
       usuarios.setClave(rs.getString(9));
       rs.close();
       conexion.cerrarConexion();
     }
     catch(Exception ex)
      {
          System.out.println(""+ex);
      }
     
     return usuarios;
    }
    
    public List<Usuario> listarTodos()
    {
       List<Usuario> lista= new ArrayList<Usuario>();       
       Usuario usuarios;
     try
     {
       Conexion objConexion=new Conexion();
       PreparedStatement pstm=objConexion.getConexion().prepareCall("SELECT * From usuarios");
       ResultSet rs=pstm.executeQuery();
       while(rs.next())
       {
        usuarios = new Usuario();
        usuarios.setIdusuario(rs.getInt(1));
        usuarios.setCedula(rs.getString(2));       
        usuarios.setNombres(rs.getString(3));
        usuarios.setDireccion(rs.getString(4));
        usuarios.setTelefono(rs.getString(5));
        usuarios.setCelular(rs.getString(6));
        usuarios.setCorreo(rs.getString(7));
        usuarios.setCuenta(rs.getString(8));
        usuarios.setClave(rs.getString(9));
        lista.add(usuarios);
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
    
    public Usuario Autenticar(Usuario user)
    {
     Usuario clave=null;              
     ResultSet rs;
     try
     {
       Conexion conexion= new Conexion();
       PreparedStatement pstm=conexion.getConexion().prepareStatement("SELECT * FROM usuarios WHERE cuenta=? and clave=?");
       pstm.setString(1, user.getCuenta());
       pstm.setString(2, user.getClave());
       rs=pstm.executeQuery();
       if(rs.next()==true)
       {
        clave = new Usuario();
        clave.setIdusuario(rs.getInt(1));
        clave.setCuenta(rs.getString(2));
        clave.setClave(rs.getString(3));        
       }
       rs.close();
       conexion.cerrarConexion();
     }
     catch(Exception ex)
      {
      System.out.println(""+ex);      
      }
     
     return clave;
    }
}
