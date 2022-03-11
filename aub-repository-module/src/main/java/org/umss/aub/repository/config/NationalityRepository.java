package org.umss.aub.repository.config;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.umss.aub.domain.config.Nationality;

public interface NationalityRepository extends JpaRepository<Nationality, Integer>,
        PagingAndSortingRepository<Nationality, Integer> {


}
