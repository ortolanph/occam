package br.senac.sp.occam.engine;

import java.util.HashMap;
import java.util.Map;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import br.senac.sp.occam.converter.engine.BeanDependencyEngine;
import br.senac.sp.occam.example.beans.Aluno;
import br.senac.sp.occam.example.control.CadastroAluno;

public class BeanDependencyEngineTest {
	private Map<String, String> values;

	@Before
	public void setUp() {
		values = new HashMap<String, String>();
		
		values.put("id", "1");
		values.put("nome", "Aluno");
		values.put("idade", "25");
		values.put("notaFinal", "7.5");
		values.put("aprovado", "true");
	}
	
	@Test
	public void testBeanResolver() {
		CadastroAluno cadastroAluno = new CadastroAluno();
		
		BeanDependencyEngine engine = new BeanDependencyEngine(cadastroAluno, values);
		
		Aluno actualAluno = (Aluno)engine.resolve();
		
		Assert.assertNotNull(actualAluno);
		Assert.assertNotNull(cadastroAluno.getAluno());
	}

}
