/**
 * 
 */
package com.example.mycrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.mycrud.model.Mobility;

/**
 * 
 */
@Repository
public interface MobilitiesRepository extends JpaRepository<Mobility, Long>{

}
