package testeprojedata;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Locale;



public class Funcionario extends Pessoa {
	
	BigDecimal salario;
	
	String funcao;
	
	public Funcionario() {}

	public Funcionario( String nome,LocalDate dataNascimento,BigDecimal salario,String funcao) {
		super();
		this.salario = salario;
		this.funcao = funcao;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.idade = LocalDate.now().getYear() - dataNascimento.getYear() ;
	}

	public BigDecimal getSalario() {
		return salario;
	}
	//retorna salário formatado
	public String getSalarioFormatado(BigDecimal salario) {
		NumberFormat numeroFormatado = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
		String salarioFormatado = numeroFormatado.format(salario);
		salarioFormatado.replace(".",",");
		return salarioFormatado;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	@Override
	public String toString() {
		return "Funcionario [ nome= " + nome +" ,Data de Nascimento= "+ getDataNascimentoFromt() +" ,salario= "
	+ getSalarioFormatado(salario) + ", funcao= " + funcao +" ]";
	}
	public String toMaisVelho() {
		return "Funcionario [ nome= " + nome +" Idade: " + idade + " ]";
		
	}	
	//calcula almento de 10%
	public BigDecimal retornaAlmento(BigDecimal salario) {
		BigDecimal valorAlmento = salario.multiply(new BigDecimal("0.10"));
		
		return valorAlmento.add(salario) ;
	}
	
	
	
	
}
