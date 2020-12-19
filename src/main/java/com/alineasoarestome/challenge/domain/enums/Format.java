package com.alineasoarestome.challenge.domain.enums;

import lombok.Getter;

@Getter
public enum Format {

    COMIC("comic"), MAGAZINE("magazine"), TRADE_PAPERBACK("trade paperback"), HARDCOVER("hardcover"), DIGEST("digest"),
    GRAPHIC_NOVEL("graphic novel"), DIGITAL_COMIC("digital comic"), INFINITE_COMIC("infinit comic");

    private String description;

    Format(String description) {
	this.description = description;
    }

}
