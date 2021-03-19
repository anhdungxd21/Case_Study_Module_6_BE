package com.codegym.lastwhisper.repository;

import com.codegym.lastwhisper.model.Singer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISingerRepository extends CrudRepository<Singer, Long> {
}
