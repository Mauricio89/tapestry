/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tapestry_1.pages;

import com.mycompany.tapestry_1.services.CarreraDAO;
import entidades.Carrera;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
/**
 *
 * @author Mauricio
 */
public class InsertarCarrera {    

    @Inject
    private CarreraDAO dao;
   
    @Property
    private  Carrera carrera;
    
    void setupRender() {
        carrera = new Carrera();
    }

    void onPrepareForSubmit() {
        carrera = new Carrera();
    }

    Class<ListaCarrera> onSuccess() { 
         dao.insertarCarrera(carrera.getNcarrera());
         return ListaCarrera.class;
    }
    
    Class<ListaCarrera> onCanceled() {          
          return ListaCarrera.class;
    }
}