package com.alineasoarestome.challenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alineasoarestome.challenge.domain.Character;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Integer> {
    
}
