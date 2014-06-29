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
import java.util.Date;
import java.util.List;
import persistencia.Conexion;

/**
 *
 * @author Mauricio
 */
public class AlumnoPagoDAOImp implements AlumnoPagoDAO{
    
    public void insertarAlumno_Pago(Integer nidalumno,Integer nidpago,Integer nidcarrera,Integer nidsemestre,Integer nidseccion,Integer nidperiodo,String nfecha){
    try {
            Conexion objconexion = new Conexion();
            CallableStatement cstm = objconexion.getConexion().prepareCall("{call sp_insertar_alumnopago(?,?,?,?,?,?,?)}");    
            cstm.setInt(1,nidalumno);
            cstm.setInt(2,nidpago);
            cstm.setInt(3,nidcarrera);
            cstm.setInt(4,nidsemestre);
            cstm.setInt(5,nidseccion);
            cstm.setInt(6,nidperiodo); 
            //cstm.setDate(7,new java.sql.Date(nfecha.getTime()));
            cstm.setString(7, nfecha);
            cstm.execute();

        } catch (SQLException ex) {
            //Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(""+ex);
        }
}
    
    public void actualizarAlumno_Pago(Integer nidalum_pag,Integer nidalumno,Integer nidpago,Integer nidcarrera,Integer nidsemestre,Integer nidseccion,Integer nidperiodo,String nfecha){
    try {
            Conexion objconexion = new Conexion();
            CallableStatement cstm = objconexion.getConexion().prepareCall("{call sp_actualizar_alumnopago(?,?,?,?,?,?,?,?)}");
            cstm.setInt(1,nidalum_pag);
            cstm.setInt(2,nidalumno);
            cstm.setInt(3,nidpago);
            cstm.setInt(4,nidcarrera);
            cstm.setInt(5,nidsemestre);
            cstm.setInt(6,nidseccion);
            cstm.setInt(7,nidperiodo);
            //cstm.setDate(8,new java.sql.Date(nfecha.getTime()));
            cstm.setString(8, nfecha);
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
       alum_pag.setIdseccion(rs.getInt(6));
       alum_pag.setIdperiodo(rs.getInt(7));       
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
        alum_pags.setIdseccion(rs.getInt(6));
        alum_pags.setIdperiodo(rs.getInt(7));        
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
       PreparedStatement pstm=conexion.getConexion().prepareStatement("SELECT idalum_pag,cedula,nombres,carrera,semestre,pago,seccion,periodo,direccion,telefono,precio,fecha,finicio,ffin FROM alumno_pago INNER JOIN alumnos ON alumno_pago.idalumno=alumnos.idalumno INNER JOIN carreras ON alumno_pago.idcarrera=carreras.idcarrera INNER JOIN semestres ON alumno_pago.idsemestre=semestres.idsemestre INNER JOIN pagos ON alumno_pago.idpago=pagos.idpago INNER JOIN secciones ON alumno_pago.idseccion=secciones.idseccion INNER JOIN periodos ON alumno_pago.idperiodo=periodos.idperiodo WHERE alumno_pago.idalum_pag=?");
       pstm.setInt(1, idalum_pag);
       ResultSet rs=pstm.executeQuery();
       rs.next();
       datos.setNidalum_pag(rs.getInt(1));
       datos.setCedula(rs.getString(2));
       datos.setNombres(rs.getString(3));
       datos.setNcarrera(rs.getString(4));
       datos.setNsemestre(rs.getString(5));
       datos.setNpago(rs.getString(6));
       datos.setNseccion(rs.getString(7));
       datos.setNperiodo(rs.getString(8));
       datos.setDireccion(rs.getString(9));
       datos.setTelefono(rs.getString(10));
       datos.setPrecio(rs.getDouble(11));
       datos.setFecha(rs.getDate(12));
       datos.setFinicio(rs.getDate(13));
       datos.setFfin(rs.getDate(14));       
       rs.close();
       conexion.cerrarConexion();
     }
     catch(Exception ex)
      {
      System.out.println(""+ex);   
      }
     
     return datos;
    }
      
    public List<GeneralAlumnoPago> listarTodosPagos()
    {
        List<GeneralAlumnoPago> lista=new ArrayList<GeneralAlumnoPago>();
        String sql="SELECT idalum_pag,cedula,nombres,carrera,semestre,pago,seccion,periodo,direccion,telefono,precio,fecha,finicio,ffin FROM alumno_pago INNER JOIN alumnos ON alumno_pago.idalumno=alumnos.idalumno INNER JOIN carreras ON alumno_pago.idcarrera=carreras.idcarrera INNER JOIN semestres ON alumno_pago.idsemestre=semestres.idsemestre INNER JOIN pagos ON alumno_pago.idpago=pagos.idpago INNER JOIN secciones ON alumno_pago.idseccion=secciones.idseccion INNER JOIN periodos ON alumno_pago.idperiodo=periodos.idperiodo ORDER BY alumnos.nombres";
       GeneralAlumnoPago general;
        try
       {
           Conexion objConexion=new Conexion();
           PreparedStatement pstm=objConexion.getConexion().prepareCall(sql);                   
           ResultSet rs= pstm.executeQuery();
           while(rs.next())
           {            
            general=new GeneralAlumnoPago();
            general.setNidalum_pag(rs.getInt(1));
            general.setCedula(rs.getString(2));
            general.setNombres(rs.getString(3));
            general.setNcarrera(rs.getString(4));
            general.setNsemestre(rs.getString(5));
            general.setNpago(rs.getString(6));
            general.setNseccion(rs.getString(7));
            general.setNperiodo(rs.getString(8));
            general.setDireccion(rs.getString(9));
            general.setTelefono(rs.getString(10));
            general.setPrecio(rs.getDouble(11));
            general.setFecha(rs.getDate(12));
            general.setFinicio(rs.getDate(13));
            general.setFfin(rs.getDate(14));
            lista.add(general);
           }
           //rs.close();
           pstm.close();           
           objConexion.cerrarConexion();
           rs.close();
           
       }
       catch(Exception ex)
       {
           System.out.println(""+ex); 
            //throw new Exception("ERROR LISTAR GENERAL: "+ ex);      
       }
        return lista;
    }
    
    public List<GeneralAlumnoPago> listarTodosFecha(String finicio1, String ffin1)
    {
        List<GeneralAlumnoPago> lista=new ArrayList<GeneralAlumnoPago>();
        //java.sql.Date fechainicio=new java.sql.Date(finicio1.getTime());
        //java.sql.Date fechafin=new java.sql.Date(ffin1.getTime());
        String sql="SELECT idalum_pag,cedula,nombres,carrera,semestre,pago,seccion,periodo,direccion,telefono,precio,fecha,finicio,ffin FROM alumno_pago INNER JOIN alumnos ON alumno_pago.idalumno=alumnos.idalumno INNER JOIN carreras ON alumno_pago.idcarrera=carreras.idcarrera INNER JOIN semestres ON alumno_pago.idsemestre=semestres.idsemestre INNER JOIN pagos ON alumno_pago.idpago=pagos.idpago INNER JOIN secciones ON alumno_pago.idseccion=secciones.idseccion INNER JOIN periodos ON alumno_pago.idperiodo=periodos.idperiodo WHERE alumno_pago.fecha BETWEEN ? and ? ORDER BY alumnos.nombres";
       GeneralAlumnoPago general;
        try
       {
           Conexion objConexion=new Conexion();
           PreparedStatement pstm=objConexion.getConexion().prepareCall(sql);          
           pstm.setString(1,finicio1);
           pstm.setString(2,ffin1);
           ResultSet rs= pstm.executeQuery();
           while(rs.next())
           {            
            general=new GeneralAlumnoPago();
            general.setNidalum_pag(rs.getInt(1));
            general.setCedula(rs.getString(2));
            general.setNombres(rs.getString(3));
            general.setNcarrera(rs.getString(4));
            general.setNsemestre(rs.getString(5));
            general.setNpago(rs.getString(6));
            general.setNseccion(rs.getString(7));
            general.setNperiodo(rs.getString(8));
            general.setDireccion(rs.getString(9));
            general.setTelefono(rs.getString(10));
            general.setPrecio(rs.getDouble(11));
            general.setFecha(rs.getDate(12));
            general.setFinicio(rs.getDate(13));
            general.setFfin(rs.getDate(14));
            lista.add(general);
           }
           //rs.close();
           pstm.close();           
           objConexion.cerrarConexion();
           rs.close();
           
       }
       catch(Exception ex)
       {
           System.out.println(""+ex); 
            //throw new Exception("ERROR LISTAR GENERAL: "+ ex);      
       }
        return lista;
    }
    
    public List<GeneralAlumnoPago> listarTodosCarrera(String ncarrera)
    {
        List<GeneralAlumnoPago> lista=new ArrayList<GeneralAlumnoPago>();
        //java.sql.Date fechainicio=new java.sql.Date(finicio1.getTime());
        //java.sql.Date fechafin=new java.sql.Date(ffin1.getTime());
        String sql="SELECT idalum_pag,cedula,nombres,carrera,semestre,pago,seccion,periodo,direccion,telefono,precio,fecha,finicio,ffin FROM alumno_pago INNER JOIN alumnos ON alumno_pago.idalumno=alumnos.idalumno INNER JOIN carreras ON alumno_pago.idcarrera=carreras.idcarrera INNER JOIN semestres ON alumno_pago.idsemestre=semestres.idsemestre INNER JOIN pagos ON alumno_pago.idpago=pagos.idpago INNER JOIN secciones ON alumno_pago.idseccion=secciones.idseccion INNER JOIN periodos ON alumno_pago.idperiodo=periodos.idperiodo WHERE carreras.carrera=? ORDER BY alumnos.nombres";
       GeneralAlumnoPago general;
        try
       {
           Conexion objConexion=new Conexion();
           PreparedStatement pstm=objConexion.getConexion().prepareCall(sql);          
           pstm.setString(1,ncarrera);           
           ResultSet rs= pstm.executeQuery();
           while(rs.next())
           {            
            general=new GeneralAlumnoPago();
            general.setNidalum_pag(rs.getInt(1));
            general.setCedula(rs.getString(2));
            general.setNombres(rs.getString(3));
            general.setNcarrera(rs.getString(4));
            general.setNsemestre(rs.getString(5));
            general.setNpago(rs.getString(6));
            general.setNseccion(rs.getString(7));
            general.setNperiodo(rs.getString(8));
            general.setDireccion(rs.getString(9));
            general.setTelefono(rs.getString(10));
            general.setPrecio(rs.getDouble(11));
            general.setFecha(rs.getDate(12));
            general.setFinicio(rs.getDate(13));
            general.setFfin(rs.getDate(14));
            lista.add(general);
           }
           //rs.close();
           pstm.close();           
           objConexion.cerrarConexion();
           rs.close();
           
       }
       catch(Exception ex)
       {
           System.out.println(""+ex); 
            //throw new Exception("ERROR LISTAR GENERAL: "+ ex);      
       }
        return lista;
    }
    
    public List<GeneralAlumnoPago> listarTodosPago(String npago)
    {
        List<GeneralAlumnoPago> lista=new ArrayList<GeneralAlumnoPago>();
        //java.sql.Date fechainicio=new java.sql.Date(finicio1.getTime());
        //java.sql.Date fechafin=new java.sql.Date(ffin1.getTime());
        String sql="SELECT idalum_pag,cedula,nombres,carrera,semestre,pago,seccion,periodo,direccion,telefono,precio,fecha,finicio,ffin FROM alumno_pago INNER JOIN alumnos ON alumno_pago.idalumno=alumnos.idalumno INNER JOIN carreras ON alumno_pago.idcarrera=carreras.idcarrera INNER JOIN semestres ON alumno_pago.idsemestre=semestres.idsemestre INNER JOIN pagos ON alumno_pago.idpago=pagos.idpago INNER JOIN secciones ON alumno_pago.idseccion=secciones.idseccion INNER JOIN periodos ON alumno_pago.idperiodo=periodos.idperiodo WHERE pagos.pago=? ORDER BY alumnos.nombres";
       GeneralAlumnoPago general;
        try
       {
           Conexion objConexion=new Conexion();
           PreparedStatement pstm=objConexion.getConexion().prepareCall(sql);          
           pstm.setString(1,npago);           
           ResultSet rs= pstm.executeQuery();
           while(rs.next())
           {            
            general=new GeneralAlumnoPago();
            general.setNidalum_pag(rs.getInt(1));
            general.setCedula(rs.getString(2));
            general.setNombres(rs.getString(3));
            general.setNcarrera(rs.getString(4));
            general.setNsemestre(rs.getString(5));
            general.setNpago(rs.getString(6));
            general.setNseccion(rs.getString(7));
            general.setNperiodo(rs.getString(8));
            general.setDireccion(rs.getString(9));
            general.setTelefono(rs.getString(10));
            general.setPrecio(rs.getDouble(11));
            general.setFecha(rs.getDate(12));
            general.setFinicio(rs.getDate(13));
            general.setFfin(rs.getDate(14));
            lista.add(general);
           }
           //rs.close();
           pstm.close();           
           objConexion.cerrarConexion();
           rs.close();
           
       }
       catch(Exception ex)
       {
           System.out.println(""+ex); 
            //throw new Exception("ERROR LISTAR GENERAL: "+ ex);      
       }
        return lista;
    }
    
    public List<GeneralAlumnoPago> listarTodosPeriodo(String nperiodo)
    {
        List<GeneralAlumnoPago> lista=new ArrayList<GeneralAlumnoPago>();
        //java.sql.Date fechainicio=new java.sql.Date(finicio1.getTime());
        //java.sql.Date fechafin=new java.sql.Date(ffin1.getTime());
        String sql="SELECT idalum_pag,cedula,nombres,carrera,semestre,pago,seccion,periodo,direccion,telefono,precio,fecha,finicio,ffin FROM alumno_pago INNER JOIN alumnos ON alumno_pago.idalumno=alumnos.idalumno INNER JOIN carreras ON alumno_pago.idcarrera=carreras.idcarrera INNER JOIN semestres ON alumno_pago.idsemestre=semestres.idsemestre INNER JOIN pagos ON alumno_pago.idpago=pagos.idpago INNER JOIN secciones ON alumno_pago.idseccion=secciones.idseccion INNER JOIN periodos ON alumno_pago.idperiodo=periodos.idperiodo WHERE periodos.periodo=? ORDER BY alumnos.nombres";
       GeneralAlumnoPago general;
        try
       {
           Conexion objConexion=new Conexion();
           PreparedStatement pstm=objConexion.getConexion().prepareCall(sql);          
           pstm.setString(1,nperiodo);           
           ResultSet rs= pstm.executeQuery();
           while(rs.next())
           {            
            general=new GeneralAlumnoPago();
            general.setNidalum_pag(rs.getInt(1));
            general.setCedula(rs.getString(2));
            general.setNombres(rs.getString(3));
            general.setNcarrera(rs.getString(4));
            general.setNsemestre(rs.getString(5));
            general.setNpago(rs.getString(6));
            general.setNseccion(rs.getString(7));
            general.setNperiodo(rs.getString(8));
            general.setDireccion(rs.getString(9));
            general.setTelefono(rs.getString(10));
            general.setPrecio(rs.getDouble(11));
            general.setFecha(rs.getDate(12));
            general.setFinicio(rs.getDate(13));
            general.setFfin(rs.getDate(14));
            lista.add(general);
           }
           //rs.close();
           pstm.close();           
           objConexion.cerrarConexion();
           rs.close();
           
       }
       catch(Exception ex)
       {
           System.out.println(""+ex); 
            //throw new Exception("ERROR LISTAR GENERAL: "+ ex);      
       }
        return lista;
    }
    
    public List<GeneralAlumnoPago> listarTodosSeccion(String nseccion)
    {
        List<GeneralAlumnoPago> lista=new ArrayList<GeneralAlumnoPago>();
        //java.sql.Date fechainicio=new java.sql.Date(finicio1.getTime());
        //java.sql.Date fechafin=new java.sql.Date(ffin1.getTime());
        String sql="SELECT idalum_pag,cedula,nombres,carrera,semestre,pago,seccion,periodo,direccion,telefono,precio,fecha,finicio,ffin FROM alumno_pago INNER JOIN alumnos ON alumno_pago.idalumno=alumnos.idalumno INNER JOIN carreras ON alumno_pago.idcarrera=carreras.idcarrera INNER JOIN semestres ON alumno_pago.idsemestre=semestres.idsemestre INNER JOIN pagos ON alumno_pago.idpago=pagos.idpago INNER JOIN secciones ON alumno_pago.idseccion=secciones.idseccion INNER JOIN periodos ON alumno_pago.idperiodo=periodos.idperiodo WHERE secciones.seccion=? ORDER BY alumnos.nombres";
       GeneralAlumnoPago general;
        try
       {
           Conexion objConexion=new Conexion();
           PreparedStatement pstm=objConexion.getConexion().prepareCall(sql);          
           pstm.setString(1,nseccion);           
           ResultSet rs= pstm.executeQuery();
           while(rs.next())
           {            
            general=new GeneralAlumnoPago();
            general.setNidalum_pag(rs.getInt(1));
            general.setCedula(rs.getString(2));
            general.setNombres(rs.getString(3));
            general.setNcarrera(rs.getString(4));
            general.setNsemestre(rs.getString(5));
            general.setNpago(rs.getString(6));
            general.setNseccion(rs.getString(7));
            general.setNperiodo(rs.getString(8));
            general.setDireccion(rs.getString(9));
            general.setTelefono(rs.getString(10));
            general.setPrecio(rs.getDouble(11));
            general.setFecha(rs.getDate(12));
            general.setFinicio(rs.getDate(13));
            general.setFfin(rs.getDate(14));
            lista.add(general);
           }
           //rs.close();
           pstm.close();           
           objConexion.cerrarConexion();
           rs.close();
           
       }
       catch(Exception ex)
       {
           System.out.println(""+ex); 
            //throw new Exception("ERROR LISTAR GENERAL: "+ ex);      
       }
        return lista;
    }
    
    public List<GeneralAlumnoPago> listarTodosSemestre(String nsemestre)
    {
        List<GeneralAlumnoPago> lista=new ArrayList<GeneralAlumnoPago>();
        //java.sql.Date fechainicio=new java.sql.Date(finicio1.getTime());
        //java.sql.Date fechafin=new java.sql.Date(ffin1.getTime());
        String sql="SELECT idalum_pag,cedula,nombres,carrera,semestre,pago,seccion,periodo,direccion,telefono,precio,fecha,finicio,ffin FROM alumno_pago INNER JOIN alumnos ON alumno_pago.idalumno=alumnos.idalumno INNER JOIN carreras ON alumno_pago.idcarrera=carreras.idcarrera INNER JOIN semestres ON alumno_pago.idsemestre=semestres.idsemestre INNER JOIN pagos ON alumno_pago.idpago=pagos.idpago INNER JOIN secciones ON alumno_pago.idseccion=secciones.idseccion INNER JOIN periodos ON alumno_pago.idperiodo=periodos.idperiodo WHERE semestres.semestre=? ORDER BY alumnos.nombres";
       GeneralAlumnoPago general;
        try
       {
           Conexion objConexion=new Conexion();
           PreparedStatement pstm=objConexion.getConexion().prepareCall(sql);          
           pstm.setString(1,nsemestre);           
           ResultSet rs= pstm.executeQuery();
           while(rs.next())
           {            
            general=new GeneralAlumnoPago();
            general.setNidalum_pag(rs.getInt(1));
            general.setCedula(rs.getString(2));
            general.setNombres(rs.getString(3));
            general.setNcarrera(rs.getString(4));
            general.setNsemestre(rs.getString(5));
            general.setNpago(rs.getString(6));
            general.setNseccion(rs.getString(7));
            general.setNperiodo(rs.getString(8));
            general.setDireccion(rs.getString(9));
            general.setTelefono(rs.getString(10));
            general.setPrecio(rs.getDouble(11));
            general.setFecha(rs.getDate(12));
            general.setFinicio(rs.getDate(13));
            general.setFfin(rs.getDate(14));
            lista.add(general);
           }
           //rs.close();
           pstm.close();           
           objConexion.cerrarConexion();
           rs.close();
           
       }
       catch(Exception ex)
       {
           System.out.println(""+ex); 
            //throw new Exception("ERROR LISTAR GENERAL: "+ ex);      
       }
        return lista;
    }
    
    public Double total()
    {
        //java.math.BigDecimal valor = new java.math.BigDecimal("0.00");        
        //System.out.println(suma);
        Double valor = null;
        String sql="SELECT SUM(precio) FROM alumno_pago INNER JOIN alumnos ON alumno_pago.idalumno=alumnos.idalumno INNER JOIN carreras ON alumno_pago.idcarrera=carreras.idcarrera INNER JOIN semestres ON alumno_pago.idsemestre=semestres.idsemestre INNER JOIN pagos ON alumno_pago.idpago=pagos.idpago INNER JOIN secciones ON alumno_pago.idseccion=secciones.idseccion INNER JOIN periodos ON alumno_pago.idperiodo=periodos.idperiodo";       
        try
       {
           Conexion objConexion=new Conexion();
           PreparedStatement pstm=objConexion.getConexion().prepareCall(sql);          
           //pstm.setString(1,nsemestre);           
           ResultSet rs= pstm.executeQuery();
           valor = rs.getDouble(1);
           //java.math.BigDecimal valor=rs.getDouble(1);
           //rs.close();
           pstm.close();           
           objConexion.cerrarConexion();
           rs.close();
           //System.out.println(valor); 
       }
       catch(Exception ex)
       {
           System.out.println(""+ex); 
            //throw new Exception("ERROR LISTAR GENERAL: "+ ex);      
       }        
        return valor;
    }
}
