package com.reki.seu_blog.base;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class BasedResponse <T>{
    private Integer code;
    private T payload;
}
