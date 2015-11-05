<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.* ,Javabean.Goods,Javabean.User " %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
 div{
	      float:left;
	      margin: 10px;
	   }
	   div dd{
	      margin:0px;
	      font-size:10pt;
	   }
	   div dd.dd_name
	   {
	      color:blue;
	   }
	   div dd.dd_city
	   {
	      color:#000;
	   }
</style>
</head>
<body>
	<table width="750" height="60" cellpadding="0" cellspacing="0" border="0">
      <tr>
        <td>
          
          <!-- 商品循环开始 -->
           <% 
               
           	   List<Goods> list = new ArrayList<Goods>();
               list = (List<Goods>)request.getAttribute("user");
               System.out.println(list);
               if(list!=null&&list.size()>0)
               {
	               for(int i=0;i<list.size();i++)
	               {
	                  Goods goods = list.get(i);
           %>   
          <div>
             <dl>
               <dt>
                 <img src="../Images/<%=goods.getUrl()%>" width="120" height="90" border="1"/>
               </dt>
               <dd class="dd_name"><%=goods.getName() %></dd> 
               <dd class="dd_address"><%=goods.getAddress() %>&nbsp;&nbsp;价格:￥ <%=goods.getPrice() %></dd> 
             </dl>
          </div>
          <!-- 商品循环结束 -->
        
          <%
                   }
              } 
          %>
        </td>
      </tr>
    </table>
</body>
</html>