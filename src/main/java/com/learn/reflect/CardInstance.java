package com.learn.reflect;

/**
 * @Description:  被反射的类
 * @author: WeFon
 * @date: 2018-08-13 22:57
 * @Copyright: 2018
 */
@CardAnnotation(type = "全球黑卡", color = "超级亮银色")
public class CardInstance {
		private String id;
		private Long balance;
		private String belongsName;

		private CardInstance(Long balance){
				this.balance = balance;
		}
		public CardInstance(String id, Long balance, String belongsName) {
				this.id = id;
				this.balance = balance;
				this.belongsName = belongsName;
		}

		public CardInstance() {
		}

		public Long balanceReduce(Long money){
				this.balance = this.balance - money;
				return this.balance;
		}
		@MethodAnnotation(version = "1.0", importLvl = "high")
		public void methodAnnotation(){
				System.out.println(this);
		}
		public Long balanceAutoGen(){
				if(balance == null){
						balance = 10000L;
				}
				this.balance += 100;
				return this.balance;
		}

		public void setBalance(Long balance) {
				this.balance = balance;
		}

		@Override
		public String toString() {
				return "CardInstance{" +
							"id='" + id + '\'' +
							", balance=" + balance +
							", belongsName='" + belongsName + '\'' +
							'}';
		}
}
