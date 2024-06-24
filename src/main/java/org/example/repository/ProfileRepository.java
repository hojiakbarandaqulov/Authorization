package org.example.repository;

import org.example.entity.ProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface ProfileRepository extends JpaRepository<ProfileEntity, Long>, PagingAndSortingRepository<ProfileEntity, Long> {

    Optional<ProfileEntity> findByEmailAndVisibleTrue(String email);

}
