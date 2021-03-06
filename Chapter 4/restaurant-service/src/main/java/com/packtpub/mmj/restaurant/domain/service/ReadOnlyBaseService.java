package com.packtpub.mmj.restaurant.domain.service;

import com.packtpub.mmj.restaurant.domain.repository.Repository;

public abstract class ReadOnlyBaseService<TE, T> {

    private Repository<TE, T> repository;

    ReadOnlyBaseService(Repository<TE, T> repository) {
        this.repository = repository;
    }
}
