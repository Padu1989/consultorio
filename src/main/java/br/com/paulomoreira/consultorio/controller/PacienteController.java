package br.com.paulomoreira.consultorio.controller;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.paulomoreira.consultorio.controller.dto.ConsultaDto;
import br.com.paulomoreira.consultorio.controller.dto.DetalhesDoPacienteDto;
import br.com.paulomoreira.consultorio.controller.dto.PacienteDto;
import br.com.paulomoreira.consultorio.controller.form.AtualizacaoConsultaForm;
import br.com.paulomoreira.consultorio.controller.form.AtualizacaoPacienteForm;
import br.com.paulomoreira.consultorio.controller.form.ConsultaForm;
import br.com.paulomoreira.consultorio.controller.form.PacienteForm;
import br.com.paulomoreira.consultorio.modelo.Consulta;
import br.com.paulomoreira.consultorio.modelo.Paciente;
import br.com.paulomoreira.consultorio.repository.ConsultaRepository;
import br.com.paulomoreira.consultorio.repository.PacienteRepository;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

	@Autowired
	private PacienteRepository pacienteRepository;
	@Autowired
	private ConsultaRepository consultaRepository;

	@GetMapping
	public Page<PacienteDto> lista(@RequestParam (required = false) String telefone, 
			@PageableDefault(sort="id", direction = Direction.ASC, page = 0, size=10) Pageable paginacao
			) {
		if (telefone == null) {
			Page<Paciente> pacientes = pacienteRepository.findAll(paginacao);
			return PacienteDto.converter(pacientes);
		} else {
			Page<Paciente> pacientes = pacienteRepository.findByTelefone(telefone, paginacao);
			return PacienteDto.converter(pacientes);
		}
	}
	
	@GetMapping("/{telefone}")
	public List<DetalhesDoPacienteDto> detalhar(@PathVariable String telefone) {
		List<Paciente> pacientes = pacienteRepository.findByTelefone(telefone);
		return DetalhesDoPacienteDto.converter(pacientes);
	}
	
	@GetMapping(path = "/consultas/{pacienteId}")
	public List<ConsultaDto> detalharConsultas(@PathVariable Long pacienteId){
		
		if(pacienteId == null) {
			List<Consulta> consultas = consultaRepository.findAll();
			return ConsultaDto.converter(consultas);
		}else {
		
		List<Consulta> consultas = consultaRepository.findByPacienteId(pacienteId);
		return ConsultaDto.converter(consultas);	
		
		}
	}
	
	@PostMapping
	public ResponseEntity<PacienteDto> cadastrar(@RequestBody @Valid PacienteForm form, UriComponentsBuilder uriBuilder) {
		Paciente paciente = form.converter(pacienteRepository);
		pacienteRepository.save(paciente);

		URI uri = uriBuilder.path("/paciente/{id}").buildAndExpand(paciente.getTelefone()).toUri();
		return ResponseEntity.created(uri).body(new PacienteDto(paciente));
	}
	
	@PostMapping (path = "/consultas")
	public ResponseEntity<ConsultaDto> cadastrarConsulta(@RequestBody @Valid ConsultaForm form, UriComponentsBuilder uriBuilder) {
		Consulta consulta = form.converter(consultaRepository);
		consultaRepository.save(consulta);

		URI uri = uriBuilder.path("/paciente/{id}/consultas").buildAndExpand(consulta.getId()).toUri();
		return ResponseEntity.created(uri).body(new ConsultaDto(consulta));
	}

	@PutMapping("{telefone}")
	@Transactional
	public ResponseEntity<PacienteDto> atualizar(@PathVariable String telefone, @RequestBody @Valid AtualizacaoPacienteForm form) {
		Paciente paciente = form.atualizar(telefone, pacienteRepository);
		return ResponseEntity.ok(new PacienteDto(paciente));
	} 
	
	public ResponseEntity<ConsultaDto> atualizarConsulta(@PathVariable Long id, @RequestBody @Valid AtualizacaoConsultaForm form){
		Consulta consulta = form.atualizarConsulta(id, consultaRepository);
		return ResponseEntity.ok(new ConsultaDto(consulta));
	}
	
	
	
	
	
	@DeleteMapping("{telefone}")
	@Transactional
	public ResponseEntity<PacienteDto> deletar(@PathVariable String telefone){
		pacienteRepository.deleteByTelefone(telefone);
		return ResponseEntity.ok().build();
	}
}
