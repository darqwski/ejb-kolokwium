package ejb.kolokwium;

import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "TemplateServlet", value = "/template")
public class TemplateServlet extends HttpServlet {
    @EJB
    IBeanInterface iBean;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        PrintWriter out;
        try {
            out = response.getWriter();
        } catch (Exception exception){
            exception.printStackTrace();
            return;
        }

        out.println(iBean.someMethodWhichMustBeImplemented());

    }
}
