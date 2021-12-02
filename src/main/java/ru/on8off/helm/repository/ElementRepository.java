package ru.on8off.helm.repository;

import ru.on8off.helm.repository.entity.Element;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ElementRepository extends JpaRepository<Element, Integer>, JpaSpecificationExecutor<Element> {
}
