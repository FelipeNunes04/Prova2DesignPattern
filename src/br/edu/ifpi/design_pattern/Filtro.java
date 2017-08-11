package br.edu.ifpi.design_pattern;

import java.util.ArrayList;
import java.util.List;

abstract class Filtro {
    protected Filtro proximoFiltro;

    public Filtro(Filtro proximoFiltro) {
    	this.proximoFiltro = proximoFiltro;
    }

    public Filtro() {
    	
    }

    public abstract List<Conta> filtra(List<Conta> contas);

    protected List<Conta> proximo(List<Conta> contas) {
    	if(proximoFiltro != null) return proximoFiltro.filtra(contas);
    	else return new ArrayList<Conta>();
    }
  }
