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
					System.out.println("VAI COME�AR O SHOW DO MILH�O!!\n\n");
					
					Jogo jogo = new Jogo();
					
					//Para saber o nome do jogador para ser armazenado na lista de melhores
					System.out.println("Digite seu nome:");
					String nome = entrada.nextLine();
					Jogador jogadorAtual = new Jogador(nome);
					
					jogo.novaPergunta();
					
					while (entrada.hasNextLine()) { 
						answer = entrada.nextLine();
						try{
						//caso a pergunta tenha sido respondida corretamente
							if (jogo.responder(answer.charAt(0))) {
													
									
								System.out.println("QUER CONTINUAR? (Digite 's' para continuar e 'n' para sair do jogo)\n");
								
								if (entrada.hasNextLine()) {
									if (entrada.nextLine().equalsIgnoreCase("n")) {
										sair = true;
										
										//Se o jogo for encerrado deve mostrar o nome do jogador e a pontua��o do mesmo
										jogadorAtual.setPontuacao(jogadorAtual.getPontuacao()+500);
										System.out.println("Nome: "+ jogadorAtual.getNome() + "\n" );
										System.out.println("SCORE: " + jogadorAtual.getPontuacao() + "\n");
										
										
										break;
									} else {
										jogadorAtual.setPontuacao(jogadorAtual.getPontuacao()+1000);
										System.out.println("\nSCORE: " + jogadorAtual.getPontuacao());
										jogo.novaPergunta();
									}
								}
							//caso contrario, sai do jogo
							} else {
								sair = true;
								
								System.out.println("Nome: "+ jogadorAtual.getNome() + "\n" );
								System.out.println("SCORE: " + jogadorAtual.getPontuacao() + "\n");
								
								//adiciona o jogador a lista de jogadores p armazenar seu nome e score
								jogadores.add(jogadorAtual);
								
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