import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.*;

@WebServlet(name = "zadPostServ")
public class zadPostServ extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("windows-1250");
        PrintWriter out = response.getWriter();
        Enumeration<String> names = request.getParameterNames();
        out.println("<html>");
        out.println("<head><title>Post</title></head>");
        out.println("<body>");

        boolean isNum = true;
        List<Number> numList = new ArrayList<Number>();
        String elements = "Elements sorted: ";

        while(names.hasMoreElements()){
            String name = names.nextElement();
            String val = request.getParameter(name);
            if(val.matches("[0-9]+")){
                numList.add(Integer.parseInt(val));
            }
            else {
                if(val.matches("[0-9]+.[0-9]+")){
                    numList.add(Float.parseFloat(val));
                }
                else {
                    isNum = false;
                    break;
                }
            }
        }

        if(isNum){
            Collections.sort(numList,new Comparator<Number>() {
                @Override
                public int compare(Number o1, Number o2) {
                    Double d1 = (o1 == null) ? Double.POSITIVE_INFINITY : o1.doubleValue();
                    Double d2 = (o2 == null) ? Double.POSITIVE_INFINITY : o2.doubleValue();
                    return  d1.compareTo(d2);
                }
            });
            for (Number number: numList){
                elements+= number + ", ";
            }
            out.println(elements.substring(0,elements.length()-2) + "<br>");
        }
        else {
            out.println("<p> Elements other than numbers </p>");
        }
        out.println("</body>");
        out.println("</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
