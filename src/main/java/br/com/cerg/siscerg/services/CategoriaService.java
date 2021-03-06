package br.com.cerg.siscerg.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.cerg.siscerg.entities.Categoria;
import br.com.cerg.siscerg.repositories.CategoriaRepository;
import br.com.cerg.siscerg.services.exceptions.DataIntegrityException;
import br.com.cerg.siscerg.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	public Categoria find(Integer id) {
		Optional<Categoria> obj = categoriaRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
													"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName() ));
	}

	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return categoriaRepository.save(obj);
	}

	public Categoria update(Categoria obj) {
		find(obj.getId());
		return categoriaRepository.save(obj);
	}

	public void delete(Integer id) {
		find(id);		
		try {
			categoriaRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel excluir uma categoria que possui produtos ");
		}		
	}

	public List<Categoria> findAll() {
		return categoriaRepository.findAll();
	}
}
