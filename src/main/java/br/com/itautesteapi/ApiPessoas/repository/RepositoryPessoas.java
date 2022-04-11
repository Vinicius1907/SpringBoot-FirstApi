package br.com.itautesteapi.ApiPessoas.repository;

import br.com.itautesteapi.ApiPessoas.entity.Pessoas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RepositoryPessoas extends JpaRepository<Pessoas, UUID> {
}
