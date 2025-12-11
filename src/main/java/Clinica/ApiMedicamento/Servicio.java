/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clinica.ApiMedicamento;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Servicio {

    @Autowired
    private Repositorio repo;

    public Medicamento grabar(Medicamento med) {
        return repo.save(med);
    }

    public Medicamento buscar(Long id) {
        return repo.findById(id).orElse(null);
    }

    public List<Medicamento> listar() {
        return repo.findAll();
    }

    public Medicamento actualizar(Long id, Medicamento med) {
        return repo.findById(id).map(existing -> {
            existing.setNom(med.getNom());
            existing.setDes(med.getDes());
            existing.setPre(med.getPre());
            return repo.save(existing);
        }).orElse(null);
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}
