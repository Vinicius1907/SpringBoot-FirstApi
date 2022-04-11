package br.com.itautesteapi.ApiPessoas.service;

import br.com.itautesteapi.ApiPessoas.entity.Pessoas;
import br.com.itautesteapi.ApiPessoas.repository.RepositoryPessoas;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PessoasService {

    private final RepositoryPessoas repositoryPessoas;

    public List<Pessoas> findAll(){
        return repositoryPessoas.findAll();
    }

    public Pessoas findById(String id){
        UUID uuid = UUID.fromString(id);
        Optional<Pessoas> idPessoa = repositoryPessoas.findById(uuid);

        if(!idPessoa.isPresent())
            throw new RuntimeException("Pessoa não encontrada");

        return idPessoa.get();
    }

    public Pessoas create(Pessoas pessoas){
        Pessoas novaPessoa = repositoryPessoas.saveAndFlush(pessoas);
        return novaPessoa;
    }

    public Pessoas update(Pessoas novosDados ,String id){
        UUID uuid = UUID.fromString(id);
        Optional<Pessoas> idPessoa = repositoryPessoas.findById(uuid);

        if (!idPessoa.isPresent()) {
            throw new RuntimeException("Pessoa não existe!");
        } else {
            Pessoas pessoas = idPessoa.get();
            pessoas.setNome(novosDados.getNome());
            pessoas.setIdade(novosDados.getIdade());
            pessoas.setDataNascimento(novosDados.getDataNascimento());
        }

        Pessoas updatePessoa = idPessoa.get();

        repositoryPessoas.saveAndFlush(updatePessoa);
        return updatePessoa;


    }

    public void delete(String id){
        UUID uuid = UUID.fromString(id);

        if(repositoryPessoas.existsById(uuid))
            repositoryPessoas.deleteById(uuid);

    }
}
