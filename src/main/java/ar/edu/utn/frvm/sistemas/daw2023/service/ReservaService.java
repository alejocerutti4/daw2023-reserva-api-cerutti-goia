package ar.edu.utn.frvm.sistemas.daw2023.service;

import ar.edu.utn.frvm.sistemas.daw2023.model.Reserva;
import ar.edu.utn.frvm.sistemas.daw2023.repository.ReservaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ReservaService implements IReservaService{
    private final ReservaRepository reservaRepository;

    public ReservaService(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    @Override
    public Reserva getById(Integer id) {
        return null;
    }

    @Override
    public Reserva add(Reserva reserva) {
        return null;
    }

    @Override
    public Reserva update(Integer id, Reserva reserva) {
        return null;
    }

    @Override
    public String delete(Integer id) {
        return null;
    }

    @Override
    public Page<Reserva> getAll(Pageable p) {
        return null;
    }
}