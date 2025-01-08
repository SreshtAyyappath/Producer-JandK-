package com.karix.polling.source;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SourceRepository extends JpaRepository<SourceEntity, String> {
    List<SourceEntity> findByStatus(Integer status);
}
