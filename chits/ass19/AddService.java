package com.add;

import javax.jws.WebService;
import javax.jws.WebMethod;

@WebService(serviceName = "AddService")
public class AddService
{
    @WebMethod
    public int add(int a, int b)
    {
        return a + b;
    }
}