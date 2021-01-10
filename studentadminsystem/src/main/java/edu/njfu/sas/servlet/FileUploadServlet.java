package edu.njfu.sas.servlet;

import edu.njfu.sas.util.FileUtil;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

@WebServlet("/fileUploadServlet")
public class FileUploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        //1. 设置response编码
        response.setContentType("text/html;charset=utf-8");
        //response.setCharacterEncoding("UTF-8");
        //2. 创建DiskFileItemFactory对象
        DiskFileItemFactory factory = new DiskFileItemFactory();
        //3. 设置临时目录
        File file = new File("/Users/lqj/temp/");//D:\\TempFolder
        //4. 判断文件是否存在,如果文件不存在,则创建
        if(!file.exists()){
            file.mkdirs();
        }
        //5.把file加入到facotry中
        factory.setRepository(file);
        //6.从临时文件夹中读取数据 ,创建ServletFileUpload
        //使用servletFileUpload来连接临时文件夹
        ServletFileUpload fileUpload = new ServletFileUpload(factory);
        try {
            List<FileItem> fileItems = fileUpload.parseRequest(request);
            //7.遍历
            for(FileItem item:fileItems){
                //8.判断
                if(item.isFormField()){
                    //9.formfield
                    System.out.println("上传者:"+":"+
                            new String(item.getString().getBytes("ISO-8859-1"),"UTF-8"));
                }else{
                    //10.是上传的文件,只上传一个文件
                    //10.1获取上传文件的文件名
                    String fileName = item.getName();
                    System.out.println(fileName);
                    if(fileName!=null && !fileName.equals("")){
                         //10.2修改上传文件的文件名,文件名要唯一
                        fileName= FileUtil.getRandomFileName(fileName);
                        //10.3把文件保存到指定位置,正常位置为:./uploads,也可以指定其他位置
                        //"/Users/lqj/uploads",E:\\uploads"
                        String path="/Users/lqj/uploads/" ;
                        //10.4 创建文件
                        File file2 = new File(path+fileName);
                        //10.5 获取输入流
                        InputStream inputStream = item.getInputStream();
                        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
                        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(file2));
                        byte[] buffer=new byte[1024];
                        int len;
                        //把输入流中的数据,写入到文件中
                        while((len=bufferedInputStream.read(buffer))>0){
                            out.write(buffer,0,len);
                        }
                        //关闭流
                        bufferedInputStream.close();
                        out.close();
                        //删除临时文件
                        item.delete();
                        //提示信息文件保存成功!
                        response.getWriter().write("文件保存成功!");
                    }
                }
            }
            /**
             * FileItem有两种,一种是文件,一种是formfield
             */
        } catch (FileUploadException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("请使用Post方式上传文件");
    }
}
