import br.rudson.porfirio.Dao.Dao;
import br.rudson.porfirio.Entidades.Usuario;

public class Main {

	public static void main(String[] args) {
		Dao dao = new Dao();
		Usuario u = new Usuario();
		
		u.setNome("Rellda");
		u.setIdade(25);
		
		dao.salvarObjeto(u);
	}

}
