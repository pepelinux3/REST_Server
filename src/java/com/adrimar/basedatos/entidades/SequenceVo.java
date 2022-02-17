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
public class SequenceVo {
	private int tsec_clave;
	private int tsec_codigo;
	private String tsec_tabla;
	private String tsec_fecha;
	private int tsec_final;
	private int tsec_update;
        private int tsec_restore;

	public SequenceVo(int tsec_clave, int tsec_codigo, String tsec_tabla, String tsec_fecha, int tsec_final, int tsec_update, int tsec_restore) {
		this.tsec_clave = tsec_clave;
		this.tsec_codigo = tsec_codigo;
		this.tsec_tabla = tsec_tabla;
		this.tsec_fecha = tsec_fecha;
		this.tsec_final = tsec_final;
		this.tsec_update = tsec_update;
                this.tsec_restore = tsec_restore;
	}

	public int getTsec_clave() {
		return tsec_clave;
	}
	public void setTsec_clave(int tsec_clave) {
		this.tsec_clave = tsec_clave;
	}

	public int getTsec_codigo() {
		return tsec_codigo;
	}
	public void setTsec_codigo(int tsec_codigo) {
		this.tsec_codigo = tsec_codigo;
	}

	public String getTsec_tabla() {
		return tsec_tabla;
	}
	public void setTsec_tabla(String tsec_tabla) {
		this.tsec_tabla = tsec_tabla;
	}

	public String getTsec_fecha() {
		return tsec_fecha;
	}
	public void setTsec_fecha(String tsec_fecha) {
		this.tsec_fecha = tsec_fecha;
	}

	public int getTsec_final() {
		return tsec_final;
	}
	public void setTsec_final(int tsec_final) {
		this.tsec_final = tsec_final;
	}

	public int getTsec_update() {
		return tsec_update;
	}
	public void setTsec_update(int tsec_update) {
		this.tsec_update = tsec_update;
	}

        public int getTsec_restore() {
		return tsec_restore;
	}
	public void setTsec_restore(int tsec_restore) {
		this.tsec_restore = tsec_restore;
	}
}
