package com.alineasoarestome.challenge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alineasoarestome.challenge.domain.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {

    public List<Event> findAllByCharacterId(Integer id);
}
