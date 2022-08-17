package com.app.self.repository;

import com.app.self.entity.MPTime_EO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MPTimeRepository extends JpaRepository<MPTime_EO, Integer> {
}
