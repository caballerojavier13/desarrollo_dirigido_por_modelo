/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos;

import Modelo.Persona;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;

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

    public List<Persona> createPersonas(int size) {
        List<Persona> list = new ArrayList();
        for(int i = 0 ; i < size ; i++) {
            Persona p = new Persona(i);
            list.add(p);
        }
         
        return list;
    }
    
}
