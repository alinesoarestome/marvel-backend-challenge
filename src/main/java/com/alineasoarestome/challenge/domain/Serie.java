package com.alineasoarestome.challenge.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
public class Serie implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Schema(description = "The unique ID of the series resource.", required = true)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Schema(description = "The canonical title of the series.")
    @Column(length = 80, nullable = false)
    private String title;

    @Schema(description = "A description of the series.")
    @Column(columnDefinition = "text")
    private String description;
    
    @Schema(description = "The age-appropriateness rating for the series.")
    @Column(length = 80)
    private String rating;

    @Schema(description = "The date the resource was most recently modified.")
    @Column(nullable = false)
    private Date modified;
    
    @Schema(description = "The first year of publication for the series.")
    @Column(name = "start_year")
    private Integer startYear;
    
    @Schema(description = "The last year of publication for the series (conventionally, 2099 for ongoing series).")
    @Column(name = "end_year")
    private Integer endYear;

    @Getter(onMethod = @__({@JsonIgnore}))
    @ManyToOne
    @JoinColumn(name = "character_id", nullable = false)
    private Character character;

}
