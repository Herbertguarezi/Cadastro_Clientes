package br.senai.sp.cadastro.application.port.in;

import br.senai.sp.cadastro.application.domain.Cliente;

import java.util.List;
import java.util.Optional;

public interface GetClienteUseCase {
    List<Cliente> getCLientes();
    Optional<Cliente> getCliente(Long id);
}
