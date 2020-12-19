package com.alineasoarestome.challenge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alineasoarestome.challenge.domain.Story;

@Repository
public interface StoryRepository extends JpaRepository<Story, Integer> {

    public List<Story> findAllByCharacterId(Integer id);
}
