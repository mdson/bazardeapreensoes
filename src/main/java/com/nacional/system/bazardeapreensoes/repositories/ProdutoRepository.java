package com.nacional.system.bazardeapreensoes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nacional.system.bazardeapreensoes.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
