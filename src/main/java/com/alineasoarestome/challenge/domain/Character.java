package com.alineasoarestome.challenge.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Character implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 60, nullable = false)
    private String name;

    @Column(columnDefinition = "text")
    private String description;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modified;

    @OneToMany(mappedBy = "character")
    private List<Comic> comics = new ArrayList<Comic>();

    @OneToMany(mappedBy = "character")
    private List<Event> events = new ArrayList<Event>();

    @OneToMany(mappedBy = "character")
    private List<Serie> series = new ArrayList<Serie>();
    
    @OneToMany(mappedBy = "character")
    private List<Story> stories = new ArrayList<Story>();


}
