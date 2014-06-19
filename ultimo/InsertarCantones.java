/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sfsg.pages;

import com.mycompany.sfsg.encoder.ProvinciaEncoder;
import com.mycompany.sfsg.services.CantonDAO;
import com.mycompany.sfsg.services.ProvinciaDAO;
import entidades.Cantones;
import entidades.Provincias;
import java.util.List;
import org.apache.tapestry5.EventContext;
import org.apache.tapestry5.SelectModel;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.SelectModelFactory;

/**
 *
 * @author Mauricio
 */
public class InsertarCantones {
    
    private Integer idprovincia;
    //Cantones
    @Inject
    private CantonDAO daocanton;    
    @Property
    private  Cantones canton;    
    //Provincias
    @Inject
    private ProvinciaDAO daoprovincia;    
    @Property
    private  Provincias provincia;
    
    //Modelos
    @Property
    private SelectModel provinciasModel;
    
    @Inject
    private SelectModelFactory selectModelFactory;
    
     void setupRender() {
        canton = new Cantones();        
    }
     
    void onPrepareForSubmit() {
        canton = new Cantones(); 
    }    
    
    void onActivate(EventContext context) {
        //Provincias
        if (context.getCount() > 0) {
            idprovincia = context.get(Integer.class, 0);
        }
    }
    
    void onPrepareForRender() {
        //Obtiene toda la lista
        List<Provincias> provincias = daoprovincia.listarTodos();
        if (idprovincia != null) {
            provincia = encontrarProvinciaLista(idprovincia, provincias);
        }
        provinciasModel = selectModelFactory.create(provincias, "nprovincia"); 
    }
    
    void onValidateFromForm() {
        idprovincia = provincia == null ? null : provincia.getIdprovincia();        
    }
    
    //Provincias
    private Provincias encontrarProvinciaLista(Integer idprovincia, List<Provincias> provincias) {
        for (Provincias provincia : provincias) {
            if (provincia.getIdprovincia().equals(idprovincia)) {
                return provincia;
            }
        }
        return null;
    }    
    
    //Provincias Encoder
    public ProvinciaEncoder getProvinciaEncoder() {
        return new ProvinciaEncoder(daoprovincia);
    }
    
     Class<ListaCantones> onSuccess() { 
         daocanton.insertarCanton(provincia.getIdprovincia(),canton.getNcanton()); 
         return ListaCantones.class;
    }
     
      Class<ListaCantones> onCanceled() {          
          return ListaCantones.class;
    }
}
