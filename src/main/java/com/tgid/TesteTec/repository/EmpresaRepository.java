package com.tgid.TesteTec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import com.tgid.TesteTec.model.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long>{

	public List <Empresa> findAllByCNPJContainingIgnoreCase(@Param("cnpj")String cnpj);
}
