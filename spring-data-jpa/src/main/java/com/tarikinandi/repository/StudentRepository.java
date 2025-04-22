package com.tarikinandi.repository;

import com.tarikinandi.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    //HQL(HİBERNATE QUERY LANGUAGE) SORGUSU BU : Sınıfın ismi ve değişken isimleri kullanılarak sorgular yazılır.
    @Query(value = "from Student " , nativeQuery = false)
    public List<Student> findAllStudents();

    //SQL : tablo ismi ve tablo içerisindeki kolon isimleri ile sorgular yazılır.
    @Query(value = "SELECT * FROM student.student s WHERE s.id = :studentId" , nativeQuery = true)
    Optional<Student> findStudentById(@Param("studentId") int studentId);
}
