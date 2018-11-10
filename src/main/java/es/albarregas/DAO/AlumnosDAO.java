/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.DAO;

import es.abarregas.Beans.Alumno;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author FranciscoAntonio
 */
public class AlumnosDAO implements IAlumnosDAO{
 
    @Override
    public ArrayList<Alumno> getAlumnos(String limit){
        ArrayList <Alumno> lista = new ArrayList();
        String consulta="select nombre,grupos from alumnos" + limit;
        try{
            Statement sentencia=ConnectionFactory.conectar().createStatement();
            ResultSet resultado=sentencia.executeQuery(consulta);
            
            while(resultado.next()){
                Alumno alumno =new Alumno();
                alumno.setNombre(resultado.getString("nombre"));
                alumno.setGrupo(resultado.getString("grupo"));
                lista.add(alumno);
        
            }
            resultado.close();
    }catch (SQLException ex){
        System.out.println("Error al ejecutar la sentencia.");
        ex.printStackTrace();
    }   catch (ClassNotFoundException ex) {
            Logger.getLogger(AlumnosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    return lista;
    }

    @Override
    public ArrayList<Alumno> getAlumnosEquipos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void closeConnection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
