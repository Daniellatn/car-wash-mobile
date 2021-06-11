package br.com.carwash.dto;

import java.util.Date;

import javax.xml.stream.Location;

import br.com.carwash.entity.Agendamento;

public class AgendamentoDTO {

	private Long idAgendamento;
	private Long idCliente;
	private Long idLavaJato;
	private Date agendamento;
	private Location local;

	public AgendamentoDTO() {

	}

	public AgendamentoDTO(Agendamento a) {
		idAgendamento = a.getId();
		idCliente = a.getCliente().getId();
		idLavaJato = a.getLavaJato().getId();
		agendamento = a.getDataAgendamento();
		local = a.getLavaJato().getLocalizacao();
	}

	public long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}

	public long getIdLavaJato() {
		return idLavaJato;
	}

	public void setIdLavaJato(long idLavaJato) {
		this.idLavaJato = idLavaJato;
	}

	public Date getAgendamento() {
		return agendamento;
	}

	public void setAgendamento(Date agendamento) {
		this.agendamento = agendamento;
	}

	public Long getIdAgendamento() {
		return idAgendamento;
	}

	public void setIdAgendamento(Long idAgendamento) {
		this.idAgendamento = idAgendamento;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public void setIdLavaJato(Long idLavaJato) {
		this.idLavaJato = idLavaJato;
	}

	public Location getLocal() {
		return local;
	}

	public void setLocal(Location local) {
		this.local = local;
	}
}
