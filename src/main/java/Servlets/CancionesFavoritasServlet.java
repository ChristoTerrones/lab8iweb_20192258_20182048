package Servlets;

import Beans.CancionesFavoritas;
import Daos.CancionesFavoritasDao;
import Daos.CancionesFavoritasDaoDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "CancionesFavoritasServlet", value = "/CancionesFavoritasServlet")
public class CancionesFavoritasServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CancionesFavoritasDao cancionfavorita = new CancionesFavoritasDao();
        ArrayList<CancionesFavoritas> listaCancion = cancionesfavorita.obtenerListaCancion();

        request.setAttribute("listaCancion",listaCancion);

        RequestDispatcher view =request.getRequestDispatcher("listaCancionesFavoritas.jsp");
        view.forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
