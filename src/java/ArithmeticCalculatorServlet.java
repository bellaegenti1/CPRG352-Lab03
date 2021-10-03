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
public class ArithmeticCalculatorServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("message", "---");
        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request,response);
        return;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String first = request.getParameter("first");
        String second = request.getParameter("second");
        String operator = request.getParameter("operator");
        request.setAttribute("first", first);
        request.setAttribute("second", second);
        
        int firstInt = 0;
        int secondInt = 0;
        
        try {
            firstInt = Integer.parseInt(first);
            secondInt = Integer.parseInt(second);
        } catch (NumberFormatException e) {
            request.setAttribute("message", "invalid");
            getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request,response);
            return;
        }
        
        switch (operator) {
            case "+": request.setAttribute("message", firstInt + secondInt); break;
            case "-": request.setAttribute("message", firstInt - secondInt); break;
            case "*": request.setAttribute("message", firstInt * secondInt); break;
            case "%": request.setAttribute("message", firstInt % secondInt); break;
            default: break;
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request,response);
        return;
    }

   
}