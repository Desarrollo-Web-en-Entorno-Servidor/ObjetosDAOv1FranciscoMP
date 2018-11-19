
package es.albarregas.DAO;

import es.albarregas.Beans.Alumno;
import es.albarregas.Beans.Equipo;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
        ArrayList <Alumno> lista = new ArrayList();
        String consulta="select nombre,grupos from alumnos" + limit;
        try{
            Statement sentencia=ConnectionFactory.getConnection().createStatement();
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
    //Usar getAlumnos para obtener array de alumnos y añadir su equipo
    public ArrayList<Alumno> getAlumnosEquipo(String limit) {

        ArrayList<Alumno> lista = getAlumnos(limit);
        String consulta = "SELECT * FROM alumnos NATURAL join equipos where idAlumno=?";
        try {
            Connection conexion=ConnectionFactory.getConnection();
            PreparedStatement preparada = conexion.prepareStatement(consulta);
            for (int i=0;i<lista.size();i++) {
                
                preparada.setInt(1, lista.get(i).getIdAlumno());
                ResultSet resultado = preparada.executeQuery();
                while (resultado.next()) {
                    Equipo equipo = new Equipo();
                    equipo.setIdEquipo(resultado.getInt("idEquipo"));
                    equipo.setMarca(resultado.getString("marca"));
                    equipo.setNumSerie(resultado.getString("numSerie"));
                    lista.get(i).setEquipo(equipo);
                }
                resultado.close();              
            }
            preparada.close();
        } catch (SQLException ex) {
            System.out.println("Error al ejecutar la sentencia");
            ex.printStackTrace();
        }
        return lista;

    }

    public void closeConnection(Connection conexion) {

        ConnectionFactory.closeConnection(conexion);

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
