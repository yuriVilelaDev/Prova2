package controller;

import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JOptionPane;

import java.sql.ResultSet;

public class ExportXls {
	
	public static void csvExport()  {
		String filename ="C:\\Users\\yuris\\eclipse-workspace\\trabalhoPrimeiroBimestre\\Export\\test.csv";
        try {
            FileWriter fw = new FileWriter(filename);
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/trabalho_primeiro_bimestre", "root", "");
            String query = "select * from catalagoEndereco";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                fw.append(rs.getString(1));
                fw.append(',');
                fw.append(rs.getString(2));
                fw.append(',');
                fw.append(rs.getString(3));
                fw.append('\n');
               }
            fw.flush();
            fw.close();
            conn.close();
            JOptionPane.showMessageDialog(null,"CSV File is created successfully.");
        } catch (Exception e) {
        	JOptionPane.showMessageDialog(null,"erro");
        	e.printStackTrace();
        }
    }
		
	}

