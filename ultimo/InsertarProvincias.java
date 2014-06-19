/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sfsg.pages;

import com.mycompany.sfsg.services.ProvinciaDAO;
import entidades.Provincias;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author Mauricio
 */
public class InsertarProvincias {
    @Inject
    private ProvinciaDAO dao;
   
    @Property
    private  Provincias provincia;
    
    void setupRender() {
        provincia = new Provincias();
    }

    void onPrepareForSubmit() {
        provincia = new Provincias();
    }

    Class<ListaProvincias> onSuccess() { 
         dao.insertarProvincia(provincia.getNprovincia());
         return ListaProvincias.class;
    }
    
    Class<ListaProvincias> onCanceled() {          
          return ListaProvincias.class;
    }
}
