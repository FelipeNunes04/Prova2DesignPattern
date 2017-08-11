package br.edu.ifpi.design_pattern;

public class Conservador implements Investimento{

	public double investir(Conta conta) {
		return conta.getSaldo()*0.008;
	}

}
