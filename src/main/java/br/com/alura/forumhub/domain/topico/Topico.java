package br.com.alura.forumhub.domain.topico;

import br.com.alura.forumhub.domain.usuario.Autor;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String titulo;
    @NotBlank
    private String mensagem;
    @Enumerated(EnumType.STRING)
    private Curso curso;
    private Status status;
    @Column
    private LocalDateTime data;
    private Autor autor;

    public Topico(CadastroTopico dados) {
        this.ativo = true;
        this.titulo = dados.titulo();
        this.mensagem = dados.mensagem();
        this.curso = dados.curso();
        this.status = Status.ATIVADO;
        this.data = LocalDateTime.now();
        this.autor = Autor.AUTOR_TESTE;
    }

    private Boolean ativo;

    public void atualizarInformacoes(AtualizacaoTopico dados) {
        if (dados.titulo() != null) {
            this.titulo = dados.titulo();
        }
        if (dados.mensagem() != null) {
            this.mensagem = dados.mensagem();
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}