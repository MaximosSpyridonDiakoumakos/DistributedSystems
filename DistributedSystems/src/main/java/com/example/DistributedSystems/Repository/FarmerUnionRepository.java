package com.example.DistributedSystems.Repository;

import com.example.DistributedSystems.Entity.FarmerUnion;
//import org.eclipse.sisu.Hidden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FarmerUnionRepository extends JpaRepository<FarmerUnion, Integer> {
}
