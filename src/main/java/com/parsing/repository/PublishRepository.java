package com.parsing.repository;

import com.parsing.domain.ParsingResult;
import com.parsing.domain.PublishedResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PublishRepository extends JpaRepository<PublishedResult, Long> {

    @Query(value = "SELECT t.id, t.id_vacancy as id_publish_vacancy FROM parsing t", nativeQuery = true)
    List<PublishedResult> findAllId();

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM publish", nativeQuery = true)
    void truncatePublish();

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO publish (id, id_publish_vacancy) SELECT id, id_vacancy FROM parsing", nativeQuery = true)
    void copyInPublishFromRezault();

}