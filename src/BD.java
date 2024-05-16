import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BD {
    private Connection con;
    
public Connection getConnection() {
    try {
       
        String myBD = "jdbc:mysql://localhost:3306/maestros";
        
        con = DriverManager.getConnection(myBD, "root", "");
        
        if (con != null) {
            System.out.println("Conexión establecida correctamente.");
        } else {
            System.out.println("No se pudo establecer la conexión.");
        }
        return con;
    } catch (SQLException e) {
        System.out.println("Error al conectar a la base de datos:");
        e.printStackTrace();
        return null;
    }
}

    public void cerrarConexion() {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
                System.out.println("Conexión cerrada");
            }
        } catch (SQLException e) {
               System.out.println("Error al cerrar la conexión:");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        BD bd = new BD(); 
        Connection conn = bd.getConnection(); 
        bd.cerrarConexion();
    }
}
