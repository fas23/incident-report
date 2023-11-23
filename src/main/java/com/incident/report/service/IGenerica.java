package com.incident.report.service;

import java.util.List;

public interface IGenerica<T> {
    T save(T objeto);
    void delete(Long  id);
    T update(T objeto);
    List<T> getAll();
}
