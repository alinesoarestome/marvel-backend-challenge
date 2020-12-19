package com.alineasoarestome.challenge.domain.converter;

import java.util.stream.Stream;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.alineasoarestome.challenge.domain.enums.Format;

@Converter(autoApply = true)
public class FormatConverter implements AttributeConverter<Format, String> {

    @Override
    public String convertToDatabaseColumn(Format format) {

	if (format == null) {
	    return null;
	}

	return format.getDescription();
    }

    @Override
    public Format convertToEntityAttribute(String descricao) {
	if (descricao == null) {
	    return null;
	}

	return Stream.of(Format.values()).filter(c -> c.getDescription().equals(descricao)).findFirst()
		.orElseThrow(IllegalArgumentException::new);
    }

}
