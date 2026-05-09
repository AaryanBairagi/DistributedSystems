package com.div;

import javax.jws.WebService;
import javax.jws.WebMethod;

@WebService(serviceName = "DivService")
public class DivService
{
    @WebMethod
    public float divide(int a, int b)
    {
        return (float)a / b;
    }
}