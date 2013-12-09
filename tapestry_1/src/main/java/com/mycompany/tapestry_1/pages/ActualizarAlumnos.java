/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tapestry_1.pages;

import com.mycompany.tapestry_1.encoder.CantonEncoder;
import com.mycompany.tapestry_1.encoder.CiudadEncoder;
import com.mycompany.tapestry_1.encoder.EstadoCivilEncoder;
import com.mycompany.tapestry_1.encoder.ProvinciaEncoder;
import com.mycompany.tapestry_1.services.AlumnosDAO;
import com.mycompany.tapestry_1.services.CantonDAO;
import com.mycompany.tapestry_1.services.CiudadDAO;
import com.mycompany.tapestry_1.services.EstadoCivilDAO;
import com.mycompany.tapestry_1.services.ProvinciaDAO;
import entidades.Alumnos;
import entidades.Cantones;
import entidades.Ciudades;
import entidades.EstadoCivil;
import entidades.Provincias;
import java.util.List;
import org.apache.tapestry5.EventContext;
import org.apache.tapestry5.SelectModel;
import org.apache.tapestry5.annotations.PageActivationContext;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.SelectModelFactory;

/**
 *
 * @author Mauricio
 */
public class ActualizarAlumnos {
    
    private Integer idestadocivil;
    private Integer idprovincia;
    private Integer idcanton;
    private Integer idciudad;
    
    //Alumnos
    @Inject
    private AlumnosDAO daoalumno;   
    @Property
    private  Alumnos alumno; 
    
    @PageActivationContext
    private Integer idalumno; 
    
    //Estado Civil
    @Inject
    private EstadoCivilDAO daoestadocivil;    
    @Property
    private  EstadoCivil estadocivil;
    
    //Provincias
    @Inject
    private ProvinciaDAO daoprovincia;    
    @Property
    private  Provincias provincia;
    
    //Cantones
    @Inject
    private CantonDAO daocanton;    
    @Property
    private  Cantones canton;
    
    //Ciudades
    @Inject
    private CiudadDAO daociudad;    
    @Property
    private  Ciudades ciudad;
    
    //Modelos
    @Property
    private SelectModel estadocivilModel;
    @Property
    private SelectModel provinciasModel;
    @Property
    private SelectModel cantonesModel;
    @Property
    private SelectModel ciudadesModel;
    
    @Inject
    private SelectModelFactory selectModelFactory;
    
    void setupRender() {
        alumno = new Alumnos();
    }

    void onPrepare() {    
        alumno = daoalumno.buscarId(idalumno); 
    }
    
    void onActivate(Integer idalumno) {
        alumno = daoalumno.buscarId(idalumno);
    }
    
    void onActivate(EventContext context) {
        //Estados Civiles
        if (context.getCount() > 0) {
            idestadocivil = context.get(Integer.class, 0);
        }
        //Provincias
        if (context.getCount() > 0) {
            idprovincia = context.get(Integer.class, 0);
        }
        //Cantones
        if (context.getCount() > 0) {
            idcanton = context.get(Integer.class, 0);
        }
        //Ciudades
        if (context.getCount() > 0) {
            idciudad = context.get(Integer.class, 0);
        }
    }
    
    void onPrepareForRender() {
        //Obtiene toda la lista de los estados civiles
        List<EstadoCivil> estadosciviles = daoestadocivil.listarTodos();
        if (idestadocivil != null) {
            estadocivil = encontrarEstadoCivilLista(idestadocivil, estadosciviles);
        }
        estadocivilModel = selectModelFactory.create(estadosciviles, "nestadocivil"); 
        
        //Obtiene toda la lista de las Provincias
        List<Provincias> provincias = daoprovincia.listarTodos();
        if (idprovincia != null) {
            provincia = encontrarProvinciaLista(idprovincia, provincias);
        }
        provinciasModel = selectModelFactory.create(provincias, "nprovincia"); 
        
        //Obtiene toda la lista de los Cantones
        List<Cantones> cantones = daocanton.listarTodos();
        if (idcanton != null) {
            canton = encontrarCantonLista(idcanton, cantones);
        }
        cantonesModel = selectModelFactory.create(cantones, "ncanton"); 
        
        //Obtiene toda la lista de las Ciudades
        List<Ciudades> ciudades = daociudad.listarTodos();
        if (idciudad != null) {
            ciudad = encontrarCiudadLista(idciudad, ciudades);
        }
        ciudadesModel = selectModelFactory.create(ciudades, "nciudad"); 
    }
    
    void onValidateFromForm() {
        idestadocivil = estadocivil == null ? null : estadocivil.getIdestadocivil();
        idprovincia = provincia == null ? null : provincia.getIdprovincia();
        idcanton = canton == null ? null : canton.getIdcanton();
        idciudad = ciudad == null ? null : ciudad.getIdciudad();
    }
         
     //Estados Civiles
    private EstadoCivil encontrarEstadoCivilLista(Integer idestadocivil, List<EstadoCivil> estadosciviles) {
        for (EstadoCivil estadocivil : estadosciviles) {
            if (estadocivil.getIdestadocivil().equals(idestadocivil)) {
                return estadocivil;
            }
        }
        return null;
    }    
    
    //Provincias
    private Provincias encontrarProvinciaLista(Integer idprovincia, List<Provincias> provincias) {
        for (Provincias provincia : provincias) {
            if (provincia.getIdprovincia().equals(idprovincia)) {
                return provincia;
            }
        }
        return null;
    }   
    
    //Cantones
    private Cantones encontrarCantonLista(Integer idcanton, List<Cantones> cantones) {
        for (Cantones canton : cantones) {
            if (canton.getIdcanton().equals(idcanton)) {
                return canton;
            }
        }
        return null;
    }   
    
    //Ciudades
    private Ciudades encontrarCiudadLista(Integer idciudad, List<Ciudades> ciudades) {
        for (Ciudades ciudad : ciudades) {
            if (ciudad.getIdciudad().equals(idciudad)) {
                return ciudad;
            }
        }
        return null;
    }   
    
    //Estados Civiles
    public EstadoCivilEncoder getEstadoCivilEncoder() {
        return new EstadoCivilEncoder(daoestadocivil);
    }
    
    //Provincias
    public ProvinciaEncoder getProvinciaEncoder() {
        return new ProvinciaEncoder(daoprovincia);
    }
    
    //Cantones
    public CantonEncoder getCantonEncoder() {
        return new CantonEncoder(daocanton);
    }
    
    //Ciudades
    public CiudadEncoder getCiudadEncoder() {
        return new CiudadEncoder(daociudad);
    }

    Class<ListaAlumnos> onSuccess() {         
         daoalumno.actualizarAlumnos(alumno.getIdalumno(),alumno.getCedula(),alumno.getNombres(),alumno.getFnac(),alumno.getLnac(),alumno.getLibretam(),
                 estadocivil.getIdestadocivil(),alumno.getNacionalidad(),alumno.getOcupacion(),provincia.getIdprovincia(),canton.getIdcanton(),
                 ciudad.getIdciudad(),alumno.getSexo(),alumno.getDireccion(),alumno.getTelefono(),alumno.getCelular(),
                 alumno.getCorreo(),alumno.getTelpariente(),alumno.getInstproviene(),alumno.getNpadre(),alumno.getPpadre(),
                 alumno.getDpadre(),alumno.getNmadre(),alumno.getPmadre(),alumno.getDmadre());
         return ListaAlumnos.class;
    }
    
     Class<ListaAlumnos> onCanceled() {          
          return ListaAlumnos.class;
    }
}
