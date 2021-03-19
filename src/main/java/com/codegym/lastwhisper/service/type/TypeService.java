package com.codegym.lastwhisper.service.type;

import com.codegym.lastwhisper.model.Type;
import com.codegym.lastwhisper.repository.ITypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TypeService implements ITypeService{

    @Autowired
    private ITypeRepository typeRepository;

    @Override
    public Page<Type> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Iterable<Type> findAll() {
        return null;
    }

    @Override
    public Optional<Type> findById(Long id) {
        return typeRepository.findById(id);
    }

    @Override
    public Type save(Type type) {
        return typeRepository.save(type);
    }

    @Override
    public void remove(Long id) {
        typeRepository.deleteById(id);
    }
}
