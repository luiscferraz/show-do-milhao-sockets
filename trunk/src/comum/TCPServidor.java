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
			
			while (entrada.hasNextLine()) {				
				boolean sair = false;
				String answer = entrada.nextLine();
				
				int pulos = 3;
				
				if (answer.equalsIgnoreCase("i")) {
					System.out.println("VAI COME�AR O SHOW DO MILH�O!!\n\n");
					
					Jogo jogo = new Jogo();
					
					sair = false;
					
					while (sair==false) {
						System.out.println("CRIAR NOVO JOGADOR (Responda com 's'/'n')?");
						
						if (entrada.nextLine().equalsIgnoreCase("s")) {
							//Para saber o nome do jogador para ser armazenado na lista de melhores
							System.out.println("Digite seu nome:");
							String nome = entrada.nextLine();
							
							jogo.novoJogador(new Jogador());
							jogo.getJogadorAtual().setNome(nome);
							
							jogo.novaPergunta();
							
							System.out.println("Digite 'P' para pular esta pergunta");
							
							while (entrada.hasNextLine()) { 
								answer = entrada.nextLine();
								try{
									//Caso tenha escolhido pular a pergunta
									if (answer.equalsIgnoreCase("p")){
										if (pulos>0){
											pulos = pulos-1;
											jogo.novaPergunta();
											System.out.println("Digite 'P' para pular esta pergunta");
										}
										else{
											System.out.println("Voc� j� utilizou suas tr�s op��es de pulo, informe a resposta desta pergunta.");
										}
									}
									
									//Caso a pergunta tenha sido respondida corretamente
									else if (jogo.responder(answer.charAt(0))) {													
											
										System.out.println("QUER CONTINUAR? (Digite 's' para continuar e 'n' para sair do jogo)\n");
										
										if (entrada.hasNextLine()) {
											
											//Se escolheu parar o jogo
											if (entrada.nextLine().equalsIgnoreCase("n")) {
												sair = true;
												
												//Jogador sair do jogo parando - Op��o 2
												jogo.jogadorSairDoJogo(2);
												Jogador jogadorAtual = jogo.getJogadorAtual();
												//Se o jogo for encerrado deve mostrar o nome do jogador e a pontua��o do mesmo
												System.out.println("Nome: "+ jogadorAtual.getNome() + "\n" );
												System.out.println("SCORE: " + jogadorAtual.getPontuacao() + "\n");
												
												break;
												
											} else {
												jogo.novaPergunta();
												System.out.println("Digite 'P' para pular esta pergunta");
											}
										}
									}
									
									//Caso erre a pergunta, sai do jogo
									else {
										sair = true;
										//Jogador sair do jogo parando - Op��o 1
										jogo.jogadorSairDoJogo(1);
										Jogador jogadorAtual = jogo.getJogadorAtual();
										//Mostrar o nome do jogador e a pontua��o do mesmo
										System.out.println("Nome: "+ jogadorAtual.getNome() + "\n" );
										System.out.println("SCORE: " + jogadorAtual.getPontuacao() + "\n");
										
										break;
									}
								} catch (Exception ex){
									sair = true;
									//System.out.println("Opcao invalida. JOGO ENCERRADO!");
									break;
								}
							}
						} else {
							sair = true;
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