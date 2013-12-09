/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tapestry_1.pages;

import com.mycompany.tapestry_1.services.RequisitosDAO;
import entidades.Requisitos;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author Mauricio
 */
public class InsertarRequisitos {    

    @Inject
    private RequisitosDAO dao;
   
    @Property
    private  Requisitos requisito;
    
    void setupRender() {
        requisito = new Requisitos();
    }

    void onPrepareForSubmit() {
            requisito = new Requisitos();
    }

    Class<ListaRequisitos> onSuccess() { 
         dao.InsertarRequisito(requisito.getNrequisito()); 
         return ListaRequisitos.class;
    }
    
     Class<ListaRequisitos> onCanceled() {          
          return ListaRequisitos.class;
    }
}
