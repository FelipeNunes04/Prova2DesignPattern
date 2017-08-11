package br.edu.ifpi.design_pattern;

public class Positivo implements EstadosDaConta{

	private final double porcDeDeposito = 0.98;

	@Override
	public void deposita(double valor, Conta conta) {
		double valorComDesconto = valor*porcDeDeposito;
		double novoSaldo = conta.getSaldo()+valorComDesconto;
		conta.setSaldo(novoSaldo);
	}

	@Override
	public void saca(double valor, Conta conta) {
		double novoSaldo = conta.getSaldo()-valor;
		if(novoSaldo<0)conta.estadoAtual = new Negativo();
		conta.setSaldo(novoSaldo);	
	}

}
