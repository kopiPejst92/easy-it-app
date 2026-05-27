package aga.easyit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import aga.easyit.model.Command;

public interface CommandsRepository extends JpaRepository<Command, Long>{


}
