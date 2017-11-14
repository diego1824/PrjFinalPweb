package servicos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import modelos.Vendedor;

public class VendedorServico extends Servico {

	public void salvar(Vendedor vendedor) {

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(vendedor);
		em.getTransaction().commit();
		em.close();

	}

	@SuppressWarnings("unchecked")
	public List<Vendedor> getVendedors() {

		List<Vendedor> vendedores;

		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("Select c From Vendedor c");
		vendedores = q.getResultList();
		em.close();

		return vendedores;
	}

	public void alterar(Vendedor vendedor) {

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(vendedor);
		em.getTransaction().commit();
		em.close();
	}

	public void remover(Vendedor vendedor) {

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		vendedor = em.find(Vendedor.class, vendedor.getCodigo());
		em.remove(vendedor);
		em.getTransaction().commit();
		em.close();
	}

}
