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
		Pergunta perg1 = new Pergunta("Quem era o homem mais sedutor do mundo?", "Dom Huan", "Dom Ant�nio", "Dom Marco", "Dom Carlos", 'a');
		perguntas.add(perg1);
		Pergunta perg2 = new Pergunta("De quantos anos � constitu�do um s�culo?", "50", "100", "1.000", "1.500", 'b');
		perguntas.add(perg2);
		Pergunta perg3 = new Pergunta("Qual o coletivo de c�es?", "Matilha", "Rebanho", "Cardume", "Manada", 'a');
		perguntas.add(perg3);
		Pergunta perg4 = new Pergunta("Segundo a B�blia, em que rio Jesus foi batizado por Jo�o Batista?", "No Rio Nilo", "No Rio Sena", "No Rio Reno", "No Rio Jord�o", 'd');
		perguntas.add(perg4);
		Pergunta perg5 = new Pergunta("Qual a maior floresta do mundo?", "Negra", "De Sherwood", "Da Tijuca", "Amaz�nica", 'd');
		perguntas.add(perg5);
		Pergunta perg6 = new Pergunta("Qual o nipe do baralho que tem desenho de cora��o?", "Ouros", "Paus", "Copas", "Espadas", 'c');
		perguntas.add(perg6);
		Pergunta perg7 = new Pergunta("Qual o casal foi expulso do para�so?", "Sans�o e Dalila", "Jos� e Maria", "Sara e Abra�o", "Ad�o e Eva", 'd');
		perguntas.add(perg7);
		Pergunta perg8 = new Pergunta("Qual foi o santo que s� acreditou vendo?", "Santo Ant�nio", "S�o Judas Tadeu", "S�o Pedro", "S�o Tom�", 'd');
		perguntas.add(perg8);
		Pergunta perg9 = new Pergunta("Qual � o fruto conhecido no nordeste como 'jerimum'?", "Caju", "Ab�bora", "Chuchu", "Coco", 'b');
		perguntas.add(perg9);
		Pergunta perg10 = new Pergunta("Como � conhecido o jogador Edmundo?", "Tigr�o", "Gatinho", "Animal", "Cobra", 'c');
		perguntas.add(perg10);
		Pergunta perg11 = new Pergunta("Na literatura, quem foi o criador da boneca Em�lia?", "Monteiro Lobato", "Maur�cio de Souza", "Walt Disney", "Jorge Amado", 'a');
		perguntas.add(perg11);
		Pergunta perg12 = new Pergunta("Quem � o prieiro substituto do presidente?", "Vereador", "Vice-presidente", "Senador", "Deputado", 'b');
		perguntas.add(perg12);
		Pergunta perg13 = new Pergunta("Segundo o romance qual animal era 'Moby Dick'?", "Tubar�o", "Golfinho", "Povo", "Baleia", 'd');
		perguntas.add(perg13);
		Pergunta perg14 = new Pergunta("Qual � o animal que representa o signo de �ries?", "Touro", "Le�o", "Carneiro", "Bode", 'd');
		perguntas.add(perg14);
		Pergunta perg15 = new Pergunta("Que animal � o pateta?", "Burro", "Cachorro", "Cavalo", "Raposa", 'b');
		perguntas.add(perg15);
		Pergunta perg16 = new Pergunta("Em qual cidade est� o Cristo Redentor do Corcovado?", "Rio de Janeiro", "S�o Paulo", "Curitiba", "Recife", 'a');
		perguntas.add(perg16);
		Pergunta perg17 = new Pergunta("Quantos cent�metros equivalem a um metro?", "10", "100", "1000", "10000", 'b');
		perguntas.add(perg17);
		Pergunta perg18 = new Pergunta("Qual � o nome do macho da abelha?", "Zang�o", "Abelh�o", "Rufi�o", "Pulg�o", 'a');
		perguntas.add(perg18);
		Pergunta perg19 = new Pergunta("Qual � o inseto que transmite a Doe�a de Chagas?", "Abelha", "Barata", "Barbeiro", "Pulga", 'c');
		perguntas.add(perg19);
		Pergunta perg20 = new Pergunta("Qual � o nome da missa rezada no Natal?", "Campal", "do Galo", "do Vaticano", "do S�timo dia", 'b');
		perguntas.add(perg20);
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
				System.out.println("VOC� ERROU!\n\n");
				return false;
			}
		}catch(Exception ex){
			System.out.println(ex.getMessage());
			System.out.println("VOC� ERROU!\n\n");
			return false;
		}
	}
	
	public int pontuarSeguindoJogo(int numeroDaPergunta){		
		
		if((numeroDaPergunta>=1) && (numeroDaPergunta<=5)){
			return 1000;
		} else {
			if(numeroDaPergunta==6){
				return 5000;
			}else{
				if((numeroDaPergunta>=7)&&(numeroDaPergunta<=10) ){
					return 10000;
				}else{
					if(numeroDaPergunta==11){
						return 50000;
					}else{
						if((numeroDaPergunta>=12)&&(numeroDaPergunta<=15)){
							return 100000;
						}
					}
					
				}
			}
		}
		
		return 500000;
	}
	
	//ainda em d�vida se est� correto
	public int pontuarParandoJogo(int numeroDaPergunta){
		if(numeroDaPergunta==1){
			return 500;
		} else {
			if((numeroDaPergunta>=2) && (numeroDaPergunta<=6)){
				return 1000;
			} else {
				if(numeroDaPergunta==7){
					return 5000;
				}else{
					if((numeroDaPergunta>=8)&&(numeroDaPergunta<=11) ){
						return 10000;
					}else{
						if(numeroDaPergunta==12){
							return 50000;
						}
					}
				}
			}
		}
		
		return 100000;
	}

}
