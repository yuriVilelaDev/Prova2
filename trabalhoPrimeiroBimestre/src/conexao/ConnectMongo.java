package conexao;

import dto.dto;
import model.FunctionMongoDB;
import controller.*;



public class ConnectMongo {
	public static void main( String args[] ){
		dto dto = new dto();
		ImportCsv test = new ImportCsv();
		dto.setArquivo("sp.cepaberto_parte_1.csv");
		test.cadastraDadosArquivoMongoDb(dto);
		//dto.setCep("01029000");
		//test.consultar(dto);
		}
}
