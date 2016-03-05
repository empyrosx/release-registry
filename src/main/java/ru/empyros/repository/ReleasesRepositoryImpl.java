package ru.empyros.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.empyros.model.Release;

import java.util.List;

@Repository
public class ReleasesRepositoryImpl implements ReleasesRepository {

    @Autowired
    private DataJpaReleasesRepository jpaRepository;

    @Override
    public List<Release> getAll() {
        return jpaRepository.findAll();
    }

    @Override
    public Release get(int id) {
        return jpaRepository.findOne(id);
    }

    @Override
    public Release update(Release entity) {
        return jpaRepository.save(entity);
    }

    @Override
    public void delete(int id) {
        jpaRepository.delete(id);
    }
}
