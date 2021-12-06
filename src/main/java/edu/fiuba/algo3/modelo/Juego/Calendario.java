package edu.fiuba.algo3.modelo.Juego;

public class Calendario {
    private int horasActuales = 0;

    private final int inicioDia = 1; // Lunes
    private final int inicioHs = 7; // 7 hs.;
    //private final int finalHs = 17; // 17 hs.

    private final int dormirDesde = 22;
    private final int dormirDurante = 8;
    private final int dormirHasta = (dormirDesde+dormirDurante)%24;

    private int calcularHoraDelDia(int horas)
    {
        return (horas + inicioHs)%24;
    }

    /**
     * @return La hora del día en la que se encuentra, desde 0 hs, hasta 23 hs.
     */
    public int getHoraDelDia()
    {
        return calcularHoraDelDia(horasActuales);
    }

    /**
     * @return El día de la semana en el que se encuentra, desde 0 para domingo hasta 6 para sábado.
     */
    public int getDiaDeLaSemana()
    {
        int hs = horasActuales + inicioHs;
        hs += inicioDia*24;
        return (int) Math.floor(hs/24)%7;
    }

    /**
     * @return Devuelve la cantidad de días en la misión. Comienza en 0 y cada medianoche suma 1.
     */
    public int getCantidadDeDias()
    {
        int hs = horasActuales + inicioHs;
        return (int) Math.floor(hs/24);
    }


    /**
     * Avanza el calendario al menos `horas`, durmiendo varias horas adicionales si es necesario.
     * @param horas Cantidad de horas que dura la acción que avanza el calendario.
     */
    public void avanzarHoras(int horas)
    {
        int siguiente = this.horasActuales + horas;
        if(this.deberiaDormirSiAvanzaHasta(siguiente))
        {
            this.dormir();
        }
        this.avanzarSolamente(horas);
    }

    /**
     * Avanza la cantidad de horas indicadas, sin consideraciones adicionales (como dormir).
     * @param horas Cantidad de horas a avanzar.
     */
    private void avanzarSolamente(int horas)
    {
        this.horasActuales += horas;
    }

    /**
     * Avanza el calendario de acuerdo a la cantidad de horas necesarias para dormir.
     */
    private void dormir()
    {
        this.avanzarSolamente(dormirDurante);
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

}
