package br.com.carwash.dto;

import java.time.LocalDate;

import br.com.carwash.entity.Agendamento;

public class AgendamentoDTO {

	private long idCliente;
	private long idLavaJato;
	private LocalDate agendamento;
	public AgendamentoDTO() {
		
	}
	public AgendamentoDTO(Agendamento a) {
	idCliente = a.getCliente().getId();
	idLavaJato = a.getLavaJato().getId();
	agendamento = a.getDataAgendamento();
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
	public LocalDate getAgendamento() {
		return agendamento == null ? LocalDate.now() : agendamento;
	}
	public void setAgendamento(LocalDate agendamento) {
		this.agendamento = agendamento;
	}
}
