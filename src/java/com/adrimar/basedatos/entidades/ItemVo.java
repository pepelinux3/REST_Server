/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adrimar.basedatos.entidades;

/**
 *
 * @author pepe
 */
public class ItemVo {
    
    private int idClave;
    private String noParte;
    private String nomCorto;
    private String nomLargo;
    private int idEmpresa;
    private int idSubgrupo;
    private int status;
    private int visible;
    private float impuesto;
    private int modifica;

    public ItemVo() {      
    }
    
    public ItemVo(int idClave, String noParte, String nomCorto, String nomLargo, int idEmpresa, int idSubgrupo, int status, int visible, float impuesto, int modifica) {
        this.idClave = idClave;
        this.noParte = noParte;
        this.nomCorto = nomCorto;
        this.nomLargo = nomLargo;
        this.idEmpresa = idEmpresa;
        this.idSubgrupo = idSubgrupo;
	this.status = status;
        this.visible = visible;
        this.impuesto = impuesto;
	this.modifica = modifica;
    }

    public int getIdClave() {
        return idClave;
    }
    public void setIdClave(int idClave) {
        this.idClave = idClave;
    }

    public String getNoParte() {
        return noParte;
    }
    public void setNoParte(String noParte) {
        this.noParte = noParte;
    }

    public String getNomCorto() {
        return nomCorto;
    }
    public void setNomCorto(String nomCorto) {
        this.nomCorto = nomCorto;
    }
    
    public String getNomLargo() {
        return nomLargo;
    }
    public void setNomLargo(String nomLargo) {
        this.nomLargo = nomLargo;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }
    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public int getIdSubgrupo() {
        return idSubgrupo;
    }
    public void setIdSubgrupo(int idSubgrupo) {
        this.idSubgrupo = idSubgrupo;
    }
    
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
	
    public int getVisible() {
        return visible;
    }
    public void setVisible(int visible) {
        this.visible = visible;
    }
	
    public float getImpuesto() {
        return impuesto;
    }
    public void setImpuesto(float impuesto) {
        this.impuesto = impuesto;
    }
    
    public int getModifica() {
        return modifica;
    }
    public void setModifica(int modifica) {
        this.modifica = modifica;
    }
}
