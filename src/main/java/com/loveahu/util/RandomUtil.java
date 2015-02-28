package com.loveahu.util;

import java.util.Random;
import java.util.UUID;

public class RandomUtil {
	
	private static Random random = new Random();

	static String[] message = {"[voice=http://img4.tx.com.cn/repos/img/4b4abbfffb12448b.amr/]","[pic=http://img4.tx.com.cn/repos/img/8676953e0e854b39.png/]","推荐你看[url=http://tx.com.cn/forum/threadDetail.do?fid=30577&amp;tid=39726&amp;classifyId=0&amp;pn=1&amp;t=t/]","天下通欢迎您"};
	
	static String[] images = {
		"http://img1.tx.com.cn/picture/space/small/jpg/7/090325/1237959702522.jpg",
		"http://img1.tx.com.cn/picture/space/small/jpg/18/090812/1250048121912.jpg",
		"http://img1.tx.com.cn/picture/space/small/jpg/67/090421/1240304261442.jpg",
		"http://img1.tx.com.cn/picture/space/small/jpg/32/090311/1236761550200.jpg",
		"http://img1.tx.com.cn/picture/space/small/jpg/15/090421/1240304553689.jpg",
		"http://img1.tx.com.cn/picture/space/small/jpg/56/090309/1236585463105.jpg",
		"http://img1.tx.com.cn/picture/space/small/jpg/50/090324/1237881683884.jpg",
		"http://img3.tx.com.cn/picture/space/small/gif/98/110922/1316697597303.gif",
		"http://img.tx.com.cn/img/tx/logos/B_67.gif",
		"http://img2.tx.com.cn/picture/space/small/jpg/94/091203/1259854905006.jpg",
		"http://img2.tx.com.cn/picture/space/small/jpg/94/091203/1259854905006.jpg"};
	
	/**
	 * 获取推荐位的推荐数量
	 * @param count
	 *            总的数量
	 * @param weight
	 *            当前推荐位的权值
	 * @return 这个推荐位可以提供的数量(随机)
	 */
	public static int getDiscoveryCount(int count, int weight) {
		int c = 0;
		Random random = new Random();
		for (int i = 0; i < count*(weight/100<1?1:weight/100); i++) {
			if (random.nextInt(100) < weight) {
				c++;
			}
		}
		return c;
	}

	/**
	 * 返回默认长度的随机密码
	 * @param size
	 * @return
	 */
	public static String getRandomPassword() {
		Random random = new Random();
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < 4; i++) {
			builder.append(random.nextInt(9));
		}
		return builder.toString();
	}

	/**
	 * 返回指定长度的随机密码
	 * @param size
	 * @return
	 */
	public static String getRandomPassword(int size) {
		Random random = new Random();
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < size; i++) {
			builder.append(random.nextInt(9));
		}
		return builder.toString();
	}
	
	/**
	 * 获得一个UUID
	 * 
	 * @return String UUID
	 */
	public static String getUUID() {
		String s = UUID.randomUUID().toString();
		// 去掉“-”符号
		return s.replaceAll("-", "");
	} 
	
	/**
	 * 获得指定数目的UUID
	 * 
	 * @param number
	 *            int 需要获得的UUID数量
	 * @return String[] UUID数组
	 */
	public static String[] getUUID(int number) {
		if (number < 1) {
			return null;
		}
		String[] ss = new String[number];
		for (int i = 0; i < number; i++) {
			ss[i] = getUUID();
		}
		return ss;
	}
	
	public static String randomImage(){
		return images[random.nextInt(11)];
	}
	
	public static String randomMessage(){
		return message[random.nextInt(4)];
	}

}
