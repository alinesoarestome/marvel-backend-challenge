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

import com.alineasoarestome.challenge.domain.enums.Format;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter 
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Comic implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Schema(description = "The unique ID of the comic resource.", 
            example = "1", required = true)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Schema(description = "The ID of the digital comic representation of this comic. Will be 0 if the comic is not available digitally.")
    @Column(name = "digital_id")
    private Integer digitalId;
    
    @Schema(description = "The canonical title of the comic.")
    @Column(length = 80, nullable = false)
    private String title;
    
    @Schema(description = "The number of the issue in the series (will generally be 0 for collection formats).")
    @Column(name = "issue_number")
    private String issueNumber;

    @Schema(description = "The preferred description of the comic.")
    @Column(columnDefinition = "text")
    private String description;
    
    @Schema(description = "The publication format of the comic e.g. comic, hardcover, trade paperback.")
    @Column(name = "format", length = 15)
    @Enumerated(EnumType.STRING)
    private Format format;

    @Schema(description = "The date the resource was most recently modified.")
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modified;

    @Getter(onMethod = @__({@JsonIgnore}))
    @ManyToOne
    @JoinColumn(name = "character_id", nullable = false)
    private Character character;
}
