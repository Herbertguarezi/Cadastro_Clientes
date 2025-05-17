package br.senai.sp.cadastro.application;

import br.senai.sp.cadastro.application.domain.Cliente;
import br.senai.sp.cadastro.application.port.in.CreateClienteUseCase;
import br.senai.sp.cadastro.application.port.in.DeleteClienteUseCase;
import br.senai.sp.cadastro.application.port.in.GetClienteUseCase;
import br.senai.sp.cadastro.application.port.in.UpdateClienteUseCase;
import br.senai.sp.cadastro.application.port.out.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService implements CreateClienteUseCase, DeleteClienteUseCase, GetClienteUseCase, UpdateClienteUseCase {

    @Autowired
    private ClienteRepository repository;

    @Override
    public Cliente criar(Cliente cliente) {
        return repository.salvaCliente(cliente);
    }

    @Override
    public void excluir(long idCliente) {
        repository.excluirCliente(idCliente);
    }

    @Override
    public List<Cliente> getCLientes() {
        return repository.getClientes();
    }

    @Override
    public Optional<Cliente> getCliente(Long id) {
        return repository.getCliente(id);
    }

    @Override
    public Cliente atualizarCliente(Cliente detalhesCliente, Long idCliente) {
        Cliente cliente = repository.getCliente(idCliente).orElseThrow(() -> new RuntimeException("Cliente não encontrado com id ::" + idCliente));
        cliente.setNome(detalhesCliente.getNome());
        cliente.setEmail(detalhesCliente.getEmail());

        return repository.salvaCliente(cliente);
    }
}
