/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Brand;
import entity.Camera;
import entity.Company;
import entity.Store;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import repository.BrandFacade;
import repository.CameraFacade;
import repository.CompanyFacade;
import repository.StoreFacade;

/**
 *
 * @author Jakob Hanner
 */
@Path("rest")
public class RESTservices {

    BrandFacade brandFacade = new BrandFacade();
    CameraFacade cameraFacade = new CameraFacade();
    CompanyFacade companyFacade = new CompanyFacade();
    StoreFacade storeFacade = new StoreFacade();

    @Context
    private UriInfo contect;

    public RESTservices() {

    }

    @GET
    @Path("test")
    public String message() {
        return "Hello World";
    }

    @GET
    @Path("init")
    public String initializeDB() {
        Store s1 = new Store("Linz", 3);
        Store s2 = new Store("Rohrbach", 2);

        Brand b1 = new Brand("Fujifilm", "Japan", "Shing Yo");
        Brand b2 = new Brand("Canon", "Japan", "Ho Yu Sing");

        Camera cam1 = new Camera("EOS 600D", 1);
        Camera cam2 = new Camera("EOS 70D", 3);
        Camera cam3 = new Camera("X-T2", 10);

        b1.addCam(cam3);
        b2.addCam(cam1);
        b2.addCam(cam2);

        s1.addBrand(b1);
        s2.addBrand(b1);
        s2.addBrand(b2);

        Company c = new Company("CamcorderAG", "Samuel Hanner");

        c.addStore(s1);
        c.addStore(s2);

        companyFacade.edit(c);

        return "DB init done!";
    }

    //Abruf aller Firmen
    @GET
    @Path("findAllCompanies")
    @Produces("application/json")
    public List<Company> findAllCompanies() {
        return companyFacade.findAll();
    }

    //Abruf aller Geschäfte mit gleicher Firma
    @GET
    @Path("findStoreByComp/{cID}")
    @Produces("application/json")
    public List<Store> findStoreByComp(@PathParam("cID") int cID) {
        return companyFacade.findStoresByC(cID);
    }

    //Abruf aller Marken im gleichem Geschäft
    @GET
    @Path("findBrandByStore/{sID}")
    @Produces("application/json")
    public List<Brand> findBrandByStore(@PathParam("sID") int sID) {
        return storeFacade.findBrandByStore(sID);
    }

    //Abruf aller Kameras mit gleicher Marke
    @GET
    @Path("findCamsByBrand/{bID}")
    @Produces("application/json")
    public List<Camera> findCamByBrand(@PathParam("bID") int bID) {
        return brandFacade.findCamByBrand(bID);
    }

    //Company hinzufügen
    @PUT
    @Path("createCompany")
    @Produces("application/json")
    public Company insertCompany(Company company){
        companyFacade.create(company);
        return company;
    }
    
    //Marke löschen
    @DELETE
    @Path("deleteB/{bId}")
    @Produces("application/json")
    public Brand deleteBrand(@PathParam("bId") int brandId){
        brandFacade.remove(brandFacade.findById(brandId));
        return brandFacade.findById(brandId);
    }
    
    //Kamera updaten
    @PUT
    @Path("updateCam/{cId}")
    @Produces("application/json")
    public Camera updateCam(@PathParam("cId") int camId, Camera cam){
        cam.setCamId(camId);
        cameraFacade.edit(cam);
        return cameraFacade.findById(camId);
    }
}
