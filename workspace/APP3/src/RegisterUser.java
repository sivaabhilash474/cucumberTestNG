import java.io.IOException;
import javax.servlet.ServletException;
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

@WebServlet({ "/RegisterUser" })
public class RegisterUser extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        final PrintWriter out = response.getWriter();
        final String n = request.getParameter("name");
        final String p = request.getParameter("password");
        final String e = request.getParameter("email");
        final String c = request.getParameter("country");
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            final Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "FE4USER", "Blizarddy_20");
            final PreparedStatement ps = con.prepareStatement("insert into registeruser values(?,?,?,?)");
            ps.setString(1, n);
            ps.setString(2, p);
            ps.setString(3, e);
            ps.setString(4, c);
            final int i = ps.executeUpdate();
            if (i > 0) {
                out.print("You are successfully registered...");
            }
        }
        catch (Exception e2) {
            System.out.println(e2);
        }
        out.close();
    }
}