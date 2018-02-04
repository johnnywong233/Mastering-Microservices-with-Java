package com.packtpub.mmj.mcrsrvc.domain.model;

import java.util.Collection;

public interface ReadOnlyRepository<TE, T> {

    //long Count;

    boolean contains(T id);

    Entity get(T id);

    Collection<TE> getAll();
}
