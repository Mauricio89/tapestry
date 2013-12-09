/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tapestry_1.pages;

import com.mycompany.tapestry_1.services.RequisitosDAO;
import entidades.Requisitos;
import org.apache.tapestry5.annotations.PageActivationContext;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author Mauricio
 */
public class ActualizarRequisitos {
    @Inject
    private RequisitosDAO dao;
   
    @Property
    private  Requisitos requisito;
    
    @PageActivationContext
    private Integer idrequisito;
    
    void setupRender() {
        requisito = new Requisitos();
    }

    void onPrepare() {    
        requisito = dao.buscarId(idrequisito); 
    }
    
    void onActivate(Integer idrequisito) {
        requisito = dao.buscarId(idrequisito);
    }

    Class<ListaRequisitos> onSuccess() {         
         dao.ActualizarRequisito(requisito.getIdrequisito(),requisito.getNrequisito());
         return ListaRequisitos.class;
    }
    
    Class<ListaRequisitos> onCanceled() {          
          return ListaRequisitos.class;
    }
}
