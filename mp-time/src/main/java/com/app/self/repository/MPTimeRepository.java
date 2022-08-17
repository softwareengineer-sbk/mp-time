package com.app.self.repository;

import com.app.self.entity.MPTime_EO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MPTimeRepository extends JpaRepository<MPTime_EO, Integer> {

    Optional<MPTime_EO> findByMosqueId(Integer mosqueId);
}
