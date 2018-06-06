package com.bh.springboot2.config;

import com.bh.springboot2.model.User;
import com.bh.springboot2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;

import java.util.Collection;

@Configuration
public class Router {
    /**
     * Servlet
     *  请求接口:ServletRequest 或者 HttpServletRequest
     *  响应接口:ServletResponse 或者 HttpServletResponse
     * Spring5.0重新定义了服务请求和响应接口
     *  请求接口:ServerRequest
     *  响应接口:ServerReponse
     */

    @Bean
    @Autowired
    public RouterFunction<ServerResponse> personFindAll(UserRepository userRepository){
     return RouterFunctions.route(RequestPredicates.GET("/person/find/all"), request ->{
            Collection<User> users = userRepository.findAll();
            Flux<User> userFlux = Flux.fromIterable(users);
            return  ServerResponse.ok().body(userFlux,User.class);
        });
    }
}
