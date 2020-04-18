package com.study.restful.dao;

import com.study.restful.entity.User;

public class UserDao {
    User user;

    public UserDao() {
        User  user = new User();
        user.setId(1);
        user.setName("solo");
        user.setPhone("13799008888");
        this.user = user;
    }

    public UserDao(User user) {
        this.user = user;
    }

    //CRUD  创建
    public  void  createUser( int id, String name, String  phone){
        System.out.println("CRUD Opt: 创建一个User");
        user.setId(id);
        user.setName(name);
        user.setPhone(phone);
        dbOptCreate(user);

    }

    //CRUD  查询
    public User  readUserByName(String name  ){
        return dbOptQuery(name);
    }

    //CRUD  修改
    public  void updateUser(int id, String name, String  phone){
        System.out.println("CRUD Opt: 修改一个User");
        user.setId(id);
        user.setName(name);
        user.setPhone(phone);
        dbOptUpdate(user);

    }

    //CRUD  删除
    public void  deleteUser( int id ){
        System.out.println("CRUD Opt: 删除一个User");
        dbOptDelete(id);
    }


    //模拟数据库操作
    private  void dbOptCreate( User user){
        System.out.println("数据库操作，创建成功");
    }
    private  void dbOptUpdate( User user){
        System.out.println("数据库操作， 修改成功");
    }
    private  void dbOptDelete( int id){
        System.out.println("数据库操作， 删除成功");
    }

    //模拟数据库操作
    private  User dbOptQuery( String name){

        User  user= new User();
        //构造一个模拟数据
        user.setId(1);
        user.setName(name);
        user.setPhone("13988886666");
        System.out.println("数据库操作, 查询成功");
        return   user;
    }


}
