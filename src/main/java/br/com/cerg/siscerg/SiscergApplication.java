package br.com.cerg.siscerg;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.cerg.siscerg.entities.Categoria;
import br.com.cerg.siscerg.entities.Cidade;
import br.com.cerg.siscerg.entities.Cliente;
import br.com.cerg.siscerg.entities.Endereco;
import br.com.cerg.siscerg.entities.Estado;
import br.com.cerg.siscerg.entities.Produto;
import br.com.cerg.siscerg.entities.enums.TipoCliente;
import br.com.cerg.siscerg.repositories.CategoriaRepository;
import br.com.cerg.siscerg.repositories.CidadeRepository;
import br.com.cerg.siscerg.repositories.ClienteRepository;
import br.com.cerg.siscerg.repositories.EnderecoRepository;
import br.com.cerg.siscerg.repositories.EstadoRepository;
import br.com.cerg.siscerg.repositories.ProdutoRepository;

@SpringBootApplication
public class SiscergApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;	
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SiscergApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));		
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		Estado est1 = new Estado(null, "São Paulo");
		Estado est2 = new Estado(null, "Espírito Santo");
		
		Cidade c1 = new Cidade(null, "São Paulo", est1);
		Cidade c2 = new Cidade(null, "Vitória", est2);
		Cidade c3 = new Cidade(null, "Cariacica", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2, c3));		
		
		Cliente cli1 = new Cliente(null, "Felipe Kinupes Gouvêa", "felipekinupesg@hotmaill.com", "11686645783", TipoCliente.PESSOAFISICA);
		Cliente cli2 = new Cliente(null, "Centro Educacional R.G. LTDA", "secretaria@ceribeirogouvea.com.br", "39807565000110", TipoCliente.PESSOAJURIDICA);
		Cliente cli3 = new Cliente(null, "Marcela Dias Martins", "marcela@ceribeirogouvea.com.br", "37480745874", TipoCliente.PESSOAFISICA);
		
		cli1.getTelefones().addAll(Arrays.asList("997086617"));
		cli2.getTelefones().addAll(Arrays.asList("999800033", "33868370"));
		cli3.getTelefones().addAll(Arrays.asList("999963992"));
		
		Endereco end1 = new Endereco(null, "Rua João Bubach", "84", "", "Cruzeiro do Sul", "29144030", cli1, c3);
		Endereco end2 = new Endereco(null, "Rua João Bubach", "95", "", "Cruzeiro do Sul", "29144030", cli2, c3);
		Endereco end3 = new Endereco(null, "Rua João Bubach", "84", "", "Cruzeiro do Sul", "29144030", cli3, c3);
		
		clienteRepository.saveAll(Arrays.asList(cli1,cli2,cli3));
		enderecoRepository.saveAll(Arrays.asList(end1,end2,end3));
	}
}
