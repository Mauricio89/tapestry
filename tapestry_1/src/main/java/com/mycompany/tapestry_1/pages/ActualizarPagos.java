/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tapestry_1.pages;

import com.mycompany.tapestry_1.services.PagosDAO;
import entidades.Pagos;
import org.apache.tapestry5.annotations.PageActivationContext;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author Mauricio
 */
public class ActualizarPagos {
    @Inject
    private PagosDAO dao;
   
    @Property
    private  Pagos pago;
    
    @PageActivationContext
    private Integer idpago;
    
    void setupRender() {
        pago = new Pagos();
    }

    void onPrepare() {    
        pago = dao.buscarId(idpago);        
    }
    
    void onActivate(Integer idpago) {
        pago = dao.buscarId(idpago);
    }

    Class<ListaPagos> onSuccess() {         
         dao.actualizarPago(pago.getIdpago(),pago.getNpago(),pago.getPrecio());
         return ListaPagos.class;
    }
    
    Class<ListaPagos> onCanceled() {          
          return ListaPagos.class;
    }
}
