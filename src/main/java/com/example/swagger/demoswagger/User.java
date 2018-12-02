package com.example.swagger.demoswagger;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class User {

    @ApiModelProperty(notes = "The User id")
    private Long id;

    @ApiModelProperty(notes = "The User name")
    private String name;

}
