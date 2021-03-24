package com.c0920i1.lastWishper.service;

import java.util.Optional;

public interface IGeneralService<T> {
    Optional<T> findById(Long id);
    Iterable<T> findAll();
    void remove(Long id);
    T save(T t);
}
