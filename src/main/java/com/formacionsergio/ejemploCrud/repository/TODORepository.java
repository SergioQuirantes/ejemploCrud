package com.formacionsergio.ejemploCrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.formacionsergio.ejemploCrud.model.TODO;

@Repository("todoRepository")
public interface TODORepository extends JpaRepository<TODO, Long> {

}
