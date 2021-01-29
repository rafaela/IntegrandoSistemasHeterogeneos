package br.com.cliente.escola;

import static br.com.cliente.es.EntradaESaida.lerNumeroInteiro;
import static br.com.cliente.es.EntradaESaida.lerString;

import java.util.ArrayList;

import org.json.simple.JSONArray;

import br.com.cliente.dados.Dados;
import br.com.cliente.integracao.Integracao;
import br.com.cliente.modelo.Aluno;
import br.com.cliente.modelo.Turma;

public class Escola {
	
	
	public static void main(String[] args) {
		menu();

	}

	private static void menu() {
		ArrayList<Turma> turmas = new ArrayList<Turma>();
		
		menu(turmas);
		
	}

	private static void menu(ArrayList<Turma> turmas) {
		Integer opcao;
		do {
			opcao = lerNumeroInteiro("1-Cadastrar Turma\n2-Cadastrar Aluno\n3- Enviar dados\n4-Sair", "Cadastro de Turmas");
			if(opcao!=null)	
				switch (opcao) {
				case 1:
					turmas.add(cadastrarTurma());
					break;
				case 2:
					cadastrarAluno(turmas);
					break;
				case 3:
					enviaDado(turmas);
					break;
				case 4:
					System.exit(0);
				}
			
		}while(opcao!=null && opcao!=5);

	}

	private static void enviaDado(ArrayList<Turma>turmas) {
		JSONArray turma = Dados.parseTurmatoJson(turmas);
		Integracao.enviarDados(turma);	
	}

	private static void cadastrarAluno(ArrayList<Turma>turmas) {
		String titulo = "Cadastro de aluno";
		int id;
		id = lerNumeroInteiro("Informe o ID da turma:", titulo);
		for (int i = 0; i < turmas.size(); i++) {
			if(turmas.get(i).getId() == id) {
				Aluno aluno = new Aluno();
				aluno.setId(lerNumeroInteiro("Informe o ID do aluno:", titulo));
				aluno.setNome(lerString("Informe o nome do aluno:", titulo));
				int matriculado = lerNumeroInteiro("Matriculado? Digite:\n 1 para SIM\n2 para NÂo", titulo);
				if(matriculado == 1)
					aluno.setMatriculado(true);
				else
					aluno.setMatriculado(false);
				
				turmas.get(i).adicionaAluno(aluno);
				
			}
		}
	}

	private static Turma cadastrarTurma() {
		Turma turma = new Turma();
		String titulo ="Cadastro de Turma";
		turma.setId(lerNumeroInteiro("Informe o ID da turma:", titulo));
		turma.setCurso(lerString("Informe o nome do curso:", titulo));
		turma.setAno(lerNumeroInteiro("Informa o ano:", titulo));
		return turma;
	}
}
