package jogo;

import java.util.Comparator;

public class ComparadorDeJogadores implements Comparator<Jogador> {
	public int compare(Jogador jogador1, Jogador jogador2) {
		if(jogador1.getPontuacao()< jogador2.getPontuacao()){
			return +1;
		} else if(jogador1.getPontuacao() > jogador2.getPontuacao()) return -1;
		else return 0;
	} 
}

