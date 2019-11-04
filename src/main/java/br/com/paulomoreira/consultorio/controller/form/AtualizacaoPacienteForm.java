package br.com.paulomoreira.consultorio.controller.form;

import br.com.paulomoreira.consultorio.modelo.Paciente;
import br.com.paulomoreira.consultorio.repository.PacienteRepository;

public class AtualizacaoPacienteForm {
	
	private String nome;
	private String sexo;
	private Double idade;
	private String endereco;
	private String telefone;
	private String email;

	
	public Paciente atualizar(String telefone, PacienteRepository pacienteRepository) {
		Paciente paciente = pacienteRepository.findOneByTelefone(telefone);
		paciente.setNome(this.nome);
		paciente.setSexo(this.sexo);
		paciente.setIdade(this.idade);
		paciente.setTelefone(this.telefone);
		paciente.setEndereco(this.endereco);
		paciente.setEmail(this.email);
		
		return paciente;
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

	}

