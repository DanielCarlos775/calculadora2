package model;

public class CalculadoraModel {

	private double numero1;
	private double numero2;
	private String operacao = "";
	public boolean novaOperacao = true;
	private String displayText = "0";

	public CalculadoraModel() {
		limpar();
	}

	public String adicionarDigito(String digito) {

		if (!digito.matches("\\d"))
			return displayText;

		if (novaOperacao) {
			displayText = digito;
			novaOperacao = false;
		} else {
			if (displayText.equals("0")) {
				displayText = digito;
			} else {
				displayText += digito;
			}
		}

		return displayText;
	}
	
	public String adicionarVirgula() {
		if (novaOperacao) {
			displayText = "0,";
			novaOperacao = false;
		} else if (displayText.contains(",")) {
			displayText += ",";
		}
		return displayText;
	}

	public String definirOperacao(String novaOperacao) {
		if (!operacao.isEmpty() && !this.novaOperacao) {
			calcular();
		}

		try {
			this.numero1 = parseNumero(displayText);
		} catch (NumberFormatException e) {
			this.numero1 = 0;
		}

		this.operacao = novaOperacao;
		this.novaOperacao = true;

		return getExpressao();
	}

	public String calcular() {
		try {
			this.numero2 = parseNumero(displayText);
		} catch (NumberFormatException e) {
			numero2 = 0;
		}
		
		double resultado = switch (operacao) {
			case "+" -> numero1 + numero2;
			case "-" -> numero1 - numero2;
			case "*" -> numero1 * numero2;
			case "/" -> numero2 != 0 ? numero1 / numero2 : 0;
			default -> numero2;
		};
		
		displayText = formatar(resultado);
		operacao = "";
		novaOperacao = true;
		
		return displayText;
	}
	
	private String formatar (double valor) {
		if (valor == (long) valor) {
			return String.valueOf((long) valor);
		} else {
			return String.format(".%8f", valor)
					.replaceAll("0*$", "")
					.replaceAll("\\.$", "")
					.replace('.', ',');
		}
	}
	
	private double parseNumero(String valorTexto) {
		return Double.parseDouble(valorTexto.replace(',', '.'));
	}
	
	public String getExpressao() {
		return numero1 + " " + operacao + " ";
	}

	public void setNovaOperacao(boolean novaOperacao) {
		this.novaOperacao = novaOperacao;
	}

	public boolean isNovaOperacao() {
		return novaOperacao;
	}

	public String getDisplayText() {
		return displayText;
	}

	public void resetar() {
		displayText = "0";
		novaOperacao = true;
	}

	public void limpar() {
		numero1 = 0;
		numero2 = 0;
		operacao = "";
		novaOperacao = true;
		displayText = "0";
	}

}
