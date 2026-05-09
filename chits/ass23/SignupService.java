package com.signup;

import javax.jws.WebService;
import javax.jws.WebMethod;

@WebService(serviceName = "SignupService")
public class SignupService
{
    @WebMethod
    public String signup(String username,
                         String password)
    {
        return "User Registered Successfully";
    }
}