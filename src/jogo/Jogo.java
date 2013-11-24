package jogo;

import java.util.ArrayList;
import java.util.Random;

public class Jogo {
	private ArrayList<Pergunta> perguntas = new ArrayList<Pergunta>();
	private ArrayList<Jogador> jogadores = new ArrayList<Jogador>();
	private Random r = new Random();
	private Pergunta perguntaAtual;
	
		
	public ArrayList<Pergunta> getPerguntas() {
		return perguntas;
	}

	public void setPerguntas(ArrayList<Pergunta> perguntas) {
		this.perguntas = perguntas;
	}


	public ArrayList<Jogador> getJogadores() {
		return jogadores;
	}

	public void setJogadores(ArrayList<Jogador> jogadores) {
		this.jogadores = jogadores;
	}

	public Pergunta getPerguntaAtual() {
		return perguntaAtual;
	}

	public void setPerguntaAtual(Pergunta perguntaAtual) {
		this.perguntaAtual = perguntaAtual;
	}

	public Jogo() {
		Pergunta perg1 = new Pergunta("Quem era o homem mais sedutor do mundo?", "Dom Huan", "Dom Antônio", "Dom Marco", "Dom Carlos", 'a');
		perguntas.add(perg1);
		Pergunta perg2 = new Pergunta("De quantos anos é constituído um século?", "50", "100", "1.000", "1.500", 'b');
		perguntas.add(perg2);
		Pergunta perg3 = new Pergunta("Qual o coletivo de cães?", "Matilha", "Rebanho", "Cardume", "Manada", 'a');
		perguntas.add(perg3);
		Pergunta perg4 = new Pergunta("Segundo a Bíblia, em que rio Jesus foi batizado por João Batista?", "No Rio Nilo", "No Rio Sena", "No Rio Reno", "No Rio Jordão", 'd');
		perguntas.add(perg4);
		Pergunta perg5 = new Pergunta("Qual a maior floresta do mundo?", "Negra", "De Sherwood", "Da Tijuca", "Amazônica", 'd');
		perguntas.add(perg5);
		Pergunta perg6 = new Pergunta("Qual o nipe do baralho que tem desenho de coração?", "Ouros", "Paus", "Copas", "Espadas", 'c');
		perguntas.add(perg6);
		Pergunta perg7 = new Pergunta("Qual o casal foi expulso do paraíso?", "Sansão e Dalila", "José e Maria", "Sara e Abraão", "Adão e Eva", 'd');
		perguntas.add(perg7);
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
	
	public boolean responder(char resposta) {
		try{
			if (perguntaAtual.certaResposta(resposta)) {
				System.out.println("CERTA RESPOSTA!!\n\n");
				
				//retira a pergunta respondida corretamente da lista remanescente.
				perguntas.remove(perguntaAtual);
				return true;
			} else {
				System.out.println("VOCÊ ERROU!\n\n");
				return false;
			}
		}catch(Exception ex){
			System.out.println(ex.getMessage());
			System.out.println("VOCÊ ERROU!\n\n");
			return false;
		}
	}
	
	public int pontuarSeguindoJogo(int numeroDaPergunta){
		if (numeroDaPergunta>=1 && numeroDaPergunta<=5){
			return 1000;
			
		} else{
			if (numeroDaPergunta>=6 && numeroDaPergunta<=10){
				return 10000;	
			}else{
				if (numeroDaPergunta>=11 && numeroDaPergunta<=15){
					return 100000;
				}
			}
		}
		return 500000;
	}
	
	//ainda em dúvida se está correto
	public int pontuarParandoJogo(int numeroDaPergunta){
		if(numeroDaPergunta==1){
			return 500;			
		}else{
			if(numeroDaPergunta>=2 && numeroDaPergunta<=6){
				return 100;
			} else{
				if(numeroDaPergunta>=7 && numeroDaPergunta<=12){
					return 1000;
				} else{
					if(numeroDaPergunta==13){
						return 4000;
					} else {
						if (numeroDaPergunta==19){
							return 40000;
						}
					}
				}
			}
		}
		return 100000;
	}

}
