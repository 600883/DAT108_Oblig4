package no.hvl.dat108.FestPaameldingApp.repository;

import no.hvl.dat108.FestPaameldingApp.model.Deltager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DeltagerRepository extends JpaRepository<Deltager, String> {
    Deltager findByMobil(String mobil);

    boolean existsByMobil(String mobil);

}
