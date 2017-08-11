package br.edu.ifpi.design_pattern;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.junit.Test;

public class FiltroTest {
	@Test
	public void devePegarTodasAsContas() {
		List<Conta> contas = new ArrayList<>();
		Conta c1 = new Conta(Calendar.getInstance());
		c1.deposita(180);
		Conta c2 = new Conta(Calendar.getInstance());
		c2.deposita(5000001);
		Conta c3 = new Conta(Calendar.getInstance());
		c3.deposita(90);
		contas.add(c1);
		contas.add(c2);
		contas.add(c3);
		
		FiltroAberturaNoMesCorrente mesCorrente = new FiltroAberturaNoMesCorrente();
		FiltroMaiorQueQuinhentosMilReais maiorQueQuinhentosMil = new FiltroMaiorQueQuinhentosMilReais(mesCorrente);
		FiltroMenorQueCemReais menorQueCem = new FiltroMenorQueCemReais(maiorQueQuinhentosMil);
		
		List<Conta> contasFiltradas = menorQueCem.filtra(contas);
		
		assertTrue(contasFiltradas.contains(c1));
		assertTrue(contasFiltradas.contains(c2));
		assertTrue(contasFiltradas.contains(c3));

	}
	
	@Test
	public void devePegarUmaContaSoPeloMesDeAbertura() {
		List<Conta> contas = new ArrayList<>();
		Calendar c = Calendar.getInstance();
		c.set(Calendar.MONTH, 1);
		Conta c1 = new Conta(c);
		c1.deposita(180);
		Conta c2 = new Conta(c);
		c2.deposita(500000);
		Conta c3 = new Conta(Calendar.getInstance());
		c3.deposita(90);
		contas.add(c1);
		contas.add(c2);
		contas.add(c3);
		
		FiltroAberturaNoMesCorrente mesCorrente = new FiltroAberturaNoMesCorrente();
		FiltroMaiorQueQuinhentosMilReais maiorQueQuinhentosMil = new FiltroMaiorQueQuinhentosMilReais(mesCorrente);
		FiltroMenorQueCemReais menorQueCem = new FiltroMenorQueCemReais(maiorQueQuinhentosMil);
		
		List<Conta> contasFiltradas = menorQueCem.filtra(contas);
		
		assertFalse(contasFiltradas.contains(c1));
		assertFalse(contasFiltradas.contains(c2));
		assertTrue(contasFiltradas.contains(c3));

	}
}
