package com.example.gestioncandidat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CandidatRestAPI {
    @Autowired
    private CandidatRepo repository;
    @Autowired
    private CandidatService candidatService;
    @GetMapping("/candidats")
    public List<Candidat> getAll() {
        return candidatService.getAll();
    }

    @GetMapping("/candidats/search/candidatByNom")
    public Page<Candidat> searchCandidatesByName(
            @RequestParam("name") String name,
            Pageable pageable) {
        return repository.candidatByNom ("%" + name + "%", pageable);
    }

    @PostMapping(consumes = MediaType.APPLICATION_XML_VALUE) @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Candidat> createCandidat(@RequestBody Candidat candidat) { return new ResponseEntity<>(candidatService.addCandidat(candidat), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE) @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Candidat> updateCandidat(@PathVariable(value = "id") int id,
                                                   @RequestBody Candidat candidat){ return new ResponseEntity<>(candidatService.updateCandidat(id, candidat),
            HttpStatus.OK);
    }


    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE) @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteCandidat(@PathVariable(value = "id") int id){ return new ResponseEntity<>(candidatService.deleteCandidat(id), HttpStatus.OK);
    }

}
