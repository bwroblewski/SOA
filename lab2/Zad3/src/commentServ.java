import javafx.util.Pair;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

@WebServlet(name = "commentServ")
public class commentServ extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        if (username == null) username = (String) request.getSession(false).getAttribute("username");
        else request.getSession(true).setAttribute("username", username);
        String comment = request.getParameter("comment");
        out.println(username);
        out.println(comment);
        /*
        if (comment != null){
            Cookie cookie = new Cookie(username, comment);
            cookie.setMaxAge(100000000);
            response.addCookie(cookie);
            request.setAttribute("comment", null);
        }
        */

        List<Vector<String>> comments = (List<Vector<String>>) request.getSession(false).getAttribute("comments");

        if (comment != null ) {
            if(comments == null) comments = new ArrayList<>();
            username = (String) request.getSession(false).getAttribute("username");
            String finalUsername = username;
            Vector<String> v = new Vector<String>(){{
                add(finalUsername);
                add(comment);
            }};
            out.println(username);
            //pair = new Pair(username, comment);
            comments.add(v);
        }
        request.getSession(true).setAttribute("comments",comments);

        UserBase base = new UserBase();
        Vector<String> currentUser = base.getUser(username);
        out.println("<h2>Witaj " + currentUser.get(0) + "</h2>");

        RequestDispatcher rd=request.getRequestDispatcher("form.html");
        rd.include(request,response);

        if(comments == null) out.print(comments);

        if(comments != null){
            for(Vector<String> v: comments){
                Vector<String> user = base.getUser(v.get(0));
                String userComment = v.get(1);
                out.print("<p>-----------------</p>");
                out.print("<p>" + user.get(0) + " " + user.get(1) + "(" + user.get(2) + ") says:" + "</p>");
                out.print("<p>" + userComment + "</p>");
            }
        }
        /*
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie: cookies){
            Vector<String> user = base.getUser(cookie.getName());
            String userComment = cookie.getValue();
            out.print("<p>-----------------</p>");
            out.print("<p>" + user.get(0) + " " + user.get(1) + "(" + user.get(2) + ") says:" + "</p>");
            out.print("<p>" + comment + "</p>");
        }
        */


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
