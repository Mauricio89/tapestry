/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tapestry_1.encoder;

import com.mycompany.tapestry_1.services.PagosDAO;
import entidades.Pagos;
import org.apache.tapestry5.ValueEncoder;

/**
 *
 * @author Mauricio
 */
public class PagoEncoder implements ValueEncoder<Pagos>{
    private PagosDAO daopago;

    public PagoEncoder(PagosDAO daopago) {
        this.daopago = daopago;
    }

    @Override
    public String toClient(Pagos value) {
        return String.valueOf(value.getIdpago());
    }
    @Override
    public Pagos toValue(String id) {
        return daopago.buscarId(Integer.parseInt(id));
    }
}