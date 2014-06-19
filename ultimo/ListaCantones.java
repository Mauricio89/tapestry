/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sfsg.pages;

import com.mycompany.sfsg.services.CantonDAO;
import com.mycompany.sfsg.services.ProvinciaDAO;
import entidades.Cantones;
import entidades.Provincias;
import java.util.List;
import org.apache.tapestry5.annotations.PageActivationContext;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.internal.services.PageLoader;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.slf4j.Logger;

/**
 *
 * @author Mauricio
 */
public class ListaCantones {
    
    private Integer idprovincia;
    
    @Inject
    private Logger logger;
    
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
    
    void pageLoaded () {
        logger.debug ("");
        logger.debug ("pageLoaded ()");
    }
        
    void setupRender() {        
       cantones = daocanton.listarCantones(idprovincia);       
        //cantones = daocanton.listarTodos();       
    }
    
    public Provincias buscarId(Integer idprovincia) {
    return daoprovincia.buscarId(idprovincia);    
    }
    
     void onActionFromDelete(Integer idcanton)
    {
        daocanton.eliminarCanton(idcanton);        
    } 
}
