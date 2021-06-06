package br.com.carwash.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response.Status;

import br.com.carwash.dao.LojaDAO;
import br.com.carwash.dto.LojaDTO;
import br.com.carwash.entity.Loja;
import br.com.carwash.exception.NotValidDataException;

public class LavaJatoService {

	LojaDAO dao = new LojaDAO(); 
	
	public List<LojaDTO> econtrarLojas(Long id, String nomeLoja, String email, String cnpj) throws Exception {
		List<LojaDTO> lojas = new ArrayList<LojaDTO>();
		List<Loja> lojasEt = dao.getListLojas(id,nomeLoja,email,cnpj);
		for(Loja l : lojasEt) {
			lojas.add(new LojaDTO(l));
		}
		return lojas;
	}

	public LojaDTO encontraLoja(Long idLoja) throws Exception {
		Loja l =null;
		l = dao.find(idLoja);
		if(l == null)
			throw new NotValidDataException(Status.NOT_FOUND,"Elemento inexistente");
		return new LojaDTO(l);
	}

	public void cadastrarLoja(LojaDTO loja) throws Exception {
		if(loja.getCnpj() == null ||  loja.getEmail() == null ||
				loja.getNomeLoja() == null )
			throw new NotValidDataException(Status.NOT_ACCEPTABLE,"faltando parametros");
		try {
			// TODO: loja.setDataCadastro();
			Loja l = new Loja(loja);
			l.setDataCadastro(LocalDate.now());
			dao.save(l);
		}catch(Exception e) {
			throw e;
		}
	}

	public void excluirLoja(Long idLoja) throws Exception {
		dao.delete(idLoja);
	}

	public void editarLoja(LojaDTO lavajato) throws Exception {
		Loja loja= dao.find(lavajato.getId());
		dao.update(loja.toEtity(lavajato));
	}

}
