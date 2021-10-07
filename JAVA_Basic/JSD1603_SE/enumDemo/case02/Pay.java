package enumDemo.case02;

public interface Pay {
    /**
     * 请求支付的接口
     * @param account   账户
     * @param money 支付金额
     * @return  请求支付结果
     */
    String requestPay(String account, float money);

    /**
     * 查询支付结果
     * @param orderId   订单好
     * @return  支付结果
     */
    String getResult(String orderId);
}
