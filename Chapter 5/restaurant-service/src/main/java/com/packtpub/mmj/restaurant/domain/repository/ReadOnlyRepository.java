package com.packtpub.mmj.restaurant.domain.repository;

import com.packtpub.mmj.restaurant.domain.model.entity.Entity;

import java.util.Collection;

public interface ReadOnlyRepository<TE, T> {

    //long Count;

    boolean contains(T id);

    Entity get(T id);

    Collection<TE> getAll();
}
