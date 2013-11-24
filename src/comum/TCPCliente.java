package comum;

/*
 * TCPCliente.java
 *
 * Estabelece conexao com o servidor e envia mensagem.
 * O servidor devolve a mensagem enviada e o cliente a imprime.
 * Argumentos: java TCPCliente <IP servidor> <porta> "msg a ser enviada"
 */

import java.net.*;
import java.util.Scanner;
import java.io.*;

public class TCPCliente {

	public static void main(String args[]) throws UnknownHostException, IOException {

		Socket cliente = new Socket("localhost", 6789);
		
		System.out.println("Digite aqui:");
		
		Scanner teclado = new Scanner(System.in);
		PrintStream saida = new PrintStream(cliente.getOutputStream());

		while (teclado.hasNextLine()) {
			saida.println(teclado.nextLine());
		}
		
		saida.close();
		teclado.close();
		cliente.close();
	}   
}
