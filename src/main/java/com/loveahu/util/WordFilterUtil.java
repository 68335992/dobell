package com.loveahu.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import cn.com.tx.galaxy.util.StringUtil;

public class WordFilterUtil {
	
	private static final String CONFIG_FILE_PATH = "../word.filter";
//	private static final String CONFIG_FILE_PATH = "/Users/bowensun/dev/work/tmp/word.filter";
	
	static Map<Character, WordFilterDo> root = new HashMap<Character, WordFilterDo>();
	
	private static final char REPLACE_CHAR =  '㊙';
	
	static class WordFilterDo{
		
		public Character key;
		
		public boolean end;
		
		Map<Character, WordFilterDo> childs = new HashMap<Character, WordFilterDo>();
		
		public WordFilterDo(Character key,boolean end){
			this.key = key;
			this.end = end;
		}
		
		public WordFilterDo getChild(Character ch){
			if (null==ch) {
				return null;
			}
			return childs.get(ch);
		}
		
		public void addChild(WordFilterDo wf){
			if (null==wf||null==wf.key) {
				return;
			}
			childs.put(wf.key, wf);
		}
	}
	
	public static void init(){ 
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		BufferedReader reader = null;
		try {
			System.out.println("wordfilter:start to reflect from file:"+loader.getResource(CONFIG_FILE_PATH));
			reader = new BufferedReader(new FileReader(loader.getResource(CONFIG_FILE_PATH).getFile()));
			String line = null;
			Map<Character, WordFilterDo> newRoot = new HashMap<Character, WordFilterUtil.WordFilterDo>();
			while(reader.ready()&&(line=reader.readLine())!=null){
				WordFilterDo father = null;
				for(int i=0,length=line.length();i<length;i++){
					Character ch = line.charAt(i);
					boolean end = i==(length-1);
					if (father==null) {
						//根节点处理
						father = newRoot.get(ch);
						if (null==father) {
							father = new WordFilterDo(ch, end);
							newRoot.put(ch, father);
						}else if (end) {
							father.end = end;
						}
					}else{
						//非根节点处理
						WordFilterDo me = father.getChild(ch);
						if (null==me) {
							me = new WordFilterDo(ch, end);
							father.addChild(me);
						}else if(end){
							me.end = end;
						}
						father = me;
					}
				}
			}
			if (newRoot.size()>0) {
				root = newRoot;
			}
		}catch(Throwable e){
			e.printStackTrace();
		}finally{
			if (null!=reader) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
//	static int count = 0;
	
	public static String filter(String origin){
		try {
			if (StringUtil.isBlank(origin)) {
				return origin;
			}
			if (null==root||root.size()==0) {
				init();
			}
			if (null==root||root.size()==0) {
				return origin;
			}
			StringBuilder sb = new StringBuilder();
			for(int i=0,length=origin.length();i<length;){
//				count++;
				Character ch = origin.charAt(i);
				FilterFlow ff = flow(origin, i, null, new FilterFlow(false, i, i));
				if (ff.needFilter) {
//					int ads = 0;
//					while(ads++<=(ff.end-ff.start)){
						sb.append(REPLACE_CHAR);
//					}
					i+=ff.end-ff.start+1;
				}else{
					sb.append(ch);
					i++;
				}
			}
			return sb.toString();
		} catch (Throwable e) {
			e.printStackTrace();
			return origin;
		}
	}
	
	static FilterFlow flow(String origin,int start,WordFilterDo wf,FilterFlow filterFlow){
//		count++;
		if (StringUtil.isBlank(origin)||start>=origin.length()) {
			return filterFlow;
		}
		
		Character ch = origin.charAt(start);
		if (wf==null) {
			wf = root.get(ch);
			if (null==wf) {
				return filterFlow;
			}else{
				filterFlow.needFilter = wf.end;
				return flow(origin, ++start, wf,filterFlow);
			}
		}else{
			wf = wf.getChild(ch);
			if (null==wf) {
				//中止
				return filterFlow;
			}else{
				//继续向下搜索
				if (wf.end) {
					filterFlow.end = start;
					filterFlow.needFilter = true;
				}
				return flow(origin, ++start, wf, filterFlow);
			}
		}
	}
	
	static class FilterFlow{
		
		public boolean needFilter;
		
		public int start;
		
		public int end;
		
		public FilterFlow(){}
		
		public FilterFlow(boolean needFilter,int start,int end){
			this.needFilter = needFilter;
			this.start = start;
			this.end = end;
		}
	}
	
	public static boolean hasBlockWord(String origin){
		if (StringUtil.isBlank(origin)) {
			return false;
		}
		try {
			if (null==root||root.size()==0) {
				init();
			}
			if (null==root||root.size()==0) {
				return false;
			}
			for(int i=0,length=origin.length();i<length;){
				FilterFlow ff = flow(origin, i, null, new FilterFlow(false, i, i));
				if (ff.needFilter) {
					return true;
				}else{
					i++;
				}
			}
			return false;
		} catch (Throwable e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static void main(String[] args){
		String origin = "C炸药hoxtiliq制作教程";
		System.out.println("orgin:"+origin);
		System.out.println("after:"+filter(origin));
//		System.out.println(count);
	}
}
