package com.ayush.accountservice.service;

import com.ayush.accountservice.model.Fee;
import com.ayush.accountservice.model.FeePOJO;
import com.ayush.accountservice.model.Response;
import com.ayush.accountservice.model.Student;
import com.ayush.accountservice.proxy.StudentProxyService;
import com.ayush.accountservice.repo.AccountRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {
    private final AccountRepo accountRepo;

    private final StudentProxyService studentProxyService;

    public AccountService(AccountRepo accountRepo, StudentProxyService studentProxyService) {
        this.accountRepo = accountRepo;
        this.studentProxyService = studentProxyService;
    }

    public Fee payFee(Fee fee){
        return accountRepo.save(fee);
    }

    public List<Fee> getFeeByStudentId(int studentId){
        List<Fee> byStudentId = accountRepo.findByStudentId(studentId);
        return byStudentId;
    }

    public Response getStudentPaidFee(int studentId){
        Student student = studentProxyService.getStudentById(studentId);
        List<Fee> feeList = getFeeByStudentId(studentId);
        List<FeePOJO> feePOJOList=new ArrayList<>();
        for (Fee fee:feeList){
            feePOJOList.add(new FeePOJO(fee.getTitle(),fee.getPaidAmount()));
        }
        Response response=new Response(student.getName(),feePOJOList);
        return response;
    }

    public List<Response> getAllFee() {
        List<Fee> feeList = accountRepo.findAll();
        List<Response> responses=new ArrayList<>();
        for (Fee fee:
             feeList) {
            Response paidFee = getStudentPaidFee(fee.getStudentId());
            responses.add(paidFee);
        }
        return responses;
    }
}
