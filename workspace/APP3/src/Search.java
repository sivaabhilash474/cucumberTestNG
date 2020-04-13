

import java.io.IOException;
import javax.servlet.ServletException;
import java.sql.ResultSetMetaData;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.io.PrintWriter;
import java.sql.DriverManager;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

// 
// Decompiled by Procyon v0.5.36
// 

@WebServlet({ "/Search" })
public class Search extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        final PrintWriter out = response.getWriter();
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            final Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "FE4USER", "Blizarddy_20");
            final PreparedStatement ps = con.prepareStatement("select * from registeruser");
            out.print("<table width=50% border=1>");
            out.print("<caption>Result:</caption>");
            final ResultSet rs = ps.executeQuery();
            final ResultSetMetaData rsmd = rs.getMetaData();
            final int total = rsmd.getColumnCount();
            out.print("<tr>");
            for (int i = 1; i <= total; ++i) {
                out.print("<th>" + rsmd.getColumnName(i) + "</th>");
            }
            out.print("</tr>");
            while (rs.next()) {
                out.print("<tr><td>" + rs.getString(1) + "</td><td>" + rs.getString(2) + "</td><td>" + rs.getString(3) + "</td><td>" + rs.getString(4) + "</td></tr>");
            }
            out.print("</table>");
        }
        catch (Exception e2) {
            System.out.println(e2);
            return;
        }
        finally {
            out.close();
        }
        out.close();
    }
}

