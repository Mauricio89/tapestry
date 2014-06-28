/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sfsg.pages;

import com.mycompany.sfsg.services.AlumnoPagoDAO;
import com.mycompany.sfsg.services.AlumnosDAO;
import com.mycompany.sfsg.services.CarreraDAO;
import com.mycompany.sfsg.services.PagosDAO;
import entidades.Alumno_Pago;
import entidades.Alumnos;
import entidades.Carrera;
import java.util.List;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.apache.tapestry5.PersistenceConstants;
import org.apache.tapestry5.annotations.PageActivationContext;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author Mauricio J
 */
public class lista_pagos {
    //@RequiresUser
    private Integer idcarrera;
    private Integer idsemestre;
    private Integer idalumno;
    private Integer idpago;
    
    @Inject
    private AlumnoPagoDAO dao;
    
    @Inject
    private AlumnosDAO daoalumno;
    
    @Inject
    private PagosDAO daopago;
    
    @Inject
    private CarreraDAO daocarrera;

    @Property
    private  Alumno_Pago pagoalumno;
    
    @Property
    private  Alumnos alumno;
    
    @Property
    private  Carrera carrera;
    
    @Property
    private List<Alumno_Pago> pagosalumnos;
    
    @PageActivationContext
    private Integer idalumnopago;
    
    //Dialogo
    @Property
    @Persist(PersistenceConstants.FLASH)
    private String errorMessage;
            
    void setupRender() {        
       //pagoalumno = dao.buscarId(idalumnopago);       
        pagosalumnos = dao.listarTodos();
        //carrera = daocarrera.buscarId(idcarrera);
    }
    
    /*@Inject
    private AlumnoPagoDAO dao;

    @Property
    private  GeneralAlumnoPago general;
    
    @Property
    private GeneralAlumnoPago datos;
    
    @Persist(PersistenceConstants.FLASH)
    @Property
    private String periodo;
        
    //void setupRender (Integer idalumno_pag) {        
     //  datos = dao.buscarTodoAP(idalumno_pag);       
    //}
    
    @Inject private Request req;
    public void getPeriodo() {
    req.getParameter("periodo");
}

    //public Object[] getPeriodo() {        
		//return new Object[] { periodo };
	////}*/
      
    //@Persist
    //@PageActivationContext
    /*private Integer id;
    @Property
    private Alumnos alumno;

    @Inject
    private AlumnosDAO dao;*/
    
    //@Property
    //private List<Alumno_Pago> alumno_pago;

    //private Integer id;

    /*public void setAlumnoId(Integer id) {
        this.id = id ;
    }*/

    /* void setupRender() {
        alumno = new Alumnos();
    }
     
    void onPrepare() {    
        alumno = dao.buscarId(id); 
    }*/
    
    /*void onActivate(Integer id) {
        this.id = id ;
        alumno = dao.buscarId(id) ;
    }

    Integer onPassivate() {
        return id;
    }*/
}
