/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tapestry_1.pages;

import com.mycompany.tapestry_1.services.EstadoCivilDAO;
import entidades.EstadoCivil;
import org.apache.tapestry5.annotations.PageActivationContext;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author Mauricio
 */
public class ActualizarEstadoCivil {
    @Inject
    private EstadoCivilDAO dao;
   
    @Property
    private  EstadoCivil estadocivil;
    
    @PageActivationContext
    private Integer idestadocivil;
    
    void setupRender() {
        estadocivil = new EstadoCivil();
    }

    void onPrepare() {    
        estadocivil = dao.buscarId(idestadocivil); 
    }
    
    void onActivate(Integer idestadocivil) {
        estadocivil = dao.buscarId(idestadocivil);
    }

    Class<ListaEstadoCivil> onSuccess() {         
         dao.actualizarEstado_Civil(estadocivil.getIdestadocivil(),estadocivil.getNestadocivil());
         return ListaEstadoCivil.class;
    }
    
    Class<ListaEstadoCivil> onCanceled() {          
          return ListaEstadoCivil.class;
    }
}
