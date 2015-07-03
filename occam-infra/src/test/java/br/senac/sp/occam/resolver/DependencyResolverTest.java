package br.senac.sp.occam.resolver;

import org.junit.Assert;
import org.junit.Test;

import br.senac.sp.occam.example.control.CadastroAluno;
import br.senac.sp.occam.resolver.implementation.DependencyResolver;

public class DependencyResolverTest {

	@Test
	public void testHasInstance() {
		CadastroAluno cadastroAluno = new CadastroAluno();
		
		AbstractDependencyResolver resolver = new DependencyResolver(cadastroAluno);
		
		cadastroAluno = (CadastroAluno)resolver.resolve();
		
		Assert.assertNotNull(cadastroAluno.getAlunoDao());
	}

	@Test
	public void testInstanceHasInstance() {
		CadastroAluno cadastroAluno = new CadastroAluno();
		
		AbstractDependencyResolver resolver = new DependencyResolver(cadastroAluno);
		
		cadastroAluno = (CadastroAluno)resolver.resolve();
		
		Assert.assertNotNull(cadastroAluno.getAlunoDao().getDummy());
	}
	
	@Test
	public void testHasntInstance() {
		CadastroAluno cadastroAluno = new CadastroAluno();
		
		AbstractDependencyResolver resolver = new DependencyResolver(cadastroAluno);
		
		cadastroAluno = (CadastroAluno)resolver.resolve();
		
		Assert.assertNull(cadastroAluno.getCursoDao());
	}
}
