package controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import dto.dto;
import model.insert;
import model.FunctionMongoDB;


public class ImportCsv {

	  public void cadastraDadosArquivoMysql(dto arquivo) {
	    
		BufferedReader br = null;
	       
	    try {

	        br = new BufferedReader(new FileReader("C:/Users/CEMIG01/Prova2/trabalhoPrimeiroBimestre/baseDados/"+arquivo.getArquivo()));
	        dto dto = new dto();
	        insert insert = new insert();
	        String texto;
	        while ((texto = br.readLine()) != null) 
	        { 
	        	String endereco[] = texto.split(",");
	        	
	        	dto.setCep(endereco[0]); 
	        	dto.setNum(endereco[1]);
	        	dto.setRua(endereco[2]); 
	           	dto.setBairro(endereco[3]);
	        	dto.setEstado(endereco[4]);
	        	insert.insertDados(dto);
	        }

	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	        if (br != null) {
	            try {
	                br.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	  }
	  public void cadastraDadosArquivoMongoDb(dto arquivo) {
		 
		  
			BufferedReader br = null;
		       
		    try {

		        br = new BufferedReader(new FileReader("C:/Users/CEMIG01/Prova2/trabalhoPrimeiroBimestre/baseDados/"+arquivo.getArquivo()));
		        dto dto = new dto();
		        
		        String texto;
		        while ((texto = br.readLine()) != null) 
		        { 
		        	String endereco[] = texto.split(",");
		      	  FunctionMongoDB mongo = new FunctionMongoDB();
		        	dto.setCep(endereco[0]); 
		        	dto.setNum(endereco[1]);
		        	dto.setRua(endereco[2]); 
		           	dto.setBairro(endereco[3]);
		        	dto.setEstado(endereco[4]);
		        	mongo.cadastrar(dto);
		        }

		    } catch (FileNotFoundException e) {
		        e.printStackTrace();
		    } catch (IOException e) {
		        e.printStackTrace();
		    } finally {
		        if (br != null) {
		            try {
		                br.close();
		            } catch (IOException e) {
		                e.printStackTrace();
		            }
		        }
		    }
		  }

}