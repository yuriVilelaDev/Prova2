package conexao;

import dto.dto;
import model.FunctionMongoDB;
import controller.*;



public class ConnectMongo {
	public static void main( String args[] ){
		dto dto = new dto();
		FunctionMongoDB test = new FunctionMongoDB();
		dto.setArquivo("sp.cepaberto_parte_1.csv");
		//test.cadastraDadosArquivoMongoDb(dto);
		
		test.consultar(dto);
		}
}
