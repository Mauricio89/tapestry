/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tapestry_1.pages;

import com.mycompany.tapestry_1.services.CarreraDAO;
import entidades.Carrera;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.apache.tapestry5.PersistenceConstants;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.PageActivationContext;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Checkbox;
import org.apache.tapestry5.corelib.components.Zone;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.json.JSONObject;
import org.apache.tapestry5.services.Request;
import org.apache.tapestry5.services.javascript.JavaScriptSupport;

/**
 *
 * @author Mauricio
 */

@Import(library = "context:Recursos/Js/FechaSistema.js")
public class ListaCarrera { 

    @Inject
    private CarreraDAO dao;

    @Property
    private  Carrera carrera;
    
    @Property
    private List<Carrera> carreras;
    
    @PageActivationContext
    private Integer idcarrera;
    
    //Dialogo
    @Property
    @Persist(PersistenceConstants.FLASH)
    private String errorMessage;
    
//    @InjectComponent
//    private Checkbox delete;
    
    @InjectComponent
    private Zone timeZone;

    @Inject
    private JavaScriptSupport javaScriptSupport;
    
    @Inject
    private Request request;

  
    public void afterRender() {
        javaScriptSupport.addInitializerCall("periodicTimeZoneUpdater", new JSONObject());
    }

    Object onRefreshTimeZone() {
        // Here we can do whatever updates we want, then return the content we want rendered.
        return request.isXHR() ? timeZone.getBody() : null;
    }

    public String getServerTime() {
        Date fecha = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("EEEE dd MMMM yyyy HH:mm:ss");
//        DateFormat fechasistema = DateFormat.getDateInstance(DateFormat.FULL);
//        String salida = fechasistema.format(fecha);
//        return salida;
//        //DateFormat hourdateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss ");
//        //return hourdateFormat.format(fecha);
        return formato.format(fecha);
    }
    
    void setupRender() {        
       carreras = dao.listarTodos();       
    }
    
     void onActionFromDelete(Integer idcarrera)
    {
            dao.eliminarCarrera(idcarrera); 
    }
}