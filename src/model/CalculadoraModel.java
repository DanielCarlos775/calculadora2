package model;

public class CalculadoraModel {
	
	private double numero1;
	private double numero2;
	private String operacao;
	private boolean novaOperacao = true;
	private String displayText = "0";
	
	public CalculadoraModel() {
		limpar();
	}
	
	public void adicionarDigito(int digito) {
		if (novaOperacao) {
			displayText = String.valueOf(digito);
			novaOperacao = false;
		} else {
			if (displayText.equals("0")) {
				displayText = String.valueOf(digito);
			} else {
				displayText += digito;
			}
		}
	}
	
	public void limpar() {
		numero1 = 0;
		numero2 = 0;
		operacao = "";
		novaOperacao = true;
		displayText = "0";
	}

}
