package com.scytl.internal.sharing.rest.service;


import com.scytl.internal.sharing.rest.model.TallySheet;

import java.util.List;

public interface TallySheetService {

    TallySheet save(final TallySheet tallySheet);

    List<TallySheet> getAll();

    TallySheet getById(String id);

    void deleteAll();

    boolean deleteById(String id);

}

