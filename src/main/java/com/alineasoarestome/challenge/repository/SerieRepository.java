package com.alineasoarestome.challenge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alineasoarestome.challenge.domain.Serie;

@Repository
public interface SerieRepository extends JpaRepository<Serie, Integer> {

    public List<Serie> findAllByCharacterId(Integer id);
}
