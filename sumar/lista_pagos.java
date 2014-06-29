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
import entidades.GeneralAlumnoPago;
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
@RequiresUser
public class lista_pagos {   
    
    private Integer idcarrera;
    private Integer idsemestre;
    private Integer idalumno;
    private Integer idpago;
    private Double valor;
    
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
    private  GeneralAlumnoPago generalpagoalumno;
    
    @Property
    private  Alumnos alumno;
    
    @Property
    private  Carrera carrera;
    
    @Property
    private List<Alumno_Pago> pagosalumnos;
    
    @Property
    private List<GeneralAlumnoPago> generalpagosalumnos;
    
    @PageActivationContext
    private Integer idalumnopago;
    
    //Dialogo
    @Property
    @Persist(PersistenceConstants.FLASH)
    private String errorMessage;
            
    void setupRender() {        
       generalpagosalumnos = dao.listarTodosPagos();
        valor = dao.total();
       //alumno = daoalumno.buscarId(idalumno);
        //generalpagosalumnos = dao.listarTodosPagos();
        //carrera = daocarrera.buscarId(idcarrera);
    }
    
     public Double getTotal()
    {        
        return valor;
    }
   
}
