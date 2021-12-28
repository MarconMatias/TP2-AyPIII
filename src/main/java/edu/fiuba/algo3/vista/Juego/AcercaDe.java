package edu.fiuba.algo3.vista.Juego;

import edu.fiuba.algo3.componentes.Imagen.IconoEdificios;
import edu.fiuba.algo3.componentes.Imagen.IconoVolver;
import edu.fiuba.algo3.componentes.Imagen.Mapita;
import edu.fiuba.algo3.componentes.Libro.Libro;
import edu.fiuba.algo3.controlador.Juego.AcercaDeControlador;
import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.modelo.Juego.Mision;
import edu.fiuba.algo3.vista.Orden.IconoOrden;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.transform.Rotate;

public class AcercaDe extends Libro{
    public AcercaDe(Juego juego, Mision mision, AcercaDeControlador controlador){
        Label tituloCiudad = new Label();
        tituloCiudad.setText("Ayuda");
        tituloCiudad.setAlignment(Pos.CENTER);
        tituloCiudad.setMaxWidth(960);
        tituloCiudad.setMaxHeight(384);
        tituloCiudad.setWrapText(true);
        tituloCiudad.setStyle("-fx-font: 120 Impact");
        tituloCiudad.getStyleClass().add("etiquetaTituloLibroCiudad");
        tituloCiudad.getTransforms().setAll(new Rotate(2d, 0,0));
        agregar(tituloCiudad, 0.368, 0.225);

        Label textoAyuda = new Label();
        textoAyuda.setAlignment(Pos.CENTER);
        textoAyuda.setText("Un individuo desconocido se robó un objeto muy importante, realiza la investigación necesaria recolectando rasgos y pistas sobre el ladron viajando por distintas ciudades de todo el mundo. Cada vez que visites un edificio se te brindara informacion sobren el ladron y su proximo destino ¡Atrápalo antes de que se termine el tiempo!");
        textoAyuda.setMaxWidth(960);
        textoAyuda.setMaxHeight(750);
        textoAyuda.setWrapText(true);
        textoAyuda.setStyle("-fx-font: 60 \"Times New Roman\"");
        textoAyuda.getStyleClass().add("etiquetaTextoLibroCiudad");
        agregar(textoAyuda, 0.368, 0.48);


        
         /* TODO ESTO CORRESPONDE A LA VISTA DERECHA */
        
        Label ayuda = new Label();
        ayuda.setText("Acerca De");
        ayuda.setAlignment(Pos.CENTER);
        ayuda.setMaxWidth(960);
        ayuda.setMaxHeight(384);
        ayuda.setWrapText(true);
        ayuda.setStyle("-fx-font: 120 Impact");
        ayuda.getStyleClass().add("etiquetaTituloLibroCiudad");
        ayuda.getTransforms().setAll(new Rotate(0, 0,0));
        agregar(ayuda, 0.65, 0.225);

        
        Label texto = new Label();
        texto.setAlignment(Pos.CENTER);
        texto.setText(/*ciudad.getDetalles()*/"Este juego fue desarrollado por estudiantes de la UBA a modo de trabajo practico para la materia Algoritmos y Programacion III. Cuyos integrantes estan dados a continuacion: -Eloy Alejandro Lautaro Serra Labán -Brenda Haberkon");
        texto.setMaxWidth(960);
        texto.setMaxHeight(576);
        texto.setWrapText(true);
        texto.setStyle("-fx-font: 60 \"Times New Roman\"");
        texto.getStyleClass().add("etiquetaTextoLibroCiudad");
        agregar(texto, 0.655, 0.43);

        Label integrante1 = new Label();
        integrante1.setAlignment(Pos.CENTER);
        integrante1.setText("-Agustin Rodriguez");
        integrante1.setMaxWidth(960);
        integrante1.setMaxHeight(576);
        integrante1.setWrapText(true);
        integrante1.setStyle("-fx-font: 60 \"Times New Roman\"");
        integrante1.getStyleClass().add("etiquetaTextoLibroCiudad");
        agregar(integrante1, 0.592, 0.56);
        
        Label integrante2 = new Label();
        integrante2.setAlignment(Pos.CENTER);
        integrante2.setText("-Matias Nicolas Marcon");
        integrante2.setMaxWidth(960);
        integrante2.setMaxHeight(576);
        integrante2.setWrapText(true);
        integrante2.setStyle("-fx-font: 60 \"Times New Roman\"");
        integrante2.getStyleClass().add("etiquetaTextoLibroCiudad");
        agregar(integrante2, 0.606, 0.592);

        /* TERMINA LA VISTA DERECHA */

        // Mostrar si está en una misión, no en el menú principal:
        if(null != mision) {
            Mapita mapita = new Mapita(640);
            agregar(mapita, 0.08, 0.4);

            IconoEdificios edificios = new IconoEdificios(640);
            agregar(edificios, 0.08, 0.5);

            IconoOrden orden = new IconoOrden(480);
            agregar(orden, 0.08, 0.6);

            setCalendario(mision.getCalendario());
            setRelojVisible(true);

            if(null != controlador) {
                if(null != mapita) {
                    mapita.setOnMouseClicked(controlador::mapitaClicked);
                    mapita.setOnKeyPressed(controlador::mapitaKeyPressed);
                }
                if(null != edificios) {
                    edificios.setOnMouseClicked(controlador::edificiosClicked);
                    edificios.setOnKeyPressed(controlador::edificiosKeyPressed);
                }
                if(null != orden) {
                    orden.setOnMouseClicked(controlador::ordenClicked);
                    orden.setOnKeyPressed(controlador::ordenKeyPressed);
                }
            }

        } else {
            IconoVolver volver = new IconoVolver(320);
            agregar(volver, 0.9, 0.1);
            if((null != volver)&&(null!=controlador)) {
                volver.setOnMouseClicked(controlador::volverClicked);
                volver.setOnKeyPressed(controlador::volverKeyPressed);
            }
        }
        setRadio(juego.getRadio());
    }


}
