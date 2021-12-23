package edu.fiuba.algo3.modelo.Pista;

import edu.fiuba.algo3.modelo.Pista.NivelPista.NivelPista;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PistaLadronNoFacil extends PistaLadron {

    private static final Map<String, List<String>> detallesPosibles = Map.of(
            "cabello", List.of("Negro", "Rojo", "Rubio", "Castaño"),
            "deporte", List.of("Croquet", "Escalada de montaña", "Tenis"),
            "distincion", List.of("Anillo", "Tatuaje", "Joyas"),
            "sexo", List.of("Femenino", "Masculino"),
            "vehiculo", List.of("Moto", "Convertible", "Limusina")
    );
    private final int cantidadValores;

    /**
     * Crea una pista sobre el ladrón indicando, no el valor de un detalle, sino valores que no son.
     * 
     * @param tipo Texto del tipo de detalle.
     * @param valor Texto del valor de detalle.
     * @param nivel Nivel de la pista.
     * @param cantidadValores Cantidad de valores que no son a incorporar en la pista (más, es más fácil)
     */
    public PistaLadronNoFacil(String tipo, String valor, NivelPista nivel, int cantidadValores) {
        super(tipo,valor,nivel);
        this.cantidadValores = cantidadValores;
    }

    @Override
    public String toString() {
        if( (null == tipo) || ("".equals(tipo.trim()))
                || (null == valor)  || ("".equals(valor.trim())) ) {
            return noHayDetalles;
        }
        List<String> valoresPosibles = detallesPosibles.get(tipo);
        if( (null == valoresPosibles) || (0 == valoresPosibles.size())) {
            return noHayDetalles;
        }
        String filtrados = valoresPosibles.stream().filter(posible -> !posible.equals(valor.trim()))
                .limit(cantidadValores).collect(Collectors.joining(", ni "));
        return "Recuerdo que su "+tipo+" no era "+filtrados+".";
    }
}
