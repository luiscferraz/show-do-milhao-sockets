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
					System.out.println("\n ========= VAI COME�AR O SHOW DO MILH�O!! ============\n\n");
					
					Jogo jogo = new Jogo();
					
					
					
					while (sair==false) {
						System.out.println("CRIAR NOVO JOGADOR (Responda com 's'/'n')?\n");
						
						if (entrada.nextLine().equalsIgnoreCase("s")) {
							//Para saber o nome do jogador para ser armazenado na lista de melhores
							System.out.println("Digite seu nome:\n");
							String nome = entrada.nextLine();
							
							jogo.novoJogador(new Jogador());
							jogo.getJogadorAtual().setNome(nome);
							
							System.out.println("INSTRU��ES DE JOGO\n");
							System.out.println("- Digite os valores das alternativas (entre 'A' e 'D') para responder as perguntas.");
							System.out.println("- Digite 'P' para pular a quest�o (voc� s� pode dar 3 pulos).");
							System.out.println("- Digite 'U' para pedir ajuda aos universit�rios.");
							System.out.println("- Digite 'R' para pedir ajuda �s cartas.");
							System.out.println("- Digite 'L' para pedir ajuda �s placas.");
							System.out.println("Bom jogo!");
							
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
											System.out.println("Voc� j� utilizou suas tr�s op��es de pulo, informe a resposta desta pergunta.");
										}
									}
									
									//Caso pe�a ajuda aos universitarios
									else if (answer.equalsIgnoreCase("u")) {
										if (jogo.getJogadorAtual().isAjuda()) {
											System.out.println("VOCE J� PEDIU AJUDA! \n");
										} else {
											jogo.ajudaUniversitarios();
											System.out.println("\nE AGORA, " + jogo.getJogadorAtual().getNome().toUpperCase() + " QUAL "
												+ "ALTERNATIVA VOC� ESCOLHE? \n");
										}
									}
									
									//Caso pe�a ajuda as cartas
									else if (answer.equalsIgnoreCase("r")) {
										if (jogo.getJogadorAtual().isAjuda()) {
											System.out.println("VOCE J� PEDIU AJUDA! \n");
										} else {
											jogo.ajudaCartas();
											System.out.println("\nAGORA ESCOLHA A RESPOSTA ENTRE AS ALTERNATIVAS RESTANTES:\n");
										}
									}
									
									//Caso pe�a ajuda a plateia
									else if (answer.equalsIgnoreCase("l")) {
										if (jogo.getJogadorAtual().isAjuda()) {
											System.out.println("VOCE J� PEDIU AJUDA! \n");
										} else {
											jogo.ajudaPlacas();
											System.out.println("\nAGORA RESPONDA:\n");
										}
									}
									
									//Caso a pergunta tenha sido respondida corretamente
									else if (jogo.responder(answer.charAt(0))) {													
											
										System.out.println("QUER CONTINUAR? (Digite 's' para continuar e 'n' para sair do jogo)");
										
										if (entrada.hasNextLine()) {
											
											//Se escolheu parar o jogo
											if (entrada.nextLine().equalsIgnoreCase("n")) {
												//Jogador sair do jogo parando - Op��o 2
												jogo.jogadorSairDoJogo(2);
												Jogador jogadorAtual = jogo.getJogadorAtual();
												
												break;
												
											} else {
												jogo.novaPergunta();
											}
										}
									}
									
									//Caso erre a pergunta, sai do jogo
									else {
										//Jogador sair do jogo parando - Op��o 1
										jogo.jogadorSairDoJogo(1);
										break;
									}
								} catch (Exception ex){
									//System.out.println("Opcao invalida. JOGO ENCERRADO!");
									break;
								}
							}
						}
						else {
							sair = true;
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