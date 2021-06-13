<%@ page import="java.sql.*, javax.sql.*, java.io.*, javax.naming.*" %>
<html>
<head><title>Hello world from JSP</title></head>
<body>
<%
    InitialContext ctx;
    DataSource ds;
    Connection conn;
    Statement stmt;
    ResultSet rs;

    try {
        ctx = new InitialContext();
        ds = (DataSource) ctx.lookup("MariaDBResource");
        conn = ds.getConnection();
        stmt = conn.createStatement();
        rs = stmt.executeQuery("SELECT * FROM first_last_name");

        while(rs.next()) {
%>
<p>Name: <%= rs.getString("first") %> <%= rs.getString("second") %> <%= rs.getString("third") %></p>
<%
    }
}
catch (SQLException se) {
%>
<%= se.getMessage() %>
<%
}
catch (NamingException ne) {
%>
<%= ne.getMessage() %>
<%
    }
%>
</body>
</html>