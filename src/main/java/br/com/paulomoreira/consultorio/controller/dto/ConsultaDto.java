package br.com.paulomoreira.consultorio.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.paulomoreira.consultorio.modelo.Consulta;

public class ConsultaDto {

	private Long id;
	private Long pacienteId;
	private Double peso;
	private Double altura;
	private String descricao;

	public ConsultaDto(Consulta consulta) {

		this.id = consulta.getId();
		this.pacienteId = consulta.getPacienteId();
		this.peso = consulta.getPeso();
		this.altura = consulta.getAltura();
		this.descricao = consulta.getDescricao();
	}

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

	public static List<ConsultaDto> converter(List<Consulta> consultas) {
		return consultas.stream().map(ConsultaDto::new).collect(Collectors.toList());
	}
}
