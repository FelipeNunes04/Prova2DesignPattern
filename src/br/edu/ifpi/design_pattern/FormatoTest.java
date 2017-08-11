package br.edu.ifpi.design_pattern;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Calendar;
import org.junit.Test;

public class FormatoTest {
	
	@Test
	public void deveEntenderRequisicaoDaPrimeiraRespostaInstamciada() {	 
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));
	    
		Conta conta = new Conta(Calendar.getInstance(), "Felipe");
		Requisicao requisicao = new Requisicao(Formato.XML);
		RespostaEmXml xml = new RespostaEmXml();
		RespostaEmCsv csv = new RespostaEmCsv();
		RespostaEmPorcento porcento = new RespostaEmPorcento();
		porcento.setProxima(xml);
		xml.setProxima(csv);
		porcento.responde(requisicao, conta);
		
		assertEquals("<conta><titular>Felipe</titular><saldo>0.0</saldo></conta>\n", outContent.toString());
		
	}
	
	@Test
	public void deveEntenderRequisicaoDaUltimaRespostaInstamciada() {	 
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));
	    
		Conta conta = new Conta(Calendar.getInstance(), "Felipe");
		Requisicao requisicao = new Requisicao(Formato.PORCENTO);
		RespostaEmXml xml = new RespostaEmXml();
		RespostaEmCsv csv = new RespostaEmCsv();
		RespostaEmPorcento porcento = new RespostaEmPorcento();
		porcento.setProxima(xml);
		xml.setProxima(csv);
		csv.setProxima(porcento);
		porcento.responde(requisicao, conta);
		
		assertEquals("Felipe%0.0\n", outContent.toString());
		
	}
}
