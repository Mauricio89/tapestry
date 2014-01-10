/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tapestry_1.pages;

import com.mycompany.tapestry_1.services.ProvinciaDAO;
import entidades.Provincias;
import org.apache.tapestry5.annotations.PageActivationContext;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author Mauricio
 */
public class ActualizarProvincias {
    @Inject
    private ProvinciaDAO dao;
   
    @Property
    private  Provincias provincia;
    
    @PageActivationContext
    private Integer idprovincia;
    
    void setupRender() {
        provincia = new Provincias();
    }

    void onPrepare() {    
        provincia = dao.buscarId(idprovincia);
    }
    
    void onActivate(Integer idprovincia) {
        provincia = dao.buscarId(idprovincia);
    }

    Class<ListaProvincias> onSuccess() {         
         dao.actualizarProvincia(provincia.getIdprovincia(),provincia.getNprovincia());
         return ListaProvincias.class;
    }
    
    Class<ListaProvincias> onCanceled() {          
          return ListaProvincias.class;
    }
}
