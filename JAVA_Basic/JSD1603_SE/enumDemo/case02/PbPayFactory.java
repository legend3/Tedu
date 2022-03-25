package enumDemo.case02;


/**
 * 案例二：工厂模式
 */
public class PbPayFactory {
    /**
     * 传统模式
     */
    //微信
    public static final String weixinPayType = "weixin";
    public static final String weixinPayUrl = "https://weixin.com";

    //阿里
    public static final String ALIPayType = "ali";
    public static final String ALIPayUrl = "https://ali.com";

    //银联
    public static final String UnionPayType = "union";
    public static final String UnionPayUrl = "https://union.com";

//    public static Pay getPay(String payType){
//        //支付对象
//        Pay pay = null;
//
//        switch (payType){
//            case weixinPayType:
//                System.out.println("构造一个微信支付对象");
//            case ALIPayType:
//                System.out.println("构造一个阿里支付对象");
//            case UnionPayType:
//                System.out.println("构造一个银联支付对象");
//            default:
//                System.out.println("不在支付方式中");
//                    break;
//        }
//        return pay;
//    }

    /**
     * switch支持enum类型
     * @param payType
     * @return
     *
     * 注意，在switch中，不能使用枚举类名称，例如：“case PayEmun.WEIXINPAY：”这是错误的，
     * 因为编译器会根据switch中payType的类型来判定每个枚举类型，在case中必须直接给出与payType相同类型的枚举选项，而不能再有类型。
     *
     */
    public static Pay getPay(PayEnum payType){
        //支付对象
        Pay pay = null;

        switch (payType){
            case WEIXINPAY://直接填写与枚举类名称一致名称即可
                System.out.println("构造一个微信支付对象");
                break;
            case ALIPAY:
                System.out.println("构造一个阿里支付对象");
                break;
            case UNIONPAY:
                System.out.println("构造一个银联支付对象");
                break;
            default:
                System.out.println("不在支付方式中");
                break;
        }
        return pay;
    }
}
