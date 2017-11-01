package br.unincor.controle;

import br.unincor.exception.PrecoZeradoException;
import br.unincor.model.Produto;
import br.unincor.model.Sanduiche;
import br.unincor.model.Sobremesa;

public class CalculoPrecos {
	
	/**
	 * Primeiro deve-se testar se o preço do produto não está 'null'
	 * 		- Caso o preço esteja zerado ('null'), lançar uma PrecoZeradoException
	 * 
	 * Realizar o cálculo do preço final do produto seguindo as regras:
	 * 
	 * Sanduiche:
	 * 		- Trio: se for TRUE acrescenta R$XX,XX no preço (valor referente a batata e bebida)
	 * 		- Dobro de recheio: ser for TRUE acresce o preço em XX%
	 * 
	 * Sobremesa:
	 * 		- Adicionais: se for TRUE acresce o preço em XX%
	 * 
	 */
	private void calculaPrecoFinal(Produto p) throws PrecoZeradoException {
		if(p.getPreco() != null){
			
			if(p instanceof Sanduiche){
				Sanduiche sanduiche = (Sanduiche)p;
				if(sanduiche.getTrio()){
					sanduiche.setPreco(sanduiche.getPreco() + 20.00);
				} else {
					sanduiche.setPreco(sanduiche.getPreco()*4.0);					
				}
			} else if(p instanceof Sobremesa){
				Sobremesa sobremesa = (Sobremesa)p;
				if(sobremesa.getAdicionais()){
					sobremesa.setAdicionais(sobremesa.getPreco()*0.5);
				}
			}
		} else {
			throw new PrecoZeradoException(p);
		}
		
	}
	
	public void pagtoDinheiro(Produto p) throws PrecoZeradoException {
		p.setPreco(p.getPreco()-0.5);
	}
	
	public void pagtoCartao(Produto p) throws PrecoZeradoException {
		p.setPreco(p.getPreco()-1.0);
	}

}
