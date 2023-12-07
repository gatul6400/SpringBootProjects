package com.example.exportingdbdatainjsonwithrecursive_springboot.repository;

import com.example.exportingdbdatainjsonwithrecursive_springboot.model.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataRepository extends JpaRepository<Data, Long> {
}
