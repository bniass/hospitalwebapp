package controller;

import model.Service;
import model.Specialite;
import service.IParametre;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SpecialiteServlet", urlPatterns = "/specialite")
public class SpecialiteServlet extends HttpServlet {
    @EJB
    private IParametre parametreEJB;

    public void addOrUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        Specialite specialite = new Specialite();
        if(request.getParameter("action").equals("update")){
            int idsp = Integer.parseInt(request.getParameter("id"));
            specialite = parametreEJB.findSpecialiteById(idsp);
        }
        specialite.setLibelle(request.getParameter("libelle"));
        int id = Integer.parseInt(request.getParameter("service"));
        Service service = parametreEJB.findServiceById(id);
        specialite.setService(service);
        parametreEJB.addSpecialite(specialite);
        response.sendRedirect("specialite?action=list");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action!=null){
            switch (action){
                case "add" :
                    addOrUpdate(request, response);
                    break;
                case "update"  :
                    addOrUpdate(request, response);
                    break;
                default:
                    request.setAttribute("specialites", parametreEJB.findSpecialites());
                    getServletContext().getRequestDispatcher("/WEB-INF/specialite.jsp")
                            .forward(request, response);
            }
        }
        else {
            request.setAttribute("specialites", parametreEJB.findSpecialites());
            getServletContext().getRequestDispatcher("/WEB-INF/specialite.jsp")
                    .forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action!=null){
            switch (action){
                case "list" :
                    request.setAttribute("specialites", parametreEJB.findSpecialites());
                    getServletContext().getRequestDispatcher("/WEB-INF/specialite.jsp")
                            .forward(request, response);
                    break;
                case "add"  :
                    request.setAttribute("services", parametreEJB.findServices());
                    getServletContext().getRequestDispatcher("/WEB-INF/addspecialite.jsp")
                            .forward(request, response);
                case "update"  :
                    request.setAttribute("services", parametreEJB.findServices());
                    long id = Integer.parseInt(request.getParameter("id"));
                    request.setAttribute("specialite", parametreEJB.findSpecialiteById(id));
                    getServletContext().getRequestDispatcher("/WEB-INF/addspecialite.jsp")
                            .forward(request, response);
                    break;
                case "delete" :
                    long idsp = Integer.parseInt(request.getParameter("id"));
                    parametreEJB.deleteSpecialiteById(idsp);
                    response.sendRedirect("specialite?action=list");
                    break;
                default:
                    request.setAttribute("specialites", parametreEJB.findSpecialites());
                    getServletContext().getRequestDispatcher("/WEB-INF/specialite.jsp")
                            .forward(request, response);
            }
        }
        else {
            request.setAttribute("specialites", parametreEJB.findSpecialites());
            getServletContext().getRequestDispatcher("/WEB-INF/specialite.jsp")
                    .forward(request, response);
        }
    }
}
