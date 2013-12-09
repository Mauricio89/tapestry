/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tapestry_1.pages;

import com.mycompany.tapestry_1.services.UsuarioDAO;
import entidades.Usuario;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author Mauricio
 */
public class InsertarUsuario {
    @Inject
    private UsuarioDAO dao;
   
    @Property
    private  Usuario usuario;
    
    void setupRender() {
        usuario = new Usuario();
    }

    void onPrepareForSubmit() {
        usuario = new Usuario();
    }

    Class<Index> onSuccess() { 
         dao.insertarUsuario(usuario.getCedula(),usuario.getNombres(),usuario.getDireccion(),usuario.getTelefono(),usuario.getCelular(),
                 usuario.getCorreo(),usuario.getCuenta(),usuario.getClave());
         return Index.class;
    }
    
    Class<Index> onCanceled() {          
         return Index.class;
    }
}
