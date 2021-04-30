package br.com.cerg.siscerg.entities;

import javax.persistence.Entity;

import br.com.cerg.siscerg.entities.enums.EstadoPagamento;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
 
@Entity
public class PagamentoComCartao extends Pagamento {
	private static final long serialVersionUID = 1L;
	
	private Integer numeroDeParcelas;
	
	public PagamentoComCartao() {
	}

	public PagamentoComCartao(Integer id, EstadoPagamento estado, Pedido pedido, Integer numeroDeParcelas) {
		super(id, estado, pedido);
		this.numeroDeParcelas = numeroDeParcelas;
	}
	
	
}
