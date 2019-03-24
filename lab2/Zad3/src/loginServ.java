import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

@WebServlet(name = "loginServ")
public class loginServ extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String log = request.getParameter("username");
        String pass = request.getParameter("password");
        RequestDispatcher rd=request.getRequestDispatcher("login.html");
        rd.include(request,response);

        //UserBase base = new UserBase();
        if(log.equals("")){
            out.print("<p>Podaj login<p>");
            if(pass.equals("")) out.print("<p>Podaj haslo<p>");
        }
        else{
            if(pass.equals("")) out.print("<p>Podaj haslo<p>");
            else{
                Vector<String> user = new UserBase().getUser(log);
                if (user == null){
                    out.print("<p>Bledne dane logowania</p>");
                }
                else{
                    if (log.equals(user.get(2))) {
                        if (pass.equals(user.get(3))) {
                            request.getRequestDispatcher("/comment").forward(request,response);
                        } else {
                            out.print("<p>Bledne haslo</p>");
                        }
                }
                /*
                boolean found = false;
                for (Vector<String> user : data) {
                    if (log.equals(user.get(2))) {
                        if (pass.equals(user.get(3))) {
                            request.getRequestDispatcher("/comment").forward(request,response);
                        } else {
                            found = true;
                        }
                    }
                }
                if (found) out.print("<p>Bledne haslo</p>");
                else out.print("<p>Bledne dane logowania</p>");
                */
            }
        }
            /*
        if(log.equals(data.get(2)) && log.equals(data.get(2))){

        }
        else{
            if(log.equals("")){
                out.print("<p>Podaj login<p>");
            }
            if(pass.equals("")){
                out.print("<p>Podaj haslo<p>");
            }
            if((!log.equals(data.get(2)) && !log.equals(data.get(2))) && !log.equals("") && !pass.equals("")){
                out.print("<p>Bledne dane logowania<p>");
            }

        */
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        RequestDispatcher rd=request.getRequestDispatcher("login.html");
        rd.include(request,response);
    }
}
