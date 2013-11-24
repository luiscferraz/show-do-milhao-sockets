package jogo;

import java.util.ArrayList;
import java.util.Random;

public class Jogo {
	private ArrayList<Pergunta> perguntas = new ArrayList<Pergunta>();
	private Random r = new Random();
	private Pergunta perguntaAtual;
	
	public Jogo() {
		Pergunta perg1 = new Pergunta("Qual o sobrenome de Marcela?", "Amaral", "Monteiro", "Domingues", "Ferraz", 'c');
		perguntas.add(perg1);
		Pergunta perg2 = new Pergunta("Qual o sobrenome de Allan?", "Amaral", "Monteiro", "Domingues", "Ferraz", 'a');
		perguntas.add(perg2);
		Pergunta perg3 = new Pergunta("Qual o sobrenome de Fernanda?", "Amaral", "Monteiro", "Domingues", "Ferraz", 'b');
		perguntas.add(perg3);
		Pergunta perg4 = new Pergunta("Qual o sobrenome de Luis?", "Amaral", "Monteiro", "Domingues", "Ferraz", 'd');
		perguntas.add(perg4);
	}
	
	public void novaPergunta(){
		if (perguntas.size() > 0) {
			int proxPerg = r.nextInt(perguntas.size());
			perguntaAtual = perguntas.get(proxPerg);
			System.out.println(perguntaAtual.toString());
		} else {
			System.out.println("ACABARAM AS PERGUNTAS!!!");
		}
	}
	
	public void responder(char resposta) {
		if (perguntaAtual.certaResposta(resposta)) {
			System.out.println("CERTA RESPOSTA!!\n\n");
			perguntas.remove(perguntaAtual);
		} else {
			System.out.println("OPA, VOCÊ ERROU! U_U\n\n");
		}
	}

}
