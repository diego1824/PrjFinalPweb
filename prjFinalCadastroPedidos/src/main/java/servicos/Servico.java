package servicos;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Servico {

    protected static EntityManagerFactory emf;
	
	public Servico()
	{
	      emf = Persistence.createEntityManagerFactory("PrjFinalCadastros");
	}
	
}
