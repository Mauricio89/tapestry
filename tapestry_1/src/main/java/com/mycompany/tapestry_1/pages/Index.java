package com.mycompany.tapestry_1.pages;

//import com.mycompany.tapestry_1.conversiones.IIntermediatePage;
import com.mycompany.tapestry_1.services.UsuarioDAO;
import entidades.Usuario;
import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.EventContext;
import org.apache.tapestry5.Link;
import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.corelib.components.TextField;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.slf4j.Logger;

/**
 * Start page of application Prototipo_Tapestry.
 */
public class Index
{
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
    
    Class<Portada> onSuccess() {          
         return Portada.class;
    }
    
//    void onActivate(Usuario user) {
//        usuario = dao.Autenticar(user);
//    }
    
//    Class<Portada> onLogin() {
//        
//        Usuario user;                
//        user=dao.Autenticar(usuario);
//        if(user!=null)
//        {             
//            return Portada.class;
////                if(user.getTipo()==1)
////                {
////                valor= "/layout.xhtml?faces-redirect=true";
////                redirectToPage(valor);
////                }
////                if(clave1.getTipo()==0)
////                {
////                 valor= "/pagUsuario.xhtml?faces-redirect=true";
////                redirectToPage(valor);
////                }
//        } 
//        else { 
//            System.out.println("ERROR "); 
////            msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "ERROR DE AUTENTICACION", "Usuario o contrasenia incorrectos");  
////            FacesContext.getCurrentInstance().addMessage(null, msg); 
//        }  
//        return null;
//        
//    }
}
