/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tapestry_1.services;

import entidades.Semestre;
import java.util.List;

/**
 *
 * @author Mauricio
 */
public interface SemestreDAO {
    public void insertarSemestre(String nsemestre);
    public void actualizarSemestre(Integer nidsemestre,String nsemestre);
    public void eliminarSemestre(Integer nidsemestre);
    public Semestre buscarId(Integer idsemestre);
    public List<Semestre> listarTodos();
}
