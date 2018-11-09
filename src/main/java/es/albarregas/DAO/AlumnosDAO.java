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

/**
 *
 * @author FranciscoAntonio
 */
public class AlumnosDAO implements IAlumnosDAO{
 
    @Override
    public ArrayList<Alumno> getAlumnos(String limit){
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
    }
    return lista;
    }
}
