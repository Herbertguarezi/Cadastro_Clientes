package br.senai.sp.cadastro.application.port.out;

import br.senai.sp.cadastro.adapters.out.persistence.ClienteEntity;
import br.senai.sp.cadastro.application.domain.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteRepository {
    List<Cliente> getClientes();
    Optional<Cliente> getCliente(Long id);
    Cliente salvaCliente(Cliente cliente);
    void excluirCliente(Long idCliente);
}
