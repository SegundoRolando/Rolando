package ec.edu.ups.PlataformasWebCliente.view;

import java.util.Date;
import java.util.Hashtable;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;

import ec.edu.ups.EvaluacionU2.bussines.LibrosOnRemote;
import ec.edu.ups.EvaluacionU2.model.Libro;


public class VentanaCalculadora {

	
	private LibrosOnRemote librosOnRemote;
	
	public void conectar() throws Exception {
		try {  
            final Hashtable<String, Comparable> jndiProperties =  
                    new Hashtable<String, Comparable>();  
            jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY,  
                    "org.wildfly.naming.client.WildFlyInitialContextFactory");  
            jndiProperties.put("jboss.naming.client.ejb.context", true);  
              
            jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");  
            jndiProperties.put(Context.SECURITY_PRINCIPAL, "PlataformasWeb");  
            jndiProperties.put(Context.SECURITY_CREDENTIALS, "PlataformasWeb");  
            final Context context = new InitialContext(jndiProperties);   
          //---------------------------------------------------------------------------Producto-----------------------------------
            final String lookupName = "ejb:/PlataformasWeb/LibrosOn!ec.edu.ups.EvaluacionU2.bussines.LibrosOnRemote";  
  
            this.librosOnRemote = (LibrosOnRemote) context.lookup(lookupName);
            
        } catch (Exception ex) {  
            ex.printStackTrace();  
            throw ex;  
        }  
	}
	


	
	public void crearProducto() {
		Libro l = new Libro();
		l.setCodigo(1);
		l.setNombre("Matematicas");
		l.setAutor("Jose Maria");
		l.setAnio("1995");
		try {
			this.librosOnRemote.insertar(l);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VentanaCalculadora vtncCalculadora = new VentanaCalculadora();
		try {
			vtncCalculadora.conectar();
			vtncCalculadora.crearProducto();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
