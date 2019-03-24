import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "WyborPiwa")
public class WyborPiwa extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("windows-1250");

        EkspertPiwny ekspert = new EkspertPiwny();
        String colour = request.getParameter("colour");
        List<String> brandList = ekspert.getBrands(colour);

        request.setAttribute("brandList", brandList);
        getServletConfig().getServletContext().getRequestDispatcher("/wynik.jsp").forward(request,response);

        /*
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>Pierwszy Servlet</title></head>");
        out.println("<body>");
        for(String brand: brandList) {
            out.println("<p>" + brand + "</p>");
        }
        out.println("</body>");
        out.println("</html>");
        out.close();
        */
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
