package ru.empyros.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.empyros.model.Release;
import ru.empyros.service.ReleasesService;

import java.net.URI;
import java.util.List;

@Controller
@RestController
@RequestMapping(value = ReleasesRestController.REST_UPDATES_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class ReleasesRestController {

    public static final String REST_UPDATES_URL = "/rest/releases";

    @Autowired
    private ReleasesService service;

    @RequestMapping(method = RequestMethod.GET)
    public List<Release> getAll() {
        return service.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Release get(@PathVariable("id") int id) {
        return service.get(id);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Release update(@RequestBody Release entity) {
        return service.update(entity);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Release> create(@RequestBody Release release) {
        release.setId(null);
        Release entity = service.update(release);

        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_UPDATES_URL + "/{id}")
                .buildAndExpand(entity.getId()).toUri();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(uri);
        return new ResponseEntity<>(entity, httpHeaders, HttpStatus.CREATED);
    }
}