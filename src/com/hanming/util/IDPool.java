package com.hanming.util;

import java.util.Date;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;


public class IDPool 
{
	private static int SECOND=5*60;
	public static int  MAX=0;
    private static List<Node> xhs=new LinkedList<Node>(); 
    public static Hashtable sessionMaps=new Hashtable();
    
    
    
    synchronized
    public static boolean add2Pool(String xh)
    {

    	Node node=new Node(xh);
    	xhs.add(node);
    	return true;
    }
    
  
    
    synchronized
    public static String get()
    {   
    	if(MAX==0) return "";	
        for(int i=0;i<xhs.size();i++)
        {
        	Node t=xhs.get(i);
            if(t.isExpire(SECOND)) continue;
            t.data=new Date().getTime();
            System.out.println("get xh from pool");
            return t.xh;
        }
        
        MAX=MAX+1;
        String xh= xh2String(MAX);
        add2Pool(xh);
    	return xh;
    }
    
    synchronized
    public static boolean remove(String xh)
    {
        for(int i=0;i<xhs.size();i++)
        {
        	Node t=xhs.get(i);
        	if(t.xh.equals(xh))
        	{
        		xhs.remove(i);
        		System.out.println("remove xh from pool");
        		return true;
        	}
         
        }
      
    	return false;
    }
    
    synchronized
  public static int xh2Int(String id)
  {
	       id=id.substring(2);
	      int num=Integer.parseInt(id);
	      return num;
  }
    
    synchronized
   public static String xh2String(int num)
   {
	      String id=Integer.toString(num);
	       if(id.length()==1)  return "H0000"+id;
	       if(id.length()==2)  return "H000"+id;
	       if(id.length()==3)  return "H00"+id;
	       if(id.length()==4)  return "H0"+id;
	        return "H"+id;
	
   }
    
    
}

class Node
{
	String xh;
	Long  data;
	
	Node(String xh)
	{
	   this.xh=xh;
	   this.data=new Date().getTime();

	}
	
	public  boolean isExpire(int m)
	{
		Date date=new Date();
		return date.getTime()-this.data<=m*1000;
		
	}
}
