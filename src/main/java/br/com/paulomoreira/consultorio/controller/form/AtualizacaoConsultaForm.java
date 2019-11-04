package br.com.paulomoreira.consultorio.controller.form;

import br.com.paulomoreira.consultorio.modelo.Consulta;
import br.com.paulomoreira.consultorio.repository.ConsultaRepository;

public class AtualizacaoConsultaForm {

	private Long id;
	private Long pacienteId;
	private Double peso;
	private Double altura;
	private String descricao;
	
	public Consulta atualizarConsulta(Long id, ConsultaRepository consultaRepository) {
		Consulta consulta = consultaRepository.findOneById(id);
		consulta.setAltura(this.altura);
		consulta.setPacienteId(this.id);
		consulta.setDescricao(this.descricao);
		consulta.setPeso(this.peso);
		return consulta;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getPacienteId() {
		return pacienteId;
	}
	public void setPacienteId(Long pacienteId) {
		this.pacienteId = pacienteId;
	}
	public Double getPeso() {
		return peso;
	}
	public void setPeso(Double peso) {
		this.peso = peso;
	}
	public Double getAltura() {
		return altura;
	}
	public void setAltura(Double altura) {
		this.altura = altura;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	
	
	
	
}
