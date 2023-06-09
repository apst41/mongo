package com.ajay.mong.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Document
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Account {

    @Id
    private String id;
    @Indexed(name = "_owner_")
    private String owner;
    @Indexed(name = "_value_")
    private Double value;
    private Map<String,String> metaData;
}
