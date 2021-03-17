package com.codegym.lastwhisper.service.comment;

import java.util.Optional;

public interface IService<T> {
    Optional<T> findById(Long id);
    Iterable<T> findAll();
    void remove(Long id);
    T save(T t);
}