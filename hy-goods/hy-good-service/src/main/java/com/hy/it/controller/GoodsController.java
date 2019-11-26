package com.hy.it.controller;

import com.hy.it.pojo.Goods;
import com.hy.it.service.GoodsService;
import com.hyzg.utils.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;
    @GetMapping("/search/{time}")
    public ResponseEntity<PageResult<Goods>> goodsList(
            @PathVariable(value = "time",required =false ) Integer time,
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "rows", defaultValue = "5") Integer rows,
            Goods goods){
            PageResult<Goods> result = goodsService.goodsList(page,rows,time,goods);
            return ResponseEntity.ok(result);
    }
    @GetMapping("/goods")
    public ResponseEntity<Goods> goods(@RequestParam("name")String name){
        Goods goods = goodsService.selectByname(name);
        return ResponseEntity.ok(goods);
    }
    @PostMapping("/save")
    public ResponseEntity<Void> saveGoods(Goods goods){
        goodsService.saveGoods(goods);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }
    @PutMapping("/delete")
    public ResponseEntity<Void> delete(@RequestParam(value = "id")Integer id){
        goodsService.deleteByid(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }
    @PutMapping("/update")
    public ResponseEntity<Goods> update(@RequestBody Goods goods){
        Goods goods1 = goodsService.update(goods);
        return ResponseEntity.ok(goods1);
    }

}
