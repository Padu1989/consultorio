package br.com.paulomoreira.consultorio.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.paulomoreira.consultorio.modelo.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {

	Page<Paciente> findByTelefone(String telefone, Pageable paginacao);
	Paciente findOneByTelefone(String telefone);
	List<Paciente> deleteByTelefone(String telefone);
	List<Paciente> findByTelefone (String telefone);
}
