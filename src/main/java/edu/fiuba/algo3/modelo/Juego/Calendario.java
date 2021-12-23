package edu.fiuba.algo3.modelo.Juego;

import edu.fiuba.algo3.modelo.Acciones.AccionDormir;
import edu.fiuba.algo3.modelo.Acciones.IAccion;
import javafx.beans.binding.DoubleExpression;
import javafx.beans.binding.IntegerExpression;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static javafx.beans.binding.Bindings.createIntegerBinding;

public class Calendario {
    private IntegerProperty horasActuales = new SimpleIntegerProperty(0);
    private IntegerExpression horaDelDia = createIntegerBinding(this::getHoraDelDia,horasActuales);

    private final int inicioDia = 1; // Lunes
    private final int inicioHs = 7; // 7 hs.;
    //private final int finalHs = 17; // 17 hs.

    private final int dormirDesde = 22;
    private final int dormirDurante = 8;
    private final int dormirHasta = (dormirDesde+dormirDurante)%24;
    private final Set<IObservadorAcciones> observadoresAcciones = new HashSet<IObservadorAcciones>();

    private int calcularHoraDelDia(int horas)
    {
        return (horas + inicioHs)%24;
    }

    private DoubleExpression horaObservable;

    /**
     * @return La hora del día en la que se encuentra, desde 0 hs, hasta 23 hs.
     */
    public int getHoraDelDia()
    {
        return calcularHoraDelDia(horasActuales.get());
    }

    /**
     * @return El día de la semana en el que se encuentra, desde 0 para domingo hasta 6 para sábado.
     */
    public int getDiaDeLaSemana()
    {
        int hs = horasActuales.get() + inicioHs;
        hs += inicioDia*24;
        return (int) Math.floor(hs/24)%7;
    }

    /**
     * @return Devuelve la cantidad de días en la misión. Comienza en 0 y cada medianoche suma 1.
     */
    public int getCantidadDeDias()
    {
        int hs = horasActuales.get() + inicioHs;
        return (int) Math.floor(hs/24);
    }

    /**
     * Avanza el calendario al menos `horas`, durmiendo varias horas adicionales si es necesario.
     * @param horas Cantidad de horas que dura la acción que avanza el calendario.
     */
    public void avanzarHoras(int horas)
    {
        int siguiente = horasActuales.get() + horas;
        boolean debeDormir = this.deberiaDormirSiAvanzaHasta(siguiente);
        this.avanzarSolamente(horas);
        if(debeDormir) {
            aplicarAccion(new AccionDormir());
        }
    }

    /**
     * Avanza la cantidad de horas indicadas, sin consideraciones adicionales (como dormir).
     * @param horas Cantidad de horas a avanzar.
     */
    private void avanzarSolamente(int horas)
    {
        horasActuales.set(horasActuales.get() + horas);
    }

    /**
     * Indica si es una hora del día a la que debería dormir.
     * @param hs Hora del día a evaluar.
     * @return
     */
    private boolean esHoraDeDormir(int hs)
    {
        if(dormirDesde < dormirHasta)
            return (hs >= dormirDesde) && (hs < dormirHasta);
        return (hs >= dormirDesde) || (hs <dormirHasta);
    }


    private boolean deberiaDormirSiAvanzaHasta(int horasSiguiente)
    {
       int hsSiguiente = calcularHoraDelDia(horasSiguiente);
       return !esHoraDeDormir(getHoraDelDia()) && esHoraDeDormir(hsSiguiente);
    }

    public void aplicarAccion(IAccion accion) {
        notificarObservadores(accion);
        accion.avanzarCalendario(this);
        accion.realizar();
    }

    private void notificarObservadores(IAccion accion) {
        ArrayList<RuntimeException> excepciones = new ArrayList<>();
        for(IObservadorAcciones observador : observadoresAcciones)
        try {
            observador.accionRealizada(accion);
        } catch(RuntimeException ex) {
            excepciones.add(ex);
        }
        if(excepciones.size()>0) {
            throw new RuntimeException("Hubo "+excepciones.size()+" errores al notificar observadores de acción.");
        }
    }

    public void observarAcciones(IObservadorAcciones observador) {
        observadoresAcciones.add(observador);
    }
    public void desobservarAcciones(IObservadorAcciones observador) {
        observadoresAcciones.remove(observador);
    }

    public IntegerExpression getHoraObservable() {
        return horaDelDia;
    }
}
