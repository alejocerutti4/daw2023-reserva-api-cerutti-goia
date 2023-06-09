package ar.edu.utn.frvm.sistemas.daw2023.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity(name = "estado")
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Estado extends ObjectoDB{
    private String nombre;

    private String color;
    @ManyToOne
    private Ambito ambito;

}
