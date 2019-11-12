package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexao {
    public static Connection getConnection(){
        try{
            return DriverManager.getConnection("jdbc:mysql://localhost/trabalho_primeiro_bimestre","root","");
        }
        catch(SQLException e){
            System.out.println("Problemas na conexao com o banco de dados."+e);
        }
		return null;
    } 
    
}