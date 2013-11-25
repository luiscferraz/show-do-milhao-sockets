package jogo;

import java.util.ArrayList;
import java.util.Random;

public class Jogo {
	private ArrayList<Pergunta> perguntas = new ArrayList<Pergunta>();
	private ArrayList<Jogador> jogadores = new ArrayList<Jogador>();
	private Jogador jogadorAtual;
	private Random r = new Random();
	private Pergunta perguntaAtual;
	private int numeroDaPergunta;
	
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

	public Jogador getJogadorAtual() {
		return jogadorAtual;
	}
	public void setJogadorAtual(Jogador jogadorAtual) {
		this.jogadorAtual = jogadorAtual;
	}
	public int getNumeroDaPergunta() {
		return numeroDaPergunta;
	}
	public void setNumeroDaPergunta(int numeroDaPergunta) {
		this.numeroDaPergunta = numeroDaPergunta;
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
	
	public void novoJogador(Jogador jogador){
		jogadorAtual = jogador;
		jogadorAtual.setPerguntasDoJogador(perguntas);
		numeroDaPergunta = 1;
	}
	
	public void novaPergunta(){
		System.out.println("\n\nPERGUNTA - " + this.getNumeroDaPergunta());
		int proxPerg = r.nextInt(jogadorAtual.getPerguntasDoJogador().size());
		perguntaAtual = jogadorAtual.getPerguntasDoJogador().get(proxPerg);
		System.out.println(perguntaAtual.toString());
	}
	
	public boolean responder(char resposta) {
		try{
			if (perguntaAtual.certaResposta(resposta)) {
				System.out.println("CERTA RESPOSTA!!\n\n");
				//retira a pergunta respondida corretamente da lista remanescente.
				jogadorAtual.getPerguntasDoJogador().remove(perguntaAtual);
				
				System.out.println("\n\nSTATUS: ");
				System.out.println("\nPegunta atual - " + numeroDaPergunta);
				System.out.println("Pontua��o atual - " + this.pontuarSeguindoJogo(numeroDaPergunta));
				System.out.println("Caso parasse - " + this.pontuarParandoJogo(numeroDaPergunta));
				System.out.println("Caso errasse - " + this.pontuarErrandoPergunta(numeroDaPergunta) + "\n\n");
				numeroDaPergunta += 1;
				
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
	
	public void jogadorSairDoJogo(int opcao) {
		//sair do jogo errando
		if (opcao == 1) {
			jogadorAtual.setPontuacao(this.pontuarErrandoPergunta(numeroDaPergunta));
		} 
		//sair do jogo parando
		else if (opcao == 2) {
			jogadorAtual.setPontuacao(this.pontuarParandoJogo(numeroDaPergunta));
		}
		//sair do jogo ganhando
		else if (opcao == 3){
			jogadorAtual.setPontuacao(this.pontuarSeguindoJogo(numeroDaPergunta));
		}
		jogadores.add(jogadorAtual);
		System.out.println("\n\nRANK DOS JOGADORES:\n");
		System.out.println(jogadores);
	}
	
	public int pontuarSeguindoJogo(int num){		
		if((num>=1) && (num<=5)){
			return (num * 1000);
		} else if ((num>=6) && (num<=10)){
			return ((num-5) * 10000);
		} else if ((num>=11) && (num<=15)){
			return ((num-10) * 100000);
		} else if (num==16){
			return 1000000;
		} else {
			return 0;
		}
	}
	
	//ainda em d�vida se est� correto
	public int pontuarParandoJogo(int num){
		if (num == 1) {
			return 500;
		} else {
			num -= 1;
			return this.pontuarSeguindoJogo(num);
		}
	}
	
	public int pontuarErrandoPergunta(int num){
		if (num == 1) {
			return 0;
		} else {
			return (this.pontuarParandoJogo(num)/2);
		}
	}
	
	public void ajudaUniversitarios() {		
		System.out.println("Universit�rio 1 - Eu lhe indico a alternativa " + this.conversaoIntParaChar(r.nextInt(4)));
		System.out.println("Universit�rio 2 - Eu lhe indico a alternativa " + this.conversaoIntParaChar(r.nextInt(4)));
		System.out.println("Universit�rio 3 - Eu lhe indico a alternativa " + this.conversaoIntParaChar(r.nextInt(4)));
		jogadorAtual.setAjuda(true);
	}
	
	public char conversaoIntParaChar(int valor) {
		if (valor == 1) {
			return 'a';
		} else if (valor == 2) {
			return 'b';
		} else if (valor == 3) {
			return 'c';
		} else {
			return 'd';
		}
	}
}
