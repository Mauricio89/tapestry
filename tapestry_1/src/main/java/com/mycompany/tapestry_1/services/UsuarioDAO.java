/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tapestry_1.services;

import entidades.Usuario;
import java.util.List;

/**
 *
 * @author Mauricio
 */
public interface UsuarioDAO {
    
    public void insertarUsuario(String ncedula,String nnombres,String ndireccion,String ntelefono,String ncelular,String ncorreo,String ncuenta,String nclave);
    public void actualizarUsuario(Integer nidusuario,String ncedula,String nnombres,String ndireccion,String ntelefono,String ncelular,String ncorreo,String ncuenta,String nclave);
    public void eliminarUsuario(Integer nidusuario);
    public Usuario buscarId(Integer idusuario);
    public List<Usuario> listarTodos();
    public Usuario Autenticar(Usuario user);
}
