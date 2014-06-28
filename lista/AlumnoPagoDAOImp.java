/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sfsg.services;

import entidades.Alumno_Pago;
import entidades.Alumnos;
import entidades.Carrera;
import entidades.GeneralAlumnoPago;
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
public class AlumnoPagoDAOImp implements AlumnoPagoDAO{
    
    public void insertarAlumno_Pago(Integer nidalumno,Integer nidpago,Integer nidcarrera,Integer nidsemestre,String nseccion,String nperiodo){
    try {
            Conexion objconexion = new Conexion();
            CallableStatement cstm = objconexion.getConexion().prepareCall("{call sp_insertar_alumnopago(?,?,?,?,?,?)}");    
            cstm.setInt(1,nidalumno);
            cstm.setInt(2,nidpago);
            cstm.setInt(3,nidcarrera);
            cstm.setInt(4,nidsemestre);
            cstm.setString(5,nseccion);
            cstm.setString(6,nperiodo);            
            cstm.execute();

        } catch (SQLException ex) {
            //Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(""+ex);
        }
}
    
    public void actualizarAlumno_Pago(Integer nidalum_pag,Integer nidalumno,Integer nidpago,Integer nidcarrera,Integer nidsemestre,String nseccion,String nperiodo){
    try {
            Conexion objconexion = new Conexion();
            CallableStatement cstm = objconexion.getConexion().prepareCall("{call sp_actualizar_alumnopago(?,?,?,?,?,?,?)}");
            cstm.setInt(1,nidalum_pag);
            cstm.setInt(2,nidalumno);
            cstm.setInt(3,nidpago);
            cstm.setInt(4,nidcarrera);
            cstm.setInt(5,nidsemestre);
            cstm.setString(6,nseccion);
            cstm.setString(7,nperiodo);            
            cstm.execute();
        } catch (SQLException ex) {
            //Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(""+ex);
        }
}
    
    public void eliminarALumno_Pago(Integer nidalum_pag){
     try {
            Conexion objconexion = new Conexion();
            CallableStatement cstm = objconexion.getConexion().prepareCall("{call sp_eliminar_alumnopago(?)}");            
            cstm.setInt(1, nidalum_pag);
            cstm.execute();
        } catch (SQLException ex) {
            //Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(""+ex);
        }
}    
    
    public Alumno_Pago buscarId(Integer idalum_pag)
    {
     Alumno_Pago alum_pag= new Alumno_Pago();      
     try
     {
       Conexion conexion= new Conexion();
       PreparedStatement pstm=conexion.getConexion().prepareStatement("SELECT * FROM alumno_pago WHERE idalum_pag=?");
       pstm.setInt(1, idalum_pag);
       ResultSet rs=pstm.executeQuery();
       rs.next();
       alum_pag.setIdalum_pag(rs.getInt(1));
       alum_pag.setIdalumno(rs.getInt(2));      
       alum_pag.setIdcarrera(rs.getInt(3));
       alum_pag.setIdpago(rs.getInt(4));
       alum_pag.setIdsemestre(rs.getInt(5));
       alum_pag.setSeccion(rs.getString(6));
       alum_pag.setPeriodo(rs.getString(7));       
       rs.close();
       conexion.cerrarConexion();
     }
     catch(Exception ex)
      {
      System.out.println(""+ex);   
      }     
     return alum_pag ;
    }
    
    public List<Alumno_Pago> listarTodos()
    {
       List<Alumno_Pago> lista= new ArrayList<Alumno_Pago>();       
       Alumno_Pago alum_pags;
     try
     {
       Conexion objConexion=new Conexion();
       PreparedStatement pstm=objConexion.getConexion().prepareCall("SELECT * From alumno_pago");
       ResultSet rs=pstm.executeQuery();
       while(rs.next())
       {
        alum_pags = new Alumno_Pago();
        alum_pags.setIdalum_pag(rs.getInt(1));
        alum_pags.setIdalumno(rs.getInt(2));      
        alum_pags.setIdcarrera(rs.getInt(3));
        alum_pags.setIdpago(rs.getInt(4));
        alum_pags.setIdsemestre(rs.getInt(5));
        alum_pags.setSeccion(rs.getString(6));
        alum_pags.setPeriodo(rs.getString(7));       
        lista.add(alum_pags);
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
    
    public List<Carrera> listarCarreras()
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
     //catch (JDBCException ex )
     catch(Exception ex)
        {
            //throw new RuntimeException(ex) ;
            System.out.println(""+ex);
             //throw new Exception("ERROR LISTAR:" + ex);
        }
     return lista;
    }
    
    public GeneralAlumnoPago buscarTodoAP(Integer idalum_pag)
    {
     GeneralAlumnoPago datos= new GeneralAlumnoPago();      
     try
     {
       Conexion conexion= new Conexion();
       PreparedStatement pstm=conexion.getConexion().prepareStatement("SELECT * FROM alumno_pago "
               + "INNER JOIN alumnos ON alumno_pago.idalumno=alumnos.idalumno "
               + "INEER JOIN carreras ON alumno_pago.idcarrera=carreras.idcarrera "
               + "INEER JOIN pagos ON alumno_pago.idpago=pagos.idpago"
               + "INEER JOIN semestres ON alumno_pago.idsemestre=semestres.idsemestre "
               + "WHERE idalum_pag=?");
       pstm.setInt(1, idalum_pag);
       ResultSet rs=pstm.executeQuery();
       rs.next();
       datos.setCedula(rs.getString(1));
       datos.setNombres(rs.getString(2));      
       datos.setCarrera(rs.getString(3));
       datos.setSemestre(rs.getString(4));
       datos.setPago(rs.getString(5));
       datos.setSeccion(rs.getString(6));
       datos.setPeriodo(rs.getString(7));       
       rs.close();
       conexion.cerrarConexion();
     }
     catch(Exception ex)
      {
      System.out.println(""+ex);   
      }
     
     return datos;
    }
    
    public List<Alumno_Pago> listarTodosDatos()
    {
       List<Alumno_Pago> lista= new ArrayList<Alumno_Pago>();       
       Alumno_Pago alum_pags;
       List<Alumnos> lista1= new ArrayList<Alumnos>();       
       Alumnos alumno = null;
     try
     {
       Conexion objConexion=new Conexion();
       PreparedStatement pstm=objConexion.getConexion().prepareCall("SELECT * FROM alumno_pago "
               + "INNER JOIN alumnos ON alumno_pago.idalumno=alumnos.idalumno "
               + "INEER JOIN carreras ON alumno_pago.idcarrera=carreras.idcarrera "
               + "INEER JOIN pagos ON alumno_pago.idpago=pagos.idpago"
               + "INEER JOIN semestres ON alumno_pago.idsemestre=semestres.idsemestre ");
       ResultSet rs=pstm.executeQuery();
       while(rs.next())
       {
        alum_pags = new Alumno_Pago();
        alum_pags.setIdalum_pag(rs.getInt(1));
        alumno.setNombres(rs.getString(2));        
        alum_pags.setIdalumno(rs.getInt(2));      
        alum_pags.setIdcarrera(rs.getInt(3));
        alum_pags.setIdpago(rs.getInt(4));
        alum_pags.setIdsemestre(rs.getInt(5));
        alum_pags.setSeccion(rs.getString(6));
        alum_pags.setPeriodo(rs.getString(7));       
        lista.add(alum_pags);
        lista1.add(alumno);
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
