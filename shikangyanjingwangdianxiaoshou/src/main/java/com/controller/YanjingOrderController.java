
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 眼镜订单
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/yanjingOrder")
public class YanjingOrderController {
    private static final Logger logger = LoggerFactory.getLogger(YanjingOrderController.class);

    @Autowired
    private YanjingOrderService yanjingOrderService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private AddressService addressService;
    @Autowired
    private YanjingService yanjingService;
    @Autowired
    private YonghuService yonghuService;
@Autowired
private CartService cartService;
@Autowired
private JifenjiluService jifenjiluService;
@Autowired
private YanjingCommentbackService yanjingCommentbackService;



    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = yanjingOrderService.queryPage(params);

        //字典表数据转换
        List<YanjingOrderView> list =(List<YanjingOrderView>)page.getList();
        for(YanjingOrderView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        YanjingOrderEntity yanjingOrder = yanjingOrderService.selectById(id);
        if(yanjingOrder !=null){
            //entity转view
            YanjingOrderView view = new YanjingOrderView();
            BeanUtils.copyProperties( yanjingOrder , view );//把实体数据重构到view中

                //级联表
                AddressEntity address = addressService.selectById(yanjingOrder.getAddressId());
                if(address != null){
                    BeanUtils.copyProperties( address , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setAddressId(address.getId());
                    view.setAddressYonghuId(address.getYonghuId());
                }
                //级联表
                YanjingEntity yanjing = yanjingService.selectById(yanjingOrder.getYanjingId());
                if(yanjing != null){
                    BeanUtils.copyProperties( yanjing , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYanjingId(yanjing.getId());
                }
                //级联表
                YonghuEntity yonghu = yonghuService.selectById(yanjingOrder.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody YanjingOrderEntity yanjingOrder, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,yanjingOrder:{}",this.getClass().getName(),yanjingOrder.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            yanjingOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        yanjingOrder.setInsertTime(new Date());
        yanjingOrder.setCreateTime(new Date());
        yanjingOrderService.insert(yanjingOrder);
        return R.ok();
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody YanjingOrderEntity yanjingOrder, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,yanjingOrder:{}",this.getClass().getName(),yanjingOrder.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            yanjingOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<YanjingOrderEntity> queryWrapper = new EntityWrapper<YanjingOrderEntity>()
            .eq("id",0)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YanjingOrderEntity yanjingOrderEntity = yanjingOrderService.selectOne(queryWrapper);
        if(yanjingOrderEntity==null){
            yanjingOrderService.updateById(yanjingOrder);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        yanjingOrderService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<YanjingOrderEntity> yanjingOrderList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            YanjingOrderEntity yanjingOrderEntity = new YanjingOrderEntity();
//                            yanjingOrderEntity.setYanjingOrderUuidNumber(data.get(0));                    //订单号 要改的
//                            yanjingOrderEntity.setAddressId(Integer.valueOf(data.get(0)));   //收货地址 要改的
//                            yanjingOrderEntity.setYanjingId(Integer.valueOf(data.get(0)));   //眼镜 要改的
//                            yanjingOrderEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            yanjingOrderEntity.setBuyNumber(Integer.valueOf(data.get(0)));   //购买数量 要改的
//                            yanjingOrderEntity.setYanjingOrderTruePrice(data.get(0));                    //实付价格 要改的
//                            yanjingOrderEntity.setYanjingOrderTypes(Integer.valueOf(data.get(0)));   //订单类型 要改的
//                            yanjingOrderEntity.setYanjingOrderPaymentTypes(Integer.valueOf(data.get(0)));   //支付类型 要改的
//                            yanjingOrderEntity.setInsertTime(date);//时间
//                            yanjingOrderEntity.setCreateTime(date);//时间
                            yanjingOrderList.add(yanjingOrderEntity);


                            //把要查询是否重复的字段放入map中
                                //订单号
                                if(seachFields.containsKey("yanjingOrderUuidNumber")){
                                    List<String> yanjingOrderUuidNumber = seachFields.get("yanjingOrderUuidNumber");
                                    yanjingOrderUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> yanjingOrderUuidNumber = new ArrayList<>();
                                    yanjingOrderUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("yanjingOrderUuidNumber",yanjingOrderUuidNumber);
                                }
                        }

                        //查询是否重复
                         //订单号
                        List<YanjingOrderEntity> yanjingOrderEntities_yanjingOrderUuidNumber = yanjingOrderService.selectList(new EntityWrapper<YanjingOrderEntity>().in("yanjing_order_uuid_number", seachFields.get("yanjingOrderUuidNumber")));
                        if(yanjingOrderEntities_yanjingOrderUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(YanjingOrderEntity s:yanjingOrderEntities_yanjingOrderUuidNumber){
                                repeatFields.add(s.getYanjingOrderUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [订单号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        yanjingOrderService.insertBatch(yanjingOrderList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }





    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        // 没有指定排序字段就默认id倒序
        if(StringUtil.isEmpty(String.valueOf(params.get("orderBy")))){
            params.put("orderBy","id");
        }
        PageUtils page = yanjingOrderService.queryPage(params);

        //字典表数据转换
        List<YanjingOrderView> list =(List<YanjingOrderView>)page.getList();
        for(YanjingOrderView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        YanjingOrderEntity yanjingOrder = yanjingOrderService.selectById(id);
            if(yanjingOrder !=null){


                //entity转view
                YanjingOrderView view = new YanjingOrderView();
                BeanUtils.copyProperties( yanjingOrder , view );//把实体数据重构到view中

                //级联表
                    AddressEntity address = addressService.selectById(yanjingOrder.getAddressId());
                if(address != null){
                    BeanUtils.copyProperties( address , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setAddressId(address.getId());
                }
                //级联表
                    YanjingEntity yanjing = yanjingService.selectById(yanjingOrder.getYanjingId());
                if(yanjing != null){
                    BeanUtils.copyProperties( yanjing , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYanjingId(yanjing.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(yanjingOrder.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody YanjingOrderEntity yanjingOrder, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,yanjingOrder:{}",this.getClass().getName(),yanjingOrder.toString());
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if("用户".equals(role)){
            YanjingEntity yanjingEntity = yanjingService.selectById(yanjingOrder.getYanjingId());
            if(yanjingEntity == null){
                return R.error(511,"查不到该物品");
            }
            // Double yanjingNewMoney = yanjingEntity.getYanjingNewMoney();

            if(false){
            }
            else if((yanjingEntity.getYanjingKucunNumber() -yanjingOrder.getBuyNumber())<0){
                return R.error(511,"购买数量不能大于库存数量");
            }
            else if(yanjingEntity.getYanjingNewMoney() == null){
                return R.error(511,"物品价格不能为空");
            }

            //计算所获得积分
            Double buyJifen =0.0;
            Integer userId = (Integer) request.getSession().getAttribute("userId");
            YonghuEntity yonghuEntity = yonghuService.selectById(userId);
            if(yonghuEntity == null)
                return R.error(511,"用户不能为空");
            if(yonghuEntity.getNewMoney() == null)
                return R.error(511,"用户金额不能为空");
            double balance = yonghuEntity.getNewMoney() - yanjingEntity.getYanjingNewMoney()*yanjingOrder.getBuyNumber();//余额
            if(balance<0)
                return R.error(511,"余额不够支付");
            yanjingOrder.setYanjingOrderTypes(3); //设置订单状态为已支付
            yanjingOrder.setYanjingOrderTruePrice(yanjingEntity.getYanjingNewMoney()*yanjingOrder.getBuyNumber()); //设置实付价格
            yanjingOrder.setYonghuId(userId); //设置订单支付人id
            yanjingOrder.setYanjingOrderPaymentTypes(1);
            yanjingOrder.setInsertTime(new Date());
            yanjingOrder.setCreateTime(new Date());
                yanjingEntity.setYanjingKucunNumber( yanjingEntity.getYanjingKucunNumber() -yanjingOrder.getBuyNumber());
                yanjingService.updateById(yanjingEntity);
                yanjingOrderService.insert(yanjingOrder);//新增订单
            yonghuEntity.setNewMoney(balance);//设置金额
            yonghuEntity.setYonghuSumJifen(yonghuEntity.getYonghuSumJifen() + buyJifen); //设置总积分
            yonghuEntity.setYonghuNewJifen(yonghuEntity.getYonghuNewJifen() + buyJifen); //设置现积分
                if(yonghuEntity.getYonghuSumJifen()  < 10000)
                    yonghuEntity.setHuiyuandengjiTypes(1);
                else if(yonghuEntity.getYonghuSumJifen()  < 100000)
                    yonghuEntity.setHuiyuandengjiTypes(2);
                else if(yonghuEntity.getYonghuSumJifen()  < 1000000)
                    yonghuEntity.setHuiyuandengjiTypes(3);
            yonghuService.updateById(yonghuEntity);
            return R.ok();
        }else{
            return R.error(511,"您没有权限支付订单");
        }
    }
    /**
     * 添加订单
     */
    @RequestMapping("/order")
    public R add(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("order方法:,,Controller:{},,params:{}",this.getClass().getName(),params.toString());
        String yanjingOrderUuidNumber = String.valueOf(new Date().getTime());

        //获取当前登录用户的id
        Integer userId = (Integer) request.getSession().getAttribute("userId");
        Integer addressId = Integer.valueOf(String.valueOf(params.get("addressId")));

        Integer yanjingOrderPaymentTypes = Integer.valueOf(String.valueOf(params.get("yanjingOrderPaymentTypes")));//支付类型

        String data = String.valueOf(params.get("yanjings"));
        JSONArray jsonArray = JSON.parseArray(data);
        List<Map> yanjings = JSON.parseObject(jsonArray.toString(), List.class);

        //获取当前登录用户的个人信息
        YonghuEntity yonghuEntity = yonghuService.selectById(userId);

        //积分记录表
        List<JifenjiluEntity> jifenjiluList = new ArrayList<>();
        //当前订单表
        List<YanjingOrderEntity> yanjingOrderList = new ArrayList<>();
        //商品表
        List<YanjingEntity> yanjingList = new ArrayList<>();
        //购物车ids
        List<Integer> cartIds = new ArrayList<>();

        BigDecimal zhekou = new BigDecimal(1.0);
        // 获取折扣
        Wrapper<DictionaryEntity> dictionary = new EntityWrapper<DictionaryEntity>()
                .eq("dic_code", "huiyuandengji_types")
                .eq("dic_name", "会员等级类型")
                .eq("code_index", yonghuEntity.getHuiyuandengjiTypes())
                ;
        DictionaryEntity dictionaryEntity = dictionaryService.selectOne(dictionary);
        if(dictionaryEntity != null ){
            zhekou = BigDecimal.valueOf(Double.valueOf(dictionaryEntity.getBeizhu()));
        }

        //循环取出需要的数据
        for (Map<String, Object> map : yanjings) {
           //取值
            Integer yanjingId = Integer.valueOf(String.valueOf(map.get("yanjingId")));//商品id
            Integer buyNumber = Integer.valueOf(String.valueOf(map.get("buyNumber")));//购买数量
            YanjingEntity yanjingEntity = yanjingService.selectById(yanjingId);//购买的商品
            String id = String.valueOf(map.get("id"));
            if(StringUtil.isNotEmpty(id))
                cartIds.add(Integer.valueOf(id));

            //判断商品的库存是否足够
            if(yanjingEntity.getYanjingKucunNumber() < buyNumber){
                //商品库存不足直接返回
                return R.error(yanjingEntity.getYanjingName()+"的库存不足");
            }else{
                //商品库存充足就减库存
                yanjingEntity.setYanjingKucunNumber(yanjingEntity.getYanjingKucunNumber() - buyNumber);
            }

            //设置数据
            //在积分记录表增加记录
            JifenjiluEntity jifenjiluEntity = new JifenjiluEntity();
            //订单信息表增加数据
            YanjingOrderEntity yanjingOrderEntity = new YanjingOrderEntity<>();

            //赋值订单信息
            yanjingOrderEntity.setYanjingOrderUuidNumber(yanjingOrderUuidNumber);//订单号
            yanjingOrderEntity.setAddressId(addressId);//收货地址
            yanjingOrderEntity.setYanjingId(yanjingId);//眼镜
            yanjingOrderEntity.setYonghuId(userId);//用户
            yanjingOrderEntity.setBuyNumber(buyNumber);//购买数量 ？？？？？？
            yanjingOrderEntity.setYanjingOrderTypes(3);//订单类型
            yanjingOrderEntity.setYanjingOrderPaymentTypes(yanjingOrderPaymentTypes);//支付类型
            yanjingOrderEntity.setInsertTime(new Date());//订单创建时间
            yanjingOrderEntity.setCreateTime(new Date());//创建时间

            //判断是什么支付方式 1代表余额 2代表积分
            if(yanjingOrderPaymentTypes == 1){//余额支付
                //计算金额
                Double money = new BigDecimal(yanjingEntity.getYanjingNewMoney()).multiply(new BigDecimal(buyNumber)).multiply(zhekou).doubleValue();

                if(yonghuEntity.getNewMoney() - money <0 ){
                    return R.error("余额不足,请充值！！！");
                }else{
                    //计算所获得积分
                    Double buyJifen =0.0;
                    yonghuEntity.setNewMoney(yonghuEntity.getNewMoney() - money); //设置金额
                    yonghuEntity.setYonghuSumJifen(yonghuEntity.getYonghuSumJifen() + buyJifen); //设置总积分
                    yonghuEntity.setYonghuNewJifen(yonghuEntity.getYonghuNewJifen() + buyJifen); //设置现积分
                        if(yonghuEntity.getYonghuSumJifen()  < 10000)
                            yonghuEntity.setHuiyuandengjiTypes(1);
                        else if(yonghuEntity.getYonghuSumJifen()  < 100000)
                            yonghuEntity.setHuiyuandengjiTypes(2);
                        else if(yonghuEntity.getYonghuSumJifen()  < 1000000)
                            yonghuEntity.setHuiyuandengjiTypes(3);

                    jifenjiluEntity.setCreateTime(new Date());
                    jifenjiluEntity.setYonghuId(userId);
                    jifenjiluEntity.setInsertTime(new Date());
                    jifenjiluEntity.setJifenTypes(2);
                    jifenjiluEntity.setJifenjiluName("购买 "+ yanjingEntity.getYanjingName() + " " + buyNumber + " 个 花费金额 " + money + " 获得积分"+buyJifen);
                    jifenjiluEntity.setJifenjiluNumber(buyJifen);

                    yanjingOrderEntity.setYanjingOrderTruePrice(money);

                }
            }
            else{//积分支付

                Double money = yanjingEntity.getYanjingNewMoney() * buyNumber;
                if(yonghuEntity.getYonghuNewJifen() - money <0 ){
                    return R.error("积分不足,无法支付");
                }else{
                    yonghuEntity.setYonghuNewJifen(yonghuEntity.getYonghuNewJifen() - money);//设置现在积分

                    jifenjiluEntity.setCreateTime(new Date());
                    jifenjiluEntity.setYonghuId(userId);
                    jifenjiluEntity.setInsertTime(new Date());
                    jifenjiluEntity.setJifenTypes(1);
                    jifenjiluEntity.setJifenjiluName("消费 "+ yanjingEntity.getYanjingName()+" "+buyNumber+" 个 花费积分 "+money);
                    jifenjiluEntity.setJifenjiluNumber(money);

                    yanjingOrderEntity.setYanjingOrderTruePrice(money);//实付积分
                }

            }
            yanjingOrderList.add(yanjingOrderEntity);
            jifenjiluList.add(jifenjiluEntity);
            yanjingList.add(yanjingEntity);

        }
        yanjingOrderService.insertBatch(yanjingOrderList);
        jifenjiluService.insertBatch(jifenjiluList);
        yanjingService.updateBatchById(yanjingList);
        yonghuService.updateById(yonghuEntity);
        if(cartIds != null && cartIds.size()>0)
            cartService.deleteBatchIds(cartIds);
        return R.ok();
    }











    /**
    * 退款
    */
    @RequestMapping("/refund")
    public R refund(Integer id, HttpServletRequest request){
        logger.debug("refund方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        String role = String.valueOf(request.getSession().getAttribute("role"));

        //积分记录表
        JifenjiluEntity jifenjiluEntity = new JifenjiluEntity();
        if("用户".equals(role)){
            YanjingOrderEntity yanjingOrder = yanjingOrderService.selectById(id);
            Integer buyNumber = yanjingOrder.getBuyNumber();
            Integer yanjingOrderPaymentTypes = yanjingOrder.getYanjingOrderPaymentTypes();
            Integer yanjingId = yanjingOrder.getYanjingId();
            if(yanjingId == null)
                return R.error(511,"查不到该物品");
            YanjingEntity yanjingEntity = yanjingService.selectById(yanjingId);
            if(yanjingEntity == null)
                return R.error(511,"查不到该物品");
            Double yanjingNewMoney = yanjingEntity.getYanjingNewMoney();
            if(yanjingNewMoney == null)
                return R.error(511,"物品价格不能为空");

            Integer userId = (Integer) request.getSession().getAttribute("userId");
            YonghuEntity yonghuEntity = yonghuService.selectById(userId);
            if(yonghuEntity == null)
                return R.error(511,"用户不能为空");
            if(yonghuEntity.getNewMoney() == null)
                return R.error(511,"用户金额不能为空");

            Double zhekou = 1.0;
            // 获取折扣
            Wrapper<DictionaryEntity> dictionary = new EntityWrapper<DictionaryEntity>()
                    .eq("dic_code", "huiyuandengji_types")
                    .eq("dic_name", "会员等级类型")
                    .eq("code_index", yonghuEntity.getHuiyuandengjiTypes())
                    ;
            DictionaryEntity dictionaryEntity = dictionaryService.selectOne(dictionary);
            if(dictionaryEntity != null ){
                zhekou = Double.valueOf(dictionaryEntity.getBeizhu());
            }


            //判断是什么支付方式 1代表余额 2代表积分
            if(yanjingOrderPaymentTypes == 1){//余额支付
                //计算金额
                Double money = yanjingEntity.getYanjingNewMoney() * buyNumber  * zhekou;
                //计算所获得积分
                Double buyJifen = 0.0;
                yonghuEntity.setNewMoney(yonghuEntity.getNewMoney() + money); //设置金额
                yonghuEntity.setYonghuSumJifen(yonghuEntity.getYonghuSumJifen() - buyJifen); //设置总积分
                if(yonghuEntity.getYonghuNewJifen() - buyJifen <0 )
                    return R.error("积分已经消费,无法退款！！！");
                yonghuEntity.setYonghuNewJifen(yonghuEntity.getYonghuNewJifen() - buyJifen); //设置现积分

                if(yonghuEntity.getYonghuSumJifen()  < 10000)
                    yonghuEntity.setHuiyuandengjiTypes(1);
                else if(yonghuEntity.getYonghuSumJifen()  < 100000)
                    yonghuEntity.setHuiyuandengjiTypes(2);
                else if(yonghuEntity.getYonghuSumJifen()  < 1000000)
                    yonghuEntity.setHuiyuandengjiTypes(3);

                jifenjiluEntity.setCreateTime(new Date());
                jifenjiluEntity.setYonghuId(userId);
                jifenjiluEntity.setInsertTime(new Date());
                jifenjiluEntity.setJifenTypes(1);
                jifenjiluEntity.setJifenjiluName("退款已购买的"+ yanjingEntity.getYanjingName()+" "+buyNumber+" 个 增加的 "+buyJifen +" 积分");
                jifenjiluEntity.setJifenjiluNumber(money);
            }
            else{//积分支付

                Double money = yanjingEntity.getYanjingNewMoney() * buyNumber;
                yonghuEntity.setYonghuNewJifen(yonghuEntity.getYonghuNewJifen() + money); //设置现积分

                    jifenjiluEntity.setCreateTime(new Date());
                    jifenjiluEntity.setYonghuId(userId);
                    jifenjiluEntity.setInsertTime(new Date());
                    jifenjiluEntity.setJifenTypes(2);
                    jifenjiluEntity.setJifenjiluName("退还购买物品所消费的 "+ yanjingEntity.getYanjingName()+" "+buyNumber+" 个 花费积分 "+money);
                    jifenjiluEntity.setJifenjiluNumber(money);
            }

            yanjingEntity.setYanjingKucunNumber(yanjingEntity.getYanjingKucunNumber() + buyNumber);



            yanjingOrder.setYanjingOrderTypes(2);//设置订单状态为退款
            yanjingOrderService.updateById(yanjingOrder);//根据id更新
            jifenjiluService.insert(jifenjiluEntity);
            yonghuService.updateById(yonghuEntity);//更新用户信息
            yanjingService.updateById(yanjingEntity);//更新订单中物品的信息
            return R.ok();
        }else{
            return R.error(511,"您没有权限退款");
        }
    }


    /**
     * 发货
     */
    @RequestMapping("/deliver")
    public R deliver(Integer id){
        logger.debug("refund:,,Controller:{},,ids:{}",this.getClass().getName(),id.toString());
        YanjingOrderEntity  yanjingOrderEntity = new  YanjingOrderEntity();;
        yanjingOrderEntity.setId(id);
        yanjingOrderEntity.setYanjingOrderTypes(4);
        boolean b =  yanjingOrderService.updateById( yanjingOrderEntity);
        if(!b){
            return R.error("发货出错");
        }
        return R.ok();
    }









    /**
     * 收货
     */
    @RequestMapping("/receiving")
    public R receiving(Integer id){
        logger.debug("refund:,,Controller:{},,ids:{}",this.getClass().getName(),id.toString());
        YanjingOrderEntity  yanjingOrderEntity = new  YanjingOrderEntity();
        yanjingOrderEntity.setId(id);
        yanjingOrderEntity.setYanjingOrderTypes(5);
        boolean b =  yanjingOrderService.updateById( yanjingOrderEntity);
        if(!b){
            return R.error("收货出错");
        }
        return R.ok();
    }



    /**
    * 评价
    */
    @RequestMapping("/commentback")
    public R commentback(Integer id, String commentbackText, Integer yanjingCommentbackPingfenNumber, HttpServletRequest request){
        logger.debug("commentback方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if("用户".equals(role)){
            YanjingOrderEntity yanjingOrder = yanjingOrderService.selectById(id);
        if(yanjingOrder == null)
            return R.error(511,"查不到该订单");
        if(yanjingOrder.getYanjingOrderTypes() != 5)
            return R.error(511,"您不能评价");
        Integer yanjingId = yanjingOrder.getYanjingId();
        if(yanjingId == null)
            return R.error(511,"查不到该物品");

        YanjingCommentbackEntity yanjingCommentbackEntity = new YanjingCommentbackEntity();
            yanjingCommentbackEntity.setId(id);
            yanjingCommentbackEntity.setYanjingId(yanjingId);
            yanjingCommentbackEntity.setYonghuId((Integer) request.getSession().getAttribute("userId"));
            yanjingCommentbackEntity.setYanjingCommentbackText(commentbackText);
            yanjingCommentbackEntity.setReplyText(null);
            yanjingCommentbackEntity.setInsertTime(new Date());
            yanjingCommentbackEntity.setUpdateTime(null);
            yanjingCommentbackEntity.setCreateTime(new Date());
            yanjingCommentbackService.insert(yanjingCommentbackEntity);

            yanjingOrder.setYanjingOrderTypes(1);//设置订单状态为已评价
            yanjingOrderService.updateById(yanjingOrder);//根据id更新
            return R.ok();
        }else{
            return R.error(511,"您没有权限评价");
        }
    }







}
