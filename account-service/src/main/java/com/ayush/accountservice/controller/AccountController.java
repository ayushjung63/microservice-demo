package com.ayush.accountservice.controller;

import com.ayush.accountservice.model.Fee;
import com.ayush.accountservice.model.FeePOJO;
import com.ayush.accountservice.model.GlobalApiResponse;
import com.ayush.accountservice.model.Response;
import com.ayush.accountservice.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fee")
public class AccountController extends BaseController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/{studentId}")
    public ResponseEntity getPaidFee(@PathVariable("studentId") int studentId){
        Response studentPaidFee = accountService.getStudentPaidFee(studentId);
        return ResponseEntity.ok(successResponse("Data Fetched Successfully",studentPaidFee));
    }


    @PostMapping
    public ResponseEntity pay(@RequestBody Fee fee){
        Fee paidFee = accountService.payFee(fee);
        return ResponseEntity.ok(successResponse("Data Saved Successfully",paidFee));
    }

    @GetMapping
    public ResponseEntity all(){
        List<Response> list = accountService.getAllFee();
        return ResponseEntity.ok(successResponse("Data Fetched Successfully",list));
    }

}
