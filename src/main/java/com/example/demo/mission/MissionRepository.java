package com.example.demo.mission;

import com.example.demo.Consultant.Consultant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;


@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
interface MissionRepository extends JpaRepository<Mission, Long> {
    Page<Mission> findByConsultantId(Long consultantId, Pageable pageable);

    Page<Mission> findByConsultantIdAndId(Long consultantId, Long id, Pageable pageable);

}
