package com.example.reservation_spring.business.dto;

import com.example.reservation_spring.business.model.Business;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GetBusinessDto {

    private Long id;
    private String name;
    private String email;
    private String phone;


    public GetBusinessDto(Business business) {
        this.id = business.getId();
        this.name = business.getName();
        this.email = business.getEmail();
        this.phone = business.getPhone();
    }


}


