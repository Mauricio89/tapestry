/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tapestry_1.pages;

import com.mycompany.tapestry_1.services.PagosDAO;
import entidades.Pagos;
import java.util.List;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author Mauricio
 */
public class ListaPagos {
   
    @Inject
    private PagosDAO dao;

    @Property
    private  Pagos pago;
    
    @Property
    private List<Pagos> pagos;
    
    void setupRender() {        
       pagos = dao.listarTodos();       
    }
    
     void onActionFromDelete(Integer idpago)
    {
        dao.eliminarPago(idpago);
    }  
}
