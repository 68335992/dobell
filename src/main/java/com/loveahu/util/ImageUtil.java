package com.loveahu.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import javax.imageio.ImageIO;

public class ImageUtil {

	public static enum PhotoType{
		BIG("(/small/)|(/special/)","/big/"),//原图
		SMALL("(/big/)|(/special/)","/small/"),//比BIG小，比SPECIAL大。长宽比在5以内则最小边为128px
		SPECIAL("(/small/)|(/big/)","/special/");//最小。长宽比在5以内则最小边为50px。该选项为默认值
		
		public String fromRegex;
		public String toRegex;
		
		private PhotoType(String fromRegex,String toRegex){
			this.fromRegex = fromRegex;
			this.toRegex = toRegex;
		}
	}
	
	private static final String imgRegex = "^http://.*";
	
	/**
	 * 图片处理
	 * 
	 * @return
	 */
	public static BufferedImage compressPic(String url, int width, int heigth,	boolean proportion) {
		try {
			Image img = null;
			// 获得源文件
			if (url.matches(imgRegex)) {
				img = ImageIO.read(new URL(url));
			}
			if (null == img) {
				return null;
			}
			// 判断图片格式是否正确
			if (img.getWidth(null) == -1) {
				return null;
			}
			int newWidth;
			int newHeight;
			// 判断是否是等比缩放
			if (proportion) {
				// 为等比缩放计算输出的图片宽度及高度
				double rate1 = ((double) img.getWidth(null)) / (double) width + 0.1;
				double rate2 = ((double) img.getHeight(null)) / (double) heigth	+ 0.1;
				// 根据缩放比率大的进行缩放控制
				double rate = rate1 > rate2 ? rate1 : rate2;
				newWidth = (int) (((double) img.getWidth(null)) / rate);
				newHeight = (int) (((double) img.getHeight(null)) / rate);
			} else {
				newWidth = width; // 输出的图片宽度
				newHeight = heigth; // 输出的图片高度
			}
			BufferedImage tag = new BufferedImage((int) newWidth, (int) newHeight, BufferedImage.TYPE_INT_RGB);
			/*
			 * Image.SCALE_SMOOTH 的缩略算法 生成缩略图片的平滑度的 优先级比速度高 生成的图片质量比较好 但速度慢
			 */
			tag.getGraphics().drawImage(img.getScaledInstance(newWidth, newHeight,Image.SCALE_SMOOTH), 0, 0, null);
			return tag;
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	private static ByteArrayOutputStream getByteArrayOutputStream(BufferedImage bufferedImage){
		   ByteArrayOutputStream out = new ByteArrayOutputStream();
		   try {
			   ImageIO.write(bufferedImage, "jpg", out);
			   write2file(bufferedImage);
			   return out;
			} catch (IOException e) {
				e.printStackTrace();
				return null;
		   }
	   }
	
	/**
	 * 用于获取图片的高/宽
	 * @param path
	 * @return
	 */
	public static Image getImage(String path){
		Image image = null;
		if(path.matches(imgRegex)){
			try {
				image = ImageIO.read(new URL(path));
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			File file = new File(path);
			if(!file.exists()){
				return null;
			}
			try {
				image = ImageIO.read(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return image;
	}
    
	 public static BufferedImage getImge(String num) {
		java.util.List<String> fonts = new ArrayList<String>();
		GraphicsEnvironment.getLocalGraphicsEnvironment().preferLocaleFonts();
		String[] names = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames(Locale.CHINA);
		for (String s : names) {
			char c = s.charAt(0);
			if (Character.isLowerCase(c) || Character.isUpperCase(c)) {

			} else {
				fonts.add(s);
			}
		}
		int w = 100;
		int h = 30;
		BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		try {
			Graphics2D g = bi.createGraphics();
			char[] use = new char[4];
			int xper = w / (use.length + 2);
			g.fillRect(0, 0, w, h);
			for (int i = 0; i < 4; i++) {
				Point p = new Point(1 + (i * ((int) (Math.random() * 10) + (int) w / 5)), h - 5);
				int size = 0;
				int[] sizes = new int[5];
				for (int j = 0; j < sizes.length; j++) {
					sizes[j] = 25 + j;
				}
				size = sizes[(int) (Math.random() * sizes.length)];
				int face = 0;
				if (Math.random() * 10 > 5) {
					face = Font.BOLD;
				} else {
					face = Font.ITALIC;
				}
				use[i] = num.charAt(i);
				g.setPaint(new GradientPaint(p.x, p.y, new Color((int) (Math.random() * 256), 0,
						(int) (Math.random() * 256)), p.x, p.y - size, new Color((int) (Math.random() * 256), (int) (Math
						.random() * 256), (int) (Math.random() * 256))));
				g.setFont(new Font(fonts.get((int) (Math.random() * fonts.size())), face, size));
				int x = (i + 1) * xper;
				g.drawString("" + use[i], x, p.y);
			}
			g.setPaint(null);
			Random random = new Random();
			for(int i = 0; i < 30; i++)
			{
			int x0 = random.nextInt(w);
			int y0 = random.nextInt(h);
			int xl = random.nextInt(12);
			int yl = random.nextInt(12);
			g.drawLine(x0, y0, x0 + xl, y0 + yl);
			}

			g.dispose();
		} catch (Exception e) {
			e.printStackTrace();
		}
		bi.flush();
		return bi;

	}
	   
	   public static void main(String[] args) {
		List<String> picList = new ArrayList<String>();  
		picList.add(RandomUtil.randomImage());
		picList.add(RandomUtil.randomImage());
		picList.add(RandomUtil.randomImage());
		picList.add(RandomUtil.randomImage());
		picList.add(RandomUtil.randomImage());
		picList.add(RandomUtil.randomImage());
		picList.add(RandomUtil.randomImage());
		picList.add(RandomUtil.randomImage());
		picList.add(RandomUtil.randomImage());
		mergeImage(76, 76, 4, 3, picList);
	  }
	   
	   
	   
	   /**
	    * 把多个图片合并在一起
	    * 默认为9张图片
	    * @param width 生成图片的宽
	    * @param height 生成图片的高度
	    * @param px 两张图片之间的间距
	    * @param count 一行最多显示的数量
	    * @param path   
	    * @param pathList 
	    * @param result
	    */
	   public static ByteArrayOutputStream mergeImage(int width,int height,int px,int count,List<String> pathList){
		   //生成空白图片缓存区
		   BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		   //填充背景色为灰色
		   Graphics2D gd = bufferedImage.createGraphics();
		   gd.setColor(new Color(165, 165, 165));
		   gd.fillRect(0, 0, width, height);
		   gd.dispose();
		   
		   if(null==pathList||pathList.size()<=0){
			   return null;
		   }
		   
		   /**
		    * 原图只有一张
		    */
		   if(pathList.size()==1){
			   Image image = getImage(pathList.get(0));
			   bufferedImage.getGraphics().drawImage(image,0,0,null);			   
			   return getByteArrayOutputStream(bufferedImage);
		   }
		   
		   /**
		    * 原图只有2张
		    */
		   if(pathList.size()==2){
			   width = (width-3*px)/2;
			   int h = height;
			   height = (height-2*px)/2;
			   int w = width<height?width:height;
			   for(int i=0;i<pathList.size();i++){
				   Image image = compressPic(pathList.get(i),w,w,true) ;
				   bufferedImage.getGraphics().drawImage(image,i*width+(i+1)*px,(h-height)/2,null);
			   }
			   return getByteArrayOutputStream(bufferedImage);
		   }
		   
		   /**
		    * 原图只有3张
		    */
		   if(pathList.size()==3){
			   int w = (width-3*px)/2;
			   int h = (height-3*px)/2;
			   int pic = w<h?w:h;
			   for(int i=0;i<pathList.size();i++){
				   Image image = compressPic(pathList.get(i), pic,pic, true) ;
				   if(i==0){
					   bufferedImage.getGraphics().drawImage(image,(width-w)/2,(i+1)*px,null);   
				   }
				   if(i==1){
					   bufferedImage.getGraphics().drawImage(image,i*px+(i-1)*w,2*px+h,null);
				   }
				   if(i==2){
					   bufferedImage.getGraphics().drawImage(image,i*px+(i-1)*w,2*px+h,null);
				   }
			   }
			   return getByteArrayOutputStream(bufferedImage);
		   }
		   
		   /**
		    * 原图只有4张
		    */
		   if(pathList.size()==4){
			   int w = (width-3*px)/2;
			   int h = (height-3*px)/2;
			   int pic = w<h?w:h;
			   for(int i=0;i<pathList.size();i++){
				   Image image = compressPic(pathList.get(i), pic,pic, true) ;
				   if(i==0){
					   bufferedImage.getGraphics().drawImage(image,(i+1)*px+i*w,(i+1)*px,null);   
				   }
				   if(i==1){
					   bufferedImage.getGraphics().drawImage(image,(i+1)*px+i*w,i*px,null);
				   }
				   if(i==2){
					   bufferedImage.getGraphics().drawImage(image,(i-1)*px+(i-2)*w,2*px+h,null);
				   }
				   if(i==3){
					   bufferedImage.getGraphics().drawImage(image,(i-1)*px+(i-2)*w,2*px+h,null);
				   }
			   }
			   return getByteArrayOutputStream(bufferedImage);
		   }
		   
		   if(pathList.size()==5){
			   int w = (width-4*px)/3;
			   int h = (height-3*px)/2;
			   int pic = w<h?w:h;
			   int blank = (height - 2*pic+px)/2;
			   for(int i=0;i<pathList.size();i++){
				   Image image = compressPic(pathList.get(i), pic,pic,true) ;
				   if(i==0){
					   bufferedImage.getGraphics().drawImage(image,(width-w)/3,blank,null);   
				   }
				   if(i==1){
					   bufferedImage.getGraphics().drawImage(image,(width-w)/3+w+px,blank,null);
				   }
				   if(i>=2){
					   bufferedImage.getGraphics().drawImage(image,(i-1)*px+(i-2)*w,blank+px+pic,null);
				   }
			   }
			   return getByteArrayOutputStream(bufferedImage);
		   }
		   
		   /**
		    * 原图只有6张
		    */
		   if(pathList.size()==6){
			   int w = (width-4*px)/3;
			   int h = (height-3*px)/2;
			   int pic = w<h?w:h;
			   int blank = (height - 2*pic+px)/2;
			   for(int i=0;i<pathList.size();i++){
				   Image image = compressPic(pathList.get(i), pic,pic,true) ;
				   if(i<3){
					   bufferedImage.getGraphics().drawImage(image,i*w+(i+1)*px,blank,null);
				   }else {
					   bufferedImage.getGraphics().drawImage(image,(i-2)*px+(i-3)*w,px+pic+blank,null);
				   }
			   }
			   return getByteArrayOutputStream(bufferedImage);
		   }
		   /**
		    * 原图只有7张
		    */
		   if(pathList.size()==7){
			   int w = (width-4*px)/3;
			   int h = (height-4*px)/3;
			   int pic = w<h?w:h;
			   for(int i=0;i<pathList.size();i++){
				   Image image = compressPic(pathList.get(i), pic,pic, true) ;
				   if(i==0){
					   bufferedImage.getGraphics().drawImage(image,(width-w)/2,px,null);   
				   }
				   if(i==1){
					   bufferedImage.getGraphics().drawImage(image,i*px+(i-1)*w,2*px+h,null);
				   }
				   if(i==2){
					   bufferedImage.getGraphics().drawImage(image,i*px+(i-1)*w,2*px+h,null);
				   }
				   if(i==3){
					   bufferedImage.getGraphics().drawImage(image,i*px+(i-1)*w,2*px+h,null);
				   }
				   if(i==4){
					   bufferedImage.getGraphics().drawImage(image,(i-3)*px+(i-4)*w,3*px+2*h,null);
				   }
				   if(i==5){
					   bufferedImage.getGraphics().drawImage(image,(i-3)*px+(i-4)*w,3*px+2*h,null);
				   }
				   if(i==6){
					   bufferedImage.getGraphics().drawImage(image,(i-3)*px+(i-4)*w,3*px+2*h,null);
				   }
			   }
			   return getByteArrayOutputStream(bufferedImage);
		   }
		   
		   /**
		    * 原图只有8张
		    */
		   if(pathList.size()==8){
			   int w = (width-4*px)/3;
			   int h = (height-4*px)/3;
			   int pic = w<h?w:h;
			   for(int i=0;i<pathList.size();i++){
				   Image image = compressPic(pathList.get(i), pic,pic,true) ;
				   if(i==0){
					   bufferedImage.getGraphics().drawImage(image,i*px+(width-2*w)/2,px,null);   
				   }
				   if(i==1){
					   bufferedImage.getGraphics().drawImage(image,i*px+(width-2*w)/2+w,px,null);
				   }
				   if(i==2){
					   bufferedImage.getGraphics().drawImage(image,(i-1)*px+(i-2)*w,2*px+h,null);
				   }
				   if(i==3){
					   bufferedImage.getGraphics().drawImage(image,(i-1)*px+(i-2)*w,2*px+h,null);
				   }
				   if(i==4){
					   bufferedImage.getGraphics().drawImage(image,(i-1)*px+(i-2)*w,2*px+h,null);
				   }
				   if(i==5){
					   bufferedImage.getGraphics().drawImage(image,(i-4)*px+(i-5)*w,3*px+2*h,null);
				   }
				   if(i==6){
					   bufferedImage.getGraphics().drawImage(image,(i-4)*px+(i-5)*w,3*px+2*h,null);
				   }
				   if(i==7){
					   bufferedImage.getGraphics().drawImage(image,(i-4)*px+(i-5)*w,3*px+2*h,null);
				   }
			   }
			   return getByteArrayOutputStream(bufferedImage);
		   }
		   
		   /**
		    * 原图只有9张
		    */
		   if(pathList.size()>=9){			   
			   int w = (width-4*px)/3;
			   int h = (height-4*px)/3;
			   int pic = w<h?w:h;
			   for(int i=0;i<pathList.size();i++){
				   Image image = compressPic(pathList.get(i), pic,pic, true) ;
				   if(i==0){
					   bufferedImage.getGraphics().drawImage(image,(i+1)*px+i*w,px,null);   
				   }
				   if(i==1){
					   bufferedImage.getGraphics().drawImage(image,(i+1)*px+i*w,px,null);
				   }
				   if(i==2){
					   bufferedImage.getGraphics().drawImage(image,(i+1)*px+i*w,px,null);
				   }
				   if(i==3){
					   bufferedImage.getGraphics().drawImage(image,(i-2)*px+(i-3)*w,2*px+h,null);
				   }
				   if(i==4){
					   bufferedImage.getGraphics().drawImage(image,(i-2)*px+(i-3)*w,2*px+h,null);
				   }
				   if(i==5){
					   bufferedImage.getGraphics().drawImage(image,(i-2)*px+(i-3)*w,2*px+h,null);
				   }
				   if(i==6){
					   bufferedImage.getGraphics().drawImage(image,(i-5)*px+(i-6)*w,3*px+2*h,null);
				   }
				   if(i==7){
					   bufferedImage.getGraphics().drawImage(image,(i-5)*px+(i-6)*w,3*px+2*h,null);
				   }
				   if(i==8){
					   bufferedImage.getGraphics().drawImage(image,(i-5)*px+(i-6)*w,3*px+2*h,null);
				   }
			   }
			   return getByteArrayOutputStream(bufferedImage);
		   }
		   return null;
	   }
	   
	   /**
	    * 把多个图片合并在一起
	    * 默认为9张图片
	    * @param width 生成图片的宽
	    * @param height 生成图片的高度
	    * @param px 原来图片的宽度 30*30的图片
	    * @param count 一行最多显示的数量
	    * @param path   
	    * @param pathList 
	    * @param result
	    */
	   public static ByteArrayOutputStream mergeImage2(int width,int height,int px,int count,List<String> pathList){
		   //生成空白图片缓存区
		   BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		   //填充背景色为白色
		   bufferedImage.getGraphics().setColor(new Color(0));  
		   bufferedImage.getGraphics().fillRect(1, 1, width-1, height-1);
		   if(null==pathList||pathList.size()<=0){
			   return null;
		   }
		   //计算给出的图片,能绘制几行
		   int line = 0;
		   if(pathList.size()/count%2==0){
			   line = pathList.size()/count+1;
		   }else {
			   line = pathList.size()/count;
		   }
		   //计算图片之间的预留空白
		   int x = 0;
		   int y = 0;
		   if(line>1){
			   x = (width - count*px)/count;   
		   }else {
			   x = (width - pathList.size()*px)/pathList.size();
		   }
		   y = (height-line*px)/(line+1);
		   for(int i=0,size=pathList.size();i<size;i++){
			   Image image = compressPic(pathList.get(i), px, px, true) ;
			   if(null==image){
				   continue;
			   }
			   //显示效果好的调用方式
			   //bufferedImage.getGraphics().drawImage(image.getScaledInstance(image.getWidth(null), image.getHeight(null), Image.SCALE_SMOOTH), (i+1)*x, (i+1)*y, null);
			   bufferedImage.getGraphics().drawImage(image,(i%3+1)*x+i%3*30,(i/count+1)*y+(i/count)*image.getHeight(null),null);   	
		   }
		   ByteArrayOutputStream out = new ByteArrayOutputStream();
		   try {
			   ImageIO.write(bufferedImage, "jpg", out);
			   return out;
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
	   }
	   
	  /**
	    * 把图片保存到文件系统中
	    * @param image
	    */
	   private static void write2file(BufferedImage image){
			try {
				ImageIO.write(image, "jpg", new File("e:\\img\\"+RandomUtil.getRandomPassword()+".jpg"));
			} catch (IOException e) {
				e.printStackTrace();
			}
	   }
	  
	  
	   
}
