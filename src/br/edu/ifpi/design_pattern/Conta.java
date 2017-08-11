package br.edu.ifpi.design_pattern;

import java.text.DecimalFormat;
import java.util.Calendar;

public class Conta {
	private int id;
	private String titular;
	private double saldo = 0;
	private Calendar dataAbertura;
	protected EstadosDaConta estadoAtual;
	
	public Conta(Calendar dataAbertura, String titular) {
		this.titular = titular;
		this.dataAbertura = dataAbertura;
		estadoAtual = new Positivo();
	}
	
	public void saca(double valor) {
		estadoAtual.saca(valor, this);
	}
	
	public void deposita(double valor) {
		estadoAtual.deposita(valor, this);
	}
	
	public String getTitular() {
		return titular;
	}
	
	public double getSaldo() {
		DecimalFormat f = new DecimalFormat("#.##");
		String valorFormatado = f.format(saldo); 
		return Double.parseDouble(valorFormatado.replace(',', '.'));
	}
	
	protected void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public EstadosDaConta getEstadoAtual() {
		return estadoAtual;
	}

	public Calendar getDataAbertura() {
		return dataAbertura;
	}
}
