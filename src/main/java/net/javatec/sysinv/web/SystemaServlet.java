package net.javatec.sysinv.web;

/**
 * Servlet implementation class SystemServlet
 */

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jakarta.servlet.annotation.WebServlet;
import net.javatec.sysinv.dao.SystemaDAO;
import net.javatec.sysinv.model.Systema;


@WebServlet("/")
public class SystemaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private SystemaDAO systemaDAO;

    public void init() {
        systemaDAO = new SystemaDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertSystema(request, response);
                    break;
                case "/delete":
                    deleteSystema(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateSystema(request, response);
                    break;
                default:
                    listSystema(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listSystema(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
        List < Systema > listSystema = systemaDAO.selectAllSystems();
        request.setAttribute("listSystema", listSystema);
        RequestDispatcher dispatcher = request.getRequestDispatcher("systema-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("systema-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Systema existingSystema = systemaDAO.selectSystema(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("systema-form.jsp");
        request.setAttribute("systema", existingSystema);
        dispatcher.forward(request, response);

    }

    private void insertSystema(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        String name = request.getParameter("name");
        String serialNumber = request.getParameter("serialNumber");
        String location = request.getParameter("location");
        Systema newSystema = new Systema(name, serialNumber, location);
        systemaDAO.insertSystema(newSystema);
        response.sendRedirect("list");
    }

    private void updateSystema(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String serialNumber = request.getParameter("serialNumber");
        String location = request.getParameter("location");

        Systema book = new Systema(id, name, serialNumber, location);
        systemaDAO.updateSystema(book);
        response.sendRedirect("list");
    }

    private void deleteSystema(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        systemaDAO.deleteSystem(id);
        response.sendRedirect("list");

    }
}
