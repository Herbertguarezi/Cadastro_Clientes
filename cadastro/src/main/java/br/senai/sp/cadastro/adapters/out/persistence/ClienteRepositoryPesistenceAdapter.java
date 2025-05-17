package br.senai.sp.cadastro.adapters.out.persistence;

import br.senai.sp.cadastro.application.domain.Cliente;
import br.senai.sp.cadastro.application.port.out.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ClienteRepositoryPesistenceAdapter implements ClienteRepository {

    @Autowired
    private ClienteJpaRepository repository;

    @Override
    public List<Cliente> getClientes() {
        return repository.findAll().stream().map(this::toDomain).collect(Collectors.toList());
    }

    @Override
    public Optional<Cliente> getCliente(Long idCliente) {
        return repository.findById(idCliente).map(this::toDomain);
    }

    @Override
    public Cliente salvaCliente(Cliente cliente) {
        ClienteEntity clienteEntity = toEntity(cliente);
        return toDomain(repository.save(clienteEntity));
    }

    @Override
    public void excluirCliente(Long idCliente) {
        repository.deleteById(idCliente);
    }

    private Cliente toDomain(ClienteEntity entity) {
        if (entity == null) return null;

        Cliente cliente = new Cliente();
        cliente.setId(entity.getId());
        cliente.setNome(entity.getName());
        cliente.setEmail(entity.getEmail());
        return cliente;
    }

    private ClienteEntity toEntity(Cliente cliente) {
        if (cliente == null) return null;

        ClienteEntity entity = new ClienteEntity();
        entity.setId(cliente.getId());
        entity.setName(cliente.getNome());
        entity.setEmail(cliente.getEmail());
        return entity;
    }
}