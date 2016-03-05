package ru.empyros.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.empyros.model.Release;
import ru.empyros.repository.ReleasesRepositoryImpl;

import java.util.List;

@Service
public class ReleasesServiceImpl implements ReleasesService {

    @Autowired
    private ReleasesRepositoryImpl repository;

    @Override
    public List<Release> getAll() {
        return repository.getAll();
    }

    @Override
    public Release get(int id) {
        return repository.get(id);
    }

    @Override
    public Release update(Release entity) {
        return repository.update(entity);
    }

    @Override
    public void delete(int id) {
        repository.delete(id);
    }
}