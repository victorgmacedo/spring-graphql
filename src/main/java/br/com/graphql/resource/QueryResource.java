package br.com.graphql.resource;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

@Component
public class QueryResource implements GraphQLQueryResolver {

    public String hello(){
        return "Hello GraphQL";
    }

    public Integer soma(Integer a, Integer b){
        return a + b;
    }


}
