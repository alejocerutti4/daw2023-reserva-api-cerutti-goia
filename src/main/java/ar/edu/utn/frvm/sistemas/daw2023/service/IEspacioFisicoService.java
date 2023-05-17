package ar.edu.utn.frvm.sistemas.daw2023.service;

import ar.edu.utn.frvm.sistemas.daw2023.model.EspacioFisico;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEspacioFisicoService extends IService<EspacioFisico>{
    public Iterable<EspacioFisico> getFiltroNombre(String nombre, Pageable p);
    public List<EspacioFisico> getFiltroCapacidad(Integer capacidad);

    public List<EspacioFisico> getFiltroNombreCapacidad(String nombre, Integer capacidad);
}
