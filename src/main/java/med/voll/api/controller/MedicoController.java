package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping("cadastrar")
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados){
        Medico medicoEntidade = new Medico(dados);
        repository.save(medicoEntidade);
    }
    @GetMapping("listar")
    public Page<DadosListagemMedico> listar(@PageableDefault(size = 10, page=0, sort = {"nome"}) Pageable paginacao) {
        return  repository.findAllByAtivoIsTrue(paginacao).map(DadosListagemMedico::new);
    }
    @PutMapping("atualizar")
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados){
        var medico = repository.getReferenceById((dados.id()));
        medico.atualizarInformacoes(dados);
    }
    @DeleteMapping("excluir/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        var medico = repository.getReferenceById(id);
        medico.desativarMedico();
    }
}
