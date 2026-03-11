import java.sql.*;

public class DBTest {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:sakila_master.db");
            Statement stmt = conn.createStatement();
            String sql = "select title, description, release_year from film";
            ResultSet rs = stmt.executeQuery(sql);

            ResultSetMetaData metaData = rs.getMetaData();
            int cols = metaData.getColumnCount();

            for (int i=1; i <= cols; i++) {
                System.out.print(metaData.getColumnLabel(i));
                System.out.print("\t");
            }
            System.out.println();

            while (rs.next()) {
                for (int i=1; i <= cols; i++) {
                    System.out.print(rs.getString(i));
                    System.out.print("\t");
                }
                System.out.println();
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
