package edu.fiuba.algo3.componentes.Radio;

import edu.fiuba.algo3.componentes.Imagen.Imagen;
import edu.fiuba.algo3.modelo.Evento.RadioEvento;
import edu.fiuba.algo3.modelo.Evento.TrackCambia;
import edu.fiuba.algo3.modelo.Radio.Radio;
import javafx.scene.media.*;

import java.util.*;

public class RadioSonido {
    private final Radio radio;
    private final List<Media> medias = new ArrayList<Media>();
    private MediaPlayer musica;

    public RadioSonido(Radio radio) {
        this.radio = radio;
        radio.escucharTracks(this::trackCambia);
        for(int i=1; i<4; i++) {
            medias.add(getMedia(i));
        }
        trackCambia(new TrackCambia(radio, 1));
    }

    private Media getMedia(int numeroTrack) {
        try {
            return new Media(getMediaPath(numeroTrack));
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private String getMediaPath(int numeroTrack) {
        String recurso = String.format("radio/track%02d.mp3",numeroTrack);
        String path = Imagen.urlDesdeRecursos(recurso);
        return path;
    }

    private void trackCambia(RadioEvento ev) {
        try {
            int numero = ((TrackCambia) ev).getNumeroTrack();
            if(null!=musica) {
                musica.stop();
            }
            musica = null;
            if(numero>0) {
                musica = new MediaPlayer(medias.get(numero-1));
                musica.setAutoPlay(true);
                musica.setCycleCount(MediaPlayer.INDEFINITE);
                musica.play();
                radio.setTitulo(String.format("Track %02d",numero));
            } else {
                radio.setTitulo("");
            }
        } catch (RuntimeException ex) {
            ex.printStackTrace();
            radio.setTitulo("ERROR");
        }
    }
}
