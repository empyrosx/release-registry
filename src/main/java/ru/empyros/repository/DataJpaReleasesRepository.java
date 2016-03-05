package ru.empyros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import ru.empyros.model.Release;

@Transactional(readOnly = true)
public interface DataJpaReleasesRepository extends JpaRepository<Release, Integer> {
}