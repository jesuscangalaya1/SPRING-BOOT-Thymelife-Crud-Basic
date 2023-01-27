package com.crud.crudspringboot1.repositoy;

import com.crud.crudspringboot1.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryStudent extends JpaRepository<Student, Long> {
}
