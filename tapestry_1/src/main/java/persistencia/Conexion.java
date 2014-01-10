/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.*;

/**
 *
 * @author Mauricio
 */
public class Conexion 
{
    // ATRIBUTO PARA MANEJAR LA CONEXION
    private Connection conexion;   
    
    /**
     * @return the conexion
     */
    public Connection getConexion() {
        return conexion;
    }
    
    public Conexion()
    {
        this.conexion = null;
        try
        {
            // CARGAR DRIVER
            Class.forName("com.mysql.jdbc.Driver");
            //Class.forName("org.gjt.mm.mysql.Driver");
            //System.out.println("Driver cargado correctamente.");
            
            // OBTENER CONEXION
            // A TRAVES DEL METODO ESTATICO getConnection del DriverManager
            String URI = "jdbc:mysql://127.0.0.1:3306/san_gabriel";
            String USER = "root";
            String PSW = "12345";
            
            Connection conex = DriverManager.getConnection(URI, USER, PSW);
            //System.out.println("Conexión establecida satisfactoriamente." + con.getCatalog());
            this.conexion = conex;
            //conex = null;
        }
        catch( ClassNotFoundException exCNF )
        {
           // throw new ClassNotFoundException("ERROR: Al cargar el driver: " + exCNF.getMessage() );
            System.out.println(exCNF);
        }
        catch( SQLException exSQL)
        {
            //throw new SQLException("ERROR: Al conectarse a la Base de Datos: " + exSQL.getMessage() );
            System.out.println(exSQL);
        }
    }

    public void cerrarConexion()throws SQLException
    {
        try
        {
            //if( this.conexion != null )
            //{
                this.getConexion().close();
                //System.out.println("Conexión cerrada correctamente.");
            //}
        }
        catch( SQLException exSQL )
        {
            throw new SQLException("ERROR: No se pudo liberar la conexion " + exSQL);
        }
    }     
}
