package br.com.rh.service;

import java.math.BigDecimal;
import java.util.List;

import br.com.rh.model.Funcionario;

public class ReajusteService {
	
	public ReajusteService(List<ValidacaoReajuste> validacoes) {
		super();
	}

	public void reajustarSalarioDoFuncionario(Funcionario funcionario, BigDecimal aumento) {
		
		ValidacaoPercentualReajusteService validacaoPercentualReajuste = new ValidacaoPercentualReajusteService();
		ValidacaoPeriocidadeReajuste validacaoPeriocidadeReajuste = new ValidacaoPeriocidadeReajuste();
		
		validacaoPercentualReajuste.validar(funcionario, aumento);
		validacaoPeriocidadeReajuste.validar(funcionario, aumento);
		
		BigDecimal salarioReajustado = funcionario.getDadosPessoais().getSalario().add(aumento);
		funcionario.atualizarSalario(salarioReajustado);
	}

}
