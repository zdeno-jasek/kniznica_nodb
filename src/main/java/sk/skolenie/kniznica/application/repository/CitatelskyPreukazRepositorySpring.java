package sk.skolenie.kniznica.application.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import sk.skolenie.kniznica.domain.CitatelskyPreukaz;

@Repository
interface CitatelskyPreukazRepositorySpring extends CrudRepository<CitatelskyPreukaz, Long> {

}
