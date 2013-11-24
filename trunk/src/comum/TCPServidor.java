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
			int numeroDaPergunta = 1;
			
			while (entrada.hasNextLine()) {
				boolean sair = false;
				String answer = entrada.nextLine();
				
				//int pulos = 3;
				
				if (answer.equalsIgnoreCase("i")) {
					System.out.println("VAI COMEÇAR O SHOW DO MILHÃO!!\n\n");
					
					Jogo jogo = new Jogo();
					
					//Para saber o nome do jogador para ser armazenado na lista de melhores
					System.out.println("Digite seu nome:");
					String nome = entrada.nextLine();
					Jogador jogadorAtual = new Jogador(nome);
					
					System.out.println("PERGUNTA -" + numeroDaPergunta);
					jogo.novaPergunta();
					//System.out.println("Digite 'P' para pular esta pergunta");
					
					while (entrada.hasNextLine()) { 
						answer = entrada.nextLine();
						try{

							//caso a pergunta tenha sido respondida corretamente

							
							/*if (answer.equalsIgnoreCase("p")){
								if (pulos>0){
									pulos = pulos-1;
									jogo.novaPergunta();
									System.out.println("Digite 'P' para pular esta pergunta");
								}
								else{
									System.out.println("Você já utilizou suas três opções de pulo, informe a resposta desta pergunta.");
								}
							}
							*/
						//caso a pergunta tenha sido respondida corretamente

							if (jogo.responder(answer.charAt(0))) {
													
									
								System.out.println("QUER CONTINUAR? (Digite 's' para continuar e 'n' para sair do jogo)\n");
								
								if (entrada.hasNextLine()) {
									if (entrada.nextLine().equalsIgnoreCase("n")) {
										sair = true;
										
										//Se o jogo for encerrado deve mostrar o nome do jogador e a pontuação do mesmo
										jogadorAtual.setPontuacao(jogadorAtual.getPontuacao()+500);
										System.out.println("Nome: "+ jogadorAtual.getNome() + "\n" );
										System.out.println("SCORE: " + jogadorAtual.getPontuacao() + "\n");
										
										
										break;
									} else {
																				
										jogadorAtual.setPontuacao(jogadorAtual.getPontuacao()+ jogo.pontuarSeguindoJogo(numeroDaPergunta));
										System.out.println("\nSCORE: " + jogadorAtual.getPontuacao() + "\n");
										
										// só pode jpgar até completar um milhão, por isto o teste
										if(jogadorAtual.getPontuacao()<1000000){
											System.out.println("PERGUNTA -" + numeroDaPergunta);
											jogo.novaPergunta();
											
										
											numeroDaPergunta = numeroDaPergunta + 1;
										} else{
											sair = true;
											break;
										}
										
										
										//System.out.println("Digite 'P' para pular esta pergunta");
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