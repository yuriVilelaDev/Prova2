package controller;
import model.*;
import dto.dto;
import controller.*;

public class processo implements Runnable{
	
	ImportCsv leia = new ImportCsv();
	insert insert = new insert();
	ExportXls xls = new ExportXls();
	FunctionMongoDB mongoDb = new FunctionMongoDB();
	
	
	public String cadastraEndereco(dto dto) {
		
		new Thread(() ->leia.cadastraDadosArquivoMysql(dto)).start();
		return "";
		
	}
	public String  buscaenderecoCep(dto dto) {
		
		 new Thread(() ->insert.BuscaEnderecoCep(dto)).start();
		 return "";
	}
	
	public String ExportBaseDados() {
		new Thread(() ->ExportXls.csvExport()).start();
		return "";
	}
	public String CadastraEnderecoMongoDB(dto dto) {
		new Thread(()->leia.cadastraDadosArquivoMongoDb(dto)).start();
		return "";
	}
	public String BuscarEnderoMongoDB(dto dto) {
		new Thread(()->mongoDb.consultar(dto)).start();
		return "";
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
