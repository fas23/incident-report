package com.incident.report.service;

import java.util.List;

public interface IGenerica<T> {
    T save(T objeto);
    void delete(T objeto);
    T update(T objeto);
    List<T> getAll();
}
