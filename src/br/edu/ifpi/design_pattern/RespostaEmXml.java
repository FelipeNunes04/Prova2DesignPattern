package br.edu.ifpi.design_pattern;

public class RespostaEmXml implements Resposta{
	private Resposta outraResposta;
	@Override
	public void responde(Requisicao req, Conta conta) {
		// TODO Auto-generated method stub
		if(req.getFormato() == Formato.XML) {
			System.out.println("<conta><titular>" + conta.getTitular() + "</titular><saldo>" + conta.getSaldo() + "</saldo></conta>");
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
