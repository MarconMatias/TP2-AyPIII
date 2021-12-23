package edu.fiuba.algo3.modelo.Edificio.TipoEdificio;

<<<<<<< HEAD
import edu.fiuba.algo3.modelo.Pista.Filtro.*;

public class Aeropuerto extends EdificioAbstracto{
    public Aeropuerto() {
        super(new SinFiltro());
=======
<<<<<<< HEAD
=======
import java.util.Collection;
import java.util.List;

>>>>>>> 23139d46d7d80a047c698aaecd0075157e861b59
import edu.fiuba.algo3.modelo.Ciudad.Ciudad;
import edu.fiuba.algo3.modelo.Edificio.Testigo.Testigo;
import edu.fiuba.algo3.modelo.Juego.Calendario;
import edu.fiuba.algo3.modelo.Ladron.Ladron;
import edu.fiuba.algo3.modelo.Pista.PistaCiudad;
import edu.fiuba.algo3.modelo.Policia.Policia;

<<<<<<< HEAD
import java.util.Collection;
import java.util.List;

public class Aeropuerto implements ITipoEdificio{
    @Override
    public String getNombreTipo() {
=======
public class Aeropuerto implements ITipoEdificio{

    @Override
    public List<PistaCiudad> filtrarPistas(Collection<PistaCiudad> sinFiltrar) {
        // TODO Auto-generated method stub
        return null;
>>>>>>> ce92e3cf564b1cd7a8e01fd370036153672bccdd
    }

    @Override
    public String getNombreTipo() {
<<<<<<< HEAD
        return "Aeropuerto";
    }

    @Override
    protected String getNombreTestigo() {
        return "Piloto";
    }
=======
        // TODO Auto-generated method stub
>>>>>>> 23139d46d7d80a047c698aaecd0075157e861b59
        return null;
    }

    @Override
    public Testigo getTestigo() {
<<<<<<< HEAD
=======
        // TODO Auto-generated method stub
>>>>>>> 23139d46d7d80a047c698aaecd0075157e861b59
        return null;
    }

    @Override
    public boolean mostrarPista(Ladron unLadron) {
<<<<<<< HEAD
        return false;
=======
        // TODO Auto-generated method stub
        return true;
>>>>>>> 23139d46d7d80a047c698aaecd0075157e861b59
    }

    @Override
    public void visitadoPorLadron(Ladron ladron, Ciudad destino) {
<<<<<<< HEAD

=======
        // TODO Auto-generated method stub
        
>>>>>>> 23139d46d7d80a047c698aaecd0075157e861b59
    }

    @Override
    public void visitar(Policia policia, Calendario cal) {
<<<<<<< HEAD
>>>>>>> ce92e3cf564b1cd7a8e01fd370036153672bccdd


<<<<<<< HEAD
=======
    @Override
    public List<PistaCiudad> filtrarPistas(Collection<PistaCiudad> sinFiltrar) {
        return null;
    }
=======
        // TODO Auto-generated method stub
        
    }
    
>>>>>>> 23139d46d7d80a047c698aaecd0075157e861b59
>>>>>>> ce92e3cf564b1cd7a8e01fd370036153672bccdd
}

