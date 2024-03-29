package com.bookrental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookrental.models.FileDB;

@Repository
public interface FileDBRepository extends JpaRepository<FileDB, String> {

}