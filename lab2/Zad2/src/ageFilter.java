import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ageFilter")
public class ageFilter extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("windows-1250");

        int age = Integer.parseInt(request.getParameter("age"));
        if (age >=18){
            HttpServletResponse HttpResponse = (HttpServletResponse) response;
            HttpResponse.sendRedirect(request.getContextPath()+"/form.html");
        }
        else {
            PrintWriter out = response.getWriter();
            out.println("<html>");
            out.println("<head><title>Pierwszy Servlet</title></head>");
            out.println("<body>");
            out.println("<p>Nie jestes pelnoletni</p>");
            out.println("</body>");
            out.println("</html>");
            out.close();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
