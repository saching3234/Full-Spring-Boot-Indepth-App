package com.to.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.to.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

}
