/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tapestry_1.pages;

import com.mycompany.tapestry_1.encoder.ProvinciaEncoder;
import com.mycompany.tapestry_1.services.CiudadDAO;
import com.mycompany.tapestry_1.services.ProvinciaDAO;
import entidades.Ciudades;
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
public class InsertarCiudades {
    
    private Integer idprovincia;
    //Ciudades
    @Inject
    private CiudadDAO daociudad;    
    @Property
    private  Ciudades ciudad;    
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
        ciudad = new Ciudades();        
    }
    void onPrepareForSubmit() {
        ciudad = new Ciudades(); 
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
    
     Class<ListaCiudades> onSuccess() { 
         daociudad.insertarCiudad(provincia.getIdprovincia(),ciudad.getNciudad());       
         return ListaCiudades.class;
    }
     
      Class<ListaCiudades> onCanceled() {          
          return ListaCiudades.class;
    }
}
