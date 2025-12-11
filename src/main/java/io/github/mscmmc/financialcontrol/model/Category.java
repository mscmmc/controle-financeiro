package io.github.mscmmc.financialcontrol.model;

import jakarta.persistence.*; //< Traz as annotations JPA. Diz ao Hibernate como mapear a classe no banco
import jakarta.validation.constraints.NotBlank; //< Campo não pode ser nulo ou string vazia

@Entity //< Entidade JPA, vai virar tabela no banco de dados
@Table(name = "categories") //< Define o nome da tabela no banco
public class Category {

    @Id //< Chave primária da entidade (obrigatório)
    @GeneratedValue(strategy = GenerationType.IDENTITY) //< Banco gera o ID automaticamente
    private Long id;

    @NotBlank //< Aplica validação no campo name antes de entrar no controller
    private String name;

    private String description;

    /// Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
