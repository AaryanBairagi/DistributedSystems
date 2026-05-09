package com.mul;

import javax.jws.WebService;
import javax.jws.WebMethod;

@WebService(serviceName = "MulService")
public class MulService
{
    @WebMethod
    public int multiply(int a, int b)
    {
        return a * b;
    }
}