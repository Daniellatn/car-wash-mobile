package br.com.carwash.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.ws.rs.core.Response.Status;

import br.com.carwash.dao.LojaDAO;
import br.com.carwash.dao.ProdutoDAO;
import br.com.carwash.dto.ProdutoCadastroDTO;
import br.com.carwash.dto.ProdutoDTO;
import br.com.carwash.dto.ProdutoLojaDTO;
import br.com.carwash.entity.Produto;
import br.com.carwash.exception.NotValidDataException;

public class ProdutoService {

	final static ProdutoDAO dao = new ProdutoDAO();
	final static LojaDAO lojaDao = new LojaDAO();
	
	public void criarProduto(ProdutoCadastroDTO produto) throws Exception {
		if(!produto.isValidToCreate())
			throw new NotValidDataException(Status.BAD_REQUEST,"missing arguments");
		Produto p = produto.toEntity();
		p.setLoja(lojaDao.find(produto.getLojaId()));
		dao.save(p);
	}

	public List<ProdutoLojaDTO> encontrarProdutoPorLojaId(Long idLoja,Long idProduto,String nomeProduto) {
		List<Produto> produtos = dao.econtraProdutoELojaPorIdLoja(idLoja,idProduto,nomeProduto);
		List<ProdutoLojaDTO> produtosDto = new ArrayList<ProdutoLojaDTO>();
		for(Produto p : produtos) {
			produtosDto.add(new ProdutoLojaDTO(p));
		}
		return produtosDto;
	}

	public ProdutoDTO encontrarProdutoPorId(Long idProduto) throws Exception {
		Produto p = dao.find(idProduto);
		if(Objects.isNull(p))throw new NotValidDataException(Status.NOT_FOUND,"Não encontrado");
		return new ProdutoDTO(p);
	}
}
