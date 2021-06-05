package cz.czechitas.java2webapps.lekce10.repository;

import cz.czechitas.java2webapps.lekce10.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 */
@Repository
public interface StudentRepository  extends JpaRepository<Student, Integer> {

    Page<Student> findStudentsByTridaNazev (String nazev, Pageable pageable);
}
