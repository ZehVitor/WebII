import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "meuBean")
@ViewScoped
public class MeuBean implements Serializable {

	private List<Pessoal> pessoas = new ArrayList<Pessoal>();

	public MeuBean() {
		Pessoal p1 = new Pessoal();
		p1.setNome("nome1");
		p1.setEmail("email1");
		Pessoal p2 = new Pessoal();
		p2.setNome("nome2");
		p2.setEmail("email2");
		pessoas.add(p1);
		pessoas.add(p2);
		
		
	}
	public List<Pessoal> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoal> pessoas) {
		this.pessoas = pessoas;
	}
	
}
