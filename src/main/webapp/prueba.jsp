<%@ page import="Beans.Cancion" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean type="java.util.ArrayList<Beans.Cancion>" scope="request" id="listasParaAgregar"/>
<jsp:useBean id="id" scope="request" type="java.lang.String" class="java.lang.String" />
<html>
    <jsp:include page="/static/head.jsp">
        <jsp:param name="title" value="Lista de Canciones Favoritas"/>
    </jsp:include>
    <body>
        <div class='container'>
            <jsp:include page="/includes/navbar.jsp">
                <jsp:param name="page" value=""/>
            </jsp:include>
            <div class="pb-5 pt-4 px-3 titlecolor">

                <div class="row gx-lg-5">
                    <div class="col-lg-8">
                        <h1 class='text-light'>Guardar en :</h1>
                    </div>

                </div>


            </div>
            <form method="post" action="<%=request.getContextPath()%>/listaCanciones?a=crearlista&id=<%=id%>">
                <div class="input-group mb-3">
                    <input type="text" class="form-control" placeholder="Escriba nombre de la nueva lista"
                           aria-label="Escriba nombre de la nueva lista" aria-describedby="button-addon2"
                           name="nuevoNombre" value="">
                    <button class="btn btn-outline-secondary" type="submit" id="button-addon2">Crear</button>
                </div>
            </form>
            <div class="tabla">
                <table class="table table-dark table-transparent table-hover">
                    <thead>
                        <th>NOMBRE LISTA</th>
                        <th>AGREGAR</th>
                    </thead>
                    <%
                        for (Cancion cancionesFavoritas : listasParaAgregar) {
                    %>
                    <tr>
                        <td><%=cancionesFavoritas.getNombreCancion()%></td>
                        <td><a href="<%=request.getContextPath()%>/listaCanciones?a=agregarAlista&id=<%=id%>&nomLista=<%=cancionesFavoritas.getNombreCancion()%>" class="btn btn-info"> + </a></td>
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
