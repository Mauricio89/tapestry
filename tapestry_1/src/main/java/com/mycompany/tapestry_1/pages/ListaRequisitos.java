/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tapestry_1.pages;

import com.mycompany.tapestry_1.services.RequisitosDAO;
import entidades.Requisitos;
import java.util.List;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author Mauricio
 */
public class ListaRequisitos {    

    @Inject
    private RequisitosDAO dao;

    @Property
    private  Requisitos requisito;
    
    @Property
    private List<Requisitos> requisitos;
    
    void setupRender() {        
       requisitos = dao.listarTodos();       
    }
    
     void onActionFromDelete(Integer idrequisito)
    {
        dao.EliminarRequsiito(idrequisito);
    }  
}
