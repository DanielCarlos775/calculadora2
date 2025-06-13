package controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import model.CalculadoraModel;

public class CalculadoraController {

	private final CalculadoraModel calculadora = new CalculadoraModel();

	@FXML
	private void initialize() {
		Platform.runLater(() -> rootPane.requestFocus());

		rootPane.setOnKeyPressed(this::handleTeclado);
	}

	@FXML
	private void onNumeroClick(ActionEvent event) {
		String valor = ((Button) event.getSource()).getText();
		String novoTexto = calculadora.adicionarDigito(valor);
		txfDisplay.setText(novoTexto);
	}

	@FXML
	private void onOperadorClick(ActionEvent event) {
		String operador = ((Button) event.getSource()).getText();
		lblExpressao.setText(calculadora.definirOperacao(operador));
	}

	@FXML
	private void onIgualClick(ActionEvent event) {
		String resultado = calculadora.calcular();
		txfDisplay.setText(resultado);
		lblExpressao.setText("");
	}

	@FXML
	private void onLimparClick(ActionEvent event) {
		calculadora.limpar();
		txfDisplay.setText("0");
		lblExpressao.setText("");
	}

	@FXML
	private void onApagar() {
		String textoAtual = txfDisplay.getText();

		if (textoAtual.equals("0") && textoAtual.isEmpty()) {
			return;
		}
		textoAtual = textoAtual.substring(0, textoAtual.length() - 1);

		if (textoAtual.isEmpty()) {
			txfDisplay.setText("0");
			calculadora.novaOperacao = true;
		} else {
			txfDisplay.setText(textoAtual);
		}
	}

	private void handleTeclado(KeyEvent event) {
		String tecla = event.getText();

		if (tecla.equals(",") || tecla.equals(".")) {
			txfDisplay.setText(calculadora.adicionarVirgula());
		} else {
			switch (event.getCode()) {
			case DIGIT0, NUMPAD0 -> txfDisplay.setText(calculadora.adicionarDigito("0"));
			case DIGIT1, NUMPAD1 -> txfDisplay.setText(calculadora.adicionarDigito("1"));
			case DIGIT2, NUMPAD2 -> txfDisplay.setText(calculadora.adicionarDigito("2"));
			case DIGIT3, NUMPAD3 -> txfDisplay.setText(calculadora.adicionarDigito("3"));
			case DIGIT4, NUMPAD4 -> txfDisplay.setText(calculadora.adicionarDigito("4"));
			case DIGIT5, NUMPAD5 -> txfDisplay.setText(calculadora.adicionarDigito("5"));
			case DIGIT6, NUMPAD6 -> txfDisplay.setText(calculadora.adicionarDigito("6"));
			case DIGIT7, NUMPAD7 -> txfDisplay.setText(calculadora.adicionarDigito("7"));
			case DIGIT8, NUMPAD8 -> txfDisplay.setText(calculadora.adicionarDigito("8"));
			case DIGIT9, NUMPAD9 -> txfDisplay.setText(calculadora.adicionarDigito("9"));
			case PLUS, ADD -> lblExpressao.setText(calculadora.definirOperacao("+"));
			case MINUS, SUBTRACT -> lblExpressao.setText(calculadora.definirOperacao("-"));
			case MULTIPLY -> lblExpressao.setText(calculadora.definirOperacao("*"));
			case DIVIDE, SLASH -> lblExpressao.setText(calculadora.definirOperacao("/"));
			case ENTER, EQUALS -> txfDisplay.setText(calculadora.calcular());
			case ESCAPE -> onLimparClick(null);
			case BACK_SPACE -> {
				String atual = txfDisplay.getText();
				if (!atual.isEmpty() && !calculadora.novaOperacao) {
					txfDisplay.setText(atual.substring(0, atual.length() - 1));
				}
			}
			}
		}
		event.consume();
	}

	@FXML
	private void onVirgulaClick(ActionEvent event) {
		txfDisplay.setText(calculadora.adicionarVirgula());
	}

	@FXML
	private void manterFoco() {
		Platform.runLater(() -> rootPane.requestFocus());
	}

	@FXML
	private Button btPorcentagem;
	@FXML
	private Button btClear2;
	@FXML
	private Button btClear;
	@FXML
	private Button btApagar;
	@FXML
	private Button btDividir;
	@FXML
	private Button btMultiplicar;
	@FXML
	private Button btSubtrair;
	@FXML
	private Button btSomar;
	@FXML
	private Button btIgual;
	@FXML
	private Button btVirgula;
	@FXML
	private Button bt0;
	@FXML
	private Button bt1;
	@FXML
	private Button bt2;
	@FXML
	private Button bt3;
	@FXML
	private Button bt4;
	@FXML
	private Button bt5;
	@FXML
	private Button bt6;
	@FXML
	private Button bt7;
	@FXML
	private Button bt8;
	@FXML
	private Button bt9;
	@FXML
	private TextField txfDisplay;
	@FXML
	private Label lblExpressao;
	@FXML
	private AnchorPane rootPane;

}
