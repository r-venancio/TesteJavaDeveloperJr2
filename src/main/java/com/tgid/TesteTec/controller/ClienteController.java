package com.tgid.TesteTec.controller;

import com.tgid.TesteTec.model.Cliente;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.*;
import com.tgid.TesteTec.repository.ClienteRepository;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
    
    @PostMapping("/criar")
    public ResponseEntity<Cliente> criarCliente(@RequestParam String cpf) {
       new Cliente(cpf);
    return null;
 }
    @DeleteMapping("/{cpf}")
    public String excluirCliente(@PathVariable String cpf, Long id) {
	   Optional<Cliente> cliente = clienteRepository.findById(id);
	   if (cliente.isEmpty())
           throw new ResponseStatusException(HttpStatus.NOT_FOUND);
       clienteRepository.deleteById(id);
	return null;
}
    }