package model;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import dto.dto;


public class FunctionMongoDB {
	MongoClientURI uri = new MongoClientURI(
		    "mongodb://yuri:20berv18@facu-shard-00-00-tym0q.gcp.mongodb.net:27017,facu-shard-00-01-tym0q.gcp.mongodb.net:27017,facu-shard-00-02-tym0q.gcp.mongodb.net:27017/test?ssl=true&replicaSet=facu-shard-0&authSource=admin&retryWrites=true&w=majority");

			MongoClient mongoClient = new MongoClient(uri);
			MongoDatabase database = mongoClient.getDatabase("prova2");
			
	public void cadastrar(dto dto) {
		try {
				MongoCollection<Document> collection = database.getCollection("endereco");

				Document doc = new Document();
				doc.put("Rua", "sao tomas de aquino 4");
				doc.put("Cep", "casado");
				doc.put("Bairro", "sao tomas de aquino 4");
				doc.put("Estado", "sao tomas de aquino 4");

				collection.insertOne(doc);

			}catch (Exception e) {
					// TODO: handle exception
					System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			}
		}
	
}

