package br.com.alura.forumhub.domain.topico;

import java.time.LocalDateTime;

public record ListagemTopico(
                             Long id,
                             String titulo,
                             String mensagem,
                             LocalDateTime dataCriacao) {
    public ListagemTopico(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.getData());
    }
}