package com.packtpub.mmj.restaurant.domain.service;

import com.packtpub.mmj.restaurant.domain.repository.Repository;

import java.util.Collection;

/**
 * @param <TE>
 * @param <T>
 * @author Sourabh Sharma
 */
public abstract class BaseService<TE, T> extends ReadOnlyBaseService<TE, T> {

    private Repository<TE, T> _repository;

    BaseService(Repository<TE, T> repository) {
        super(repository);
        _repository = repository;
    }

    /**
     * @param entity
     * @throws Exception
     */
    public void add(TE entity) throws Exception {
        _repository.add(entity);
    }


    public Collection<TE> getAll() {
        return _repository.getAll();
    }
}
