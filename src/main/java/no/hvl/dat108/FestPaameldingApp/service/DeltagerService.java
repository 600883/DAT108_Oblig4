package no.hvl.dat108.FestPaameldingApp.service;

import no.hvl.dat108.FestPaameldingApp.model.Deltager;
import no.hvl.dat108.FestPaameldingApp.repository.DeltagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DeltagerService {

    private DeltagerRepository deltagerRepository;

    @Autowired
    public DeltagerService(DeltagerRepository deltagerRepository) {
        this.deltagerRepository = deltagerRepository;
    }

    public Deltager saveUser(Deltager deltager) {

        Deltager nyDeltager = deltagerRepository.save(deltager);

        return nyDeltager;
    }

    public void deleteDeltager(String mobil) {
        Deltager deltager = deltagerRepository.findByMobil(mobil);
        deltagerRepository.deleteById(mobil);
    }

    public List<Deltager> findAllDeltagere() {
        List<Deltager> deltagerList = (List<Deltager>) deltagerRepository.findAll();
        return deltagerList;
    }

    public Deltager findUser(String mobil) {
        Deltager deltager = deltagerRepository.findByMobil(mobil);

        return deltager;
    }

    public boolean exists(String mobil) {
        return deltagerRepository.existsByMobil(mobil);
    }
}