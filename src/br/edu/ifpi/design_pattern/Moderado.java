package br.edu.ifpi.design_pattern;

public class Moderado implements Investimento{
	public double investir(Conta conta) {
		double chance = new java.util.Random().nextDouble();
		double porc_lucro;
		if(chance<=0.5) porc_lucro = 0.025;
		else porc_lucro = 0.007;
		return conta.getSaldo()*porc_lucro;
	}

}
