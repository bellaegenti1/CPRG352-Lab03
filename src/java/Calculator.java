/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author bellaegenti1
 */
public class Calculator extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // load up JSP
        getServletContext().getRequestDispatcher ("/WEB-INF/Calculator.jsp").forward(request,response);
        return;
    
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //capture parameters
        String currentage = request.getParameter("current_age");
        String nextage = request.getParameter("next_age");
        
        //System.out.println(firstname);
          // System.out.println(firstname);
          request.setAttribute("currentAge", currentage);
          request.setAttribute("nextAge", nextage);
        //validations: make sure parameters are met
        if (currentage == null || currentage.equals("") || nextage == null || nextage.equals("")){
            // set a message to help user
            request.setAttribute("message", "Invalid input, please enter next age");
          
            // distplay the form again
            getServletContext().getRequestDispatcher ("/WEB-INF/CalculatorForm.jsp").forward(request, response);
          return;
        }
        
             getServletContext().getRequestDispatcher("/WEB-INF/calcAge.jsp").forward(request,response);
        return;
    }
}
    

