import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AgeCalculatorServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // this will have the servlet call upon a JSP to be loaded by the client's browser
        getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request,response);
        // stop the code call
        return;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String currentage = "";
       
        // capture the parameters coming in from the POST request
        currentage = request.getParameter("current_age");
        
   
        // Set some attributes in the request object.
        request.setAttribute("currentAge", currentage);
 

        // validation: if the parameters don't exist or are empty, show the first page again.
        if( currentage == null || currentage.equals(" ") ){
            // set up a helpful error message for the user.
            request.setAttribute("message", "Invalid entry. Please enter age");
            // display the form again.
            getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request, response);
            // after we load a JSP, use a return statement.
            // stop the code from executing (VERY IMPORTANT!)
            return;
        }
        if (!currentage.matches("[0-9]+")) {
         request.setAttribute("message", "Invalid input, enter a number");
             // display the form again.
            getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request, response);
            // after we load a JSP, use a return statement.
            // stop the code from executing (VERY IMPORTANT!)
            return;
        }
       else {
        
            // set the attributes for the JSP   
            request.setAttribute("nextAge", "Your age next birthday will be " + (+Integer.parseInt(currentage) + 1));
            return;
        
            
        }
    }

}