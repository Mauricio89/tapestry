/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tapestry_1.encoder;

import com.mycompany.tapestry_1.services.CarreraDAO;
import entidades.Carrera;
import org.apache.tapestry5.ValueEncoder;

/**
 *
 * @author Mauricio
 */
public class CarreraEncoder implements ValueEncoder<Carrera>{
    private CarreraDAO daocarrera;

    public CarreraEncoder(CarreraDAO daocarrera) {
        this.daocarrera = daocarrera;
    }

    @Override
    public String toClient(Carrera value) {
        return String.valueOf(value.getIdcarrera());
    }
    @Override
    public Carrera toValue(String id) {
        return daocarrera.buscarId(Integer.parseInt(id));
    }
}