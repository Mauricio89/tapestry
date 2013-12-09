/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tapestry_1.pages;

import com.mycompany.tapestry_1.services.SemestreDAO;
import entidades.Semestre;
import org.apache.tapestry5.annotations.PageActivationContext;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author Mauricio
 */
public class ActualizarSemestres {
    @Inject
    private SemestreDAO dao;
   
    @Property
    private  Semestre semestre;
    
    @PageActivationContext
    private Integer idsemestre;
    
    void setupRender() {
        semestre = new Semestre();
    }

    void onPrepare() {    
        semestre = dao.buscarId(idsemestre);  
    }
    
    void onActivate(Integer idsemestre) {
        semestre = dao.buscarId(idsemestre);
    }

    Class<ListaSemestres> onSuccess() {         
         dao.actualizarSemestre(semestre.getIdsemestre(),semestre.getNsemestre());
         return ListaSemestres.class;
    }
    
    Class<ListaSemestres> onCanceled() {          
          return ListaSemestres.class;
    }
}
