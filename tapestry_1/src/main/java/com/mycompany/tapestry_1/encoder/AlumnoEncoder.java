/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tapestry_1.encoder;

import com.mycompany.tapestry_1.services.AlumnosDAO;
import entidades.Alumnos;
import org.apache.tapestry5.ValueEncoder;

/**
 *
 * @author Mauricio
 */
public class AlumnoEncoder implements ValueEncoder<Alumnos>{
    private AlumnosDAO daoalumno;

    public AlumnoEncoder(AlumnosDAO daoalumno) {
        this.daoalumno = daoalumno;
    }

    @Override
    public String toClient(Alumnos value) {
        return String.valueOf(value.getIdalumno());
    }
    @Override
    public Alumnos toValue(String id) {
        return daoalumno.buscarId(Integer.parseInt(id));
    }
}