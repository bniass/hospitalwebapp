package controller;

import model.Utilisateur;
import service.IParametre;
import service.IUser;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserServlet", urlPatterns = "/user")
public class UserServlet extends HttpServlet {


    @EJB
    private IUser userEJB;
    @EJB
    private IParametre parametreEJB;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("username");
        String pwd = request.getParameter("password");
        Utilisateur u = userEJB.authentification(login, pwd);
        if(u != null)
        {
            if(u.getProfil().equals("admin")) {
                request.setAttribute("specialites", parametreEJB.findSpecialites());
                getServletContext().getRequestDispatcher("/WEB-INF/specialite.jsp")
                        .forward(request, response);
            }
            else{
                request.setAttribute("services", parametreEJB.findServices());
                getServletContext().getRequestDispatcher("/WEB-INF/service.jsp")
                        .forward(request, response);
            }
        }
        else{
            request.setAttribute("error", "Login ou password inccorect !");
            getServletContext().getRequestDispatcher("/WEB-INF/index.jsp")
                    .forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/index.jsp")
                .forward(request, response);
    }
}
