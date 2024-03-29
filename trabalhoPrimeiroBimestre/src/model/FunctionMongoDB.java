package model;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.*;
import org.bson.Document;
import static com.mongodb.client.model.Filters.*;

import javax.swing.JOptionPane;

import org.bson.types.ObjectId;
import dto.dto;


public class FunctionMongoDB {
	MongoClientURI uri = new MongoClientURI(
	    "mongodb://yuri:20berv18@facu-shard-00-00-tym0q.gcp.mongodb.net:27017,facu-shard-00-01-tym0q.gcp.mongodb.net:27017,facu-shard-00-02-tym0q.gcp.mongodb.net:27017/test?ssl=true&replicaSet=facu-shard-0&authSource=admin&retryWrites=true&w=majority");

			MongoClient mongoClient = new MongoClient(uri);
			MongoDatabase database = mongoClient.getDatabase("prova2");
			MongoCollection<Document> collection = database.getCollection("endereco");

			Document doc = new Document();
			
	public void cadastrar(dto dto) {
		try {

				
			doc.put("Rua", dto.getRua());
				doc.put("Cep", dto.getCep());
			doc.put("Bairro",dto.getBairro());
			doc.put("Estado", dto.getEstado());

				collection.insertOne(doc);

			}catch (Exception e) {
					// TODO: handle exception
					System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			}
		}
	/***
	 * @return string
	 * @param dto
	 */
	public void consultarCep(dto dto) {
	
		MongoCursor<Document> cursor = collection.
				find(eq("Cep",dto.getCep())).iterator();
		try {
			while (cursor.hasNext()){
				Document atual = cursor.next();
				
				JOptionPane.showMessageDialog(null, atual.get("Rua")+"\n"+atual.get("Cep")+"\n"+atual.get("Bairro")+"/n"+atual.get("Estado"));
			}
		}finally {
			cursor.close();
		}
	}
	public void consultarRua(dto dto) {
		
		MongoCursor<Document> cursor = collection.
				find(eq("Rua",dto.getRua())).iterator();
		try {
			while (cursor.hasNext()){
				Document atual = cursor.next();
				
				JOptionPane.showMessageDialog(null,"Rua: "+ atual.get("Rua")+"\n CEP: "+atual.get("Cep")+"\n Bairro: "+atual.get("Bairro")+"/n Estado: "+atual.get("Estado"));
			}
		}finally {
			cursor.close();
		}
	}
	
	
}

