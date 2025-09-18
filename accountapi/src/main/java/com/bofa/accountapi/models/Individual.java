package com.bofa.accountapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.codecs.pojo.annotations.BsonId;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("individuals")
public class Individual {

    @BsonId
    private String accountNo;
    private FullName fullName;
    private String email;
    private String contactNo;


}
