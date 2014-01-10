/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tapestry_1.encoder;

import com.mycompany.tapestry_1.services.SemestreDAO;
import entidades.Semestre;
import org.apache.tapestry5.ValueEncoder;

/**
 *
 * @author Mauricio
 */
public class SemestreEncoder implements ValueEncoder<Semestre>{
    private SemestreDAO daosemestre;

    public SemestreEncoder(SemestreDAO daosemestre) {
        this.daosemestre = daosemestre;
    }

    @Override
    public String toClient(Semestre value) {
        return String.valueOf(value.getIdsemestre());
    }
    @Override
    public Semestre toValue(String id) {
        return daosemestre.buscarId(Integer.parseInt(id));
    }
}