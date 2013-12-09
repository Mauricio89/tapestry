/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tapestry_1.services;

import entidades.Pagos;
import java.util.List;

/**
 *
 * @author Mauricio
 */
public interface PagosDAO {
    public void insertarPagos(String npago,Double nprecio);
    public void actualizarPago(Integer nidpago,String npago,Double nprecio);
    public void eliminarPago(Integer nidpago);
    public Pagos buscarId(Integer idpago);
    public List<Pagos> listarTodos();
}
