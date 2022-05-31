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
public interface ParsingRepository extends JpaRepository<ParsingResult, Long> {

    @Query(value = "SELECT * FROM parsing t " +
            "Where t.id_vacancy NOT IN (Select id_publish_vacancy From publish)" +
            "order by RIGHT(date_vacancy, 2), LEFT(date_vacancy, 2)", nativeQuery = true)
    List<ParsingResult> findAllPublishInformation();


    @Modifying
    @Transactional
    @Query(value = "DELETE FROM publish", nativeQuery = true)
    void truncatePublish();


    @Modifying
    @Transactional
    @Query(value = "INSERT INTO publish (id, id_publish_vacancy, date_publish_vacancy) SELECT id, id_vacancy, date_vacancy FROM parsing", nativeQuery = true)
    void copyInPublishFromRezault();


    @Modifying
    @Transactional
    @Query(value = "Select * FROM parsing WHERE id in (SELECT t.id FROM parsing t JOIN publish q ON q.id = t.id WHERE STR_TO_DATE(q.date_publish_vacancy, '%d.%m') < STR_TO_DATE(t.date_vacancy, '%d.%m')) and country = 'Беларусь'", nativeQuery = true)
    List<ParsingResult> updatePublishInformation();

    //SELECT * FROM parsing order by RIGHT(date_vacancy, 2), LEFT(date_vacancy, 2);

}
