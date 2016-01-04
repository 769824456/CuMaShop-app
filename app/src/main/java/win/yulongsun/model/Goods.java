package win.yulongsun.model;

import cn.bmob.v3.BmobObject;

/**
 * Created by yulongsun on 2016/1/4.
 * 商品
 */
public class Goods extends BmobObject {
    private String goodsIcon;
    private String goodsName;
    private Float goodsPrice;
    private Integer goodsXiaoShouNum;//已经卖了多少
    private Integer goodsTotalNum;//商品总量
    private Integer goodsLeftNum;//剩余数量
    private String goodsDesc;//描述
    private String goodsStatus;//
}
