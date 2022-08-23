package com.example.OnlineStore.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;
import java.util.Map;


@AllArgsConstructor
@NoArgsConstructor
@Data
@RedisHash("statistic")
public class Statistic implements Serializable{
    @Id
    private Long id;

    private Map<String, Map<String, List<Long>>> stats;

}
