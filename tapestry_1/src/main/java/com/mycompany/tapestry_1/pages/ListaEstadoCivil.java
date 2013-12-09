/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tapestry_1.pages;

import com.mycompany.tapestry_1.services.EstadoCivilDAO;
import entidades.EstadoCivil;
import java.util.List;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author Mauricio
 */
public class ListaEstadoCivil {

    @Inject
    private EstadoCivilDAO dao;

    @Property
    private  EstadoCivil estadocivil;
    
    @Property
    private List<EstadoCivil> estadosciviles;
    
    void setupRender() {        
       estadosciviles = dao.listarTodos();       
    }
    
     void onActionFromDelete(Integer idestadocivil)
    {
        dao.eliminarEstado_Civil(idestadocivil); 
    }  
}
