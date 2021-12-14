package ec.edu.ups.EvaluacionU2.bussines;

import java.util.List;

import javax.ejb.Remote;

import ec.edu.ups.EvaluacionU2.model.Libro;

//usurio PlataformasWeb
// contrasenia PlataformasWeb
@Remote
public interface LibrosOnRemote {
	
	public void insertar(Libro l) ;
	public void update(Libro l);
}
