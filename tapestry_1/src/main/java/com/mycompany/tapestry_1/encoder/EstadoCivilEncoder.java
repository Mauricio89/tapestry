/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tapestry_1.encoder;

import com.mycompany.tapestry_1.services.EstadoCivilDAO;
import entidades.EstadoCivil;
import org.apache.tapestry5.ValueEncoder;

/**
 *
 * @author Mauricio
 */
public class EstadoCivilEncoder implements ValueEncoder<EstadoCivil>{
    private EstadoCivilDAO daoestadocivil;

    public EstadoCivilEncoder(EstadoCivilDAO daoestadocivil) {
        this.daoestadocivil = daoestadocivil;
    }
    
    @Override
    public String toClient(EstadoCivil value) {
        return String.valueOf(value.getIdestadocivil());
    }
    @Override
    public EstadoCivil toValue(String id) {
        return daoestadocivil.buscarId(Integer.parseInt(id));
    }
}
