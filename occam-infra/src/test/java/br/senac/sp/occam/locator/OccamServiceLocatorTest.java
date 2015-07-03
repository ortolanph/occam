package br.senac.sp.occam.locator;

import java.net.URL;

import junit.framework.Assert;

import org.junit.Test;

import br.senac.sp.occam.example.control.CadastroAluno;
import br.senac.sp.occam.example.control.CadastroCurso;

public class OccamServiceLocatorTest {
	public static final String ARQUIVO_OPERACAO = "file://C:/media/docs/ETACS/DAS/WEB/projeto/occam-infra/src/test/resources/WEB-INF/operations.xml";
	
	@Test
	public void testCriarPrototype() throws Exception {
		OccamServiceLocator locator = OccamServiceLocator.getInstance();
		
		CadastroAluno cadastroAluno = (CadastroAluno)locator.getOperationInstance(new URL(ARQUIVO_OPERACAO) ,"cadastroAluno");
		
		Assert.assertNotNull(cadastroAluno);
	}
	
	@Test
	public void testCriarSingleton() throws Exception {
		OccamServiceLocator locator = OccamServiceLocator.getInstance();
		
		CadastroCurso cadastroCurso = (CadastroCurso)locator.getOperationInstance(new URL(ARQUIVO_OPERACAO), "cadastroCurso");
		
		Assert.assertNotNull(cadastroCurso);
	}
	
	@Test
	public void testObtemSingleton() throws Exception {
		Assert.assertNotNull(OccamServiceLocator.getInstance().getOperationInstance(new URL(ARQUIVO_OPERACAO), "cadastroCurso"));
	}
}
