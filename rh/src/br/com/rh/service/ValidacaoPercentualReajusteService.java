package br.com.rh.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.rh.ValidacaoException;
import br.com.rh.model.Funcionario;

public class ValidacaoPercentualReajusteService implements ValidacaoReajuste{
	
	public void validar(Funcionario funcionario, BigDecimal aumento) {
		BigDecimal salarioAtual = funcionario.getDadosPessoais().getSalario();
		BigDecimal percentualReajuste = aumento.divide(salarioAtual, RoundingMode.HALF_UP);
		if(percentualReajuste.compareTo(new BigDecimal("0.4")) > 0) {
			throw new ValidacaoException("Reajuste n�o pode ser superior a 40% do sal�rio");
		}
	}

}
