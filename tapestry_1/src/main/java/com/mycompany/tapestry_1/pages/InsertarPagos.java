/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tapestry_1.pages;

import com.mycompany.tapestry_1.services.PagosDAO;
import entidades.Pagos;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author Mauricio
 */
public class InsertarPagos {    

    @Inject
    private PagosDAO dao;
   
    @Property
    private  Pagos pago;
    
    void setupRender() {
        pago = new Pagos();
    }

    void onPrepareForSubmit() {
            pago = new Pagos();
    }

    Class<ListaPagos> onSuccess() { 
         dao.insertarPagos(pago.getNpago(),pago.getPrecio()); 
         return ListaPagos.class;
    }
    
    Class<ListaPagos> onCanceled() {          
          return ListaPagos.class;
    }
}
