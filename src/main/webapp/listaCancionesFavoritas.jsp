<%@ page import="Beans.Cancion" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean type="java.util.ArrayList<Beans.Cancion>" scope="request" id="listaCancion"/>
<html>
    <jsp:include page="/static/head.jsp">
        <jsp:param name="title" value="Lista de Canciones"/>
    </jsp:include>
    <body>
        <div class='container'>
            <jsp:include page="/includes/navbar.jsp">
                <jsp:param name="page" value="canciones"/>
            </jsp:include>
            <div class="pb-5 pt-4 px-3 titlecolor">

                <div class="row gx-lg-5">
                    <div class="col-lg-8">
                        <h1 class='text-light'>Lista de Canciones</h1>
                    </div>
                    <div class="col-lg-3">
                        <a class="btn btn-warning" href="<%=request.getContextPath()%>/listaCanciones">Mostrar todas las canciones</a>
                    </div>
                </div>

            </div>
            <div class="tabla">
                <table class="table table-dark table-transparent table-hover">
                    <thead>
                        <th>ID</th>
                        <th>CANCION</th>
                        <th>BANDA</th>
                    </thead>
                    <%
                        for (Cancion cancion : listaCancion) {
                    %>
                    <tr>
                        <td><%=cancion.getIdCancion()%></td>
                        <td><%=cancion.getNombreCancion()%></td>
                        <td><%=cancion.getBanda()%></td>
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