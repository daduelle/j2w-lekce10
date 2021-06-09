package cz.czechitas.java2webapps.lekce10.service;

import cz.czechitas.java2webapps.lekce10.entity.Rodic;
import cz.czechitas.java2webapps.lekce10.entity.Student;
import cz.czechitas.java2webapps.lekce10.entity.Trida;
import cz.czechitas.java2webapps.lekce10.entity.Ucitel;
import cz.czechitas.java2webapps.lekce10.repository.RodicRepository;
import cz.czechitas.java2webapps.lekce10.repository.StudentRepository;
import cz.czechitas.java2webapps.lekce10.repository.TridaRepository;
import cz.czechitas.java2webapps.lekce10.repository.UcitelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkolaService {

    private final TridaRepository tridaRepository;
    private final StudentRepository studentRepository;
    private final RodicRepository rodicRepository;
    private final UcitelRepository ucitelRepository;


    @Autowired
    public SkolaService(TridaRepository tridaRepository, StudentRepository studentRepository, RodicRepository rodicRepository, UcitelRepository ucitelRepository) {
        this.tridaRepository = tridaRepository;
        this.studentRepository = studentRepository;
        this.rodicRepository = rodicRepository;
        this.ucitelRepository = ucitelRepository;

    }

    // metoda vrací seznam všech tříd ve škole
    public Page<Trida> findAll() {
        final Pageable pageable = PageRequest.of(0, Math.toIntExact(tridaRepository.count()));
        return tridaRepository.findAll(pageable);
    }


    // metoda vrací (vybranou) jednu třídu dle zadaného názvu
    public Trida jednaTrida(String nazev) {

        return tridaRepository.findByNazev(nazev);
    }

    // metoda vrací seznam studentů vybrané třídy
    public Page<Student> vyhledejStudentyTridy(String nazev, Pageable pageable) {
        return studentRepository.findStudentsByTridaNazev(nazev, pageable);
    }

    // metoda vrací (vybraného) jednoho studenta dle id
    public Optional<Student> jedenStudent(Integer id) {

        return studentRepository.findById(id);
    }

    // metoda vrací detaily rodiče vybraného studenta
    public List<Rodic> rodiceStudenta (Integer id, Pageable pageable) {
        return rodicRepository.findByDetiId(id, pageable);
    }

    // metoda vrací údaje o učiteli dle vybrané třídy
    public Ucitel ucitelTridy(String nazev) {
        return ucitelRepository.findByTridaNazev(nazev);
    }
 }




