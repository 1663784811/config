package cn.cyyaw.common.table.em;

public class GOrderEnum {

    public enum Status {
        //    complete    {1:下单,2:未完成,3:完成,4:取消,5:售后,6:异常}
        CREATE(1, "下单"),
        NOCOMPLETE(2, "未完成"),
        SUCCESS(3, "完成"),
        CANCEL(4, "取消"),
        AFTERSALE(5, "售后"),
        ABNORMAL(6, "异常");
        private Integer value;
        private String message;

        Status(Integer value, String message) {
            this.message = message;
            this.value = value;
        }

        public Integer getValue() {
            return this.value;
        }

        public String getMessage() {
            return this.message;
        }
    }

    public enum Paystatus {
        NOCOMPLETE(1, "未支付"),
        PAYING(2, "正在支付"),
        SUCCESS(3, "支付成功"),
        FAIL(4, "支付失败"),
        REFUNDING(5, "退款中"),
        REFUNDSUCCESS(6, "退款成功"),
        REFUNDFAIL(7, "退款失败");
        private Integer value;
        private String message;

        Paystatus(Integer value, String message) {
            this.message = message;
            this.value = value;
        }

        public Integer getValue() {
            return this.value;
        }

        public String getMessage() {
            return this.message;
        }

    }


    public enum Rechargestatus {
        NOCOMPLETE(1, "未充值"),
        RECHARGING(2, "正在充值"),
        SUCCESS(3, "充值成功"),
        FAIL(4, "充值失败");
        private Integer value;
        private String message;

        Rechargestatus(Integer value, String message) {
            this.message = message;
            this.value = value;
        }
        public Integer getValue() {
            return this.value;
        }
        public String getMessage() {
            return this.message;
        }
    }
}
