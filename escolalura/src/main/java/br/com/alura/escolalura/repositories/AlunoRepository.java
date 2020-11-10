package br.com.alura.escolalura.repositories;

import org.springframework.stereotype.Repository;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import br.com.alura.escolalura.models.Aluno;

@Repository
public class AlunoRepository {

	public void salvar(Aluno aluno) {
		MongoClient cliente = new MongoClient();
		MongoDatabase bancoDeDados = cliente.getDatabase("test");
		MongoCollection<Aluno> alunos = bancoDeDados.getCollection("alunos", Aluno.class);
		alunos.insertOne(aluno);
		cliente.close();
	}
}
