package com.example.gestioncandidat;

public interface ICandidatService {
     Candidat addCandidat(Candidat candidate);
      Candidat updateCandidat(int id, Candidat newCandidat);
    String deleteCandidat(int id);
}
