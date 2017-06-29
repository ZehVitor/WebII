package dominio;

import java.io.Serializable;
import java.lang.Double;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: ItemCardapio
 *
 */
@Entity

public class ItemCardapio implements Serializable {

	private static final long serialVersionUID = 1L;
   
	@Id
	@GeneratedValue
	@Column(name="id_ItemCardapio")
	private Integer id;
	private String nome;
	private Double valor;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.REFRESH)
	@JoinColumn(name = "id_Pedido")
	private Pedido pedido;
	
	public ItemCardapio() {
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
	public Double getValor() {
		return this.valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
   
}
