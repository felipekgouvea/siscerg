package br.com.cerg.siscerg.entities;

import java.util.Date;

import javax.persistence.Entity;

import br.com.cerg.siscerg.entities.enums.EstadoPagamento;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
public class PagamentoComBoleto extends Pagamento {
	private static final long serialVersionUID = 1L;
	
	private Date dataPagamento;
	private Date dataVencimento;
	
	public PagamentoComBoleto() {
	}

	public PagamentoComBoleto(Integer id, EstadoPagamento estado, Pedido pedido, Date dataPagamento, Date dataVencimento) {
		super(id, estado, pedido);
		this.dataPagamento = dataPagamento;
		this.dataVencimento = dataVencimento;	
	}
	
	
}
