package onlineexamination;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Prasant
 */
public class DBConnection {
    
    public Connection connection() {
        Connection con = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/online_examination", "root", "2507");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "There is a problem. Please Try Again!\n" + ex);
        }
        
        return con;
    }
}
