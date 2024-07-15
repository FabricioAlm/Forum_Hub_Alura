package br.com.alura.forumhub.domain.topico;

import br.com.alura.forumhub.domain.usuario.Autor;
import java.time.LocalDateTime;

public record DetalhamentoTopico(
        Long id,
        String titulo,
        String mensagem,
        Curso curso,
        Status status,
        LocalDateTime dataCriacao,
        Autor autor) {

    public DetalhamentoTopico(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.getCurso(), topico.getStatus(), topico.getData(), topico.getAutor());
    }
}