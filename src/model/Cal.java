package model;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.PrintWriter;
import java.io.IOException;
import data.User;

public class Cal extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        String b = request.getParameter("birthday");
        String reg = "\\d{4}/\\d{1,2}/\\d{1,2}";
        boolean checkF = b.matches(reg);
        String url;
        User user = new User();

        if(checkF){

            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            try {
                //parse String(mom birthday)to Date object
                Date birthday = dateFormat.parse(b);
                //create Date Object of today
                Date today = new Date();
                //calculate days between today and birthday
                long day = (today.getTime()-birthday.getTime())/(24*60*60*1000);
                user.setDay(day);
                request.setAttribute("user", user);
                url = "/answer.jsp";
                getServletContext().getRequestDispatcher(url).forward(request, response);

            }catch(ParseException e){
                e.printStackTrace();
            }
            //new一個當前日期物件
            //算出相隔日期
        }else {
            String error = "格式錯誤,";
            request.setAttribute("error","error");
        }




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
