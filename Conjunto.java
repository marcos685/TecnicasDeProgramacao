import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Conjunto{
	List<Object> lista;


	Conjunto(){
		this.lista = new ArrayList<Object>();
	}


	boolean contem(Object e){
		return this.lista.contains(e);
	}


	boolean eSubconjunto(Conjunto c){
		for(Object i : this.lista){
			if(!(c.contem(i))){
				return false;
			}
		}
		return true;
	}


	void inserir(Object e){
		if(!(this.contem(e))){
			this.lista.add(e);
		}
	}


	Conjunto uniao(Conjunto c){
		Conjunto u = new Conjunto();

		for(Object e : this.lista){
			u.inserir(e);
		}
		for(Object e : c.lista){
			if(!(this.contem(e))){
				u.inserir(e);
			}
		}

		return u;
	}


	Conjunto interseccao(Conjunto c){
		Conjunto i = new Conjunto();

		for(Object e : this.lista){
			if(c.contem(e)){
				i.inserir(e);
			}
		}  

		return i;
	}


	Conjunto diferenca(Conjunto c){
		Conjunto u = new Conjunto();
		Conjunto i = new Conjunto();
		Conjunto d = new Conjunto();

		u = this.uniao(c);
		i = this.interseccao(c);

		for (Object e : u.lista){
			if(!(i.contem(e))){
				d.inserir(e);
			}			
		}

		return d;
	}


	boolean eVazio(){
		return this.lista.isEmpty();
	}


	Conjunto prodCartesiano(Conjunto c){
		Conjunto cart = new Conjunto();

		for(Object e : this.lista){
			for(Object f : c.lista){
				
				List<Object> aux = new ArrayList<Object>();
				aux.add(e);
				aux.add(f);
				cart.inserir(aux);
			}
		}

		return cart;
	}


	Conjunto conjPotencia(){
		Conjunto pot = new Conjunto();
		List<List<Object>> aux1 = new ArrayList<List<Object>>();
		aux1.add(new ArrayList<Object>());

		for(Object e : this.lista){
			List<List<Object>> aux2 = new ArrayList<List<Object>>();

			for(List<Object> subc : aux1){
				aux2.add(subc);

				List<Object> novoSubc = new ArrayList<Object>(subc);
				novoSubc.add(e);
				aux2.add(novoSubc);
			}

			aux1 = aux2;
		}
		
		for(List<Object> e : aux1){
			pot.inserir(e);
		}
		return pot;
	}
}