import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.Enumeration;

@WebServlet(name = "zadPost")
public class zadPost extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("windows-1250");
        PrintWriter out = response.getWriter();
        /*
        int number1 = Integer.parseInt(request.getParameter("num1"));
        int number2 = Integer.parseInt(request.getParameter("num2"));
        int number3 = Integer.parseInt(request.getParameter("num3"));
        int number4 = Integer.parseInt(request.getParameter("num4"));
        int number5 = Integer.parseInt(request.getParameter("num5"));
        float number = (number1 + number2 + number3 + number4 + number5) / 5;
        */
        Enumeration<String> names = request.getParameterNames();
        //int count = Array.getLength(names);
        out.println("<html>");
        out.println("<head><title>Post</title></head>");
        out.println("<body>");
        out.println("<p> Formularz </p>");
        int count = 0;
        String curr_added = "Currently added: ";
        String form_string = "";
        while(names.hasMoreElements()){
            String name = names.nextElement();
            String val = request.getParameter(name);
            form_string+="<input type = \"hidden\" name = \"" + name + "\" value = \"" + val + "\">";
            count++;
            curr_added += val + ", ";
        }
        out.println(curr_added.substring(0,curr_added.length()-2) + "<br>");

        out.println("<form action = \"zadPost\" method  = \"post\">");
        out.println(form_string);
        out.println("<input type = \"text\" name = \"param" + count +"\"><br>");
        out.println("<input type = \"submit\" value = \"Dodaj\">");
        out.println("</form>");

        out.println("<form action = \"zadPostServ\" method  = \"post\">");
        out.println(form_string);
        out.println("<input type = \"submit\" value = \"Sortuj\">");
        out.println("</form>");

        out.println("</body>");
        out.println("</html>");
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("windows-1250");
        PrintWriter out = response.getWriter();
        out.println("<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Get</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<p>Formularz</p>" +
                "<form action  = \"zadPost\" method  = \"post\">\n" +
                "    <input type = \"text\" name = \"param0\"><br>" +
                "    <input type = \"submit\" value = \"Dodaj\">\n" +
                "</form>\n" +
                "</body>\n" +
                "</html>");
    }
}
