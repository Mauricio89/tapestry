/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tapestry_1.pages;

import com.mycompany.tapestry_1.services.ProvinciaDAO;
import entidades.Provincias;
import java.util.List;
import org.apache.tapestry5.annotations.PageActivationContext;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author Mauricio
 */
public class ListaProvincias {
    @Inject
    private ProvinciaDAO dao;

    @Property
    private  Provincias provincia;
    
    @Property
    private List<Provincias> provincias;
    
    @PageActivationContext
    private Integer idprovincia;
    
    void setupRender() {        
       provincias = dao.listarTodos();       
    }
    
     void onActionFromDelete(Integer idprovincia)
    {
        dao.eliminarProvincia(idprovincia);        
    } 
}
