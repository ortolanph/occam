package br.senac.sp.occam.example.dao;

import javax.inject.Inject;

import br.senac.sp.occam.example.beans.Dummy;

public class AlunoDAO {
	@Inject
	private Dummy dummy;
	
	public Dummy getDummy() {
		return dummy;
	}
	
	public void setDummy(Dummy dummy) {
		this.dummy = dummy;
	}
}
