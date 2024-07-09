package testeprojedata;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Pessoa {
	
	String nome;
	LocalDate dataNascimento;
    Integer idade;
    
	public Integer getIdade() {
		return idade;
	}
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public LocalDate getDataNascimento() {
		
		return dataNascimento;
		
	}
    public String getDataNascimentoFromt() {
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return dataNascimento.format(formatter);
		
	}
    

	public String getMesColaborador() {
		
		return this.getDataNascimento().getMonth().toString();
    	 
	}
	
	public void setDadaNascimento(LocalDate dadaNascimento) {
		this.dataNascimento = dadaNascimento;
	}
	@Override
	public String toString() {
		return "Pessoa [idade=" + idade + "]";
	}
	
	
	
}
