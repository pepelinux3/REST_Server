/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adrimar.basedatos.entidades;

/**
 *
 * @author Martin3
 */
public class GroupVo {
	
	private int gruId;
    private int gruEmpresa;
    private String gruNombre;
    
    public GroupVo(int gruId, int gruEmpresa, String gruNombre) {
        this.gruId = gruId;
        this.gruEmpresa = gruEmpresa;
        this.gruNombre = gruNombre;
    }

	public int getGruId() {
		return gruId;
	}
	public void setGruId(int gruId) {
		this.gruId = gruId;
	}

	public int getGruEmpresa() {
		return gruEmpresa;
	}
	public void setGruEmpresa(int gruEmpresa) {
		this.gruEmpresa = gruEmpresa;
	}

	public String getGruNombre() {
		return gruNombre;
	}
	public void setGruNombre(String gruNombre) {
		this.gruNombre = gruNombre;
	}
    

}
