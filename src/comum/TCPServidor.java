package comum;

/*
 * TCPServidor.java
 *
 * Servidor ECHO (Coulouris, 2001) pg. 137
 * Passar numero da porta como argumento (opcional)
 * Ex. java TCPServidor <porta> ou
 *     java TCPServidor
 */

import java.net.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

import jogo.Jogador;
import jogo.Jogo;

public class TCPServidor {
	
	public static void main(String args[]) {
		try {
			ServerSocket servidor = new ServerSocket(6789);
	
			Socket cliente = servidor.accept();
			System.out.println("Tecle 'I' para iniciar um novo jogo e 'S' para sair.");
			Scanner entrada = new Scanner(cliente.getInputStream());
			
			ArrayList<Jogador> jogadores = new ArrayList<Jogador>();
			
			while (entrada.hasNextLine()) {
				boolean sair = false;
				String answer = entrada.nextLine();
				
				if (answer.equalsIgnoreCase("i")) {
					System.out.println("VAI COMEÇAR O SHOW DO MILHÃO!!\n\n");
					
					Jogo jogo = new Jogo();
					
					//Para saber o nome do jogador para ser armazenado na lista de melhores
					//System.out.println("Digite seu nome:");
					String nome = entrada.nextLine();
					Jogador jogadorAtual = new Jogador(nome);
					
					
					jogo.novaPergunta();
					
					while (entrada.hasNextLine()) { 
						answer = entrada.nextLine();
						try{
						//caso a pergunta tenha sido respondida corretamente
							if (jogo.responder(answer.charAt(0))) {
								//coloquei essa linha para ele pontuar quando acertar uma pergunta
								jogadorAtual.setPontuacao(jogadorAtual.getPontuacao()+1000);
								
								
								System.out.println("SCORE:"+jogadorAtual.getPontuacao());
								System.out.println(jogadorAtual.getNome());
								
								System.out.println("QUER CONTINUAR? (Digite 's' para continuar e 'n' para sair do jogo)\n");
								//jogadorAtual.setPontuacao(jogadorAtual.getPontuacao()+1000);
								
								
								if (entrada.hasNextLine()) {
									if (entrada.nextLine().equalsIgnoreCase("n")) {
										sair = true;
										break;
									} else {
										jogo.novaPergunta();
									}
								}
							//caso contrario, sai do jogo
							} else {
								sair = true;
								break;
							}
						} catch (Exception ex){
							sair = true;
							//System.out.println("Opcao invalida. JOGO ENCERRADO!");
							break;
						}
						
					}
				}
				
				else if (answer.equalsIgnoreCase("s")) {
					sair = true;
					break;
				}
				if (sair) {
					System.out.println("JOGO ENCERRADO!");
				}
			}
			
			entrada.close();
			servidor.close();
		} catch (IOException e) {
			System.out.println("Erro na escuta: " + e.getMessage());
		}
	}    
}