package com.zjer.aspect;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author shijun
 * @date 2018/8/15 12:40
 * @param
 * @return
*/
@Component
@Aspect
public class ExceptionBean {
    @AfterThrowing(throwing = "e", pointcut = "within(com.zjer.service..*)")
    public void execute(Exception e) {
        //将异常信息输入文件
        try {
            FileWriter fileWriter = new FileWriter("C:\\Users\\pactera\\errorLog\\error.log", true);
            //向文件中写入数据
            PrintWriter printWriter = new PrintWriter(fileWriter);
            //文件头：时间信息、异常类型等
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-DD HH:mm:ss");
            String timeStr = simpleDateFormat.format(date);
            //构建文件头
            printWriter.println("*********************");
            printWriter.print("异常类型：" + e);
            printWriter.println("异常时间：" + timeStr);
            printWriter.println("*******异常详细信息********");
            e.printStackTrace(printWriter);
            printWriter.close();
            fileWriter.close();
        } catch (IOException e1) {
            e1.printStackTrace();
            System.out.println("记录异常失败...");
        }
    }
}
