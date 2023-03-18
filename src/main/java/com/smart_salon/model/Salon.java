package com.smart_salon.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter

@Document(collation = "salon")
public class Salon {

    @Id
    private String id;

    private String salonName;

    private String contactNumber;
}
