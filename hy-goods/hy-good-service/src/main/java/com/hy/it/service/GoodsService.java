package com.hy.it.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hy.it.mapper.GoodsMapper;
import com.hy.it.pojo.*;
import com.hyzg.utils.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class GoodsService {

    @Autowired
    private GoodsTypeService goodsTypeService;
    @Autowired
    private TransPortService transPortService;
    @Autowired
    private GoodsKindService goodsKindService;
    @Autowired
    private CarTypeService carTypeService;
    @Autowired
    private GoodsMapper goodsMapper;

    public void saveGoods(Goods goods) {

        System.out.println(goods);
        Goods goods1 = coller(goods);
        //货源表信息收集完毕，保存
        goodsMapper.insert(goods1);
    }

    public Goods selectByname(String name) {
        Goods goods = new Goods();
        goods.setName(name);
        List<Goods> goodsList = goodsMapper.select(goods);
        return goodsList.get(0);
    }

    public PageResult<Goods> goodsList(Integer page, Integer rows, Integer time,Goods goods) {
        PageHelper.startPage(page,Math.min(rows,100));
        Goods goods2 = coller(goods);
//        List<Goods> list = goodsMapper.select(goods2);
        Example example = new Example(Goods.class);
        Example.Criteria criteria = example.createCriteria();
        Double maxprice = goods.getMaxprice();
        Double minprice = goods.getMinprice();

        if( maxprice != null && minprice != null){
            criteria.andEqualTo("name",goods2.getName())
                    .andEqualTo("cat_type_id",goods2.getCar_type_id())
                    .andEqualTo("weight",goods2.getWeight())
                    .andEqualTo("transport",goods2.getTransport_id())
                    .andEqualTo("goods_type_id",goods2.getGoods_type_id())
                    .andEqualTo("goods_kind_id",goods2.getGoods_kind_id())
                    .andEqualTo("startplace",goods2.getStartplace_name())
                    .andEqualTo("endplace_name",goods2.getEndplace_name())
                    //时间的中间值
//                    .andBetween()
                    .andBetween("price",maxprice,minprice);
        }
//        if(time != null){
//
//        }
        List<Goods> list = goodsMapper.selectByExample(example);
        PageInfo<Goods> pageInfo = new PageInfo<>(list);
        PageResult<Goods> goodsPageResult = new PageResult<>();
        goodsPageResult.setTotal(pageInfo.getTotal());
        goodsPageResult.setTotalPage(Long.valueOf(pageInfo.getPages()));
        goodsPageResult.setItems(list);
        return goodsPageResult;
    }
    public Goods coller(Goods goods){
        //通过车辆种类查出车辆种类id
        Cartype cartype = new Cartype();
        cartype.setCar_type(goods.getCartypename());
        Long cartypeid = carTypeService.select(cartype);
        goods.setCar_type_id(cartypeid);
        //通过线路类型名称查出ID
        TransPort transPort = new TransPort();
        transPort.setName(goods.getTransportname());
        Long transportid = transPortService.select(transPort);
        goods.setTransport_id(transportid);
        //通过货源类别名称查出ID
        GoodsKind goodsKind = new GoodsKind();
        goodsKind.setName(goods.getGoodskindname());
        Long kindId = goodsKindService.select(goodsKind);
        goods.setGoods_kind_id(kindId);
        //通过货源种类名称查出ID
        GoodsType goodsType = new GoodsType();
        goodsType.setName(goods.getGoodstypename());
        Long goodsTypeid = goodsTypeService.select(goodsType);
        goods.setGoods_type_id(goodsTypeid);

        System.out.println("-----0"+goods.getCreate_time());
        System.out.println("-----1"+goods.getEnd_time());
        System.out.println("-----01"+goods.getCreatetime());
        System.out.println("-----11"+goods.getEndtime());
        SimpleDateFormat smp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            goods.setCreate_time(smp.parse(goods.getCreatetime()));
            goods.setEnd_time(smp.parse(goods.getEndtime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("-----2"+goods.getCreate_time());
        System.out.println("-----3"+goods.getEnd_time());
        System.out.println("-----21"+goods.getCreatetime());
        System.out.println("-----31" +goods.getEndtime());
        return goods;
    }

    public void deleteByid(Integer id) {
        Goods goods = new Goods();
        goods.setId(Long.valueOf(id));
        goodsMapper.delete(goods);
    }

    public Goods update(Goods goods) {
         goodsMapper.updateByPrimaryKey(goods);
        Goods goods1 = goodsMapper.selectByPrimaryKey(goods);
        return goods1;
    }
}
