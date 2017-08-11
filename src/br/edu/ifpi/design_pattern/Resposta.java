package br.edu.ifpi.design_pattern;

public interface Resposta {
	void responde(Requisicao req, Conta conta);
    void setProxima(Resposta resposta);
}
