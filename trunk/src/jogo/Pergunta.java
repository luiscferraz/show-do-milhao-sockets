package jogo;

public class Pergunta {
	
	//aqui seria a pergunta exibida para o usu�rio
	private String pergunta;
	
	//aqui seriam as 4 alternativas pedidas no projeto
	private String alternativaA;
	private String alternativaB;
	private String alternativaC;
	private String alternativaD;
	
	//aqui seria especificado a alternativa correta
	private char respostaCorreta;

	public String getPergunta() {
		return pergunta;
	}

	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}

	public String getAlternativaA() {
		return alternativaA;
	}

	public void setAlternativaA(String alternativaA) {
		this.alternativaA = alternativaA;
	}

	public String getAlternativaB() {
		return alternativaB;
	}

	public void setAlternativaB(String alternativaB) {
		this.alternativaB = alternativaB;
	}

	public String getAlternativaC() {
		return alternativaC;
	}

	public void setAlternativaC(String alternativaC) {
		this.alternativaC = alternativaC;
	}

	public String getAlternativaD() {
		return alternativaD;
	}

	public void setAlternativaD(String alternativaD) {
		this.alternativaD = alternativaD;
	}

	public char getRespostaCorreta() {
		return respostaCorreta;
	}

	public void setRespostaCorreta(char respostaCorreta) {
		this.respostaCorreta = respostaCorreta;
	}
	
	

}
