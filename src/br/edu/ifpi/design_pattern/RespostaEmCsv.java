package br.edu.ifpi.design_pattern;

public class RespostaEmCsv implements Resposta{
	private Resposta outraResposta;
	@Override
	public void responde(Requisicao req, Conta conta) {
		// TODO Auto-generated method stub
		if(req.getFormato() == Formato.CSV) {
			System.out.println(conta.getTitular() + "," + conta.getSaldo());
	    }
	    else {
	    	outraResposta.responde(req, conta);
	    }
	}

	@Override
	public void setProxima(Resposta resposta) {
		// TODO Auto-generated method stub
		this.outraResposta = resposta;
	}

}
