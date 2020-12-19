package com.alineasoarestome.challenge.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.alineasoarestome.challenge.domain.enums.Type;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Story implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Schema(description = "The unique ID of the story resource.", required = true)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Schema(description = "The story title.")
    @Column(length = 80, nullable = false)
    private String title;

    @Schema(description = "A short description of the story.")
    @Column(columnDefinition = "text")
    private String description;

    @Schema(description = "The canonical URL identifier for this resource.")
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modified;

    @Schema(description = "The story type e.g. interior story, cover, text story.")
    @Column(name = "type", length = 15)
    @Enumerated(EnumType.STRING)
    private Type type;
    
    @Getter(onMethod = @__({@JsonIgnore}))
    @ManyToOne
    @JoinColumn(name = "character_id", nullable = false)
    private Character character;

}
