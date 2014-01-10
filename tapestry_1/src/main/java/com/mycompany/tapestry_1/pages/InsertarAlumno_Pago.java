/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tapestry_1.pages;

import com.mycompany.tapestry_1.encoder.AlumnoEncoder;
import com.mycompany.tapestry_1.encoder.CarreraEncoder;
import com.mycompany.tapestry_1.encoder.PagoEncoder;
import com.mycompany.tapestry_1.encoder.SemestreEncoder;
import com.mycompany.tapestry_1.services.AlumnoPagoDAO;
import com.mycompany.tapestry_1.services.AlumnosDAO;
import com.mycompany.tapestry_1.services.CarreraDAO;
import com.mycompany.tapestry_1.services.PagosDAO;
import com.mycompany.tapestry_1.services.SemestreDAO;
import entidades.Alumno_Pago;
import entidades.Alumnos;
import entidades.Carrera;
import entidades.Pagos;
import entidades.Semestre;
import java.util.List;
import org.apache.tapestry5.EventContext;
import org.apache.tapestry5.SelectModel;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.SelectModelFactory;

/**
 *
 * @author Mauricio
 */
public class InsertarAlumno_Pago {    
    private Integer idalumno;    
    private Integer idcarrera;
    private Integer idpago;
    private Integer idsemestre;    
    //Alumno_Pago
    @Inject
    private AlumnoPagoDAO dao;    
    @Property
    private  Alumno_Pago alumno_pago;    
    //Alumnos
    @Inject
    private AlumnosDAO daoalumno;    
    @Property
    private  Alumnos alumno;    
    //Carreras
    @Inject
    private CarreraDAO daocarrera;    
    @Property
    private  Carrera carrera;    
    //Pagos
    @Inject
    private PagosDAO daopago;    
    @Property
    private  Pagos pago;    
    //Semestres
    @Inject
    private SemestreDAO daosemestre;    
    @Property
    private  Semestre semestre;    
    //Modelos
    @Property
    private SelectModel alumnosModel;    
    @Property
    private SelectModel carrerasModel;
    @Property
    private SelectModel pagosModel;
    @Property
    private SelectModel semestresModel;
    
    @Inject
    private SelectModelFactory selectModelFactory;
    
    void setupRender() {
        alumno_pago = new Alumno_Pago();        
    }
    void onPrepareForSubmit() {
        alumno_pago = new Alumno_Pago();
    }    
    void onActivate(EventContext context) {
        //Alumnos
        if (context.getCount() > 0) {
            idalumno = context.get(Integer.class, 0);
        }
        //Carreras
        if (context.getCount() > 0) {
            idcarrera = context.get(Integer.class, 0);
        }
        //Pagos
        if (context.getCount() > 0) {
            idpago = context.get(Integer.class, 0);
        }
        //Semestres
        if (context.getCount() > 0) {
            idsemestre = context.get(Integer.class, 0);
        }
    }

    void onPrepareForRender() {
        //Obtiene toda la lista de Alumnos
        List<Alumnos> alumnos = daoalumno.listarTodos();
        if (idalumno != null) {
            alumno = encontrarAlumnoLista(idalumno, alumnos);
        }
        alumnosModel = selectModelFactory.create(alumnos, "nombres");        
        //Obtiene toda la lista de Carreras
        List<Carrera> carreras = daocarrera.listarTodos();
        if (idcarrera != null) {
            carrera = encontrarCarreraLista(idcarrera, carreras);
        }
        carrerasModel = selectModelFactory.create(carreras, "ncarrera");        
        //Obtiene toda la lista de Pagos
        List<Pagos> pagos = daopago.listarTodos();
        if (idpago != null) {
            pago = encontrarPagosLista(idpago, pagos);
        }
        pagosModel = selectModelFactory.create(pagos, "npago");        
        //Obtiene toda la lista de Semestres
        List<Semestre> semestres = daosemestre.listarTodos();
        if (idsemestre != null) {
            semestre = encontrarSemestresLista(idsemestre, semestres);
        }
        semestresModel = selectModelFactory.create(semestres, "nsemestre");
    }

    void onValidateFromForm() {
        idalumno = alumno == null ? null : alumno.getIdalumno();
        idcarrera = carrera == null ? null : carrera.getIdcarrera();
        idpago = pago == null ? null : pago.getIdpago();
        idsemestre = semestre == null ? null : semestre.getIdsemestre();
    }
    
    //Alumnos
    private Alumnos encontrarAlumnoLista(Integer idalumno, List<Alumnos> alumnos) {
        for (Alumnos alumno : alumnos) {
            if (alumno.getIdalumno().equals(idalumno)) {
                return alumno;
            }
        }
        return null;
    }    
    //Carreras
    private Carrera encontrarCarreraLista(Integer idcarrera, List<Carrera> carreras) {
        for (Carrera carrera : carreras) {
            if (carrera.getIdcarrera().equals(idcarrera)) {
                return carrera;
            }
        }
        return null;
    }    
    //Pagos
    private Pagos encontrarPagosLista(Integer idpago, List<Pagos> pagos) {
        for (Pagos pago : pagos) {
            if (pago.getIdpago().equals(idpago)) {
                return pago;
            }
        }
        return null;
    }    
    //Semestres
    private Semestre encontrarSemestresLista(Integer idsemestre, List<Semestre> semestres) {
        for (Semestre semestre : semestres) {
            if (semestre.getIdsemestre().equals(idsemestre)) {
                return semestre;
            }
        }
        return null;
    }    
    //Alumnos
    public AlumnoEncoder getAlumnoEncoder() {
        return new AlumnoEncoder(daoalumno);
    }
    //Carrera
    public CarreraEncoder getCarreraEncoder() {
        return new CarreraEncoder(daocarrera);
    }
    //Pagos
    public PagoEncoder getPagoEncoder() {
        return new PagoEncoder(daopago);
    }
    //Semestres
    public SemestreEncoder getSemestreEncoder() {
        return new SemestreEncoder(daosemestre);
    }
    
    void onSuccess() { 
         dao.insertarAlumno_Pago(alumno.getIdalumno(),pago.getIdpago(),carrera.getIdcarrera(),semestre.getIdsemestre(),alumno_pago.getSeccion(), alumno_pago.getPeriodo());         
    }
    
    Class<Portada> onCanceled() {          
         return Portada.class;
    }
}