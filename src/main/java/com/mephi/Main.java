package com.mephi;

import com.mephi.service.UserServiceImpl;
import com.mephi.util.Util;

public class Main {
    public static void main(String[] args){

        UserServiceImpl service = new UserServiceImpl();
        //write your commands here
        Util.closeEM();
    }
}
