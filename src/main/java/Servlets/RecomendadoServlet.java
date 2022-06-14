package Servlets;

import Beans.Recomendados;
import Daos.RecomendadosDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "RecomendadoServlet", value = "/listaRecomendados")
public class RecomendadoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RecomendadosDao reco = new RecomendadosDao();
        ArrayList<Recomendados> listaReco = reco.obtenerListaReco();

        request.setAttribute("listaReco",listaReco);

        RequestDispatcher view =request.getRequestDispatcher("listaReco.jsp");
        view.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
