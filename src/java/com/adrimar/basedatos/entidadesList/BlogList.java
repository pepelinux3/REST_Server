/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adrimar.basedatos.entidadesList;

import com.adrimar.basedatos.entidades.BlogVo;
import java.util.List;

/**
 *
 * @author pepe
 */
public class BlogList {
    
    private List <BlogVo> bloglist;
    
    public List<BlogVo> getListBlog(){
        return bloglist;
    }
    
    public void setListBlog(List<BlogVo> bloglist){
        this.bloglist = bloglist;
    }
    
}
