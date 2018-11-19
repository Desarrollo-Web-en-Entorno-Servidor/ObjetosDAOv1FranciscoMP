<%-- 
    Document   : salida
    Created on : 12-nov-2018, 16:34:02
    Author     : FranciscoAntonio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="es.albarregas.Beans.Alumno, es.albarregas.Beans.Equipo, java.util.List, java.util.ArrayList" %>
<!DOCTYPE html>
<html>
        
        <head>
            <title>Salida</title>
        </head>
        <body>
            
            <table>
                <thead>
                    <tr>
                        <th>idAlumno</th>
                        <th>Nombre</th>
                        <th>Grupo</th>
                        <th>Equipo</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        List<Alumno> alumnos = null;
                        alumnos = new ArrayList();
                        alumnos = (ArrayList<Alumno>)request.getAttribute("alumnos");
                        for(Alumno alumno : alumnos) {
//                            Equipo equipo = alumno.getEquipo();
                        
                    %>
                    
                        <tr>
                            <td><%= alumno.getIdAlumno()%></td>
                            <td><%= alumno.getNombre()%></td>
                            <td><%= alumno.getGrupo() %></td>
                            <!--Añadir equipo-->
                            <td><%= alumno.getEquipo().getIdEquipo()%> - <%= alumno.getEquipo().getMarca()%> - <%= alumno.getEquipo().getNumSerie()%></td>
                        </tr>
                        <%
                            }
                        %>
                </tbody>
            </table>
                        <p><a href="<%= request.getContextPath() %>">Volver</a></p>
        </body>
    </html>
