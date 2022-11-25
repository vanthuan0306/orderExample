package com.iviettech.thuanpv.controller;

import com.iviettech.thuanpv.entity.OrderDetailsEntity;
import com.iviettech.thuanpv.entity.OrderEntity;
import com.iviettech.thuanpv.entity.ProductEntity;
import com.iviettech.thuanpv.repository.OrderDetailRepository;
import com.iviettech.thuanpv.repository.OrderRepository;
import com.iviettech.thuanpv.repository.ProductRepository;
import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping(value = "/")
public class TestController {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderDetailRepository orderDetailRepository;

    @Autowired
    ProductRepository productRepository;

    @RequestMapping(method = GET)
    public String showOrders(Model model) {
        List<OrderEntity> orderList = (List<OrderEntity>) orderRepository.findAll();
        model.addAttribute("orderList", orderList);

        return "order_page";
    }

    @RequestMapping(value = "/view/{id}",method = GET)
    public String showOrderDetail(@PathVariable("id") int id,Model model) {
        List<OrderDetailsEntity> orderDetails = orderDetailRepository.getOrderDetailsByOrderId(id);
        model.addAttribute("orderDetails", orderDetails);

        return "order_detail_page";
    }

    @RequestMapping(value = "/search", method = GET)
    public String search(@RequestParam("searchInput")String searchInput, Model model) {
        List<OrderEntity> resultList;
        if (searchInput.isEmpty()) {
            resultList = (List<OrderEntity>) orderRepository.findAll();
        } else {
            resultList = orderRepository.findByNameContainingIgnoreCase(searchInput);
        }
        model.addAttribute("searchInput",searchInput);
        model.addAttribute("orderList", resultList);
        return "order_page";
    }

    @RequestMapping(value = "/product",method = GET)
    public String showProducts(Model model) {
        List<ProductEntity> productList = (List<ProductEntity>) productRepository.findAll();
        model.addAttribute("productList", productList);

        return "product";
    }

    @RequestMapping(value = "/newOrder", method = GET)
    public String showNewBook(Model model) {
        List<ProductEntity> productList = (List<ProductEntity>) productRepository.findAll();
        model.addAttribute("productList", productList);
        model.addAttribute("msg", "Add A New Order");
        model.addAttribute("action", "newOrder");

        return "add_edit_order";
    }

    @RequestMapping(value = "/newOrder", method = POST, produces = "text/plain;charset=UTF-8")
    public String saveOrder(OrderEntity order, OrderDetailsEntity orderDetails, Model model) {
        orderRepository.save(order);
        System.out.println(order.getId());

        orderDetailRepository.save(orderDetails);
        model.addAttribute("message","You are add success!");
        return "add_edit_order";
    }

    @RequestMapping(value = "/edit/{id}", method = GET)
    public String showEditBook(Model model, @PathVariable int id) {
        model.addAttribute("book", orderRepository.findById(id));
        model.addAttribute("msg", "Update book information");
        model.addAttribute("type", "update");
        model.addAttribute("action", "/updateBook");

        return "book";
    }

    @RequestMapping(value = "/updateOrder", method = POST)
    public String updateOrder(@ModelAttribute OrderEntity order) {
        orderRepository.save(order);
        return "redirect:/";
    }

    @RequestMapping(value = "/delete/{id}", method = GET)
    public String deleteBook(@PathVariable int id) {
        orderRepository.deleteById(id);
        return "redirect:/";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }



}
