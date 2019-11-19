package conexao;

import dto.dto;
import model.FunctionMongoDB;



public class ConnectMongo {
	public static void main( String args[] ){
		dto dto = new dto();
		FunctionMongoDB test = new FunctionMongoDB();
		test.cadastrar(dto);
		
		}
}
