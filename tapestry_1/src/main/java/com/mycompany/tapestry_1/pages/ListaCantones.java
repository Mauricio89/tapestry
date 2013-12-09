/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tapestry_1.pages;

import com.mycompany.tapestry_1.services.CantonDAO;
import com.mycompany.tapestry_1.services.ProvinciaDAO;
import entidades.Cantones;
import entidades.Provincias;
import java.util.List;
import org.apache.tapestry5.annotations.PageActivationContext;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author Mauricio
 */
public class ListaCantones {
    
    @Inject
    private ProvinciaDAO daoprovincia;
    
    @Inject
    private CantonDAO daocanton;

    @Property
    private  Cantones canton;
    
    @Property
    private List<Cantones> cantones;
    
    @PageActivationContext
    private Integer idcanton;
    
    void setupRender() {        
       cantones = daocanton.listarTodos();       
    }
    
    public Provincias buscarId(Integer idprovincia) {
    return daoprovincia.buscarId(idprovincia);    
    }
    
     void onActionFromDelete(Integer idcanton)
    {
        daocanton.eliminarCanton(idcanton);        
    } 
}
