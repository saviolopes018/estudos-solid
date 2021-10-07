package br.com.rh.service;

import java.math.BigDecimal;

import br.com.rh.model.Funcionario;

public interface ValidacaoReajuste {
	
	void validar(Funcionario funcionario, BigDecimal aumento);
	
}
