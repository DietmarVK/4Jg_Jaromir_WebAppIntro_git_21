package at.kaindorf.webintro;

import at.kaindorf.webintro.beans.GuestBookEntry;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {

    private List<GuestBookEntry> entries = new ArrayList<>();

    // method for initialisation - only called once (at the beginning)
    public void init() {}

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Get Request to our Servlet</h1>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nickname = req.getParameter("nickname");
        if(nickname == null || nickname.trim().equals("")) {
            nickname = "unknown";
        }
        String email = req.getParameter("email");
        if(email == null || email.trim().equals("")) {
            email = "unknown";
        }
        String comment = req.getParameter("comment");
        if(comment == null || comment.trim().equals("")) {
            comment = "unknown";
        }

        String[] selectedSeasons = req.getParameterValues("season");


        GuestBookEntry entry = new GuestBookEntry(nickname, email, comment);
        entries.add(entry);


        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        req.getRequestDispatcher("index.html").include(req, resp);
        for (GuestBookEntry entry1 : entries) {
            out.println(entry1.toHtmlString());
        }
    }

    public void destroy() {
    }
}