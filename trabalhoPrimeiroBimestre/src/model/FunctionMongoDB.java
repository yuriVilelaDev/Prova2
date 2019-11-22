package model;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;

import org.bson.Document;
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
	public String consultar(dto dto) {
		String mensagem;
		try {
			MongoCursor<Document> cursor = collection.find().iterator();
			while (cursor.hasNext()) {
				 System.out.println(cursor.next());
				}
		}catch (Exception e) {
			// TODO: handle exception
			mensagem = e.getClass().getName() + ": " + e.getMessage();
		}
		return "";
	}
	
	
}

