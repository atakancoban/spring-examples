package com.atakancoban.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Benim user nesnem", description = "Benim user aciklamam" )
public class User {

    @ApiModelProperty(value = "user nesnesinin tekil Id alani")
    private int id;

    @ApiModelProperty(value = "user nesnesinin Adi alani")
    private String name;

    @ApiModelProperty(value = "user nesnesinin Tarih alani")
    private Date date;
}