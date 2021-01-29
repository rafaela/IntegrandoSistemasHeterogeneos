package br.com.cliente.dados;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import br.com.cliente.modelo.Aluno;
import br.com.cliente.modelo.Turma;

public class Dados {
	@SuppressWarnings("unchecked")
	public static JSONArray parseTurmatoJson(ArrayList<Turma> turmas) {
		JSONArray jTurmas = new JSONArray();
		JSONObject turmaJson;
		for (Turma turma : turmas) {
			turmaJson = new JSONObject();
			turmaJson.put("ID", String.valueOf(turma.getId()));
			turmaJson.put("Curso", turma.getCurso());
			turmaJson.put("Ano", String.valueOf(turma.getAno()));
			JSONArray alunosJs = converteDadosAlunos((ArrayList<Aluno>) turma.getAlunos());
			turmaJson.put("Alunos", alunosJs);
			jTurmas.add(turmaJson);
		}	
		return jTurmas;
	}

	@SuppressWarnings("unchecked")
	private static JSONArray converteDadosAlunos(ArrayList<Aluno> alunos) {
		JSONArray alunosJson = new JSONArray();
		JSONObject objAluno;
		for (Aluno aluno : alunos) {
			objAluno = new JSONObject();
			objAluno.put("ID", aluno.getId());
			objAluno.put("Nome", aluno.getNome());
			objAluno.put("Matriculado", aluno.isMatriculado());
			alunosJson.add(objAluno);
		}
		
		return alunosJson;
	}
}
