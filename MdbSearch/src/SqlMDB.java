/**
 * 
 */
import java.sql.*;

/**
 * @author User
 *
 */
public class SqlMDB {

	/**
	 * @param args
	 */
    public static void main(String[] args)
    {
        try
        {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            String database = 
              "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=C:\\Users\\User\\Desktop\\Bayfield Smoke n Gift\\pos.mdb;";
            Connection conn = DriverManager.getConnection(database, "", "");
            Statement s = conn.createStatement();

            String tableName = "ITEMS";
            // Fetch table
            String selTable = "SELECT * FROM " + tableName; // + " WHERE UPC='648436300433'";
            s.execute(selTable);
            ResultSet rs = s.getResultSet();
            int i = 0;
            while((rs!=null) && (rs.next()))
            {
            	i++;
                System.out.println("#" + i + " - " + rs.getString(1) + " : " + rs.getString(2)
                		 + " : " + rs.getString(3)  + " : " + rs.getString(4) + " : " + rs.findColumn("UPCDES")  + " : "  + rs.getRow());
            }
            
            
            
/*            // create a table
            String tableName = "ITEMS2" + String.valueOf((int)(Math.random() * 1000.0));
            String createTable = "CREATE TABLE " + tableName + 
                                 " (id Integer, name Text(32))";
            s.execute(createTable); 
            
            // enter value into table
            for(int i=0; i<25; i++)
            {
              String addRow = "INSERT INTO " + tableName + " VALUES ( " + 
                     String.valueOf((int) (Math.random() * 32767)) + ", 'Text Value " + 
                     String.valueOf(Math.random()) + "')";
              s.execute(addRow);
            }
            
            // Fetch table
            String selTable = "SELECT * FROM " + tableName;
            s.execute(selTable);
            ResultSet rs = s.getResultSet();
            int i = 0;
            while((rs!=null) && (rs.next()))
            {
            	i++;
                System.out.println("#" + i + " - " + rs.getString(1) + " : " + rs.getString(2));
            }
            
            // drop the table
            String dropTable = "DROP TABLE " + tableName;
            s.execute(dropTable);
*/            
            // close and cleanup
            s.close();
            conn.close();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }

}
