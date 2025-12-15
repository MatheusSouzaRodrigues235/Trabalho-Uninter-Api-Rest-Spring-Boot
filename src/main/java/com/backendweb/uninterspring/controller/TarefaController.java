package com.backendweb.uninterspring.controller;
import com.backendweb.uninterspring.model.Tarefas;
import com.backendweb.uninterspring.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.support.Repositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/tarefas")
public class TarefaController {
   //@Autowired Permite usar os métodos crud prontos
    @Autowired
    private TarefaRepository tarefaRepository;

    // Criar Tarefa (CREATE) | POST, endpoint /tarefas
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Tarefas criarTarefa(@RequestBody Tarefas tarefa){
        //Como se Fosse um metodo save(), insere no bd
        return  tarefaRepository.save(tarefa);
    }

    // Consultar todas as tarefas | GET, endpoint /tarefas
    @GetMapping
    public List<Tarefas> listarTodasTarefas(){
        return tarefaRepository.findAll();
    }

    //Consulta pelo ID | GET, endpoint /tarefas/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Tarefas> buscarTarefaId(@PathVariable Long id){
        return tarefaRepository.findById(id)
                .map(tarefas -> ResponseEntity.ok(tarefas)) // se for encontrado, retorna 200 OK com a tarefa
                .orElse(ResponseEntity.notFound().build()); // 404 não encontrado
    }

    // Atualizar uma tarefa existente (UPDATE) | PUT, endpoint /tarefas/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Tarefas> atualizarTarefa(@PathVariable Long id, @RequestBody Tarefas tarefaDetalhes){
      return tarefaRepository.findById(id)
              .map(tarefaExistente -> {
               //Atualiza os campos da tarefa com o que for recebido
               tarefaExistente.setNome(tarefaDetalhes.getNome());
               tarefaExistente.setDataEntrega(tarefaDetalhes.getDataEntrega());
               tarefaExistente.setResponsavel(tarefaDetalhes.getResponsavel());

               // Salva a tarefa no BD
               Tarefas tarefaAtualizada = tarefaRepository.save(tarefaExistente);
               return ResponseEntity.ok(tarefaAtualizada); // 200 OK
              })
              .orElse(ResponseEntity.notFound().build());
    }

    // Remover uma tarefa (DELETE) | DELETE, endpoint /tarefas/{id}
   @DeleteMapping("/{id}")
   @ResponseStatus(HttpStatus.NO_CONTENT) // Retorna 204
  public ResponseEntity<Void> removerTarefa(@PathVariable Long id){
     // Verifica se a tarefa existe
    if(tarefaRepository.existsById(id)){
     tarefaRepository.deleteById(id);
     return  ResponseEntity.noContent().build();
    }
    else{
     return ResponseEntity.notFound().build();
    }

   }
}
