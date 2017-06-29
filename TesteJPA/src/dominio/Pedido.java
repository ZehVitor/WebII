package dominio;

import java.io.Serializable;
import java.lang.Double;
import java.lang.Integer;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Pedido
 *
 */
@Entity

public class Pedido implements Serializable {

	   
	@Id
	@GeneratedValue
	@Column(name = "id_Pedido")
	private Integer id;
	private Double valor;
	
	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy="pedido")
	private List<ItemCardapio> itensPedido;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.REFRESH)
	@JoinColumn(name = "id_Cliente")
	private Cliente cliente;

	public Pedido() {
		super();
	}   
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public Double getValor() {
		return this.valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	public List<ItemCardapio> getItensPedido() {
		return itensPedido;
	}
	public void setItensPedido(List<ItemCardapio> itensPedido) {
		this.itensPedido = itensPedido;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public void addItem(ItemCardapio item) {
		this.itensPedido.add(item);
	}
	
	public void removeItem(ItemCardapio item) {
		this.itensPedido.remove(item);
	}
}
