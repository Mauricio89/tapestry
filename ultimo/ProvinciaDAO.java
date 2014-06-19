/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sfsg.services;

import entidades.Provincias;
import java.util.List;

/**
 *
 * @author Mauricio
 */
public interface ProvinciaDAO {
    public void insertarProvincia(String nprovincia);
    public void actualizarProvincia(Integer nidprovincia,String nprovincia);
    public void eliminarProvincia(Integer nidprovincia);
    public Provincias buscarId(Integer idprovincia);
    public List<Provincias> listarTodos();
}
