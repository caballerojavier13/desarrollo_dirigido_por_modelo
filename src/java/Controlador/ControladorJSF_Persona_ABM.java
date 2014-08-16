/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author javier
 */
@ManagedBean(name = "ABMPersona")
public class ControladorJSF_Persona_ABM {

    private String Nombre;

    private String Apellido;

    private int Edad;

    /**
     * Creates a new instance of ControladorJSF_Persona_ABM
     */
    public ControladorJSF_Persona_ABM() {
    }

    /**
     * Get the value of Edad
     *
     * @return the value of Edad
     */
    public int getEdad() {
        return Edad;
    }

    /**
     * Set the value of Edad
     *
     * @param Edad new value of Edad
     */
    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

    /**
     * Get the value of Apellido
     *
     * @return the value of Apellido
     */
    public String getApellido() {
        return Apellido;
    }

    /**
     * Set the value of Apellido
     *
     * @param Apellido new value of Apellido
     */
    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    /**
     * Get the value of Nombre
     *
     * @return the value of Nombre
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * Set the value of Nombre
     *
     * @param Nombre new value of Nombre
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void Guardar() {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Bienvenido " + Nombre + " " + Apellido));
    }

    public void Cancelar() {
        Nombre = "";
        Apellido = "";
        Edad = 0;
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Bienvenido " + Nombre + " " + Apellido));
    }

    public void Eliminar() {
        System.out.println("Hola");
    }
    public void Editar() {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Bienvenido " + Nombre + " " + Apellido));
    }
    public void MostrarEdicion() {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Bienvenido " + Nombre + " " + Apellido));
    }
}
