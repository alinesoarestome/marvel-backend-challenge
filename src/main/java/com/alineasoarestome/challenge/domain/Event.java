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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 80, nullable = false)
    private String title;

    @Column(columnDefinition = "text")
    private String description;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modified;

    @Temporal(TemporalType.TIMESTAMP)
    private Date start;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date end;

    @Getter(onMethod = @__({@JsonIgnore}))
    @ManyToOne
    @JoinColumn(name = "character_id", nullable = false)
    private Character character;

}
