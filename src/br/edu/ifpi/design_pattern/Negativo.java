package br.edu.ifpi.design_pattern;

public class Negativo implements EstadosDaConta{

	private final double porcDeDeposito = 0.95;
	
	@Override
	public void deposita(double valor, Conta conta) {
		double valorComDesconto = valor*porcDeDeposito;
		double novoSaldo = conta.getSaldo()+valorComDesconto;
		if(novoSaldo>=0) conta.estadoAtual = new Positivo();
		conta.setSaldo(novoSaldo);		
	}

	@Override
	public void saca(double valor, Conta conta) {
		throw new RuntimeException("Contas com saldo negativo não podem fazer saque."); 
		
	}

}
