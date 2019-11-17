package conexao;

import com.mongodb.MongoClient;
import com.mongodb.client.*;
import org.bson.Document;
import static com.mongodb.client.model.Filters.*;
import org.bson.types.ObjectId;

public class ConnectMongo {

	private MongoClient mongoClient;
	private MongoDatabase database;
	private MongoCollection<Document> collection;
	
	public ConexaoMongoDB() {
		mongoClient = new MongoClient("localhost",27017);
		database = mongoClient.getDatabase("");
		cllection = database.getCollection("enderecos");
	}
	
}
