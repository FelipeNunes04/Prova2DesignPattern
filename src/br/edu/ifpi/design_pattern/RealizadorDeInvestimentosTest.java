package br.edu.ifpi.design_pattern;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.Test;

public class RealizadorDeInvestimentosTest {
	
	@Test
	public void deveEntenderInvestimentoConservadorAltoValor() {
		Conta poupanca = new Conta(Calendar.getInstance(),"Felipe");
		poupanca.deposita(1000000);
		Investimento conservador = new Conservador();
		RealizadorDeInvestimentos r = new RealizadorDeInvestimentos();
		r.calculaInvestimento(conservador, poupanca);		
		assertEquals(985880, poupanca.getSaldo(),0.00001);
		
	}
	
	@Test
	public void deveEntenderTodosOsTiposDeInvestimento() {
		Conta poupanca = new Conta(Calendar.getInstance(),"Felipe");
		poupanca.deposita(100);
		Investimento conservador = new Conservador();
		Investimento moderado = new Moderado();
		Investimento arrojado = new Arrojado();
		RealizadorDeInvestimentos r = new RealizadorDeInvestimentos();
		
		r.calculaInvestimento(conservador, poupanca);
		double saldoComInvestimentoConservador = poupanca.getSaldo();
		r.calculaInvestimento(moderado, poupanca);
		double saldoComInvestimentoModerado = poupanca.getSaldo();
		
		r.calculaInvestimento(arrojado, poupanca);
		double saldoComInvestimentoArrojado = poupanca.getSaldo();
		
		List<Double> valoresInvestimentoModeradoEsperados = new ArrayList<>();
		valoresInvestimentoModeradoEsperados.add(100.44);
		valoresInvestimentoModeradoEsperados.add(99.11);

		List<Double> valoresInvestimentoArrojadoEsperados = new ArrayList<>();
		valoresInvestimentoArrojadoEsperados.add(104.21);
		valoresInvestimentoArrojadoEsperados.add(102.7);
		valoresInvestimentoArrojadoEsperados.add(100.89);
		valoresInvestimentoArrojadoEsperados.add(102.83);
		valoresInvestimentoArrojadoEsperados.add(101.34);
		valoresInvestimentoArrojadoEsperados.add(99.56);

		assertEquals(98.59, saldoComInvestimentoConservador,0.00001);
		assertTrue(valoresInvestimentoModeradoEsperados.contains(saldoComInvestimentoModerado));
		assertTrue(valoresInvestimentoArrojadoEsperados.contains(saldoComInvestimentoArrojado));
		
	}
}
