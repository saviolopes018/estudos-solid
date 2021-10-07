package br.com.rh.service;

import br.com.rh.ValidacaoException;
import br.com.rh.model.Cargo;
import br.com.rh.model.Funcionario;

public class PromocaoService {
	
	public void promover(Funcionario funcionario, boolean metaBatida) {
		Cargo cargoAtual = funcionario.getDadosPessoais().getCargo();
		if(Cargo.GERENTE == cargoAtual) {
			throw new ValidacaoException("Gerentes n�o podem ser promovidos!");
		}
		
		if(metaBatida) {
			Cargo novoCargo = cargoAtual.getProximoCargo();
			funcionario.promover(novoCargo);
		}else {
			throw new ValidacaoException("Funcion�rio n�o bateu a meta");
		}
	}

}
