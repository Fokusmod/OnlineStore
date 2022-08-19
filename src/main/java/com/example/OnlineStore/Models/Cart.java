package com.example.OnlineStore.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@Scope("prototype")
public class Cart implements Serializable {

    private Long userId;

    private List<CartItem> items = new ArrayList<>();

    public void add(CartItem cartItem){
        items.add(cartItem);
    }

}
