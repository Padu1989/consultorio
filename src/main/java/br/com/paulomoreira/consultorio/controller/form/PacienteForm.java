package br.com.paulomoreira.consultorio.controller.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;

import br.com.paulomoreira.consultorio.modelo.Paciente;
import br.com.paulomoreira.consultorio.repository.PacienteRepository;

public class PacienteForm {
	
	@NotNull @NotEmpty
	private String nome;
	@NotNull @NotEmpty
	private String sexo;
	private Double idade;
	@NotNull @NotEmpty
	private String endereco;
	@NotNull @NotEmpty
	private String telefone;
	@NotNull @NotEmpty @Email
	private String email;

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

	public Paciente converter(PacienteRepository pacienteRepository) {
		return new Paciente(nome, sexo, idade, endereco, telefone, email);
	}

}
