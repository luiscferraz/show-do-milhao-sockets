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
					System.out.println("VAI COMEÇAR O SHOW DO MILHÃO!!\n\n");
					
					Jogo jogo = new Jogo();
					
					
					
					while (sair==false) {
						System.out.println("CRIAR NOVO JOGADOR (Responda com 's'/'n')?");
						
						if (entrada.nextLine().equalsIgnoreCase("s")) {
							//Para saber o nome do jogador para ser armazenado na lista de melhores
							System.out.println("Digite seu nome:");
							String nome = entrada.nextLine();
							
							jogo.novoJogador(new Jogador());
							jogo.getJogadorAtual().setNome(nome);
							
							System.out.println("INSTRUÇÕES DE JOGO\n\n");
							System.out.println("- Digite os valores das alternativas (entre 'a' e 'd') para responder as perguntas.\n");
							System.out.println("- Digite 'p' para pular a questão (você só pode dar 3 pulos).\n");
							System.out.println("- Digite 'u' para pedir ajuda aos universitários.\n");
							System.out.println("- Digite 'r' para pedir ajuda às cartas.\n");
							System.out.println("Bom jogo!\n");
							
							jogo.novaPergunta();
							
							while (entrada.hasNextLine()) { 
								answer = entrada.nextLine();
								try{
									//Caso tenha escolhido pular a pergunta
									if (answer.equalsIgnoreCase("p")){
										if (jogo.getJogadorAtual().getPulos()>0) {
											jogo.getJogadorAtual().pular();
											jogo.novaPergunta();
										}
										else{
											System.out.println("Você já utilizou suas três opções de pulo, informe a resposta desta pergunta.");
										}
									}
									
									//Caso peça ajuda aos universitarios
									else if (answer.equalsIgnoreCase("u")) {
										if (jogo.getJogadorAtual().isAjuda()) {
											System.out.println("VOCE JÁ PEDIU AJUDA! \n");
										} else {
											jogo.ajudaUniversitarios();
											System.out.println("\nE AGORA, " + jogo.getJogadorAtual().getNome().toUpperCase() + " QUAL "
												+ "ALTERNATIVA VOCÊ ESCOLHE? \n");
										}
									}
									
									//Caso a pergunta tenha sido respondida corretamente
									else if (jogo.responder(answer.charAt(0))) {													
											
										System.out.println("QUER CONTINUAR? (Digite 's' para continuar e 'n' para sair do jogo)\n");
										
										if (entrada.hasNextLine()) {
											
											//Se escolheu parar o jogo
											if (entrada.nextLine().equalsIgnoreCase("n")) {
												//Jogador sair do jogo parando - Opção 2
												jogo.jogadorSairDoJogo(2);
												Jogador jogadorAtual = jogo.getJogadorAtual();
												//Se o jogo for encerrado deve mostrar o nome do jogador e a pontuação do mesmo
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
										//Jogador sair do jogo parando - Opção 1
										jogo.jogadorSairDoJogo(1);
										Jogador jogadorAtual = jogo.getJogadorAtual();
										//Mostrar o nome do jogador e a pontuação do mesmo
										System.out.println("Nome: "+ jogadorAtual.getNome() + "\n" );
										System.out.println("SCORE: " + jogadorAtual.getPontuacao() + "\n");
										
										break;
									}
								} catch (Exception ex){
									//System.out.println("Opcao invalida. JOGO ENCERRADO!");
									break;
								}
							}
						}
					}
				}
				
				else if (answer.equalsIgnoreCase("s")) {
					sair = true;
					break;
				}
				else if (sair) {
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