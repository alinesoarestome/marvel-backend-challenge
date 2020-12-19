package com.alineasoarestome.challenge.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.alineasoarestome.challenge.domain.converter.FormatConverter;
import com.alineasoarestome.challenge.domain.enums.Format;
import com.fasterxml.jackson.annotation.JsonIgnore;

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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "digital_id")
    private Integer digitalId;
    
    @Column(length = 80, nullable = false)
    private String title;
    
    @Column(name = "issue_number")
    private String issueNumber;

    @Column(columnDefinition = "text")
    private String description;
    
    @Column(name = "format", length = 15)
    @Convert(converter = FormatConverter.class)
    private Format format;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modified;

    @Getter(onMethod = @__({@JsonIgnore}))
    @ManyToOne
    @JoinColumn(name = "character_id", nullable = false)
    private Character character;
}
