package at.kaindorf.webintro;

import at.kaindorf.webintro.beans.GuestBookEntry;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "TestServlet", value = "/TestServlet")
public class TestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        writer.println("worked");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain");
        PrintWriter writer = response.getWriter();
        String name = request.getParameter("lastname");
        System.out.println("name: " + name);
        // writer.println("request from " + name + " received");
        GuestBookEntry entry1 = new GuestBookEntry("james", "bond@mi6.uk", "Martini");
        GuestBookEntry entry2 = new GuestBookEntry("Q", "q@mi6.uk", "Take care");
        GuestBookEntry[] entries = {entry1, entry2};
        ObjectMapper mapper = new ObjectMapper();
        List<GuestBookEntry> entryList = Arrays.stream(entries).collect(Collectors.toList());
        String[] jsonStrArray = entryList.stream()
                                         .map( e -> e.getNickname() )
                                         .toArray(String[]::new);
        String jsonObjectString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(entries);
        System.out.println(jsonObjectString);
        writer.println(jsonObjectString);
        writer.flush();
        writer.close();
    }
}