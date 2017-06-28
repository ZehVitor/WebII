package br.com.ufrn.dominio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Conta")
public class Conta implements Serializable {

	@Id
	@SequenceGenerator(name="SEQ_CONTA", initialValue=1,
	allocationSize=1, sequenceName="seq_conta")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CONTA")
	@Column(name="id_Conta")
	private int id;

}
