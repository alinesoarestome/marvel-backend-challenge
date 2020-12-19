package com.alineasoarestome.challenge.domain.enums;

import lombok.Getter;

@Getter
public enum Type {
    
    INTERIOR_STORY("interior story"),
    COVER("cover"),
    TEXT_STORY("story");

    private String descricao;
    
    Type(String descricao) {
	 this.descricao = descricao;
    }

}
