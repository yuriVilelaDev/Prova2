package controller;
import model.insert;
import dto.dto;

public class processo implements Runnable{
	
	ImportCsv leia = new ImportCsv();
	insert insert = new insert();
	ExportXls xls = new ExportXls();
	
	
	public String cadastraEndereco(dto dto) {
		
		new Thread(() ->leia.cadastraDadosArquivo(dto)).start();
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
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
