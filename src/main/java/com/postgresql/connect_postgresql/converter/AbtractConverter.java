package com.postgresql.connect_postgresql.converter;

public interface AbtractConverter<T, S> {
    T toDto(S entity);

    S toEntity(T dto);

    S toEntity(S entity, T dto);
}
