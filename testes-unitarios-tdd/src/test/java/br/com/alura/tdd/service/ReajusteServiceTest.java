package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.*;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

public class ReajusteServiceTest {

	private ReajusteService service;
	private Funcionario fulano;

	@BeforeEach
	public void inicializar(){ //chamado antes de cada um dos metodos de teste
		service = new ReajusteService();
		fulano = new Funcionario("Fulano", LocalDate.now(), new BigDecimal("2000.00"));
	}

	@AfterEach //chamado apos cada um dos metodos de teste
	public void finalizar(){
		System.out.println("Teste finalizado.");
	}

	@BeforeAll //depois de todos
	public static void antes(){
		System.out.println("ANTES DE TODOS");
	}

	@AfterAll // antes de todos
	public static void depois(){
		System.out.println("DEPOIS DE TODOS");
	}


	@Test //se metodo for void faz assert em cima do objeto que vai em parametro
	void reajusteDeveriaSerDeTresPorcentoQuandoDesempenhoForADesejar() {

		service.concederReajuste(fulano, Desempenho.A_DESEJAR);
		assertEquals(new BigDecimal("2060.00"), fulano.getSalario());
	}
	
	@Test
	void reajusteDeveriaSerDeQuinzePorcentoQuandoDesempenhoForBom() {
		service.concederReajuste(fulano, Desempenho.BOM);
		assertEquals(new BigDecimal("2300.00"), fulano.getSalario());
	}
	
	@Test
	void reajusteDeveriaSerDeVintePorcentoQuandoDesempenhoForOtimo() {
		service.concederReajuste(fulano, Desempenho.OTIMO);
		assertEquals(new BigDecimal("2400.00"), fulano.getSalario());
	}
	
	
	
	
	
	

}
