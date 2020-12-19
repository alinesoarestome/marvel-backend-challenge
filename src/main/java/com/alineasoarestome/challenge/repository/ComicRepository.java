package com.alineasoarestome.challenge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alineasoarestome.challenge.domain.Comic;

@Repository
public interface ComicRepository extends JpaRepository<Comic, Integer> {

    public List<Comic> findAllByCharacterId(Integer id);
}
