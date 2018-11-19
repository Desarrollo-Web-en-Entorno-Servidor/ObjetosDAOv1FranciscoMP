<%-- 
    Document   : error
    Created on : 12-nov-2018, 16:33:41
    Author     : FranciscoAntonio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Error...¡¡¡</title>
    </head>
    <body>
            
            <div>
                <p><%=request.getAttribute("error")%></p>
                        
            </div>
                <p><a href="<%= request.getContextPath() %>">Volver</a></p>
    </body>
</html>
