/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tapestry_1.services;

import entidades.Requisitos;
import java.util.List;

/**
 *
 * @author Mauricio
 */
public interface RequisitosDAO {
     public void InsertarRequisito(String nrequisito);
     public void ActualizarRequisito(Integer nidrequisito,String nrequisito);
     public void EliminarRequsiito(Integer nidrequisito);
     public Requisitos buscarId(Integer idrequisito);
     public List<Requisitos> listarTodos();
}
