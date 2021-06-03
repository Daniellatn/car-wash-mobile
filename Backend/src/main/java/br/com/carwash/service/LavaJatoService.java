package br.com.carwash.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.core.Response.Status;

import br.com.carwash.dao.LavaJatoDAO;
import br.com.carwash.dto.LavaJatoDTO;
import br.com.carwash.entity.LavaJato;
import br.com.carwash.exception.NotValidData;

public class LavaJatoService {

	LavaJatoDAO dao = new LavaJatoDAO(); 
	
	public List<LavaJatoDTO> econtrarLojas(Long id, String nomeLoja, String email, String cnpj) throws Exception {
		List<LavaJatoDTO> lojas = new ArrayList<LavaJatoDTO>();
		List<LavaJato> lojasEt = dao.getListLojas(id,nomeLoja,email,cnpj);
		for(LavaJato l : lojasEt) {
			lojas.add(new LavaJatoDTO(l));
		}
		return lojas;
	}

	public LavaJatoDTO encontraLoja(Long idLoja) throws Exception {
		LavaJato l =null;
		l = dao.find(idLoja);
		return new LavaJatoDTO(l);
	}

	public void cadastrarLoja(LavaJatoDTO loja) throws Exception {
		if(loja.getCnpj() == null || loja.getDataCadastro() == null || loja.getEmail() == null ||
				loja.getNomeLoja() == null)
			throw new NotValidData(Status.NOT_ACCEPTABLE,"faltando parametros");
		try {
			// TODO: loja.setDataCadastro();
			LavaJato l = new LavaJato(loja);
			dao.save(l);
		}catch(Exception e) {
			throw e;
		}
	}

}
