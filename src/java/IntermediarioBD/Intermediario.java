/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package IntermediarioBD;

import java.sql.Connection;

/**
 *
 * @author javier
 */
public abstract class Intermediario {
    protected Connection ConectarBaseDatos() throws Exception{
        return ConexionMySQL.conectar("localhost", "root", "root", "tutorial");
    }
}
