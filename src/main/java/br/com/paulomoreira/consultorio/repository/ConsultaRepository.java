package br.com.paulomoreira.consultorio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.paulomoreira.consultorio.modelo.Consulta;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

	List<Consulta> findByPacienteId(Long pacienteId);

	Consulta findOneById(Long id);

}
