package com.alineasoarestome.challenge.domain.enums;

import com.fasterxml.jackson.annotation.JsonValue;

import lombok.Getter;

@Getter
public enum Type {
    
    INTERIOR_STORY("interior story"),
    COVER("cover"),
    TEXT_STORY("story");

    @JsonValue
    private String descricao;
    
    Type(String descricao) {
	 this.descricao = descricao;
    }

}
