package br.com.ufrn.dominio;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Cliente")
public class Cliente implements Serializable {

	@Id
	@SequenceGenerator(name="SEQ_CLIENTE", initialValue=1,
	allocationSize=1, sequenceName="seq_cliente")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CLIENTE")
	@Column(name="id_Cliente")
	private int id;
	
	private String nome;
	
	@OneToMany(mappedBy="cliente")
	private List<Pedido> pedidos;
	
	@OneToOne(optional=true)
    @JoinColumn(
        name="id_Conta", unique=true, nullable=true, updatable=true)
	private Conta conta;

	public String getNome() {
		return nome;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

}
