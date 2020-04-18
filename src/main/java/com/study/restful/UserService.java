package com.study.restful;

import com.study.restful.dao.UserDao;
import com.study.restful.entity.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("UserService")
public class UserService {

    UserDao  userDao =  new UserDao();
    String msg;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello() {
        return "Hello, Service is Runing";
    }

    @GET
    @Path("/{username}")
    @Produces("text/plain;charset=UTF-8")
    public String sayHello2UserByText(@PathParam("username") String username) {
        return "Hello " + username;
    }

    //CRUD
    @POST
    @Path("/create/{id}/{username}/{phone}")
    @Produces( {MediaType.APPLICATION_JSON })
    public String createUser( @PathParam("id")int id,  @PathParam("username")String name,  @PathParam("phone")String  phone) {
        userDao. createUser(  id,  name,  phone);
        return "Create User:" + id+","+name+","+phone+" Sucessfully!";
    }


    @GET
    @Path("/get")
    @Produces( {MediaType.APPLICATION_JSON} )
    public User readUserByName(@QueryParam("username") String username) {
        System.out.println(username);
        User user = userDao.readUserByName(username);
        System.out.println(user.getName());
        return user;
    }

    //@GET 用浏览器是get请求
    @PUT
    @Path("/updateUser/{id}/{username}/{phone}")
    @Produces(MediaType.APPLICATION_JSON)
    //修改
    public String updateUser(@PathParam("id") int id, @PathParam("username") String name,@PathParam("phone") String  phone) {

        userDao.updateUser( id,  name,   phone );

        return "Update User:" + id+","+name+","+phone+", Run Sucessfully!";
    }

    @DELETE
    @Path("/deleteUser/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteUser(@PathParam("id")int id)
    {
        userDao.deleteUser(id);
        return "Delete User:" + id+", Run Sucessfully!";
    }



}