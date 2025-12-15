package com.backendweb.uninterspring.repository;

import com.backendweb.uninterspring.model.Tarefas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TarefaRepository extends JpaRepository<Tarefas, Long> {


}
