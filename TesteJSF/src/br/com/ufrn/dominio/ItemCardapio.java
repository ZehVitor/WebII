package br.com.ufrn.dominio;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="ItemCardapio")
public class ItemCardapio implements Serializable {

	@Id
	@SequenceGenerator(name="SEQ_ITEM_CARDAPIO", initialValue=1,
	allocationSize=1, sequenceName="seq_item_cardapio")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ITEM_CARDAPIO")
	@Column(name="id_ItemCardapio")
	private int id;
	private String nome;
	private double valor;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.REFRESH)
	@JoinColumn(name = "id_Pedido")
	private Pedido pedido;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

}
