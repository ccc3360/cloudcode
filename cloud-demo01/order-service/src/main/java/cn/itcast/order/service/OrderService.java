package cn.itcast.order.service;

import cn.itcast.feign.clients.UserClient;
import cn.itcast.feign.pojo.User;
import cn.itcast.order.mapper.OrderMapper;
import cn.itcast.order.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;
    /**
     *  Feign远程调用
     */
    @Autowired
    private UserClient userClient;

    public Order queryOrderById(Long orderId) {
        // 1.查询订单
        Order order = orderMapper.findById(orderId);
        //2、利用Feign远程调用，查询用户
        User user = userClient.findById(order.getUserId());
        //3、封装
        order.setUser(user);
        // 4.返回
        return order;

    }


/**
 *  RestTemplate方式远程调用
 */
//    @Autowired
//    private RestTemplate restTemplate;
//
//    public Order queryOrderById(Long orderId) {
//        // 1.查询订单
//        Order order = orderMapper.findById(orderId);
//        //2、利用RestTemplate发送http请求，查询用户
////        String url="http://localhost:8081/user/"+order.getUserId();
//        String url="http://userservice/user/"+order.getUserId();
//        User user = restTemplate.getForObject(url, User.class);
//        //3、封装
//        order.setUser(user);
//        // 4.返回
//        return order;
//    }
}
