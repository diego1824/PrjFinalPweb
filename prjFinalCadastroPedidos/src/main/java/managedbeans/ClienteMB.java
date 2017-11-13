package managedbeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.RowEditEvent;


import modelos.Cliente;
//import servicos.ClienteServico;

@ManagedBean(name = "ClienteMB")
@ViewScoped
public class ClienteMB {

	private Cliente cliente = new Cliente();
	//private ClienteServico prodService = new ClienteServico();
	private List<Cliente> clientes;

	public void salvar() {

		clientes.add(cliente);

		ProdutoServico.salvar(cliente);

		cliente = new Cliente();

	}

	public void remove(Cliente cliente) {
		clientes.remove(cliente);
		prodService.remover(cliente);

	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getClientes() {
		if (clientes == null)
			clientes = prodService.getClientes();

		return clientes;
	}

	public void onRowEdit(RowEditEvent event) {

		Cliente p = ((Cliente) event.getObject());
		prodService.alterar(p);
	}

}
