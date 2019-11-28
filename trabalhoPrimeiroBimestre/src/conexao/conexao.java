package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexao {
    public static Connection getConnection(){
        try{
            return DriverManager.getConnection("jdbc:mysql:dayjob-230913:southamerica-east1:faculdade","root","");
        }
        catch(SQLException e){
            System.out.println("Problemas na conexao com o banco de dados."+e);
        }
		return null;
    } 
    
}