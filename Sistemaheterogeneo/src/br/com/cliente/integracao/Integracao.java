package br.com.cliente.integracao;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import org.json.simple.JSONArray;
import static br.com.cliente.es.EntradaESaida.*;

public class Integracao {
	
	public static String IP = "127.0.0.1";
	public static int PORTA = 8000;
	
	public Integracao() {
		
	}
	public static void enviarDados(JSONArray jTurma){
		try {
			Socket cliente = new Socket(IP, PORTA);
			msgInfo("Enviando os dados para o servidor!", "Escola");
			
			BufferedOutputStream bf = new BufferedOutputStream(cliente.getOutputStream());
	        byte[] byteT = jTurma.toJSONString().getBytes();
	        bf.write(byteT);
	        bf.flush();
	        bf.close();
	        
			cliente.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
