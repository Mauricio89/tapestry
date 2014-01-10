/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tapestry_1.encoder;

import com.mycompany.tapestry_1.services.ProvinciaDAO;
import entidades.Provincias;
import org.apache.tapestry5.ValueEncoder;

/**
 *
 * @author Mauricio
 */
public class ProvinciaEncoder implements ValueEncoder<Provincias>{
    private ProvinciaDAO daoprovincia;

    public ProvinciaEncoder(ProvinciaDAO daoprovincia) {
        this.daoprovincia = daoprovincia;
    }

    @Override
    public String toClient(Provincias value) {
        return String.valueOf(value.getIdprovincia());
    }
    @Override
    public Provincias toValue(String id) {
        return daoprovincia.buscarId(Integer.parseInt(id));
    }
}
