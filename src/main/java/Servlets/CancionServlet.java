package Servlets;

import Beans.Cancion;
import Daos.CancionDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "CancionServlet", value = "/listaCanciones")
public class CancionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CancionDao cancion = new CancionDao();
        String action = request.getParameter("a") == null? "listar" : request.getParameter("a");
        switch (action){
            case "listar" -> {
                request.setAttribute("listaCancion",cancion.obtenerListaCancion());
                request.setAttribute("inicio","sinBoton");
                RequestDispatcher view =request.getRequestDispatcher("listaCancion.jsp");
                view.forward(request,response);
            }
            case "filtra" -> {
                String banda = request.getParameter("idbanda");
                request.setAttribute("inicio","conBoton");
                request.setAttribute("listaCancion",cancion.obtenerListaCancionBanda(banda));
                RequestDispatcher view =request.getRequestDispatcher("listaCancion.jsp");
                view.forward(request,response);
            }
            case "favorito" -> {
                request.setAttribute("listaCancionesFavoritas",cancion.obtenerListaCancionesFavoritas());

                RequestDispatcher view =request.getRequestDispatcher("listaCancionesFavoritas.jsp");
                view.forward(request,response);
            }
            case "favorito" -> {
                request.setAttribute("listaCancionesFavoritas",cancion.obtenerListaCancionesFavoritas());

                RequestDispatcher view =request.getRequestDispatcher("listaCancionesFavoritas.jsp");
                view.forward(request,response);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
