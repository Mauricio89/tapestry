/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tapestry_1.pages;

import com.mycompany.tapestry_1.services.CiudadDAO;
import entidades.Ciudades;
import java.util.List;
import org.apache.tapestry5.annotations.PageActivationContext;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author Mauricio
 */
public class ListaCiudades {
    @Inject
    private CiudadDAO dao;

    @Property
    private  Ciudades ciudad;
    
    @Property
    private List<Ciudades> ciudades;
    
    @PageActivationContext
    private Integer idciudad;
    
    void setupRender() {        
       ciudades = dao.listarTodos();       
    }
    
     void onActionFromDelete(Integer idciudad)
    {
        dao.eliminarCiudad(idciudad);        
    } 
}
