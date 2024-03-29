package ar.edu.utn.frvm.sistemas.daw2023.controller;

import ar.edu.utn.frvm.sistemas.daw2023.exception.CustomException;
import ar.edu.utn.frvm.sistemas.daw2023.model.EspacioFisico;
import ar.edu.utn.frvm.sistemas.daw2023.service.IEspacioFisicoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/espaciosFisicos/")
@CrossOrigin(origins = "*")
public class EspacioFisicoController {
    private final IEspacioFisicoService espacioFisicoService;

    public EspacioFisicoController(IEspacioFisicoService espacioFisicoService) {
        this.espacioFisicoService = espacioFisicoService;
    }

    @GetMapping("/all")
    public List<EspacioFisico> getAll() {
        return this.espacioFisicoService.getAll();
    }

    @GetMapping
    public Page<EspacioFisico> getAll(Pageable page){
        return this.espacioFisicoService.getAll(page);
    }

    @GetMapping("/{id}")
    public EspacioFisico getById(@PathVariable Integer id){
        try {
            return this.espacioFisicoService.getById(id);
        } catch (Exception e) {
            throw new CustomException(404, "Espacio fisico no encontrado");
        }
    }

    @GetMapping(value = "/search", params = {"nombre", "page"})
    public Page<EspacioFisico> getFiltroNombre(Pageable page, @RequestParam(name="nombre",required=true) String nombre){
        return this.espacioFisicoService.getFiltroNombre(nombre, page);
    }

    @GetMapping(value = "/search", params = {"capacidad", "page"})
    public Page<EspacioFisico> getFiltroCapacidad(Pageable page, @RequestParam(required=true) Integer capacidad){
        return this.espacioFisicoService.getFiltroCapacidad(capacidad, page);
    }

    @GetMapping(value = "/search", params = {"nombre", "capacidad", "page"})
    public Page<EspacioFisico> getFiltroNombreCapacidad(Pageable page, @RequestParam(name = "nombre", required=true) String nombre, @RequestParam(name = "capacidad", required=true) Integer capacidad){
        return this.espacioFisicoService.getFiltroNombreCapacidad(nombre, capacidad, page);
    }

    @PostMapping
    public ResponseEntity<EspacioFisico> add(@RequestBody EspacioFisico espacioFisico){
        this.espacioFisicoService.add(espacioFisico);
        EspacioFisico newEspacioFisico = espacioFisicoService.getById(espacioFisico.getId());
        return ResponseEntity.ok(newEspacioFisico);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EspacioFisico> update(@PathVariable Integer id, @RequestBody EspacioFisico espacioFisico){
        this.espacioFisicoService.update(id, espacioFisico);
        EspacioFisico newEspacioFisico = espacioFisicoService.getById(espacioFisico.getId());
        return ResponseEntity.ok(newEspacioFisico);
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<String> delete(@PathVariable Integer id){
        String responseMessage = this.espacioFisicoService.delete(id);
        return ResponseEntity.ok().body("{\"message\": \"" + responseMessage + "\"}");
    }
}
