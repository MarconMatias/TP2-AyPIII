package edu.fiuba.algo3.vista.Calendario;

import edu.fiuba.algo3.componentes.Imagen.Imagen;
import edu.fiuba.algo3.componentes.RelativoAImagen.RelativoAImagen;
import edu.fiuba.algo3.modelo.Juego.Calendario;
import javafx.beans.binding.IntegerExpression;
import javafx.beans.binding.ObjectExpression;
import javafx.scene.image.Image;

public class Reloj extends RelativoAImagen {
    private static final Image fondo = new Image(Imagen.urlDesdeRecursos("Calendario/Reloj_fondo.png"));
    //private final ImageView imageView;
    private final ObjectExpression<Calendario> calendario;

    public Reloj(ObjectExpression<Calendario> calendario) {
        super(fondo);
        IntegerExpression hora = calendario.get().getHoraObservable();
        hora.addListener(ob->System.out.println("Hora: "+hora.get()));

        /*imageView = new ImageView(fondo);
        imageView.setFitWidth(fondo.getWidth());
        imageView.setFitHeight(fondo.getHeight());
        getChildren().setAll(imageView);*/
        this.calendario = calendario;
    }
}
