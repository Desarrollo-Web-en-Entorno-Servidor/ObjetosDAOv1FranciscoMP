/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.Controllers;

import es.abarregas.Beans.Alumno;
import es.albarregas.DAO.AlumnosDAO;
import es.albarregas.DAO.IAlumnosDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author FranciscoAntonio
 */
@WebServlet(name = "Controllers", urlPatterns = {"/Controllers"})
public class Controllers extends HttpServlet {

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
    String cantidad=request.getParameter("numero");
    String clausulaWhere="";
    String url="";
    boolean error=false;
        
        if(request.getParameter("all") !=null){
            clausulaWhere="";
        }else if(cantidad!=null){
            clausulaWhere=" limit "+ cantidad;
        }else{
            error=true;
        }
        
        if(!error){
            IAlumnosDAO adao = new AlumnosDAO();
            ArrayList<Alumno> alumnos = adao.getAlumnos(clausulaWhere);
            
            request.setAttribute("alumnos",alumnos);
            url="salida.jsp";
        }else{
            request.setAttribute("error", "No se han pasado parámetros");
            url="error.jsp";
        }
        
        request.getRequestDispatcher(url).forward(request, response);
    } 
    
    
    }
