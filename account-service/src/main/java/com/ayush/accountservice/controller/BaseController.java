package com.ayush.accountservice.controller;

import com.ayush.accountservice.model.GlobalApiResponse;

public class BaseController {
    protected final ResponseStatus API_SUCCESS_STATUS=ResponseStatus.SUCCESS;
    protected final ResponseStatus API_ERROR_STATUS=ResponseStatus.FAIL;

    public GlobalApiResponse successResponse(String message,Object data){
        GlobalApiResponse globalApiResponse=new GlobalApiResponse();
        globalApiResponse.setResponseStatus(API_SUCCESS_STATUS);
        globalApiResponse.setMessage(message);
        globalApiResponse.setData(data);
        return globalApiResponse;
    }


    public GlobalApiResponse errorResponse(String message,Object data){
        GlobalApiResponse globalApiResponse=new GlobalApiResponse();
        globalApiResponse.setResponseStatus(API_ERROR_STATUS);
        globalApiResponse.setMessage(message);
        globalApiResponse.setData(data);
        return globalApiResponse;
    }
}
