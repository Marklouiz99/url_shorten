package com.mark.urlshorten.repository;

import com.mark.urlshorten.entity.Link;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface LinkRepository extends JpaRepository<Link, Long> {
    Optional<Link> findByShortCode(String shortCode);
    boolean existsByShortCode(String shortCode);

    @Query(value = "SELECT nextval('link_id_seq')", nativeQuery = true)
    long nextId();

    @Modifying
    @Query("""
        UPDATE Link l
        SET l.clickCount = l.clickCount + 1
        WHERE l.id = :linkId
    """)
    int incrementClickCount(@Param("linkId") long linkId);
}
