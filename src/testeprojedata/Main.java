package testeprojedata;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		//Criação de array de funcionarios
		List<Funcionario> listaFunc2 = new ArrayList<>(Arrays.asList(
		
		new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal(2009.44), "Operador"),
		new Funcionario("Joao", LocalDate.of(1990, 5, 12), new BigDecimal(2284.38), "Operador"),
		new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal(9836.14), "Coordenador"),
		new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal(19119.88), "Diretor"),
		new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal(2234.68), "Recepcionista"),
		new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal(1582.72), "Operador"),
		new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal(4071.84), "Contador"),
		new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal(3017.45), "Gerente"),
		new Funcionario("Heloisa", LocalDate.of(2003, 5, 25), new BigDecimal(1606.85), "Eletricista"),
		new Funcionario("Helena", LocalDate.of(1996,9, 2), new BigDecimal(2799.93), "Gerente")
		));
		//Lista funcionarios com data e salário formatado
		System.out.println("\n\n--------------------------Lista funcionarios cadastrados---------------------------------\n\n");
		listaFunc2.forEach(f -> {
			System.out.println(f.toString());
		});
		
		System.out.println("\n\n--------------------------Removendo Joao---------------------------------\n\n");
		System.out.println(listaFunc2.get(1) + "Removido");

		//remove funcionario joao
		listaFunc2.remove(1);
		
		System.out.println("\n\n--------------------------Listando depois de remover o Joao---------------------------------\n\n");
		//lista depois de removido
		listaFunc2.forEach(f -> System.out.println(f.toString()));
			
		
		//da almento de 10%
		listaFunc2.forEach(f -> {
			f.setSalario(f.retornaAlmento(f.getSalario()));
		});
		
		System.out.println("\n\n--------------------------Almento de 10%---------------------------------\n\n");
		//lista após o almento
		listaFunc2.forEach(f -> {
			System.out.println(f.toString());
		});
		
		
		//Agrupa funcionarios por função 
		Map<String, List<Funcionario>> funcionarioPorFuncao = 
				listaFunc2
				.stream()
				.collect(Collectors.groupingBy(Funcionario::getFuncao));
		//Imprime os funcionarios agrupados por função
		
		System.out.println("\n\n--------------------------Lista Funcionarios por funcoes---------------------------------\n\n");
		funcionarioPorFuncao.forEach((funcao, funcionarios) ->{
			System.out.println(funcao + ": " + funcionarios);
		});
		
		
		
		List<Funcionario> anivensariantes = listaFunc2
				.stream()
			    .filter(f -> f.getMesColaborador().equals(LocalDate.now().withMonth(10).getMonth().toString()) || f.getMesColaborador().equals(LocalDate.now().withMonth(12).getMonth().toString()))
			    .toList();
		
		System.out.println("\n\n--------------------------Lista Aniversariantes mes 10 and 12---------------------------------\n\n");
		
		anivensariantes.forEach(System.out::println);
		
		System.out.println("\n\n-------------------------- Funcionario mais velho ---------------------------------\n\n");
	    
		Optional<Funcionario> maiorIdade = listaFunc2.stream().max(Comparator.comparing(Funcionario::getIdade));	
		
		maiorIdade.stream().forEach(t -> {
			System.out.println(t.toMaisVelho());
		}); 
		
		
		System.out.println("\n\n-------------------------- Listando em ordem afalbetica ---------------------------------\n\n");
		
		List<Funcionario> ordemAlfabetica = listaFunc2
				.stream()
				.sorted(Comparator.comparing(Funcionario::getNome))
				.collect(Collectors.toList());
		ordemAlfabetica.forEach(System.out::println);
		
		System.out.println("\n\n-------------------------- Total de Salario ---------------------------------\n\n");
	
		BigDecimal totalSalarios = listaFunc2.stream().map(Funcionario::getSalario).reduce(BigDecimal.ZERO, BigDecimal::add);
		Funcionario func = new Funcionario();
		System.out.println(func.getSalarioFormatado(totalSalarios));
		
		System.out.println("\n\n-------------------------- Quanto salários minimos guanha cada funcionario ---------------------------------\n\n");
		
		
		ordemAlfabetica.stream().forEach(t -> {
			BigDecimal divisor = new BigDecimal(1212.00); 
			System.out.println("Nome: " + t.getNome() + " Cargo: " + t.getFuncao() + " Salário: " + t.getSalarioFormatado(t.getSalario()) + " Qtde Salário min: " + (t.getSalario().divide(divisor,2, RoundingMode.UP)));
		});
		
	}	
		
	    

}
