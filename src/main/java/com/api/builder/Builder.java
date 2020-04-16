package com.api.builder;

import org.springframework.stereotype.Component;

@Component
public interface Builder<T> {

    T build();
}
