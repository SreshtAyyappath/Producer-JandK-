package com.karix.polling.source;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemplateRepository extends JpaRepository<TemplateEntity, Integer> {
    TemplateEntity findByTemplateId(String templateId);
}
