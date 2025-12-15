package com.backendweb.uninterspring.model;
import jakarta.persistence.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
@Entity
@Table(name = "tarefas")
public class Tarefas {
   // Atributos da tabela
    //Id da tarefa
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tarefa")
    private Long id;

    //Nome da tarefa
    @Column(name = "nome_tarefa", nullable = false)
    private String nome;
    // Data da entrega
    @Column(name = "data_entrega")
    private LocalDate dataEntrega;
    // Responsavel tarefa
    @Column(name = "responsavel_tarefa")
    private String responsavel;

    // CONSTRUTORES
public Tarefas(){

}
 public Tarefas (String nome, LocalDate dataEntrega, String responsavel){
  this.nome = nome;
  this.dataEntrega = dataEntrega;
  this.responsavel = responsavel;
 }

 // GETTERS E SETTERS
 public Long getId(){
  return id;
 }
 public void setId(Long id) {
  this.id = id;
 }

 public String getNome() {
  return nome;
 }

 public void setNome(String nome) {
  this.nome = nome;
 }

 public LocalDate getDataEntrega() {
  return dataEntrega;
 }

 public void setDataEntrega(LocalDate dataEntrega) {
  this.dataEntrega = dataEntrega;
 }

 public String getResponsavel() {
  return responsavel;
 }

 public void setResponsavel(String responsavel) {
  this.responsavel = responsavel;
 }

}
