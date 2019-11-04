package br.com.paulomoreira.consultorio.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.paulomoreira.consultorio.modelo.Paciente;

public class DetalhesDoPacienteDto {
	private Long id;
	private String nome;
	private String sexo;
	private Double idade;
	private String endereco;
	private String telefone;
	private String email;

	public DetalhesDoPacienteDto(Paciente paciente) {
		super();
		this.id = paciente.getId();
		this.nome = paciente.getNome();
		this.sexo = paciente.getSexo();
		this.idade = paciente.getIdade();
		this.endereco = paciente.getEndereco();
		this.telefone = paciente.getTelefone();
		this.email = paciente.getEmail();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Double getIdade() {
		return idade;
	}

	public void setIdade(Double idade) {
		this.idade = idade;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public static List<DetalhesDoPacienteDto> converter(List<Paciente> pacientes) {
		// Método de conversão de Consulta para ConsultaDto.
		return pacientes.stream().map(DetalhesDoPacienteDto::new).collect(Collectors.toList());
	}

}
