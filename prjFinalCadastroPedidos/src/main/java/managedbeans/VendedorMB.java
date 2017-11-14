package managedbeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.RowEditEvent;

import modelos.Vendedor;
import servicos.VendedorServico;

@ManagedBean(name = "VendedorMB")
@ViewScoped
public class VendedorMB {

	private Vendedor vendedor = new Vendedor();
	private VendedorServico venService = new VendedorServico();
	private List<Vendedor> vendedores;

	public void salvar() {

		vendedores.add(vendedor);

		venService.salvar(vendedor);

		vendedor = new Vendedor();

	}

	public void remove(Vendedor vendedor) {
		vendedores.remove(vendedor);
		venService.remover(vendedor);

	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public List<Vendedor> getVendedors() {
		if (vendedores == null)
			vendedores = venService.getVendedors();

		return vendedores;
	}

	public void onRowEdit(RowEditEvent event) {

		Vendedor v = ((Vendedor) event.getObject());
		venService.alterar(v);
	}

}
