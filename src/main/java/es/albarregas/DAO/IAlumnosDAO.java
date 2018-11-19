
package es.albarregas.DAO;

import es.albarregas.Beans.Alumno;
import java.util.ArrayList;

/**
 *
 * @author FranciscoAntonio
 */
public interface IAlumnosDAO {
    public ArrayList <Alumno> getAlumnos(String where);
    public ArrayList <Alumno> getAlumnosEquipos();
    public void closeConnection();
}
