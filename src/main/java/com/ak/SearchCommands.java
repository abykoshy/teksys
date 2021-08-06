package com.ak;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class SearchCommands {
    private final SearchService service;

    @Autowired
    public SearchCommands(SearchService service) {
        this.service = service;
    }

    @ShellMethod("Translate text from one language to another.")
    public String search(
            @ShellOption("-e") String entity,
            @ShellOption("-c") String mainCriteria
    ) throws SearchServiceException {
        service.initializeFromFile();
        // invoke service
        return Jsonify.asJson(service.search(entity, mainCriteria));
    }
}
