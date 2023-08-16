package med.voll.api.medico;

public record DadosListagemMedico(Long id, boolean ativo, String nome, String email, String crm, Especialidade especialidade) {
    public DadosListagemMedico(Medico medico){
        this(medico.getId(), medico.getAtivo(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}
