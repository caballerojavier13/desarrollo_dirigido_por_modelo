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

/**
 *
 * @author javier
 */
@ManagedBean(name = "HomeView")
@ViewScoped
public class ControladorJSF_Home {
    private List<Persona> refPersona;
    /**
     * Creates a new instance of ControladorJSF_Home
     */
    public ControladorJSF_Home() {
    }
    

    @ManagedProperty("#{personaService}")
    private PersonaService service;

    @PostConstruct
    public void init() {
        refPersona = service.createPersonas(50);
    }

    public List<Persona> getPersonas() {
        return refPersona;
    }

    public void setService(PersonaService service) {
        this.service = service;
    }

}
