package br.com.paulomoreira.consultorio.controller.form;

import br.com.paulomoreira.consultorio.modelo.Consulta;
import br.com.paulomoreira.consultorio.repository.ConsultaRepository;

public class ConsultaForm {
	private Long id;
	private Long pacienteId;
	private Double peso;
	private Double altura;
	private String descricao;

	
	
	public Long getPacienteId() {
		return pacienteId;
	}

	public void setPacienteId(Long pacienteId) {
		this.pacienteId = pacienteId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Consulta converter(ConsultaRepository consultaRepository) {

		return new Consulta(id,pacienteId,peso,altura,descricao);
	}


}
