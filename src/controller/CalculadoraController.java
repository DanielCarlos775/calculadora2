package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.CalculadoraModel;

public class CalculadoraController {
	
	private CalculadoraModel model;
	private CalculadoraView view;
	
	public CalculadoraController(CalculadoraModel model, CalculadoraView view) {
		this.model = model;
		this.view = view;
		
		configurarEventos();
		
		atualizarDisplay();
	}
	
	private void configurarEventos() {
		for (int i = 0; i <= 9; i++) {
			final int numero = i;
			view.getBtNum(i).setOnAction(e -> 1{
				model.adicionarDigito(numero);
				atualizarDisplay();
			});
		}
		
		view.getBtSomar().setOnAction(e -> {
			model.definirOperacao("+");
			atualizarDisplay();
		});
		
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
	
	
	
}
