package edu.fiuba.algo3.vista.Calendario;

import edu.fiuba.algo3.componentes.Imagen.Imagen;
import edu.fiuba.algo3.componentes.RelativoAImagen.RelativoAImagen;
import edu.fiuba.algo3.modelo.Calendario.Calendario;
import javafx.beans.binding.IntegerExpression;
import javafx.beans.binding.ObjectExpression;
import javafx.scene.image.Image;

import static javafx.beans.binding.Bindings.createIntegerBinding;

public class Reloj extends RelativoAImagen {
    private static final Image imgFondo = new Image(Imagen.urlDesdeRecursos("Calendario/Reloj_fondo.png"));
    private static final Image imgAguja = new Image(Imagen.urlDesdeRecursos("Calendario/Reloj_hora.png"));
    private static final Image imgVidrio = new Image(Imagen.urlDesdeRecursos("Calendario/Reloj_vidrio.png"));
    //private final ImageView imageView;
    private final ObjectExpression<Calendario> calendario;

    public Reloj(ObjectExpression<Calendario> calendario) {
        super(imgFondo);
        this.calendario = calendario;

        IntegerExpression hora = calendario.get().getHoraObservable();
        hora.addListener(ob->System.out.println("Hora: "+hora.get()));

        IntegerExpression diaSemana = calendario.get().getDiaObservable();
        diaSemana.addListener(obs -> System.out.println("Dia: "+diaSemana.get()));

        TextoReloj inicialesDia = new TextoRelojDia(diaSemana);
        agregar(inicialesDia, 0.5, 0.45);

        TextoReloj ampm = new TextoRelojAM(hora);
        agregar(ampm, 0.5, 0.55);

        Imagen aguja = agregar(new Imagen(imgAguja), 0.5, 0.5);
        aguja.anguloProperty().bind(createIntegerBinding(()->anguloHora(hora), hora));

        agregar(new Imagen(imgVidrio), 0.5, 0.5);
    }

    public static void precargar() {
        /** No necesita cuerpo. La sola invocación de este método precargará los static. **/
    }

    private Integer anguloHora(IntegerExpression hora) {
        final int corrimientoAgujaHora = 10;
        final int ajustada = (hora.get() + corrimientoAgujaHora)%12;
        return ajustada*360/12;
    }
}
