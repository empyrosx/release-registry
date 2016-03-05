package ru.empyros.repository;

import ru.empyros.model.Release;

import java.util.List;

/**
 * Interface for releases repository.
 */
public interface ReleasesRepository {

    /**
     * Returns all instances of the type.
     *
     * @return all entities
     */
    List<Release> getAll();

    /**
     * Retrieves an entity by its id.
     *
     * @param id must not be {@literal null}.
     * @return the entity with the given id or {@literal null} if none found
     * @throws IllegalArgumentException if {@code id} is {@literal null}
     */
    Release get(int id);

    /**
     * Saves a given entity.
     * Use the returned instance for further operations as the save operation might have changed the
     * entity instance completely.
     *
     * @param entity
     * @return the saved entity
     */
    Release update(Release entity);

    /**
     * Deletes the entity with the given id.
     *
     * @param id must not be {@literal null}.
     * @throws IllegalArgumentException in case the given {@code id} is {@literal null}
     */
    void delete(int id);
}
