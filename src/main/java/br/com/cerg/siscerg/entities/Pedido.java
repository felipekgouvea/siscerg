package br.com.cerg.siscerg.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;

@Data

@Entity
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Date instante;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "pedido")
	private Pagamento pagamento;

	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name = "endereco_de_entrega_id")
	private Endereco enderecoDeEntraga;
	
	public Pedido() {
	}

	public Pedido(Integer id, Date instante,  Cliente cliente, Endereco enderecoDeEntraga) {
		super();
		this.id = id;
		this.instante = instante;
		this.cliente = cliente;
		this.enderecoDeEntraga = enderecoDeEntraga;
	}
	
}
