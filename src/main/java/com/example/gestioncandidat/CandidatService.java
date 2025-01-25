package com.example.gestioncandidat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CandidatService implements ICandidatService{
    @Autowired
    private CandidatRepo candidateRepository;

    @Override
    public Candidat addCandidat(Candidat candidate) {
        return candidateRepository.save(candidate);
    }

    @Override
    public Candidat updateCandidat(int id, Candidat newCandidat) {
        if (candidateRepository.findById(id).isPresent()) {

            Candidat existingCandidat = candidateRepository.findById(id).get(); existingCandidat.setNom(newCandidat.getNom()); existingCandidat.setPrenom(newCandidat.getPrenom()); existingCandidat.setEmail(newCandidat.getEmail());

            return candidateRepository.save(existingCandidat);
        } else
            return null;

    }

    @Override
    public String deleteCandidat(int id) {
        if (candidateRepository.findById(id).isPresent()) { candidateRepository.deleteById(id);
            return "candidat supprimé";
        } else
            return "candidat non supprimé";

    }

}
