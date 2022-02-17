/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adrimar.basedatos.servicio;

import com.adrimar.basedatos.dao.ToolsDao;
import com.adrimar.basedatos.entidades.BlogVo;
import com.adrimar.basedatos.entidades.SequenceVo;
import java.util.List;

/**
 *
 * @author Martin3
 */
public class ToolService {
	
    private ToolsDao tooldao;

    public ToolService() {
        tooldao = new ToolsDao();
    }
    
    public List<SequenceVo> getListAllSeq(){
        return tooldao.getListSequence();
    } 
    
    public List<BlogVo> getListAllBlog(){
        return tooldao.getListBlog();
    } 
    /*
        private int tbi_clave;
    private String tbi_numcel;
    private String tbi_nombre;
    private String tbi_imei;
    private String tbi_mac;
    private String tbi_accion;
    private String tbi_fechahora;
    private String tbi_descripcion;
    private int tbi_sucursal;
    */
    public BlogVo addBlog(BlogVo blodVo){
        System.out.println("se insertara = "+blodVo.getTbi_clave()+"  "+blodVo.getTbi_numcel()+"  "+
                           blodVo.getTbi_nombre()+"  "+blodVo.getTbi_imei()+"  "+
                           blodVo.getTbi_accion()+"  "+blodVo.getTbi_fechahora()+"  "+blodVo.getTbi_sucursal()+  " *******");
        tooldao.addBlog(blodVo);
        return tooldao.getBlog(blodVo.getTbi_imei());
    }
    
}
