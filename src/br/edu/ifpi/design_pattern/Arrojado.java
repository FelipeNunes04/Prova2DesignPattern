package br.edu.ifpi.design_pattern;

public class Arrojado implements Investimento{

	public double investir(Conta conta) {
		double chance = new java.util.Random().nextDouble();
		double porc_lucro;
		if(chance<=0.2) porc_lucro = 0.05;
		else if(chance<=0.5) porc_lucro = 0.03;
		else porc_lucro = 0.006;
		System.out.println(porc_lucro);
		return conta.getSaldo()*porc_lucro;
	}

}
