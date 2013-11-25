package jogo;

import java.util.ArrayList;

public class Jogador {
	private String nome;
	private int pontuacao;
	private ArrayList<Pergunta> perguntasDoJogador = new ArrayList<Pergunta>();
	
	public Jogador(String nome){
		this.nome = nome;
		this.pontuacao = 0;
	}
	
	public Jogador(){
		this.pontuacao =0;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getPontuacao() {
		return pontuacao;
	}
	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}

	public ArrayList<Pergunta> getPerguntasDoJogador() {
		return perguntasDoJogador;
	}
	public void setPerguntasDoJogador(ArrayList<Pergunta> perguntasDoJogador) {
		this.perguntasDoJogador = perguntasDoJogador;
	}

	@Override
	public String toString() {
		return "Jogador [nome=" + nome + ", pontuacao=" + pontuacao + "]";
	}
}
