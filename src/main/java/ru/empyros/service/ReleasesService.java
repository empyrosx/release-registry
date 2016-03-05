package ru.empyros.service;

import ru.empyros.model.Release;

import java.util.List;

/**
 * Interface for releases service.
 */
public interface ReleasesService {

    List<Release> getAll();

    Release get(int id);

    Release update(Release entity);

    void delete(int id);
}
