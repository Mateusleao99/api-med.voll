package med.voll.api.paciente;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import med.voll.api.endereco.DadosEndereco;

public record DadosPaciente(
        @NotBlank
        String nome,
        @NotBlank
        @Email
        String email,
        @Pattern(regexp = "\\d{9}")
        @NotBlank
        String telefone,
        @Pattern(regexp = "\\d{11}")
        @NotBlank
        String cpf,
        DadosEndereco endereco) {
}
