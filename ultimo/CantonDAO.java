/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sfsg.services;

import entidades.Cantones;
import java.util.List;

/**
 *
 * @author Mauricio
 */
public interface CantonDAO {
    public void insertarCanton(Integer nidprovincia, String ncanton);
    public void actualizarCanton(Integer nidcanton, Integer nidprovincia, String ncanton);
    public void eliminarCanton(Integer nidcanton);
    public Cantones buscarId(Integer idcanton);
    public List<Cantones> listarTodos();
    public List<Cantones> listarCantones(Integer nidprovincia);
}
