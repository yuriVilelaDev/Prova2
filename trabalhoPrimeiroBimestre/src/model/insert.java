package model;


import conexao.conexao;
import dto.dto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Statement;



public class insert {
	
	Connection con = conexao.getConnection();
	
	public synchronized void insertDados(dto dto) {
		try {	
						
			String sql="insert into catalagoEndereco(cep, rua,bairro,numero,estado) values(?,?,?,?,?)";
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
		    stmt.setString(1, dto.getCep());  
	        stmt.setString(2, dto.getRua());  
	        stmt.setString(3, dto.getBairro());  
	        stmt.setString(4, dto.getNum());  
	        stmt.setString(5, dto.getEstado());  
            stmt.execute();  
           	           
		}catch(SQLException el) {
			el.printStackTrace();
			}
		
		}
	public synchronized void BuscaEnderecoCep(dto dto) {
		 try
		    {	      
			 	Class.forName("com.mysql.jdbc.Driver").newInstance();
	            Connection conn = DriverManager.getConnection("jdbc:mysql:dayjob-230913:southamerica-east1:faculdade", "root", "");
	            String query = "SELECT * FROM catalagoEndereco where cep = "+dto.getCep();
		        Statement st = (Statement) conn.createStatement();
		        ResultSet rs = st.executeQuery(query);
		        int id = rs.getInt("cep");
		        String firstName = rs.getString("rua");
		        String lastName = rs.getString("numero");
		   
		        JOptionPane.showMessageDialog(null,"dados"+ id+firstName+lastName);   
		        st.close();
		    }
		    catch (Exception e)
		    {
		    	JOptionPane.showMessageDialog(null,"Nenhum endereço encontrado com o seguinte CEP: "+dto.getCep());
		      System.err.println(e.getMessage());
		    }
		  }
	
/*	public synchronized void BuscaEnderecoBairroRua(dto dto) {
		 try
		    {
		      // create our mysql database connection
		      
		      Class.forName("com.mysql.jdbc.Driver").newInstance();
	           Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/trabalho_primeiro_bimestre", "root", "");
	          
		       String query = "SELECT COUNT( *) FROM catalagoEndereco rua  = "+dto.getRua() +"OR numero ="+dto.getRua();

		      // create the java statement
		      Statement st = (Statement) conn.createStatement();
		      
		      // execute the query, and get a java resultset
		      ResultSet rs = st.executeQuery(query);
		      
		      // iterate through the java resultset
		      while (rs.next())
		      {
		        int id = rs.getInt("cep");
		        String firstName = rs.getString("rua");
		        String lastName = rs.getString("numero");
		   
		        // print the results
		        JOptionPane.showMessageDialog(null, id+firstName+lastName);
		      }
		      st.close();
		    }
		    catch (Exception e)
		    {
		    	JOptionPane.showMessageDialog(null,"Got an exception! ");
		      System.err.println(e.getMessage());
		    }
		  }*/
		}

