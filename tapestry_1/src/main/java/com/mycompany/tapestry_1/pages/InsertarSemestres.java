/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tapestry_1.pages;

import com.mycompany.tapestry_1.services.SemestreDAO;
import entidades.Semestre;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author Mauricio
 */
public class InsertarSemestres {    

    @Inject
    private SemestreDAO dao;
   
    @Property
    private  Semestre semestre;
    
    void setupRender() {
        semestre = new Semestre();
    }

    void onPrepareForSubmit() {
         semestre = new Semestre();
    }

    Class<ListaSemestres> onSuccess() { 
         dao.insertarSemestre(semestre.getNsemestre());
         return ListaSemestres.class;
    }
    
    Class<ListaSemestres> onCanceled() {          
          return ListaSemestres.class;
    }
}
