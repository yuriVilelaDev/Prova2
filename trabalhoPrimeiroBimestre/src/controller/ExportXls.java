package controller;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JOptionPane;

import java.sql.ResultSet;

public class ExportXls {
	
	public static void csvExportMysql()  {
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
	
	public void exportCsvMogo() {
		String db = "prova2";
        String col = "endereco";
        String Host = "mongodb://yuri:20berv18@facu-shard-00-00-tym0q.gcp.mongodb.net:27017,facu-shard-00-01-tym0q.gcp.mongodb.net:27017,facu-shard-00-02-tym0q.gcp.mongodb.net:27017/test?ssl=true&replicaSet=facu-shard-0&authSource=admin&retryWrites=true&w=majority\");\r\n" ;
        String Port = "27017";
        String fileName = "D:/files/sample.csv";

        String command = "C:\\Program Files\\MongoDB\\Server\\3.4\\bin\\mongoexport.exe --host " + Host + " --port " + Port + " --db " + db + " --collection " + col + " --type=csv --fields _id,email,createdAt, --out " + fileName + "";

        try {
            System.out.println(command);
            Process process = Runtime.getRuntime().exec(command);
            int waitFor = process.waitFor();
            System.out.println("waitFor:: " + waitFor);
            BufferedReader success = new BufferedReader(new InputStreamReader(process.getInputStream()));
            BufferedReader error = new BufferedReader(new InputStreamReader(process.getErrorStream()));

            String s = "";
            while ((s = success.readLine()) != null) {
                System.out.println(s);
            }

            while ((s = error.readLine()) != null) {
                System.out.println("Std ERROR : " + s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
		
	}

