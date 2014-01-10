/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tapestry_1.services;

import entidades.EstadoCivil;
import java.util.List;

/**
 *
 * @author Mauricio
 */
public interface EstadoCivilDAO {
    public void insertarEstado_Civil(String nestadocivil);
    public void actualizarEstado_Civil(Integer nidestadocivil,String nestadocivil);
    public void eliminarEstado_Civil(Integer nidestadocivil);
    public EstadoCivil buscarId(Integer idestadocivil);
    public List<EstadoCivil> listarTodos(); 
}
