import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'

     import users from '@/views/modules/users/list'
    import address from '@/views/modules/address/list'
    import cart from '@/views/modules/cart/list'
    import chat from '@/views/modules/chat/list'
    import dictionary from '@/views/modules/dictionary/list'
    import jifenjilu from '@/views/modules/jifenjilu/list'
    import news from '@/views/modules/news/list'
    import yanjing from '@/views/modules/yanjing/list'
    import yanjingCommentback from '@/views/modules/yanjingCommentback/list'
    import yanjingOrder from '@/views/modules/yanjingOrder/list'
    import yonghu from '@/views/modules/yonghu/list'
    import config from '@/views/modules/config/list'
    import dictionaryCaizhi from '@/views/modules/dictionaryCaizhi/list'
    import dictionaryChat from '@/views/modules/dictionaryChat/list'
    import dictionaryHuiyuandengji from '@/views/modules/dictionaryHuiyuandengji/list'
    import dictionaryIsdefault from '@/views/modules/dictionaryIsdefault/list'
    import dictionaryJifen from '@/views/modules/dictionaryJifen/list'
    import dictionaryJingpian from '@/views/modules/dictionaryJingpian/list'
    import dictionaryNews from '@/views/modules/dictionaryNews/list'
    import dictionaryPeijian from '@/views/modules/dictionaryPeijian/list'
    import dictionaryPinpai from '@/views/modules/dictionaryPinpai/list'
    import dictionarySex from '@/views/modules/dictionarySex/list'
    import dictionaryShangpinOrderPayment from '@/views/modules/dictionaryShangpinOrderPayment/list'
    import dictionaryShangxia from '@/views/modules/dictionaryShangxia/list'
    import dictionaryYanjing from '@/views/modules/dictionaryYanjing/list'
    import dictionaryYanjingOrder from '@/views/modules/dictionaryYanjingOrder/list'
    import dictionaryYanjingOrderPayment from '@/views/modules/dictionaryYanjingOrderPayment/list'
    import dictionaryYanse from '@/views/modules/dictionaryYanse/list'
    import dictionaryZheshe from '@/views/modules/dictionaryZheshe/list'
    import dictionaryZhuangtai from '@/views/modules/dictionaryZhuangtai/list'





//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    } ,{
        path: '/users',
        name: '管理信息',
        component: users
      }
    ,{
        path: '/dictionaryCaizhi',
        name: '镜框材质',
        component: dictionaryCaizhi
    }
    ,{
        path: '/dictionaryChat',
        name: '数据类型',
        component: dictionaryChat
    }
    ,{
        path: '/dictionaryHuiyuandengji',
        name: '会员等级类型',
        component: dictionaryHuiyuandengji
    }
    ,{
        path: '/dictionaryIsdefault',
        name: '是否默认地址',
        component: dictionaryIsdefault
    }
    ,{
        path: '/dictionaryJifen',
        name: '类型',
        component: dictionaryJifen
    }
    ,{
        path: '/dictionaryJingpian',
        name: '镜片材质',
        component: dictionaryJingpian
    }
    ,{
        path: '/dictionaryNews',
        name: '公告类型',
        component: dictionaryNews
    }
    ,{
        path: '/dictionaryPeijian',
        name: '眼镜配件',
        component: dictionaryPeijian
    }
    ,{
        path: '/dictionaryPinpai',
        name: '品牌',
        component: dictionaryPinpai
    }
    ,{
        path: '/dictionarySex',
        name: '性别类型',
        component: dictionarySex
    }
    ,{
        path: '/dictionaryShangpinOrderPayment',
        name: '订单支付类型',
        component: dictionaryShangpinOrderPayment
    }
    ,{
        path: '/dictionaryShangxia',
        name: '上下架',
        component: dictionaryShangxia
    }
    ,{
        path: '/dictionaryYanjing',
        name: '眼镜类型',
        component: dictionaryYanjing
    }
    ,{
        path: '/dictionaryYanjingOrder',
        name: '订单类型',
        component: dictionaryYanjingOrder
    }
    ,{
        path: '/dictionaryYanjingOrderPayment',
        name: '订单支付类型',
        component: dictionaryYanjingOrderPayment
    }
    ,{
        path: '/dictionaryYanse',
        name: '颜色',
        component: dictionaryYanse
    }
    ,{
        path: '/dictionaryZheshe',
        name: '折射率',
        component: dictionaryZheshe
    }
    ,{
        path: '/dictionaryZhuangtai',
        name: '状态',
        component: dictionaryZhuangtai
    }
    ,{
        path: '/config',
        name: '轮播图',
        component: config
    }


    ,{
        path: '/address',
        name: '收货地址',
        component: address
      }
    ,{
        path: '/cart',
        name: '购物车',
        component: cart
      }
    ,{
        path: '/chat',
        name: '客服聊天',
        component: chat
      }
    ,{
        path: '/dictionary',
        name: '字典',
        component: dictionary
      }
    ,{
        path: '/jifenjilu',
        name: '积分记录',
        component: jifenjilu
      }
    ,{
        path: '/news',
        name: '公告信息',
        component: news
      }
    ,{
        path: '/yanjing',
        name: '眼镜',
        component: yanjing
      }
    ,{
        path: '/yanjingCommentback',
        name: '眼镜评价',
        component: yanjingCommentback
      }
    ,{
        path: '/yanjingOrder',
        name: '眼镜订单',
        component: yanjingOrder
      }
    ,{
        path: '/yonghu',
        name: '用户',
        component: yonghu
      }


    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
