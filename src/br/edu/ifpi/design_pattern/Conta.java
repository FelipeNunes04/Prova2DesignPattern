package br.edu.ifpi.design_pattern;

import java.util.Calendar;

public class Conta {
	private int id;
	private double saldo = 0;
	private Calendar dataAbertura;
	protected EstadosDaConta estadoAtual;
	
	public Conta(Calendar dataAbertura) {
		this.dataAbertura = dataAbertura;
		estadoAtual = new Positivo();
	}
	
	public void saca(double valor) {
		estadoAtual.saca(valor, this);
	}
	
	public void deposita(double valor) {
		estadoAtual.deposita(valor, this);
	}
	
	public double getSaldo() {
		String valorFormatado = String.format("%.2f", saldo); 
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
