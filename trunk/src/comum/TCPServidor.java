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
import java.util.Scanner;
import java.io.*;

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
				
				if (answer.equalsIgnoreCase("i")) {
					System.out.println("VAI COMEÇAR O SHOW DO MILHÃO!!\n\n");
					Jogo jogo = new Jogo();
					jogo.novaPergunta();
					
					while (entrada.hasNextLine()) {
						answer = entrada.nextLine();
						jogo.responder(answer.charAt(0));
						
						System.out.println("QUER CONTINUAR? (Digite 's' para continuar e 'n' para sair do jogo)\n");
						if (entrada.hasNextLine()) {
							if (entrada.nextLine().equalsIgnoreCase("n")) {
								sair = true;
								break;
							} else {
								jogo.novaPergunta();
							}
						}
					}
				}
				else if (answer.equalsIgnoreCase("s")) {
					sair = true;
					break;
				}
				if (sair) {
					System.out.println("ADEUS!");
				}
			}
			
			entrada.close();
			servidor.close();
		} catch (IOException e) {
			System.out.println("Erro na escuta: " + e.getMessage());
		}
	}    
}