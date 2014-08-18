/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Expertos;

import IntermediarioBD.IntermediarioPersona;
import Modelo.Persona;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author javier
 */
@ManagedBean(name = "personaService")
@ApplicationScoped
public class PersonaService {

    /**
     * Creates a new instance of PersonaService
     */
    public PersonaService() {
    }

    public List<Persona> listarPersonas() {
        return new IntermediarioPersona().ListarPersonas();
    }
    
    public void eliminarPersona(int id){
        new IntermediarioPersona().Eliminar(new IntermediarioPersona().Buscar(id));
    }
    
    public boolean guardar(Persona p){
        boolean Guardar = new IntermediarioPersona().Guardar(p);
        return Guardar;
    }
    
}
