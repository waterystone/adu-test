package com.adu.stock;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class TaxTest {
	private final static double STAMP_RATE = 0.001;// 印花税率
	private final static double COMMISSION_RATE = 0.00025;// 佣金率
	private final static double DEFAULT_COMMISSION = 5;// 最少佣金
	private final static double TRANSFER_RATE = 0.6;// 过户税率
	private final Log logger = LogFactory.getLog(this.getClass());

	@Test
	public void sellAndBuyTaxTest() {
		int buyCount = 5000, sellCount = 5000;
		double buyPprice = 8.3, sellPrice = 8.4;

		double grossProfit = sellCount * (sellPrice - buyPprice);// 毛利
		double sellTax = sellTax(sellCount, sellPrice);// 卖出税
		double buyTax = buyTax(buyCount, buyPprice);// 买入税
		double totalTax = sellTax + buyTax;
		double netProfit = grossProfit - totalTax;
		logger.debug("毛利润=" + grossProfit + ",净利润=" + netProfit + ",总税="
				+ totalTax + ",卖出税=" + sellTax + ",买入税=" + buyTax);

	}

	@Test
	public void sellTaxTest() {
		int count = 5000;
		double price = 8.33;
		double ret = sellTax(count, price);
		logger.debug("ret=" + ret);

	}

	@Test
	public void buyTaxTest() {
		int count = 5000;
		double price = 8.3;
		double ret = buyTax(count, price);
		logger.debug("ret=" + ret);

	}

	/**
	 * 卖出税
	 * 
	 * @param count
	 * @param price
	 * @return
	 */
	private double sellTax(int count, double price) {
		double total = count * price;
		double stampTax = total * STAMP_RATE;// 印花税

		double commission = DEFAULT_COMMISSION;// 佣金
		if (total > (DEFAULT_COMMISSION / COMMISSION_RATE)) {
			commission = total * COMMISSION_RATE;
		}

		double transferTax = count / 1000.0 * TRANSFER_RATE;// 过户费
		return stampTax + commission + transferTax;
	}

	/**
	 * 买入税
	 * 
	 * @param count
	 * @param price
	 * @return
	 */
	private double buyTax(int count, double price) {
		double total = count * price;

		double commission = DEFAULT_COMMISSION;// 佣金
		if (total > (DEFAULT_COMMISSION / COMMISSION_RATE)) {
			commission = total * COMMISSION_RATE;
		}

		double transferTax = count / 1000.0 * TRANSFER_RATE;// 过户费
		return commission + transferTax;
	}
}
