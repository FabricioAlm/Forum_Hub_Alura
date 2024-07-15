package br.com.alura.forumhub.domain.topico;

import jakarta.validation.constraints.NotNull;

public record AtualizacaoTopico(
        @NotNull(message = "Faltou informar o id do registro")
        Long id,
        @NotNull(message = "Título é obrigatório")
        String titulo,
        @NotNull(message = "Mensagem é obrigatório")
        String mensagem) {
}