import java.util.ArrayList;
import java.util.Arrays;

class Conjunto{
	ArrayList<Integer> vetorLista;

	Conjunto(){
		this.vetorLista = new ArrayList<Integer>();
	}

	boolean contem(Integer e){
		return this.vetorLista.contains(e);
	}

	boolean eSubconjunto(Conjunto c){
		for(Integer i : this.vetorLista){
			if(!(c.contem(i))){
				return false;
			}
		}
		return true;
	}

	void inserir(Integer e){
		if(!(this.contem(e))){
			this.vetorLista.add(e);
		}
	}

	Conjunto uniao(Conjunto c){
		Conjunto u = new Conjunto();

		for(Integer e : this.vetorLista){
			u.inserir(e);
		}
		for(Integer e : c.vetorLista){
			if(!(this.contem(e))){
				u.inserir(e);
			}
		}

		return u;
	}

	Conjunto interseccao(Conjunto c){
		Conjunto i = new Conjunto();

		for(Integer e : this.vetorLista){
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

		for (Integer e : u.vetorLista){
			if(!(i.contem(e))){
				d.inserir(e);
			}			
		}

		return d;
	}

	boolean eVazio(){
		return this.vetorLista.isEmpty();
	}
}