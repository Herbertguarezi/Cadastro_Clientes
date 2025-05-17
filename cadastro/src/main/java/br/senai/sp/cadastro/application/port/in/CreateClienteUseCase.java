package br.senai.sp.cadastro.application.port.in;
import br.senai.sp.cadastro.application.domain.Cliente;

public interface CreateClienteUseCase {
    Cliente criar(Cliente cliente);
}
