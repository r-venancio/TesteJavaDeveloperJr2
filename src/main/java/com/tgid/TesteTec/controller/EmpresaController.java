package com.tgid.TesteTec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import com.tgid.TesteTec.model.Cliente;
import java.util.Map;
import java.util.Optional;
import java.util.HashMap;
import com.tgid.TesteTec.model.Empresa;
import com.tgid.TesteTec.repository.Usuario;
import com.tgid.TesteTec.repository.EmpresaRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {

	@Autowired
	private EmpresaRepository empresaRepository;
	
    Map<String, Empresa> empresas = new HashMap<>();
    Map<String, Cliente> clientes = new HashMap<>();
	
	@PostMapping("/criar")
    public String criarEmpresa(@RequestParam String cnpj, @RequestParam double taxa) {
        new Empresa(cnpj, taxa);
        empresas.put(cnpj, new Empresa(cnpj, taxa));
        return "Empresa criada com sucesso";
    }
    @PostMapping("/{cnpj}/depositar")
    public String depositar(@PathVariable String cnpj, @RequestParam double valor, Usuario usuario, @RequestParam double taxa) {
    	Empresa empresa = new Empresa(cnpj, taxa);
    	double valorFinal = valor - taxa;
         empresa.depositar(valorFinal);
    	 return "Depósito realizado com sucesso";
    }
   @PostMapping("/{cnpj}/sacar")
    public String sacar(@PathVariable String cnpj, @RequestParam double valor, @RequestParam double taxa) {
    	Empresa empresa = new Empresa(cnpj, taxa);
    	double valorFinal = valor - taxa;
         empresa.sacar(valorFinal);
        return "Saque realizado com sucesso";
    }
  @GetMapping("/{cnpj}/saldo")
    public double getSaldo(@PathVariable String cnpj, Long id,  @RequestParam double valor, @RequestParam double taxa) {
    	Optional<Empresa> empresa = empresaRepository.findById(id);
    	return +valor; 
    }
 @GetMapping("/{cnpj}/taxa")
    public double calcularTaxa(@PathVariable String cnpj, Long id, @RequestParam double valor, @RequestParam double taxa) {
	    Optional<Empresa> empresa = empresaRepository.findById(id);
        return +valor;
   }
}