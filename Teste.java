class Teste{
	public static void main(String[] args) {
		Conjunto dez = new Conjunto();
		Conjunto par = new Conjunto();
		Conjunto impar = new Conjunto();
		Conjunto primos = new Conjunto();
		Conjunto intersec = new Conjunto();
		Conjunto uni = new Conjunto();
		Conjunto dif = new Conjunto();


		for(int i = 0; i < 10; i++) {
			dez.inserir(i);			
		}

		for(int i = 0; i < 10; i=i+2) {
			par.inserir(i);			
		}

		for(int i = 1; i < 10; i=i+2) {
			impar.inserir(i);			
		}

		primos.inserir(1);
		primos.inserir(2);
		primos.inserir(3);
		primos.inserir(5);
		primos.inserir(7);
		primos.inserir(11);
		primos.inserir(13);
		primos.inserir(17);
		primos.inserir(19);
		primos.inserir(23);

		uni = par.uniao(impar);

		intersec = dez.interseccao(par);

		dif = dez.diferenca(par);


		if(primos.eSubconjunto(primos)){
			System.out.println("a Ok");
		}
		else{
			System.out.println("a nao Ok");
		}


		if(par.eSubconjunto(dez)){
			System.out.println("b Ok");
		}
		else{
			System.out.println("b nao Ok");
		}


		if(impar.eSubconjunto(dez)){
			System.out.println("b Ok");
		}
		else{
			System.out.println("b nao Ok");
		}


		if(!(primos.eSubconjunto(dez))){
			System.out.println("b Ok");
		}
		else{
			System.out.println("b nao Ok");
		}


		if(uni.eSubconjunto(dez) && dez.eSubconjunto(uni)){
			System.out.println("c Ok");
		}
		else{
			System.out.println("c nao Ok");
		}


		if(!(intersec.eVazio())){
			System.out.println("d Ok");
		}
		else{
			System.out.println("d nao Ok");
		}


		for(Integer e : dif.vetorLista){
			System.out.println(e);
		}



	}
}