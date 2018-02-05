package com.packtpub.mmj.user.domain.repository;

import com.packtpub.mmj.user.domain.model.entity.Entity;
import java.util.Collection;

public interface ReadOnlyRepository<TE, T> {

    //long Count;
    boolean contains(T id);

    Entity get(T id);

    Collection<TE> getAll();
}
