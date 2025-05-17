package br.senai.sp.cadastro.adapters.in.web;

import br.senai.sp.cadastro.application.domain.Cliente;
import br.senai.sp.cadastro.application.port.in.CreateClienteUseCase;
import br.senai.sp.cadastro.application.port.in.DeleteClienteUseCase;
import br.senai.sp.cadastro.application.port.in.GetClienteUseCase;
import br.senai.sp.cadastro.application.port.in.UpdateClienteUseCase;
import br.senai.sp.cadastro.application.port.out.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
@CrossOrigin("*")
public class ClienteController {

    @Autowired
    GetClienteUseCase getClienteUseCase;
    @Autowired
    CreateClienteUseCase createClienteUseCase;
    @Autowired
    DeleteClienteUseCase deleteClienteUseCase;
    @Autowired
    UpdateClienteUseCase updateClienteUseCase;

    @GetMapping
    public List<Cliente> listarClientes() {
        List<Cliente> clientes = getClienteUseCase.getCLientes();
        return clientes;
    }

    @PostMapping
    public ResponseEntity<Cliente> criarCliente(@RequestBody Cliente cliente) {
        Cliente novoCliente = createClienteUseCase.criar(cliente);
        return new ResponseEntity<>(novoCliente, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizarCliente(@PathVariable Long id, @RequestBody Cliente clienteAtualizado) {
        Cliente cliente = updateClienteUseCase.atualizarCliente(clienteAtualizado, id);
        return new ResponseEntity<>(cliente, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> obterCliente(@PathVariable Long id) {
        Optional<Cliente> cliente = getClienteUseCase.getCliente(id);

        if(cliente != null) {
            return new ResponseEntity<>(cliente.get(),HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCliente(@PathVariable Long id) {

        Optional<Cliente> cliente = getClienteUseCase.getCliente(id);

        if(cliente != null) {
            deleteClienteUseCase.excluir(cliente.get().getId());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}