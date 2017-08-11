package br.edu.ifpi.design_pattern;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.Test;

public class RealizadorDeInvestimentosTest {
	
	@Test
	public void deveEntenderInvestimentoConservadorAltoValor() {
		Conta poupanca = new Conta(Calendar.getInstance());
		poupanca.deposita(1000000);
		Investimento conservador = new Conservador();
		RealizadorDeInvestimentos r = new RealizadorDeInvestimentos();
		r.calculaInvestimento(conservador, poupanca);
		
		assertEquals(1006000.00, poupanca.getSaldo(),0.01);
		
	}
	
	@Test
	public void deveEntenderInvestimentoModeradoAltoValor() {
		Conta poupanca = new Conta(Calendar.getInstance());
		poupanca.deposita(1000000);
		Investimento moderado = new Moderado();
		RealizadorDeInvestimentos r = new RealizadorDeInvestimentos();
		
		r.calculaInvestimento(moderado, poupanca);
		
		List<Double> valoresInvestimentoModeradoEsperados = new ArrayList<>();
		valoresInvestimentoModeradoEsperados.add(1005250.00);
		valoresInvestimentoModeradoEsperados.add(1018750.00);

		assertTrue(valoresInvestimentoModeradoEsperados.contains(poupanca.getSaldo()));
		
	}
	
	@Test
	public void deveEntenderInvestimentoArrojadoAltoValor() {
		Conta poupanca = new Conta(Calendar.getInstance());
		poupanca.deposita(1000000);
		Investimento arrojado = new Arrojado();
		RealizadorDeInvestimentos r = new RealizadorDeInvestimentos();
		
		r.calculaInvestimento(arrojado, poupanca);
		
		List<Double> valoresInvestimentoArrojadoEsperados = new ArrayList<>();
		valoresInvestimentoArrojadoEsperados.add(1037500.00);
		valoresInvestimentoArrojadoEsperados.add(1022500.00);
		valoresInvestimentoArrojadoEsperados.add(1004500.00);
		
		assertTrue(valoresInvestimentoArrojadoEsperados.contains(poupanca.getSaldo()));
		
	}
	
	@Test
	public void deveEntenderTodosOsTiposDeInvestimento() {
		Conta poupanca = new Conta(Calendar.getInstance());
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
		valoresInvestimentoModeradoEsperados.add(101.13);
		valoresInvestimentoModeradoEsperados.add(102.49);
		
		List<Double> valoresInvestimentoArrojadoEsperados = new ArrayList<>();
		valoresInvestimentoArrojadoEsperados.add(104.92);
		valoresInvestimentoArrojadoEsperados.add(103.40);
		valoresInvestimentoArrojadoEsperados.add(101.58);
		valoresInvestimentoArrojadoEsperados.add(106.33);
		valoresInvestimentoArrojadoEsperados.add(104.79);
		valoresInvestimentoArrojadoEsperados.add(102.95);

		assertEquals(100.60, saldoComInvestimentoConservador,0.00001);
		assertTrue(valoresInvestimentoModeradoEsperados.contains(saldoComInvestimentoModerado));
		assertTrue(valoresInvestimentoArrojadoEsperados.contains(saldoComInvestimentoArrojado));
		
	}
}
