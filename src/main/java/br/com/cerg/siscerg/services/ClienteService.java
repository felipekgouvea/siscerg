package br.com.cerg.siscerg.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cerg.siscerg.entities.Cliente;
import br.com.cerg.siscerg.repositories.ClienteRepository;
import br.com.cerg.siscerg.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository categoriaRepository;

	public Cliente find(Integer id) {
		Optional<Cliente> obj = categoriaRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
													"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName() ));
	}

}
