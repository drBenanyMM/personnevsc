package service;

import jakarta.jws.WebParam;
import jakarta.jws.WebService;

@WebService(endpointInterface = "service.ServiceOperation")
public class ServiceOperationImp implements ServiceOperation{

    @Override
    
    public int addition(@WebParam(name = "a") int a, @WebParam(name = "b") int b) {
        return a + b;
    }

    
}
