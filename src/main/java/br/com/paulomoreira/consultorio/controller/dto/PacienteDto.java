package br.com.paulomoreira.consultorio.controller.dto;

import org.springframework.data.domain.Page;

import br.com.paulomoreira.consultorio.modelo.Paciente;

public class PacienteDto {
	
	private Long id;
	private String nome;
	private String sexo;
	private Double idade;
	private String endereco;
	private String telefone;
	private String email;

	public PacienteDto(Paciente paciente) {
		this.id = paciente.getId();
		this.nome = paciente.getNome();
		this.sexo = paciente.getSexo();
		this.idade = paciente.getIdade();
		this.telefone = paciente.getTelefone();
		this.endereco = paciente.getEndereco();
		this.email = paciente.getEmail();
	}

	public void PacienteDTO() {

	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getSexo() {
		return sexo;
	}

	public Double getIdade() {
		return idade;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getEmail() {
		return email;
	}

	public static Page<PacienteDto> converter(Page<Paciente> pacientes) {
		return pacientes.map(PacienteDto::new);
	}

}
