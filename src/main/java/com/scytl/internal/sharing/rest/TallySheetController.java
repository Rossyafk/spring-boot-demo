package com.scytl.internal.sharing.rest;

import com.scytl.internal.sharing.rest.model.TallySheet;
import com.scytl.internal.sharing.rest.service.TallySheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class TallySheetController {

    private final TallySheetService tallySheetService;

    @Autowired
    public TallySheetController(final TallySheetService tallySheetService) {
        this.tallySheetService = tallySheetService;
    }

    @RequestMapping(value = "/tally-sheets", method = RequestMethod.POST)
    public TallySheet createTallySheet(@RequestBody @Valid TallySheet tallySheet) {
        return tallySheetService.save(tallySheet);
    }

    @RequestMapping(value = "/tally-sheets", method = RequestMethod.GET)
    public List<TallySheet> showAllTallySheets() {
        return tallySheetService.getAll();
    }

    @RequestMapping(value = "/tally-sheets/{tallySheetId}", method = RequestMethod.GET)
    public TallySheet showTallySheet(@PathVariable String tallySheetId) {
        return tallySheetService.getById(tallySheetId);
    }

    @RequestMapping(value = "/tally-sheets", method = RequestMethod.DELETE)
    public void deleteAllTallySheets() {
        tallySheetService.deleteAll();
    }

    @RequestMapping(value = "/tally-sheets/{tallySheetId}", method = RequestMethod.DELETE)
    public boolean deleteTallySheet(@PathVariable String tallySheetId) {
        return tallySheetService.deleteById(tallySheetId);
    }

}
