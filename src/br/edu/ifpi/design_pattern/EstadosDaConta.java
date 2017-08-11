package br.edu.ifpi.design_pattern;

public interface EstadosDaConta {
	void deposita(double valor, Conta conta);
	void saca(double valor, Conta conta);
}
