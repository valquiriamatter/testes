package br.com.alura.tdd.service;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

	//sempre testar classes que tenham regra de negócio e que tendem a ter mudanças no futuro, com novos valores e etc.
	//sempre que mexer deve testar
	

	@Test //teste de exception, simulando se uma excessao está acontecendo
	void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto() {
		BonusService service = new BonusService();
//		assertThrows(IllegalArgumentException.class,
//				() -> service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("25000"))));

		try{
			service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("25000")));
			fail("Não deu a exception.");
		}catch (Exception e){
			assertEquals("Funcionário com salário maior de R$ 10.000, não pode receber bônus.", e.getMessage());
		}



	}

	@Test //devolve um valor, pega o retorno e faz assert com retorno
	void bonusDeveriaSer10PorCentoDoSalario() {
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("2500")));

		assertEquals(new BigDecimal("250.00"), bonus);
	}

	@Test
	void bonusDeveriaSerDezPorCentoParaSalarioDeExatamente10000() {
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("10000")));

		assertEquals(new BigDecimal("1000.00"), bonus);
	}

}
