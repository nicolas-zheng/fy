package com.tencent.wxcloudrun.controller;

import org.checkerframework.checker.units.qual.K;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.dto.CounterRequest;
import com.tencent.wxcloudrun.model.Counter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Optional;

/**
 * counter控制器
 */
@RestController

public class CounterController {
  private static final String[] USERS={"老姐姐","蚂蟥","一阵风","阿b","老蔡","宇哥","闽弟弟","k","老李","毛毛","水水"};



  /**
   * 获取当前计数
   * @return API response json
   */
  @GetMapping(value = "/api/count")
  ApiResponse get() {


    return ApiResponse.ok(0);
  }


//  /**
//   * 更新计数，自增或者清零
//   * @param request {@link CounterRequest}
//   * @return API response json
//   */
  @PostMapping(value = "/api/count")
  ApiResponse create(@RequestBody CounterRequest request) {
    ArrayList<String> game_players = new ArrayList<>();
    while(game_players.size()<4){
        String user = USERS[(int)(Math.random()*USERS.length)];
        if(!game_players.contains(user)){
            game_players.add(user);
        }
    }
    String result=game_players.get(0) + " + " + game_players.get(1) + " VS " + game_players.get(2)+ " + " + game_players.get(3) ;
    return ApiResponse.ok(result);
  }
  
}