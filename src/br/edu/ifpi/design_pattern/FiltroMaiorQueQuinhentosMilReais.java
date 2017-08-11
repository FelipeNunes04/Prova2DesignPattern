package br.edu.ifpi.design_pattern;

import java.util.ArrayList;
import java.util.List;

public class FiltroMaiorQueQuinhentosMilReais extends Filtro{
	public FiltroMaiorQueQuinhentosMilReais(Filtro proximoFiltro) {
        super(proximoFiltro);
	}
	
	public FiltroMaiorQueQuinhentosMilReais() {
		super();
	}
	
	@Override
	public List<Conta> filtra(List<Conta> contas) {
		List<Conta> novaListaDeContas = new ArrayList<Conta>();
	    for(Conta c : contas) {
	      if(c.getSaldo() > 500000) novaListaDeContas.add(c);
	    }
	
	    novaListaDeContas.addAll(proximo(contas));
	    return novaListaDeContas;
	  }

}
