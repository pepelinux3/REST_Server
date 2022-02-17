/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adrimar.rest;

import com.adrimar.basedatos.entidades.BlogVo;
import com.adrimar.basedatos.entidades.GroupVo;
import com.adrimar.basedatos.entidadesList.InventoryList;
import com.adrimar.basedatos.entidades.InventoryVo;
import com.adrimar.basedatos.entidadesList.ItemList;
import com.adrimar.basedatos.entidades.ItemVo;
import com.adrimar.basedatos.entidadesList.PriceList;
import com.adrimar.basedatos.entidades.PriceVo;
import com.adrimar.basedatos.entidades.SequenceVo;
import com.adrimar.basedatos.entidades.SubgroupVo;
import com.adrimar.basedatos.servicio.GroupService;
import com.adrimar.basedatos.servicio.InventoryServicio;
import com.adrimar.basedatos.servicio.ItemService;
import com.adrimar.basedatos.servicio.PriceService;
import com.adrimar.basedatos.servicio.SubgroupService;
import com.adrimar.basedatos.servicio.ToolService;
import com.google.gson.Gson;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author pepe
 */

@Path("inventory")

public class InventoryResource {

    @Context
    private UriInfo context;
    

    /**
     * Creates a new instance of InventoryResource
    */
    
    public InventoryResource() {
    }

    @GET
    @Path("idgru_final")
    @Produces(MediaType.APPLICATION_JSON)
    
    public Response getGruSecLast(){
        int idSecuencia;
        
        try{
            GroupService servGroup = new GroupService();
            idSecuencia = servGroup.getLastGroup();
            
            String json = idSecuencia+"";
            
            return Response.ok(json, MediaType.APPLICATION_JSON).build();
        }
        catch (Exception ex){
            return Response.status(Response.Status.SEE_OTHER).entity("Error: "+ex.toString()).build();
        }
    }	
    
    @GET
    @Path("idsub_final")
    @Produces(MediaType.APPLICATION_JSON)
    
    public Response getSubSecLast(){
        int idSecuencia;
        
        try{
            SubgroupService servSub = new SubgroupService();
            idSecuencia = servSub.getLastSub();
            
            String json = idSecuencia+"";
            
            return Response.ok(json, MediaType.APPLICATION_JSON).build();
        }
        catch (Exception ex){
            return Response.status(Response.Status.SEE_OTHER).entity("Error: "+ex.toString()).build();
        }
    }
    
    @GET
    @Path("idinv_final")
    @Produces(MediaType.APPLICATION_JSON)
    
    public Response getInvSecLast(){
        int idSecuencia;
        
        try{
            InventoryServicio servInv = new InventoryServicio();
            idSecuencia = servInv.getLastInv();
            
            String json = idSecuencia+"";
            
            return Response.ok(json, MediaType.APPLICATION_JSON).build();
        }
        catch (Exception ex){
            return Response.status(Response.Status.SEE_OTHER).entity("Error: "+ex.toString()).build();
        }
    }	   
	
    @GET
    @Path("iditem_final")
    @Produces(MediaType.APPLICATION_JSON)
    
    public Response getItemSecLast(){
        int idItem;
        
        try{
            ItemService servItem = new ItemService();
            idItem = servItem.getLastItem();
            
            String json = idItem+"";
            
            return Response.ok(json, MediaType.APPLICATION_JSON).build();
        }
        catch (Exception ex){
            return Response.status(Response.Status.SEE_OTHER).entity("Error: "+ex.toString()).build();
        }
    }
     
    @GET
    @Path("idpri_final")
    @Produces(MediaType.APPLICATION_JSON)
    
    public Response getItemEditLast(){
        int idPrice;
        
        try{
            PriceService servPrice = new PriceService();
            idPrice = servPrice.getLastPrice();
            
            String json = idPrice+"";
            
            return Response.ok(json, MediaType.APPLICATION_JSON).build();
        }
        catch (Exception ex){
            return Response.status(Response.Status.SEE_OTHER).entity("Error: "+ex.toString()).build();
        }
    }
    
    @GET
    @Path("ideditem_final")
    @Produces(MediaType.APPLICATION_JSON)
    
    public Response getPriSecLast(){
        int idItem;
        
        try{
            ItemService servItem = new ItemService();
            idItem = servItem.getLastEdItem();
            
            String json = idItem+"";
            
            return Response.ok(json, MediaType.APPLICATION_JSON).build();
        }
        catch (Exception ex){
            return Response.status(Response.Status.SEE_OTHER).entity("Error: "+ex.toString()).build();
        }
    }
	
	
    @GET
    @Path("allsequences")
    @Produces(MediaType.APPLICATION_JSON)
    
    public Response getListSeque (){
        try{
			List<SequenceVo> secList = new ToolService().getListAllSeq();
            String json = new Gson().toJson(secList);
                   
            return Response.ok(json, MediaType.APPLICATION_JSON).build(); 
        }
        catch(Exception ex){        
            return Response.status(Response.Status.SEE_OTHER).entity("Error: "+ex.toString()).build();
        }
    }
    
    @GET
    @Path("allblog")
    @Produces(MediaType.APPLICATION_JSON)
    
    public Response getListBlog (){
        try{
            List<BlogVo> blogList = new ToolService().getListAllBlog();
            String json = new Gson().toJson(blogList);
                   
            return Response.ok(json, MediaType.APPLICATION_JSON).build(); 
        }
        catch(Exception ex){        
            return Response.status(Response.Status.SEE_OTHER).entity("Error: "+ex.toString()).build();
        }
    }
	
    @GET
    @Path("allgroups")
    @Produces(MediaType.APPLICATION_JSON)
    
    public Response getListGroups (){
        try{
			List<GroupVo> gruList = new GroupService().getListGroup();
            String json = new Gson().toJson(gruList);
                   
            return Response.ok(json, MediaType.APPLICATION_JSON).build(); 
        }
        catch(Exception ex){        
            return Response.status(Response.Status.SEE_OTHER).entity("Error: "+ex.toString()).build();
        }
    }
	
    @GET
    @Path("allsubgroups")
    @Produces(MediaType.APPLICATION_JSON)
    
    public Response getListSubgroups (){
        try{
			List<SubgroupVo> subList = new SubgroupService().getListSubgroup();
            String json = new Gson().toJson(subList);
                   
            return Response.ok(json, MediaType.APPLICATION_JSON).build(); 
        }
        catch(Exception ex){        
            return Response.status(Response.Status.SEE_OTHER).entity("Error: "+ex.toString()).build();
        }
    }
	
	
    @GET
    @Path("allitems")
    @Produces(MediaType.APPLICATION_JSON)
    
    public Response getListItems (){
        try{
			List<ItemVo> itemList = new ItemService().getListItem();
            String json = new Gson().toJson(itemList);
                   
            return Response.ok(json, MediaType.APPLICATION_JSON).build(); 
        }
        catch(Exception ex){        
            return Response.status(Response.Status.SEE_OTHER).entity("Error: "+ex.toString()).build();
        }
    }

	
    @GET
    @Path("allinv")
    @Produces(MediaType.APPLICATION_JSON)
    
    public Response getListInvent (){
        try{
			List<InventoryVo> invList = new InventoryServicio().getListAllInv();
            String json = new Gson().toJson(invList);
                   
            return Response.ok(json, MediaType.APPLICATION_JSON).build(); 
        }
        catch(Exception ex){        
            return Response.status(Response.Status.SEE_OTHER).entity("Error: "+ex.toString()).build();
        }
    }
	
    @GET
    @Path("group/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    
    public Response getGruListHigh (GroupVo gru, @PathParam("id") int id){
        try{
            List<GroupVo> gruList = new GroupService().getListGroup_High(id);
            String json = new Gson().toJson(gruList);
                   
            return Response.ok(json, MediaType.APPLICATION_JSON).build(); 
        }
        catch(Exception ex){        
            return Response.status(Response.Status.SEE_OTHER).entity("Error: "+ex.toString()).build();
        }
    }
	
    @GET
    @Path("subg/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    
    public Response getSubListHigh (SubgroupVo sub, @PathParam("id") int id){
        try{
            List<SubgroupVo> subList = new SubgroupService().getListSub_High(id);
            String json = new Gson().toJson(subList);
                   
            return Response.ok(json, MediaType.APPLICATION_JSON).build(); 
        }
        catch(Exception ex){        
            return Response.status(Response.Status.SEE_OTHER).entity("Error: "+ex.toString()).build();
        }
    }
	
    
    @GET
    @Path("editem/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    
    public Response getItemListHigh (@PathParam("id") int id){
        try{
            List<ItemVo> itemList = new ItemService().getListItem_High(id);
            String json = new Gson().toJson(itemList);
                   
            return Response.ok(json, MediaType.APPLICATION_JSON).build(); 
        }
        catch(Exception ex){        
            return Response.status(Response.Status.SEE_OTHER).entity("Error: "+ex.toString()).build();
        }
    }
   
    
    @GET
    @Path("noparte/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    
    public Response getInvItem (SubgroupVo invent, @PathParam("id") int id){
        try{
            List<InventoryVo> invItem = new InventoryServicio().getListInvItem(id);
            String json = new Gson().toJson(invItem);
                   
            return Response.ok(json, MediaType.APPLICATION_JSON).build(); 
        }
        catch(Exception ex){        
            return Response.status(Response.Status.SEE_OTHER).entity("Error: "+ex.toString()).build();
        }
    }
	
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    
    public Response getInvListHigh (InventoryVo invent, @PathParam("id") int id){
        try{
            List<InventoryVo> invList = new InventoryServicio().getListInv(id);
            String json = new Gson().toJson(invList);
                   
            return Response.ok(json, MediaType.APPLICATION_JSON).build(); 
        }
        catch(Exception ex){        
            return Response.status(Response.Status.SEE_OTHER).entity("Error: "+ex.toString()).build();
        }
    }

    @GET
    @Path("newinv/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    
    public Response getInvNewItem (@PathParam("id") int id){
        try{
            List<InventoryVo> invItem = new InventoryServicio().getListInvNewItem(id);
            String json = new Gson().toJson(invItem);
                   
            return Response.ok(json, MediaType.APPLICATION_JSON).build(); 
        }
        catch(Exception ex){        
            return Response.status(Response.Status.SEE_OTHER).entity("Error: "+ex.toString()).build();
        }
    }
    
    @GET
    @Path("allprice")
    @Produces(MediaType.APPLICATION_JSON)
    
    public Response getListAllPrice (){
        try{
            List<PriceVo> priceList = new PriceService().getAllPrices();
            String json = new Gson().toJson(priceList);
                   
            return Response.ok(json, MediaType.APPLICATION_JSON).build(); 
        }
        catch(Exception ex){        
            return Response.status(Response.Status.SEE_OTHER).entity("Error: "+ex.toString()).build();
        }
    }
    
    @GET
    @Path("newprice/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    
    public Response getListNewPrice (PriceVo price, @PathParam("id") int id){
        try{
            List<PriceVo> priceList = new PriceService().getNewPrices(id);
            String json = new Gson().toJson(priceList);
                   
            return Response.ok(json, MediaType.APPLICATION_JSON).build(); 
        }
        catch(Exception ex){        
            return Response.status(Response.Status.SEE_OTHER).entity("Error: "+ex.toString()).build();
        }
    }
    /*
    try{                                      
            List<PriceVo> listitem = new PriceService().checkNewPrice(pricelist);
            String json = new Gson().toJson(listitem);

            return Response.ok(json, MediaType.APPLICATION_JSON).build();
        }
        catch(Exception ex){         
            return Response.status(Response.Status.SEE_OTHER).entity("Error: "+ex.toString()).build();
        }
    */
    @POST
    @Path("newprice2")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    
    public Response updatePrice2 (PriceVo price){
        try{
            
            String json = new Gson().toJson(new PriceService().updatePrice(price));
            return Response.ok(json, MediaType.APPLICATION_JSON).build(); 
        }
        catch(Exception ex){        
            return Response.status(Response.Status.SEE_OTHER).entity("Error: "+ex.toString()).build();
        }
    }
    
    @POST
    @Path("newblog")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    
    public Response addBlog (BlogVo blog){
        try{
            System.out.println("EL OBJETO DE JSON = "+blog);
            System.out.println("EL fecha DE JSON = "+blog.getTbi_fechahora());
            String json = new Gson().toJson(new ToolService().addBlog(blog));
            return Response.ok(json, MediaType.APPLICATION_JSON).build(); 
        }
        catch(Exception ex){        
            return Response.status(Response.Status.SEE_OTHER).entity("Error: "+ex.toString()).build();
        }
    }
    
    @POST
    @Path("updatelist")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)

    public Response updateListInv(InventoryList invList){
        int idSecu_ini;

        try{                      
            InventoryServicio service = new InventoryServicio();
            service.updateListInv(invList);            

            idSecu_ini = service.getFirtsInv();

            List<InventoryVo> listInv = new InventoryServicio().getListInv(idSecu_ini);
            String json = new Gson().toJson(listInv);

            return Response.ok(json, MediaType.APPLICATION_JSON).build();
        }
        catch(Exception ex){
          
            return Response.status(Response.Status.SEE_OTHER).entity("Error: "+ex.toString()).build();
        }
    }
    
    @POST
    @Path("updatelistlim")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)

    public Response updateListInvLim(InventoryList invList){
        int idSecu_ini;
	int idSecu_fin;

        try{                      
            InventoryServicio service = new InventoryServicio();
            service.updateListInv(invList);            

            idSecu_ini = service.getFirtsInv();
	    idSecu_fin = service.getLastInv();

            List<InventoryVo> listInv = new InventoryServicio().getListInvLim(idSecu_ini, idSecu_fin);
            String json = new Gson().toJson(listInv);

            return Response.ok(json, MediaType.APPLICATION_JSON).build();
        }
        catch(Exception ex){
          
            return Response.status(Response.Status.SEE_OTHER).entity("Error: "+ex.toString()).build();
        }
    }
    
    @POST
    @Path("newitem")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)

    public Response updListItem(ItemList itemlist){

        try{                                      
            //List<ItemVo> listitem = new ItemService().checkNewItem(itemlist);
			List<ItemVo> listitem = new ItemService().checkNewItem(itemlist);
            String json = new Gson().toJson(listitem);

            return Response.ok(json, MediaType.APPLICATION_JSON).build();
        }
        catch(Exception ex){         
            return Response.status(Response.Status.SEE_OTHER).entity("Error: "+ex.toString()).build();
        }
    }
    
    @POST
    @Path("newprice")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)

    public Response updListPrice(PriceList pricelist){

        try{                                      
            List<PriceVo> listitem = new PriceService().checkNewPrice(pricelist);
            String json = new Gson().toJson(listitem);

            return Response.ok(json, MediaType.APPLICATION_JSON).build();
        }
        catch(Exception ex){         
            return Response.status(Response.Status.SEE_OTHER).entity("Error: "+ex.toString()).build();
        }
    }
}
