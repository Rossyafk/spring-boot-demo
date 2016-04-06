package com.rizandoelrizo.spring.boot.demo.rest.repository;

import com.rizandoelrizo.spring.boot.demo.rest.model.TallySheet;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * TallySheet Repository.
 */
public interface TallySheetRepository extends JpaRepository<TallySheet, String>{

}
