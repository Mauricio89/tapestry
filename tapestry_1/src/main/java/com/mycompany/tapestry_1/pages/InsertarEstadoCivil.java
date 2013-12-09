/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tapestry_1.pages;

import com.mycompany.tapestry_1.services.EstadoCivilDAO;
import entidades.EstadoCivil;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author Mauricio
 */
public class InsertarEstadoCivil {
    
    @Inject
    private EstadoCivilDAO dao;
   
    @Property
    private  EstadoCivil estadocivil;
    
    void setupRender() {
        estadocivil = new EstadoCivil();
    }

    void onPrepareForSubmit() {
            estadocivil = new EstadoCivil();
    }

    Class<ListaEstadoCivil> onSuccess() { 
         dao.insertarEstado_Civil(estadocivil.getNestadocivil());
         return ListaEstadoCivil.class;
    }
    
    Class<ListaEstadoCivil> onCanceled() {          
          return ListaEstadoCivil.class;
    }
}
