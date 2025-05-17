package br.senai.sp.cadastro.application.port.in;

import br.senai.sp.cadastro.application.domain.Cliente;

public interface UpdateClienteUseCase {
    Cliente atualizarCliente(Cliente detalhesCliente, Long idCliente);
}
