package com.rizandoelrizo.spring.boot.demo.rest.service;


import com.rizandoelrizo.spring.boot.demo.rest.model.TallySheet;

import java.util.List;

public interface TallySheetService {

    TallySheet save(final TallySheet tallySheet);

    List<TallySheet> getAll();

    TallySheet getById(String id);

    void deleteAll();

    boolean deleteById(String id);

}

