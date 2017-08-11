package br.edu.ifpi.design_pattern;

import java.util.ArrayList;
import java.util.List;

public class FiltroMenorQueCemReais extends Filtro{
	public FiltroMenorQueCemReais(Filtro proximoFiltro) {
		super(proximoFiltro);
	}
	
	public FiltroMenorQueCemReais() {
		super();
	}

	@Override
	public List<Conta> filtra(List<Conta> contas) {
		List<Conta> novaListaDeContas = new ArrayList<>();
		for (Conta c : contas) {
			if(c.getSaldo()<100){
				novaListaDeContas.add(c);
			}
		}
		novaListaDeContas.addAll(proximo(contas));
        return novaListaDeContas;
	}
}
