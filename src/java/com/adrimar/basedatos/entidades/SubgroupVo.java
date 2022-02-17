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
public class SubgroupVo {
	private int subClave;
	private String subNombre;
	private String subDescripcion;
	private int subGroup;
	private float subDesc;
	private float subPorcen;

	public SubgroupVo(int subClave, String subNombre, String subDescripcion, int subGroup, float subDesc, float subPorcen) {
		this.subClave = subClave;
		this.subNombre = subNombre;
		this.subDescripcion = subDescripcion;
		this.subGroup = subGroup;
		this.subDesc = subDesc;
		this.subPorcen = subPorcen;
	}

	public int getSubClave() {
		return subClave;
	}

	public String getSubNombre() {
		return subNombre;
	}

	public String getSubDescripcion() {
		return subDescripcion;
	}

	public int getSubGroup() {
		return subGroup;
	}

	public float getSubDesc() {
		return subDesc;
	}

	public float getSubPorcen() {
		return subPorcen;
	}
	
}
