<%@ page import="Beans.Cancion" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean type="java.util.ArrayList<Beans.Cancion>" scope="request" id="playlist"/>
<html>
    <jsp:include page="/static/head.jsp">
        <jsp:param name="title" value="Listas de Canciones "/>
    </jsp:include>
    <body>
        <div class='container'>
            <jsp:include page="/includes/navbar.jsp">
                <jsp:param name="page" value=""/>
            </jsp:include>
            <div class="pb-5 pt-4 px-3 titlecolor">
                <div class="row gx-lg-5">
                    <div class="col-lg-8">
                        <h1 class='text-light'><%=playlist.get(0).getNombreCancion()%></h1>
                    </div>
                </div>
            <div class="tabla">
                <table class="table table-dark table-transparent table-hover">
                    <thead>
                        <th>CANCIONES</th>
                    </thead>
                    <%
                        for (Cancion canciones : playlist) {
                    %>
                    <tr>
                        <td><%=canciones.getBanda()%></td>

                    </tr>
                    <%
                        }
                    %>
                </table>
            </div>

        </div>
        <jsp:include page="/static/scripts.jsp"/>
    </body>
</html>