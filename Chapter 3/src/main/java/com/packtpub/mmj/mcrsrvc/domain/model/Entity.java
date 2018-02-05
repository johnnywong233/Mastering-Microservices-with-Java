package com.packtpub.mmj.mcrsrvc.domain.model;

import lombok.Data;

@Data
public abstract class Entity<T> {
    T id;
    String name;
}