package ar.edu.utn.frvm.sistemas.daw2023.controller;

import ar.edu.utn.frvm.sistemas.daw2023.exception.CustomException;
import ar.edu.utn.frvm.sistemas.daw2023.exception.ErrorResponse;
import ar.edu.utn.frvm.sistemas.daw2023.model.Reserva;
import ar.edu.utn.frvm.sistemas.daw2023.service.IReservaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservas/")
@CrossOrigin(origins = "*")
public class ReservaController {
    private final IReservaService reservaService;

    public ReservaController(IReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @GetMapping
    public Page<Reserva> getAll(Pageable page){
        return this.reservaService.getAll(page);
    }

    @GetMapping("/{id}")
    public Reserva getById(@PathVariable Integer id){
        try {
            return this.reservaService.getById(id);
        } catch (Exception e) {
            throw new CustomException(404, "Reserva no encontrada");
        }
    }

    @PostMapping
    public ResponseEntity<Object> add(@RequestBody Reserva reserva) {
        try {
            Reserva addedReserva = this.reservaService.add(reserva);
            return ResponseEntity.ok(addedReserva);
        } catch (Exception e) {
            ErrorResponse errorResponse = new ErrorResponse(42, e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    @PutMapping("/{id}")
    public Reserva update(@PathVariable Integer id, @RequestBody Reserva reserva){
        return this.reservaService.update(id, reserva);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id){
        return this.reservaService.delete(id);
    }

}
