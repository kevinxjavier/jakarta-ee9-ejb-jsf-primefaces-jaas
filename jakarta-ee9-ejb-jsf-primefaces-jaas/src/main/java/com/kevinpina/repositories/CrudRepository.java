package com.kevinpina.repositories;

import java.util.List;

public interface CrudRepository<T> {

    List<T> list();
    T findById(Long id);
    void save(T t);
    void deleteById(Long id);

}
