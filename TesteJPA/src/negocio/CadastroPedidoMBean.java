
package negocio;


import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.sun.java.swing.plaf.windows.resources.windows;

import dao.GenericDAO;
import dao.ItemCardapioDAO;
import dominio.ItemCardapio;
import dominio.Pedido;


@ManagedBean(name = "orderController")
@SessionScoped
public class CadastroPedidoMBean {
	
	@Inject GenericDAO dao;
	
	private final String PedidoForm = "Formulario.xhtml";
	
	private Pedido pedido = new Pedido();
	private ItemCardapio item = new ItemCardapio();
	private ItemCardapio selectedItem = new ItemCardapio();
	
	public ItemCardapio getSelectedItem() {
		return selectedItem;
	}

	public void setSelectedItem(ItemCardapio selectedItem) {
		this.selectedItem = selectedItem;
	}


	// Itens que na tela de seleção
	private List<ItemCardapio> itensMenu = new ArrayList<ItemCardapio>();
	private List<ItemCardapio> itensSelecionados = new ArrayList<ItemCardapio>();
		

	public CadastroPedidoMBean() {
		// pegar do banco:
		// itensMenu = itens_no_Banco
		for (int i=1; i<=5; i++) {
			ItemCardapio item = new ItemCardapio();
			item.setId(i);
			item.setNome("Item" + i);
			this.itensMenu.add(item);
		}
	}

	public ItemCardapio getItem() {
		return item;
	}

	public void setItem(ItemCardapio item) {
		this.item = item;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
//	public String addNewItem() {
//		dao.addNew(item);
//		//itemList = dao.findEmployees();
//		return "itens";
//	}
	
	public void addItem() {
		this.itensMenu.add(item);
		pedido.addItem(item);
		this.item = null;
	}
	
	public void removeItem(ItemCardapio item) {
		pedido.removeItem(item);
		this.itensMenu.remove(item);
	}
	
	public void listarItens(){
		ItemCardapioDAO itemDAO = new ItemCardapioDAO();
		try {
			this.setItensMenu(itemDAO.findAll());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String confirmarSelecao(){
		for (ItemCardapio item : this.pedido.getItensPedido()) {
			dao.inserir(item);	
		}
		
		return "Menu";
	}
	public String confirmarEdicao(){
		for (ItemCardapio item : this.itensSelecionados) {
			dao.inserir(item);	
		}
		
		return "Menu";
	}

	/*public List<ItemCardapio> getItemList() {
		return itemList;
	}

	public void setItemList(List<ItemCardapio> itemList) {
		this.itemList = itemList;
	}*/
	
	public List<ItemCardapio> getItensMenu() {
		return itensMenu;
	}

	public void setItensMenu(List<ItemCardapio> itensMenu) {
		this.itensMenu = itensMenu;
	}

	public List<ItemCardapio> getItensSelecionados() {
		return itensSelecionados;
	}

	public void setItensSelecionados(List<ItemCardapio> itensSelecionados) {
		this.itensSelecionados = itensSelecionados;
	}
	
	
	public String enviarPedido(){
		/*for (String id : itensSelecionados) {
//			this.dao.inserir(item);
			ItemCardapio item = itensMenu
			pedido.addItem(item);
		}*/
		
		return "Index";
	}
	
}
