package com.scytl.internal.sharing.rest.service;


import com.scytl.internal.sharing.rest.model.TallySheet;
import com.scytl.internal.sharing.rest.repository.TallySheetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TallySheetServiceImpl implements TallySheetService {

    private final TallySheetRepository tallySheetResitory;

    @Autowired
    public TallySheetServiceImpl(final TallySheetRepository tallySheetRepository) {
        this.tallySheetResitory = tallySheetRepository;
    }

    @Override
    @Transactional
    public TallySheet save(TallySheet tallySheet) {
        return tallySheetResitory.save(tallySheet);
    }

    @Override
    @Transactional
    public List<TallySheet> getAll() {
        return tallySheetResitory.findAll();
    }

    @Override
    @Transactional
    public TallySheet getById(String id) {
        return tallySheetResitory.findOne(id);
    }

    @Override
    @Transactional
    public void deleteAll() {
        tallySheetResitory.deleteAll();
    }

    @Override
    @Transactional
    public boolean deleteById(String id) {

        boolean deleted = false;

        if (tallySheetResitory.exists(id)) {
            tallySheetResitory.delete(id);
            deleted = true;
        }

        return deleted;
    }
}
