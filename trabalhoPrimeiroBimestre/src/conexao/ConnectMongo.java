package conexao;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

public class ConnectMongo {
	public static void main( String args[] ){
		try {

MongoClientURI uri = new MongoClientURI(
    "mongodb://yuri:20berv18@facu-shard-00-00-tym0q.gcp.mongodb.net:27017,facu-shard-00-01-tym0q.gcp.mongodb.net:27017,facu-shard-00-02-tym0q.gcp.mongodb.net:27017/test?ssl=true&replicaSet=facu-shard-0&authSource=admin&retryWrites=true&w=majority");

MongoClient mongoClient = new MongoClient(uri);
MongoDatabase database = mongoClient.getDatabase("prova2");

MongoCollection<Document> collection = database.getCollection("endereco");

Document doc = new Document();
doc.put("rua", "sao tomas de aquino");
doc.put("cep", "32215-240");

collection.insertOne(doc);

	}catch (Exception e) {
		// TODO: handle exception
		System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	}
		}
}
