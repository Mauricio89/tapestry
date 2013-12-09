/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tapestry_1.encoder;

import com.mycompany.tapestry_1.services.CantonDAO;
import entidades.Cantones;
import org.apache.tapestry5.ValueEncoder;

/**
 *
 * @author Mauricio
 */
public class CantonEncoder implements ValueEncoder<Cantones>{
    private CantonDAO daocanton;

    public CantonEncoder(CantonDAO daocanton) {
        this.daocanton = daocanton;
    }
    
    @Override
    public String toClient(Cantones value) {
        return String.valueOf(value.getIdcanton());
    }
    @Override
    public Cantones toValue(String id) {
        return daocanton.buscarId(Integer.parseInt(id));
    }
}
