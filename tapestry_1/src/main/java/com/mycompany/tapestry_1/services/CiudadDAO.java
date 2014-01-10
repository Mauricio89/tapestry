/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tapestry_1.services;

import entidades.Ciudades;
import java.util.List;

/**
 *
 * @author Mauricio
 */
public interface CiudadDAO {
    public void insertarCiudad(Integer nidprovincia, String nciudad);
    public void actualizarCiudad(Integer nidciudad, Integer nidprovincia, String nciudad);
    public void eliminarCiudad(Integer nidciudad);
    public Ciudades buscarId(Integer idciudad);
    public List<Ciudades> listarTodos();
}
