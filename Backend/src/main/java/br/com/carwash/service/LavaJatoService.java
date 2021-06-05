package br.com.carwash.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response.Status;

import br.com.carwash.dao.LavaJatoDAO;
import br.com.carwash.dto.LavaJatoDTO;
import br.com.carwash.entity.Loja;
import br.com.carwash.exception.NotValidData;

public class LavaJatoService {

	LavaJatoDAO dao = new LavaJatoDAO(); 
	
	public List<LavaJatoDTO> econtrarLojas(Long id, String nomeLoja, String email, String cnpj) throws Exception {
		List<LavaJatoDTO> lojas = new ArrayList<LavaJatoDTO>();
		List<Loja> lojasEt = dao.getListLojas(id,nomeLoja,email,cnpj);
		for(Loja l : lojasEt) {
			lojas.add(new LavaJatoDTO(l));
		}
		return lojas;
	}

	public LavaJatoDTO encontraLoja(Long idLoja) throws Exception {
		Loja l =null;
		l = dao.find(idLoja);
		return new LavaJatoDTO(l);
	}

	public void cadastrarLoja(LavaJatoDTO loja) throws Exception {
		if(loja.getCnpj() == null ||  loja.getEmail() == null ||
				loja.getNomeLoja() == null)
			throw new NotValidData(Status.NOT_ACCEPTABLE,"faltando parametros");
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

	public void editarLoja(LavaJatoDTO lavajato) throws Exception {
		Loja loja= dao.find(lavajato.getId());
		dao.update(loja.toEtity(lavajato));
	}

}
