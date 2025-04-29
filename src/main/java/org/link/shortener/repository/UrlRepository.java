package org.link.shortener.repository;

import org.link.shortener.model.Url;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UrlRepository extends CrudRepository<Url,Long> {
    Optional<Url> findUrlByCode(String code);
}
