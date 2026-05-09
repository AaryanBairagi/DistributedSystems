package com.sub;

import javax.jws.WebService;
import javax.jws.WebMethod;

@WebService(serviceName = "SubService")
public class SubService
{
    @WebMethod
    public int subtract(int a, int b)
    {
        return a - b;
    }
}