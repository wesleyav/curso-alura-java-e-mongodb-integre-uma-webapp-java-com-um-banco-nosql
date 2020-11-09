

import java.util.Arrays;
import java.util.Date;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class Principal {
	public static void main(String[] args) {
		MongoClient cliente = new MongoClient();
		MongoDatabase bancoDeDados = cliente.getDatabase("test");
		MongoCollection<Document> alunos = bancoDeDados.getCollection("alunos");
		Document aluno = alunos.find().first();
		System.out.println(aluno);
		Document novoAluno = new Document("nome", "Joao")
		.append("data_nascimento", new Date(2003, 10 ,10))
		.append("curso", new Document("nome", "Historia"))
		.append("notas", Arrays.asList(10,9,8))
		.append("habilidades", Arrays.asList(new Document().append("nome", "Ingles")
				.append("nivel", "Basico"),
				new Document()
				.append("nome", "Espanhol")
				.append("nivel", "Basico")));

		// Alterando 
		alunos.updateOne(Filters.eq("nome", "Joao"), new Document("$set", new Document("nome", "Joao Silva")));
		
		// Apagando
//		alunos.deleteOne(Filters.eq("nome", "Joao Silva"));
		
		cliente.close();
	}

}
