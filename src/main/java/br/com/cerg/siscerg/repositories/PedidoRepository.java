package br.com.cerg.siscerg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cerg.siscerg.entities.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

}
