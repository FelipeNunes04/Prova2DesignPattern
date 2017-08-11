package br.edu.ifpi.design_pattern;

import java.text.DecimalFormat;
import java.text.Format;
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
