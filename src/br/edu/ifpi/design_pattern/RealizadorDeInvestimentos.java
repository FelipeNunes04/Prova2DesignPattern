package br.edu.ifpi.design_pattern;

public class RealizadorDeInvestimentos {
	private final double porcentagemValorAdicionado = 0.75;

	public void calculaInvestimento(Investimento investimento,Conta conta) {
		double valorBrutoDoInvestimento = investimento.investir(conta);
		double valorLiquidoDoInvestimento = valorBrutoDoInvestimento*porcentagemValorAdicionado;
		conta.setSaldo(valorLiquidoDoInvestimento+conta.getSaldo());
	}
}
