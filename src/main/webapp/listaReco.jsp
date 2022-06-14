<%@ page import="Beans.Recomendados" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean type="java.util.ArrayList<Beans.Recomendados>" scope="request" id="listaReco"/>
<html>
    <jsp:include page="/static/head.jsp">
        <jsp:param name="title" value="Lista de Canciones Recomendadas"/>
    </jsp:include>
    <body>
        <div class='container'>
            <jsp:include page="/includes/navbar.jsp">
                <jsp:param name="page" value="recomendaciones"/>
            </jsp:include>
            <div class="pb-5 pt-4 px-3 titlecolor">
                <div class="col-lg-6">
                    <h1 class='text-light'>Lista de Tours por Ciudad</h1>
                </div>
            </div>
            <div class="tabla">
                <table class="table table-dark table-transparent table-hover">
                    <thead>
                        <th>ID</th>
                        <th>CANCION</th>
                        <th>BANDA</th>
                        <th>VER</th>
                    </thead>
                    <%
                        for (Recomendados recomendados : listaReco) {
                    %>
                    <tr>
                        <td><%=recomendados.getIdCancion()%></td>
                        <td><%=recomendados.getNombreCancion()%></td>
                        <td><%=recomendados.getBanda()%></td>
                        <td><a class="btn btn-success" href="<%=request.getContextPath()%>/listaCanciones?a=filtra&idbanda=<%recomendados.getBanda();%>">Más de la banda</a></td>
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
