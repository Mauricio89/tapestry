/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tapestry_1.pages;

import com.mycompany.tapestry_1.services.SemestreDAO;
import entidades.Semestre;
import java.util.List;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author Mauricio
 */
public class ListaSemestres {
   
    @Inject
    private SemestreDAO dao;

    @Property
    private  Semestre semestre;
    
    @Property
    private List<Semestre> semestres;
    
    void setupRender() {        
       semestres = dao.listarTodos();       
    }
    
     void onActionFromDelete(Integer idsemestre)
    {
        dao.eliminarSemestre(idsemestre);
    }  
}
