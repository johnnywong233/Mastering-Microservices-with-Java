package com.packtpub.mmj.user.domain.service;

import com.packtpub.mmj.user.domain.repository.Repository;

public abstract class ReadOnlyBaseService<TE, T> {

    private Repository<TE, T> repository;

    ReadOnlyBaseService(Repository<TE, T> repository) {
        this.repository = repository;
    }
}
