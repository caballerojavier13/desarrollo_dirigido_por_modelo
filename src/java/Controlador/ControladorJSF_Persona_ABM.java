/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Persona;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author javier
 */
@ManagedBean(name = "ABMPersona")
public class ControladorJSF_Persona_ABM {
    
    private Persona selectedPersona;
       /**
     * Creates a new instance of ControladorJSF_Persona_ABM
     */
    public ControladorJSF_Persona_ABM() {
    }

    public void Guardar() {
    }

    public void Cancelar() {
        
    }

    
    public Persona getSelectedPersona() {
        return selectedPersona;
    }
 
    public void setSelectedPersona(Persona selectedPersona) {
        this.selectedPersona = selectedPersona;
    }
    
    }
