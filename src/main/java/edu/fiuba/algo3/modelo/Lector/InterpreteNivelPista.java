package edu.fiuba.algo3.modelo.Lector;

import edu.fiuba.algo3.modelo.Pista.NivelPista.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class InterpreteNivelPista {
    private final static ArrayList<Supplier<NivelPista>> factories = new ArrayList<>(
            List.of(
                    () -> new PistaFacil(),
                    () -> new PistaMedia(),
                    () -> new PistaDificil()
            )
    );

    public static NivelPista crearConDificultad(int dificultad) {
        if(dificultad>=factories.size()) {
            System.err.println("Advertencia: No existe dificultad "+dificultad+", asumiendo máxima.");
            dificultad = factories.size()-1;
        }
        Supplier<NivelPista> factory = factories.get(dificultad);
        return factory.get();
    }
}
