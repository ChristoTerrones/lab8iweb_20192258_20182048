<%@ page import="Beans.Cancion" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean type="java.util.ArrayList<Beans.Cancion>" scope="request" id="listas"/>
<html>
    <jsp:include page="/static/head.jsp">
        <jsp:param name="title" value="Listas de Canciones "/>
    </jsp:include>
    <body>
        <div class='container'>
            <jsp:include page="/includes/navbar.jsp">
                <jsp:param name="page" value="listas"/>
            </jsp:include>
            <div class="pb-5 pt-4 px-3 titlecolor">

                <div class="row gx-lg-5">
                    <div class="col-lg-8">
                        <h1 class='text-light'>Lista de Canciones </h1>
                    </div>

                </div>

            </div>
            <div class="tabla">
                <table class="table table-dark table-transparent table-hover">
                    <thead>
                        <th> </th>
                        <th> </th>

                    </thead>
                    <%
                        for (Cancion canciones : listas) {
                    %>
                    <tr>
                        <td><%=canciones.getNombreCancion()%></td>
                        <td><a class="btn btn-success" href="<%=request.getContextPath()%>/listaCanciones?a=escoge&nombrelista=<%=canciones.getNombreCancion() %>">Acceder</a></td>
                    </tr>
                    <%
                        }
                    %>
                </table>
            </div>

        </div>
        <jsp:include page="/static/scripts.jsp"/>
    </body>
