package com.aga.flashcommand.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aga.flashcommand.model.Command;

public interface CommandRepository extends JpaRepository<Command, Long>{
    Optional<Command> findByToolAndSyntax(String tool, String name);
}