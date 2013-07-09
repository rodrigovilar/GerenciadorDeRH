package projeto;

public class validacaoDeEntradas {
	
	public boolean validaDataNascimento(String dataNascimento){ //Valida��o de entrada do formato de Data
		
		if((dataNascimento.length()!=10)){
			return false;
		}else if((dataNascimento.charAt(2)!='/')||(dataNascimento.charAt(5))!='/'){
			return false;
		}
		
		if(Character.isDigit(dataNascimento.charAt(0))!=true||Character.isDigit(dataNascimento.charAt(0))!=true){
			return false;
		}else if(Character.isDigit(dataNascimento.charAt(3))!=true||Character.isDigit(dataNascimento.charAt(4))!=true){
			return false;
		}else if(Character.isDigit(dataNascimento.charAt(6))!=true||Character.isDigit(dataNascimento.charAt(7))!=true){
			return false;
		}else if(Character.isDigit(dataNascimento.charAt(8))!=true||Character.isDigit(dataNascimento.charAt(9))!=true){
			return false;
		}
		
		return true;
	}

	public boolean validaCPF(String cpf) {// Valida��o de formato CPF 
		
		boolean temp = true;
		if(cpf.length()!=11){
			temp = false;
		}else{
			for(int i =0;i<cpf.length();i++){
				if(Character.isLetter(cpf.charAt(i))==true){
					temp = false;
				}
			}
		}
		
		if (validarNumeracaoCPF(cpf))
		temp = false;
		return temp;
	}

	private boolean validarNumeracaoCPF(String cpf) {
		return cpf.equals("00000000000") || cpf.equals("11111111111") ||
		        cpf.equals("22222222222") || cpf.equals("33333333333") ||
		        cpf.equals("44444444444") || cpf.equals("55555555555") ||
		        cpf.equals("66666666666") || cpf.equals("77777777777") ||
		        cpf.equals("88888888888") || cpf.equals("99999999999") ||
		        (cpf.length() != 11);
	}

	public boolean validaRG(String rg) { //Valida��o de formato RG 
		boolean temp = true;
		
		if(rg.length()!=7){
			return false;
		}else{
			for(int i =0;i<rg.length();i++){
				if(Character.isDigit(rg.charAt(i))!=true){
					temp = false;
				}
			}
		}
		
		if (validarNumeracaoRG(rg)) 
				temp = false;
				
		return temp;
	}

	private boolean validarNumeracaoRG(String rg) {
		return rg.equals("0000000") || rg.equals("1111111") ||
				rg.equals("2222222") || rg.equals("3333333") ||
				rg.equals("4444444") || rg.equals("5555555") ||
				rg.equals("6666666") || rg.equals("7777777") ||
				rg.equals("8888888") || rg.equals("9999999");
	}
	
}
