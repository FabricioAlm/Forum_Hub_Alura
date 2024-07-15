package br.com.alura.forumhub.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CadastroTopico(
        @NotBlank(message = "Titulo é obrigatoório")
        String titulo,
        @NotBlank(message = "Mensagem é obrigatoório")
        String mensagem,
        @NotNull(message = "Curso é obrigatoório")
        Curso curso){
}