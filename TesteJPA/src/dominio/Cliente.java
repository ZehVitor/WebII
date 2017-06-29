package dominio;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Cliente
 *
 */
@Entity

public class Cliente implements Serializable {

	   
	@Id
	@GeneratedValue
	@Column(name="id_Cliente")
	private Integer id;

	private String nome;
	
	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy="cliente")
	private List<Pedido> pedidos;
	
	public Cliente() {
		super();
	}   
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public List<Pedido> getPedidos() {
		return pedidos;
	}
	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
   
}
