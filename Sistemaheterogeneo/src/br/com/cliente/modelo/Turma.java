package br.com.cliente.modelo;

import java.util.ArrayList;
import java.util.List;

public class Turma {
	private int id;
	private String curso;
	private int ano;
	private List<Aluno> alunos;

	public Turma() {
		alunos = new ArrayList<>();
	}

	public Turma(int id, String curso, int ano, List<Aluno> alunos) {
		this.id = id;
		this.curso = curso;
		this.ano = ano;
		this.alunos = alunos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
	
	public void adicionaAluno(Aluno aluno) {
		this.alunos.add(aluno);
	}

	@Override
	public String toString() {
		return String.format("Id: %s, curso: %s, ano: %s, alunos: %s", id, curso, ano, alunos);
	}
	
	
}
