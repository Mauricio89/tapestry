/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tapestry_1.pages;

import com.mycompany.tapestry_1.services.AlumnosDAO;
import entidades.Alumnos;
import java.util.List;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
/**
 *
 * @author Mauricio
 */
public class ListaAlumnos {

    @Inject
    private AlumnosDAO daoalumno;

    @Property
    private  Alumnos alumno;
    
    @Property
    private List<Alumnos> alumnos;

    void setupRender() {        
       alumnos = daoalumno.listarTodos();       
    }
    
     void onActionFromDelete(Integer idalumno)
    {
        daoalumno.eliminarAlumnos(idalumno);        
    }  
}
