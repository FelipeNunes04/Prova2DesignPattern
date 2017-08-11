package br.edu.ifpi.design_pattern;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class FiltroAberturaNoMesCorrente extends Filtro{
	public FiltroAberturaNoMesCorrente(Filtro proximoFiltro) {
		super(proximoFiltro);
    }

	public FiltroAberturaNoMesCorrente() {
		super();
    }

	public List<Conta> filtra(List<Conta> contas) {
		List<Conta> novaListaDeContas = new ArrayList<Conta>();
		for(Conta c : contas) {
			if(c.getDataAbertura().get(Calendar.MONTH) == Calendar.getInstance().get(Calendar.MONTH) && 
				c.getDataAbertura().get(Calendar.YEAR) == Calendar.getInstance().get(Calendar.YEAR)) {
				novaListaDeContas.add(c);
			}
		}

		novaListaDeContas.addAll(proximo(contas));
	    return novaListaDeContas;
  
	}
	
}
