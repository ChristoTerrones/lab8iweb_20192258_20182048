<%@ page import="Beans.Cancion" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean type="java.util.ArrayList<Beans.Cancion>" scope="request" id="listaCancion"/>
<jsp:useBean id="inicio" scope="request" type="java.lang.String" class="java.lang.String" />
<jsp:useBean id="cambio" scope="request" type="java.lang.String" class="java.lang.String" />
<jsp:useBean id="id" scope="request" type="java.lang.String" class="java.lang.String" />
<jsp:useBean type="java.util.ArrayList<Beans.Cancion>" scope="request" id="listaCancionesFavoritas" class="java.util.ArrayList"/>
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
                <% if(inicio.equals("sinBoton")){ %>
                <div class="row gx-lg-5">
                    <div class="col-lg-8">
                        <h1 class='text-light'>Lista de Canciones</h1>
                    </div>
                </div>
                <% }else{ %>
                <div class="row gx-lg-5">
                    <div class="col-lg-8">
                        <h1 class='text-light'>Lista de Canciones por banda</h1>
                    </div>
                    <div class="col-lg-3">
                        <a class="btn btn-warning" href="<%=request.getContextPath()%>/listaCanciones">Mostrar todas las canciones</a>
                    </div>
                </div>
                <% } %>

            </div>
            <div class="tabla">
                <table class="table table-dark table-transparent table-hover">
                    <thead>
                        <th>ID</th>
                        <th>CANCION</th>
                        <th>BANDA</th>
                        <th>FAVORITO</th>
                        <th>GUARDAR</th>
                    </thead>
                    <% for (Cancion cancion : listaCancion){ %>
                    <tr>
                        <td><%=cancion.getIdCancion()%></td>
                        <td><%=cancion.getNombreCancion()%></td>
                        <td><%=cancion.getBanda()%></td>

                        <%  int esFavorito = 0;
                            if(listaCancionesFavoritas.isEmpty()){
                                esFavorito = 0;
                            }else{
                                for (Cancion favorita : listaCancionesFavoritas){
                                    if(favorita.getIdCancion() == cancion.getIdCancion()){
                                        esFavorito = 1;
                                        break;
                                    }else{
                                        esFavorito = 0;
                                    }
                                }
                            }%>

                        <%if(esFavorito == 1){ %>
                        <td><a href="<%=request.getContextPath()%>/listaCanciones?a=borrar&id=<%=cancion.getIdCancion()%>" class="btn btn-danger"> <\3 </a></td>
                        <% }else{%>
                        <td><a href="<%=request.getContextPath()%>/listaCanciones?a=agregar&id=<%=cancion.getIdCancion()%>" class="btn btn-primary"> <3 </a></td>
                        <% }%>
                        <td><a href="<%=request.getContextPath()%>/listaCanciones?a=listasReproduccion&id=<%=cancion.getIdCancion()%>" class="btn btn-info"> + </a></td>

                    </tr>
                    <% }%>
                </table>
            </div>

        </div>
        <jsp:include page="/static/scripts.jsp"/>
    </body>
</html>
