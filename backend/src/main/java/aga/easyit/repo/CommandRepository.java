package aga.easyit.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import aga.easyit.model.Command;

public interface CommandRepository extends JpaRepository<Command, Long>{
    Optional<Command> findCommandBySyntax(String syntax);
}