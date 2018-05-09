package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import com.mysql.jdbc.Driver;

public class conexion {

    String Dominio,User,Pass;

    conexion con;
    Connection conectar;

    public Connection conexion(){

        String url = "jdbc:mysql://localhost:3306/hamburguesas";
        String user = "root";
        String pass = "root";
        try
        {
            conectar = DriverManager.getConnection(url, user,pass);
            System.out.println("Usted está conectado");
            return conectar;
        }
        catch ( SQLException e)
        {

            System.out.println(e.getMessage());
            System.out.println("No logró conectar");
            conectar= null;

        }
        return null;
    }
    public void cerrarConexion(){

        try
        {
            conectar.close();
        }catch (SQLException e)
        {

        }
    }


    /*-----------------------------------------METODO GLOBAL PARA INSERTAR--------------------------------------------------------*/

    public boolean consulta_insertar(String consulta){
        try{
            String query1=consulta;
            PreparedStatement s = this.conexion().prepareStatement(query1);
            s.executeUpdate(query1);
            System.out.println("Insertando ...");
            s.close();
            return true;
        }
        catch(SQLException e){
            //JOptionPane.showMessageDialog(null,e.getMessage());
            System.out.println(e.getMessage());
            return false;
        }
    }

    /*----------------------------------------METODO GLOBAL PARA MODIFICAR-------------------------------------------------------------------*/

    public int consulta_modificar(String consulta){
        try
        {
            String query1=consulta;
            PreparedStatement s = this.conexion().prepareStatement(query1);
            s.executeUpdate(query1);
            System.out.println("Modificando ...");
            s.close();
            return 1;
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public ResultSet mostrarSql(String query){

        try
        {
            PreparedStatement us = this.conexion().prepareStatement(query);
            ResultSet res = us.executeQuery();
            //us.close();
            return res;
        }
        catch  (SQLException e)
        {
            return null;
        }

    }

    public String consultaLogin(String valor){
        String sql= "Select * from users where name='"+ valor +"';";
        return sql;
    }


}
