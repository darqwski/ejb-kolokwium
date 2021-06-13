package ejb.kolokwium;

import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.sql.ConnectionEvent;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(name = "TemplateServlet", value = "/template")
public class TemplateServlet extends HttpServlet {
    @EJB
    IBeanInterface iBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        PrintWriter out;
        ResultSet rs;

        try {
            out = response.getWriter();
        } catch (Exception exception){
            exception.printStackTrace();
            return;
        }
        try {
            InitialContext ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("MariaDBResource");
            Connection conn = ds.getConnection();
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM first_last_name");
        } catch (Exception exception){
            exception.printStackTrace();
            return;
        }
        //Ten licznik jest tylko tak proforma
        int recordCounter = 0;

        //Tak się odczytuje
        while(true) {
            try {
                if (!rs.next() || recordCounter == 10) {
                    break;
                }
                out.println("<p>"+rs.getString("first") + " "+rs.getString("second")+ " " +rs.getString("third")+"</p>");
                recordCounter++;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                break;
            }

        }

        out.println("Wykonanie zwykłego beana: "+iBean.someMethodWhichMustBeImplemented());
        out.println("Wykonanie zwykłego ale z parametrem: "+iBean.anotherButWithParam());

    }
}
