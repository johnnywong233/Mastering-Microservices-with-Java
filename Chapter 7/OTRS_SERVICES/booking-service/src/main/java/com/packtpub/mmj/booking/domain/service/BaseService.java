package com.packtpub.mmj.booking.domain.service;

import com.packtpub.mmj.booking.domain.repository.Repository;

import java.util.Collection;

public abstract class BaseService<TE, T> extends ReadOnlyBaseService<TE, T> {

    private Repository<TE, T> _repository;

    BaseService(Repository<TE, T> repository) {
        super(repository);
        _repository = repository;
    }

    public TE add(TE entity) throws Exception {
        return _repository.add(entity);
    }


    public Collection<TE> getAll() {
        return _repository.getAll();
    }
}
