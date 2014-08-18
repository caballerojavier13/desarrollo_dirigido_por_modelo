/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Expertos.PersonaService;
import Modelo.Persona;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import org.primefaces.context.RequestContext;

/**
 *
 * @author javier
 */
@ManagedBean(name = "HomeView")
@ViewScoped
public class ControladorJSF_Home {

    private List<Persona> refPersona;
    private List<Persona> filtroPersona;

    private Persona selectedPersona;
    
    private String Nombre;
    private String Apellido;
    private int Edad;
    
    
    

    /**
     * Creates a new instance of ControladorJSF_Home
     */
    public ControladorJSF_Home() {
    }

    @ManagedProperty("#{personaService}")
    private PersonaService service;

    @PostConstruct
    public void init() {
        refPersona = service.listarPersonas();
        filtroPersona = refPersona;
        selectedPersona = null;
        
        Nombre = "";
        Apellido = "";
        Edad = 0;
        
        
    }

    public List<Persona> getPersonas() {
        return refPersona;
    }

    public Persona getSelectedPersona() {
        return selectedPersona;
    }

    public void setSelectedPersona(Persona selectedPersona) {
        this.selectedPersona = selectedPersona;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

    
    
    public void deletePersona() {
        refPersona.remove(selectedPersona);
        filtroPersona.remove(selectedPersona);
        service.eliminarPersona(selectedPersona.getId());
        selectedPersona = null;
    }

    public List<Persona> getFiltroPersona() {
        return filtroPersona;
    }

    public void setFiltroPersona(List<Persona> filtroPersona) {
        this.filtroPersona = filtroPersona;
    }

    public void setService(PersonaService service) {
        this.service = service;
    }

    public void cancelPersona() {
        selectedPersona = null;
    }

    public void savePersona() {
        service.guardar(selectedPersona);
        selectedPersona = null;
    }

    public void prepareCreatePersona() {
        cancelNewPersona();
    }

    public void cancelNewPersona() {
        Nombre = "";
        Apellido = "";
        Edad = 0;
    }

    public void saveNewPersona() {
        Persona p = new Persona(Nombre, Apellido, Edad);
        service.guardar(p);
        cancelNewPersona();
        refPersona = service.listarPersonas();
        filtroPersona = refPersona;
        RequestContext.getCurrentInstance().update("listadopersona");
    }
}
