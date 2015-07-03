package br.senac.sp.occam.example.control;

import javax.inject.Inject;

import br.senac.sp.occam.annotation.Bean;
import br.senac.sp.occam.annotation.NavigationCase;
import br.senac.sp.occam.annotation.NavigationCases;
import br.senac.sp.occam.annotation.Operation;
import br.senac.sp.occam.enums.InstanceStrategy;
import br.senac.sp.occam.enums.NavigationStatus;
import br.senac.sp.occam.example.beans.Aluno;
import br.senac.sp.occam.example.dao.AlunoDAO;
import br.senac.sp.occam.example.dao.CursoDAO;

@Operation(InstanceStrategy.PROTOTYPE)
public class CadastroAluno {
	
	@Bean
	private Aluno aluno;
	
	@Inject
	private AlunoDAO alunoDao;
	
	private CursoDAO cursoDao;
	
	@NavigationCases({
		@NavigationCase(status=NavigationStatus.SUCCESS, url="sucess.jsp"),
		@NavigationCase(status=NavigationStatus.FAIL, url="fail.jsp")
	})
	public void inserir() {
		
	}

	@NavigationCases({
		@NavigationCase(status=NavigationStatus.SUCCESS, url="sucess.jsp"),
		@NavigationCase(status=NavigationStatus.FAIL, url="fail.jsp")
	})
	public void update() throws Exception{
		throw new Exception("Teste");
	}
	
	@NavigationCases({
		@NavigationCase(status=NavigationStatus.SUCCESS, url="sucess.jsp"),
		@NavigationCase(status=NavigationStatus.FAIL, url="fail.jsp")
	})
	public boolean delete() {
		return true;
	}
	
	public void wontRunThisMethod() {
		
	}
	
	public AlunoDAO getAlunoDao() {
		
		return alunoDao;
	}
	
	public void setAlunoDao(AlunoDAO alunoDao) {
		this.alunoDao = alunoDao;
	}
	
	public CursoDAO getCursoDao() {
		return cursoDao;
	}
	
	public void setCursoDao(CursoDAO cursoDao) {
		this.cursoDao = cursoDao;
	}
	
	public Aluno getAluno() {
		return aluno;
	}
	
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
}
