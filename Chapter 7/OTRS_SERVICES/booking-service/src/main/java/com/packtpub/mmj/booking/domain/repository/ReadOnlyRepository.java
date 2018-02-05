package com.packtpub.mmj.booking.domain.repository;

import com.packtpub.mmj.booking.domain.model.entity.Entity;

import java.util.Collection;

public interface ReadOnlyRepository<TE, T> {

    //long Count;

    boolean contains(T id);

    Entity get(T id);

    Collection<TE> getAll();
}
