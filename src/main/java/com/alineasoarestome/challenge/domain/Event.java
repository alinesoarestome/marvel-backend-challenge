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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
public class Event implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Schema(description = "The ID of the digital event representation of this comic. Will be 0 if the comic is not available digitally.", required = true)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Schema(description = "The title of the event.")
    @Column(length = 80, nullable = false)
    private String title;

    @Schema(description = "A description of the event.")
    @Column(columnDefinition = "text")
    private String description;

    @Schema(description = "The date the resource was most recently modified.")
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modified;

    @Schema(description = "The date of publication of the first issue in this event.")
    @Temporal(TemporalType.TIMESTAMP)
    private Date start;
    
    @Schema(description = "The date of publication of the last issue in this event.")
    @Temporal(TemporalType.TIMESTAMP)
    private Date end;

    @Getter(onMethod = @__({@JsonIgnore}))
    @ManyToOne
    @JoinColumn(name = "character_id", nullable = false)
    private Character character;

}
