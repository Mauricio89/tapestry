/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tapestry_1.pages;

import com.mycompany.tapestry_1.services.CarreraDAO;
import entidades.Carrera;
import org.apache.tapestry5.annotations.PageActivationContext;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author Mauricio
 */
public class ActualizarCarrera {
    @Inject
    private CarreraDAO dao;
   
    @Property
    private  Carrera carrera;
    
    @PageActivationContext
    private Integer idcarrera;
    
    void setupRender() {
        carrera = new Carrera();
    }

    void onPrepare() {    
        carrera = dao.buscarId(idcarrera);        
    }
    
    void onActivate(Integer idcarrera) {
        carrera = dao.buscarId(idcarrera);
    }

    Class<ListaCarrera> onSuccess() {         
         dao.actualizarCarrera(carrera.getIdcarrera(),carrera.getNcarrera());
         return ListaCarrera.class;
    }
    
    Class<ListaCarrera> onCanceled() {          
          return ListaCarrera.class;
    }
}