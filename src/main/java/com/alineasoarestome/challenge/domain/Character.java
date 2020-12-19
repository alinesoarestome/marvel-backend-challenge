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
public class Character implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    @Schema(description = "The unique ID of the character resource.", 
            example = "1", required = true)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Schema(description = "The name of the character.")
    @Column(length = 60, nullable = false)
    private String name;

    @Schema(description = "A short bio or description of the character.")
    @Column(columnDefinition = "text")
    private String description;

    @Schema(description = "The date the resource was most recently modified.")
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modified;

    @Schema(description = "A list containing comics which feature this character.")
    @OneToMany(mappedBy = "character")
    private List<Comic> comics = new ArrayList<Comic>();

    @Schema(description = "A list containing events which feature this character.")
    @OneToMany(mappedBy = "character")
    private List<Event> events = new ArrayList<Event>();

    @Schema(description = "A list containing series which feature this character.")
    @OneToMany(mappedBy = "character")
    private List<Serie> series = new ArrayList<Serie>();
    
    @Schema(description = "A list containing stories which feature this character.")
    @OneToMany(mappedBy = "character")
    private List<Story> stories = new ArrayList<Story>();


}
