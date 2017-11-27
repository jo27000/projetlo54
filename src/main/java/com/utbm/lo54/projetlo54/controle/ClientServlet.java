/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utbm.lo54.projetlo54.controle;

import com.utbm.lo54.projetlo54.entity.Course;
import com.utbm.lo54.projetlo54.entity.Location;
import com.utbm.lo54.projetlo54.metier.CourseServiceImpl;
import com.utbm.lo54.projetlo54.metier.LocationServiceImpl;
import com.utbm.lo54.projetlo54.metier.interfaces.service.CourseService;
import com.utbm.lo54.projetlo54.metier.interfaces.service.LocationService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jonathan
 */
@WebServlet(name = "ClientServlet", urlPatterns = {"/ClientServlet"})
public class ClientServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ClientServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ClientServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            //ClientService cservice = new ClientServiceImpl();
            // cservice.read(0);

            Location l = new Location(null, "Belfort");
            Location l2 = new Location(null, "Paris");
            Location l3 = new Location(null, "Marseille");
            Location l4 = new Location(null, "Strasbourg");

            Course c = new Course(null, "Management");
            Course c2 = new Course(null, "Culture");
            Course c3 = new Course(null, "Economie");
            Course c4 = new Course(null, "Informatique");

            LocationService locSrv = new LocationServiceImpl();
            locSrv.create(l);
            locSrv.create(l2);
            locSrv.create(l3);
            locSrv.create(l4);

            CourseService courseSrv = new CourseServiceImpl();
            courseSrv.create(c);
            courseSrv.create(c2);
            courseSrv.create(c3);
            courseSrv.create(c4);
            //CourseSession cs = new CourseSession(null, Calendar.getInstance(), Calendar.getInstance(), c, l);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
