package com.alineasoarestome.challenge.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alineasoarestome.challenge.domain.Character;
import com.alineasoarestome.challenge.exception.ApiError;
import com.alineasoarestome.challenge.exception.NotFoundException;
import com.alineasoarestome.challenge.repository.CharacterRepository;

@Service
public class CharacterService {

    @Autowired
    private CharacterRepository characterRepository;

    public List<Character> listAll() {

	return characterRepository.findAll();
    }

    public Character getById(Integer id) {
	Optional<Character> result = characterRepository.findById(id);

	return result.orElseThrow(() -> new NotFoundException(ApiError.CHARACTER_NOT_FOUND));
    }

}
