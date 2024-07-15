package br.com.alura.forumhub.controller;

import br.com.alura.forumhub.domain.topico.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/forumhub/")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid CadastroTopico dados, UriComponentsBuilder uriBuilder) {
        var cadastrar = new Topico(dados);
        repository.save(cadastrar);
        var uri = uriBuilder.path("/forumhub/{id}").buildAndExpand(cadastrar.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetalhamentoTopico(cadastrar));

    }

    @GetMapping
    public ResponseEntity<Page<ListagemTopico>> listar(@PageableDefault(size = 10, sort = {"id"}) Pageable paginacao) {
        var page = repository.findAllByAtivoTrue(paginacao).map(ListagemTopico::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid AtualizacaoTopico dados) {
        var atualizar = repository.getReferenceById(dados.id());
        atualizar.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DetalhamentoTopico(atualizar));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        var excluir = repository.getReferenceById(id);
        excluir.excluir();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var detalhar = repository.getReferenceById(id);
        return ResponseEntity.ok(new DetalhamentoTopico(detalhar));
    }
}