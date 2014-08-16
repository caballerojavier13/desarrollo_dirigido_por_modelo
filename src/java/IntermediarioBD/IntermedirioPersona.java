/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IntermediarioBD;

import Modelo.Persona;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author javier
 */
public class IntermedirioPersona extends Intermediario {
    
    public List<Persona> ListarPersonas() {
        List<Persona> resultado = new ArrayList();
        Connection conn = null;
        try {
            try {
                // Creamos la conexion  
                conn = ConectarBaseDatos();
                conn.setAutoCommit(false);

                CallableStatement cStmt = conn.prepareCall("call FindAllPersona()");
                cStmt.execute();
                final ResultSet rs = cStmt.getResultSet();
                while (rs.next()) {
                    Persona p = new Persona();
                    p.setId(new Long(rs.getInt("id")));
                    p.setNombre(rs.getString("Nombre"));
                    p.setApellido(rs.getString("Apellido"));
                    p.setEdad(rs.getInt("Edad"));
                    resultado.add(p);
                }

            } catch (Exception e) {

                conn.rollback();

            } finally {
                conn.close();
            }
        } catch (Exception e) {

        }
        return resultado;
    }

    public Persona Buscar(int id) {
        Connection conn = null;
        Persona p = null;
        try {
            try {
                // Creamos la conexion  
                conn = ConectarBaseDatos();
                conn.setAutoCommit(false);

                CallableStatement cStmt = conn.prepareCall("{call FindPersona(?)}");
                cStmt.setInt(1, id);
                cStmt.execute();
                final ResultSet rs = cStmt.getResultSet();
                while (rs.next()) {
                    p = new Persona();
                    p.setId(new Long(rs.getInt("id")));
                    p.setNombre(rs.getString("Nombre"));
                    p.setApellido(rs.getString("Apellido"));
                    p.setEdad(rs.getInt("Edad"));
                }

            } catch (Exception e) {
                conn.rollback();
            } finally {
                conn.close();
            }
        } catch (Exception e) {
        }
        return p;
    }
    public boolean Guardar(Persona p){
        if(p.getId() < 0){
            return Crear(p);
        }else{
            return Actualizar(p);
        }
    }
    private boolean Crear(Persona p){
        Connection conn = null;
        boolean resultado = true;
        try {
            try {
                // Creamos la conexion  
                conn = ConectarBaseDatos();
                conn.setAutoCommit(true);

                CallableStatement cStmt = conn.prepareCall("{call AddPersona(?, ?, ?)}");
                cStmt.setString(1,p.getNombre());
                cStmt.setString(2,p.getApellido());
                cStmt.setInt(3,p.getEdad());
                cStmt.execute();

            } catch (Exception e) {
                conn.rollback();
                resultado = false;
            } finally {
                conn.close();
            }
        } catch (Exception e) {
            resultado = false;
        }
        return resultado;
    }
    private boolean Actualizar(Persona p){
        Connection conn = null;
        boolean resultado = true;
        try {
            try {
                // Creamos la conexion  
                conn = ConectarBaseDatos();
                conn.setAutoCommit(true);

                CallableStatement cStmt = conn.prepareCall("{call EditPersona(?, ?, ?, ?)}");
                cStmt.setInt(1,p.getId().intValue());
                cStmt.setString(2,p.getNombre());
                cStmt.setString(3,p.getApellido());
                cStmt.setInt(4,p.getEdad());
                cStmt.execute();

            } catch (Exception e) {
                conn.rollback();
                resultado = false;
            } finally {
                conn.close();
            }
        } catch (Exception e) {
            resultado = false;
        }
        return resultado;
    }
    public boolean Eliminar(Persona p){
        Connection conn = null;
        boolean resultado = true;
        try {
            try {
                // Creamos la conexion  
                conn = ConectarBaseDatos();
                conn.setAutoCommit(true);

                CallableStatement cStmt = conn.prepareCall("{call DeletePersona(?)}");
                cStmt.setInt(1,p.getId().intValue());
                cStmt.execute();

            } catch (Exception e) {
                conn.rollback();
                resultado = false;
            } finally {
                conn.close();
            }
        } catch (Exception e) {
            resultado = false;
        }
        return resultado;
    }
}
