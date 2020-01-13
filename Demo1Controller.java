package com.example.losis.demorxjava.web;

import com.example.losis.demorxjava.model.Person;
import com.example.losis.demorxjava.model.ResponseApi;
import com.example.losis.demorxjava.model.SalaryAdvanceRequest;
import com.example.losis.demorxjava.service.business.DemoService;
import io.reactivex.Single;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/demo/test")
public class DemoController {

    private DemoService demoService;

    @PostMapping(value = "/verify", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Single<ResponseApi> dummy(@RequestBody SalaryAdvanceRequest salaryAdvanceRequest) {
//        return salaryAdvanceLoanService.getFoos();
//        Person person = new Person();
//        person.setCode("1001");
//        person.setUser("losis");
//        System.out.println("Probando verify");

        System.out.println("titular de cuenta: " + salaryAdvanceRequest.getAccountHolder());

        return demoService.verify();
    }

    @GetMapping(value = "/execute", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Single<ResponseApi> execute(@RequestBody SalaryAdvanceRequest request) {
//        return salaryAdvanceLoanService.getFoos();

        Person person = new Person();
        person.setCode("1001");
        person.setUser("losis");
        System.out.println("Probando execute |");

//        return Single.just(person)
//                .map(person1 -> {
//                    person1.setUser("losis");
//                    return person1;
//                });

        return demoService.execute(request.getResponseKeyboard());
		
    }
}
