/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tapestry_1.services;

import entidades.Carrera;
import java.util.List;

/**
 *
 * @author Mauricio
 */
public interface CarreraDAO {    
    public void insertarCarrera(String ncarrera);
    public void actualizarCarrera(Integer nidcarrera, String ncarrera);
    public void eliminarCarrera(Integer nidcarrera);
    public Carrera buscarId(Integer idcarrera);
    public List<Carrera> listarTodos();   
}
