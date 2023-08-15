package med.voll.api.endereco;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.medico.DadosAtualizacaoMedico;

import java.util.function.Supplier;

import static med.voll.api.extensions.StringExtensions.atualizarSeNaoNulo;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {
    @NotBlank
    private String logradouro;
    @NotBlank
    private String bairro;
    @NotBlank
    @Pattern(regexp = "\\d{8}")
    private String cep;
    @NotBlank
    private String numero;
    private String complemento;
    @NotBlank
    private String cidade;
    private String uf;

    public Endereco(DadosEndereco dados) {
        this.logradouro = dados.logradouro();
        this.bairro = dados.bairro();
        this.cep = dados.cep();
        this.numero = dados.numero();
        this.complemento = dados.complemento();
        this.cidade = dados.cidade();
        this.uf = dados.uf();
    }

    public void atualizarInformacoes(DadosEndereco dados) {
        if(dados != null){
            this.logradouro = atualizarSeNaoNulo(this.logradouro, dados::logradouro);
            this.bairro = atualizarSeNaoNulo(this.bairro, dados::bairro);
            this.cep = atualizarSeNaoNulo(this.cep, dados::cep);
            this.uf = atualizarSeNaoNulo(this.uf, dados::uf);
            this.cidade = atualizarSeNaoNulo(this.cidade, dados::cidade);
            this.numero = atualizarSeNaoNulo(this.numero, dados::numero);
            this.complemento = atualizarSeNaoNulo(this.complemento, dados::complemento);
        }
    }

}
