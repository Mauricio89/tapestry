/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tapestry_1.encoder;

import com.mycompany.tapestry_1.services.CiudadDAO;
import entidades.Ciudades;
import org.apache.tapestry5.ValueEncoder;

/**
 *
 * @author Mauricio
 */
public class CiudadEncoder implements ValueEncoder<Ciudades>{
    private CiudadDAO daociudad;

    public CiudadEncoder(CiudadDAO daociudad) {
        this.daociudad = daociudad;
    }
    
    @Override
    public String toClient(Ciudades value) {
        return String.valueOf(value.getIdciudad());
    }
    @Override
    public Ciudades toValue(String id) {
        return daociudad.buscarId(Integer.parseInt(id));
    }
}
