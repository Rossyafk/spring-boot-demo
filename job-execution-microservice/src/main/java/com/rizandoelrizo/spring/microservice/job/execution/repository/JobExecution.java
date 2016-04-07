package com.rizandoelrizo.spring.microservice.job.execution.repository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class JobExecution implements Serializable{

    public static final long serialVersionUID = 42L;

    @Id
    @Column(name = "id", nullable = false, updatable = false)
    @NotNull
    private Long id;

    @Column(name = "description", nullable = false)
    @NotNull
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
