package com.karix.polling.source;

import jakarta.persistence.EntityManager;


import jakarta.persistence.LockModeType;

import jakarta.persistence.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class SourceRepository{

    private static final Logger log = LoggerFactory.getLogger(SourceRepository.class);

    @Autowired
    EntityManager entityManager;



    @Transactional
    List<SourceEntity> fetchDataFromTable(String tableName, Integer priority, Integer limit){


        try{// Construct the query with FETCH FIRST
            String sql = "SELECT * FROM " + tableName + " WHERE PRIORITY = ?1 AND STATUS = ?2 ORDER BY ENTRY_TIME ASC FETCH FIRST ?3 ROWS ONLY";

            // Create the query
            Query query = entityManager.createNativeQuery(sql, SourceEntity.class);
            query.setParameter(1, priority);
            query.setParameter(2, 1); // Assuming 0 is the desired status
            query.setParameter(3, limit);

            //
            List<SourceEntity> resultList = query.getResultList();
            for (SourceEntity sourceEntity : resultList) {
                BigDecimal id = sourceEntity.getId();
                updateTableStatus(tableName, id, 2);
            }

            return resultList;
        }catch (Exception e){
            log.error(String.valueOf(e));
        }

        return new ArrayList<SourceEntity>();
    }

    @Transactional
    public void updateTableStatus(String tableName, BigDecimal id, Integer status) {
        // Construct dynamic SQL
        String sql = "UPDATE " + tableName + " SET STATUS = :status WHERE ID = :id";

        // Create a native query
        Query query = entityManager.createNativeQuery(sql);

        // Set parameters
        query.setParameter("status", status);
        query.setParameter("id", id);

        // Execute the update query
        query.executeUpdate();
    }



}
