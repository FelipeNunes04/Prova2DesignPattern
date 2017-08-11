package br.edu.ifpi.design_pattern;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;

public class DepositoESaqueTest {
	
	@Test(expected=RuntimeException.class)
	public void deveEntenderSaquesComSaldoNegativo() {
		Conta corrente = new Conta(Calendar.getInstance());
		corrente.saca(1);
		corrente.saca(1);
	}
	
	@Test
	public void deveEntenderSaquesEDepositosComSaldoPositivo() {
		Conta corrente = new Conta(Calendar.getInstance());
		corrente.deposita(100);
		corrente.saca(50);
		
		Assert.assertEquals(48, corrente.getSaldo(),0.01);

	}
	
	@Test
	public void deveEntenderSaldoNegativoESaldoPositivo() {
		Conta corrente = new Conta(Calendar.getInstance());
		corrente.deposita(100);
		corrente.saca(100);
		Assert.assertEquals(Negativo.class, corrente.getEstadoAtual().getClass());

	}
}
