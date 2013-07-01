package projeto;

public class FuncionarioNullExeption extends RuntimeException{
	public FuncionarioNullExeption() {
		System.out.println("Foi passado um parametro nulo!!!");
	}

}
