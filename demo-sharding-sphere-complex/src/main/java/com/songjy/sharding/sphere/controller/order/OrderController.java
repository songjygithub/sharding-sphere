package com.songjy.sharding.sphere.controller.order;

import com.songjy.sharding.sphere.model.order.Order;
import com.songjy.sharding.sphere.model.order.OrderItem;
import com.songjy.sharding.sphere.service.order.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @author songjy
 * @date 2020-06-30
 */
@Controller
@RequestMapping("/order")
public class OrderController {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private static final String[] brand = {"耐克", "阿迪达斯", "NEW BALANCE", "亚瑟士", "美津浓",
            "李宁", "安踏", "特步", "鸿星尔克", "乔丹", "361°", "匹克", "彪马", "双星", "骆驼",
            "锐步", "圣康尼", "斯凯奇", "多威", "回力", "斐乐"};

    private static final String[] product = {"慢跑鞋", "滑板鞋", "涉水鞋", "三叶草", "透气跑鞋",
            "帆布鞋", "休闲鞋", "板鞋", "篮球鞋", "足球鞋", "运动包", "紧身裤", "休闲套装",
            "卫衣/套头衫", "夹克/风衣", "运动裤", "棉服", "羽绒服", "运动套装", "运动配饰"};

    private static final int[] discountArray = {50, 60, 70, 80, 85, 90, 100};

    @Autowired
    private IOrderService orderService;

    @PostMapping(value = {"/add"})
    @ResponseBody
    public Integer add(@RequestBody Order order) {

        OrderItem orderItem = new OrderItem();

        int totalPrice = random(200, 2000);
        int discount = discountArray[random(0, 6)];
        int paymentPrice = discount * totalPrice / 100;
        int idxBrand = random(0, brand.length - 1);
        int idxProduct = random(0, product.length - 1);
        orderItem.setBrandName(brand[idxBrand]);
        orderItem.setProductName(product[idxProduct]);
        orderItem.setOrderDate(sdf.format(new Date()));
        orderItem.setPayDate(sdf.format(new Date()));
        orderItem.setTotalPrice((float) totalPrice);
        orderItem.setPayDiscount(discount);
        orderItem.setPayPrice((float) paymentPrice);
        orderItem.setUserId(order.getUserId());
        orderItem.setOrderId(order.getOrderId());

        int r = orderService.add(order);
        r += orderService.add(orderItem);

        return r;
    }

    private static int random(int min, int max) {
        Random random = new Random();
        return random.nextInt(max) % (max - min + 1) + min;
    }

}

