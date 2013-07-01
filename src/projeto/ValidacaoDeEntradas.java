package projeto;

public class ValidacaoDeEntradas {
	
	
	
	public boolean validaCampoDeTexto(String s) {
		boolean temp = true;
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)!=' ' && Character.isLetter(s.charAt(i))!=true){
				temp = false;
			}
		}
		return temp;
		}

	public boolean validaDataNascimento(String dataNascimento) { 

		if ((dataNascimento.length() != 10)) {
			return false;
		} else if ((dataNascimento.charAt(2) != '/')
				|| (dataNascimento.charAt(5)) != '/') {
			return false;
		}

		if (Character.isDigit(dataNascimento.charAt(0)) != true
				|| Character.isDigit(dataNascimento.charAt(0)) != true) {
			return false;
		} else if (Character.isDigit(dataNascimento.charAt(3)) != true
				|| Character.isDigit(dataNascimento.charAt(4)) != true) {
			return false;
		} else if (Character.isDigit(dataNascimento.charAt(6)) != true
				|| Character.isDigit(dataNascimento.charAt(7)) != true) {
			return false;
		} else if (Character.isDigit(dataNascimento.charAt(8)) != true
				|| Character.isDigit(dataNascimento.charAt(9)) != true) {
			return false;
		}

		return true;
	}

	public boolean validaRG(String rg) { // Validação de formato RG -
											// "melhoramentos ainda"
		boolean temp = true;

		if (rg.length() != 7) {
			return false;
		} else {
			for (int i = 0; i < rg.length(); i++) {
				if (Character.isDigit(rg.charAt(i)) != true) {
					temp = false;
				}
			}
		}

		if (rg.equals("0000000") || rg.equals("1111111")
				|| rg.equals("2222222") || rg.equals("3333333")
				|| rg.equals("4444444") || rg.equals("5555555")
				|| rg.equals("6666666") || rg.equals("7777777")
				|| rg.equals("8888888") || rg.equals("9999999"))
			temp = false;

		return temp;
	}

	public boolean validaCPF(String cpf) {// Validação de formato CPF -
											// "melhoramentos ainda"

		boolean temp = true;
		if (cpf.length() != 11) {
			temp = false;
		} else {
			for (int i = 0; i < cpf.length(); i++) {
				if (Character.isLetter(cpf.charAt(i)) == true) {
					temp = false;
				}
			}
		}

		if (cpf.equals("00000000000") || cpf.equals("11111111111")
				|| cpf.equals("22222222222") || cpf.equals("33333333333")
				|| cpf.equals("44444444444") || cpf.equals("55555555555")
				|| cpf.equals("66666666666") || cpf.equals("77777777777")
				|| cpf.equals("88888888888") || cpf.equals("99999999999")
				|| (cpf.length() != 11))
			temp = false;
		return temp;
	}

}
