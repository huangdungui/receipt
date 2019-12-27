package com.zhichenkeji.utils;

import com.zhichenkeji.domain.Receipt;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

/**
 * @program: invoice
 * @description: word
 * @author: huangdungui
 * @create: 2019-12-25 13:43
 **/
public class PoiToWord {
    public void poiToWord(Receipt receipt, HttpServletRequest request, HttpServletResponse response) {
        // Blank Document
        XWPFDocument document = new XWPFDocument();
        // Write the Document in file system
        //FileOutputStream out = new FileOutputStream(new File("E:/xls/sys_" + System.currentTimeMillis() + ".docx"));

        // 添加标题
        XWPFParagraph titleParagraph = document.createParagraph();
        // 设置段落居中
        titleParagraph.setAlignment(ParagraphAlignment.CENTER);

        XWPFRun titleParagraphRun = titleParagraph.createRun();
        titleParagraphRun.setFontFamily("华文楷体");
        titleParagraphRun.setText("收据");
        titleParagraphRun.setColor("000000");
        titleParagraphRun.setFontSize(22);

        // 段落
        XWPFParagraph firstParagraph = document.createParagraph();
        XWPFRun run = firstParagraph.createRun();
        run.setFontFamily("华文楷体");
        run.setText("          今收到财务部 " + receipt.getTime() + " 现金工资（" + receipt.getMoney() + "）元，人民币大写（" + receipt.getBigMoney() + "）。");
        run.setColor("000000");
        run.setFontSize(12);

        // 签名
        XWPFParagraph firstParagraph1 = document.createParagraph();
        firstParagraph1.setAlignment(ParagraphAlignment.RIGHT);
        XWPFRun run1 = firstParagraph1.createRun();
        run1.setFontFamily("华文楷体");
        run1.setText("签字：");
        run1.setColor("000000");
        run1.setFontSize(12);
        // 时间
        XWPFParagraph firstParagraph2 = document.createParagraph();
        firstParagraph2.setAlignment(ParagraphAlignment.RIGHT);
        XWPFRun run2 = firstParagraph2.createRun();
        run2.setFontFamily("华文楷体");
        run2.setText("日期：");
        run2.setColor("000000");
        run2.setFontSize(12);


        OutputStream output;
        try {
            String fileName = receipt.getName() + "-" + receipt.getTime() + " 收据.docx";
            fileName = URLEncoder.encode(fileName, "UTF-8");
/*
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            document.write(os);
            byte[] content = os.toByteArray();
            InputStream is = new ByteArrayInputStream(content);
            // 设置response参数，可以打开下载页面
            response.reset();
            //设置编码格式
            response.setContentType("application/vnd.ms-excel;charset=utf-8");
            response.setHeader("Content-Disposition", "attachment;filename="
                    + new String((fileName + ".dock").getBytes(), "iso-8859-1"));
            ServletOutputStream out1 = response.getOutputStream();
            BufferedInputStream bis = null;
            BufferedOutputStream bos = null;

            try {
                bis = new BufferedInputStream(is);
                bos = new BufferedOutputStream(out1);
                byte[] buff = new byte[2048];
                int bytesRead;
                // Simple read/write loop.
                while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
                    bos.write(buff, 0, bytesRead);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (bis != null)
                    bis.close();
                if (bos != null)
                    bos.close();
            }*/

            //request.getRequestDispatcher(url).forward(request,response);

//            request.setCharacterEncoding("UTF-8");
//            response.setCharacterEncoding("UTF-8");
            //response.setContentType("application/x-download");

            //设置HTTP响应头
            response.reset();//重置 响应头
            response.setContentType("application/x-download");//告知浏览器下载文件，而不是直接打开，浏览器默认为打开
            response.addHeader("Content-Disposition", "attachment;filename=" + fileName);//下载文件的名称

            /*response.setHeader("Content-Disposition", "attachment; filename=\"" + new String(fileName.getBytes("GBK"), "ISO-8859-1"));
            response.setContentType("bin;charset=GBK");
            response.addHeader("Content-Disposition", "attachment;filename=" + fileName);
*/

            output = response.getOutputStream();
            BufferedOutputStream bufferedOutPut = new BufferedOutputStream(output);
            bufferedOutPut.flush();
            document.write(bufferedOutPut);
            bufferedOutPut.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("create_table document written success.");

/*


        String url = "需要下载的文件路径";
        File fileurl = new File(url);
        //浏览器下载后的文件名称showValue,从url中截取到源文件名称以及，以及文件类型，如board.docx;
        String showValue = board.docx;
        System.out.println(showValue);
        try{
            //根据条件得到文件路径
            System.out.println("===========文件路径==========="+fileurl);
            //将文件读入文件流
            InputStream inStream = new FileInputStream(fileurl);
            //获得浏览器代理信息
            final String userAgent = request.getHeader("USER-AGENT");
            //判断浏览器代理并分别设置响应给浏览器的编码格式
            String finalFileName = null;
            if(StringUtils.contains(userAgent, "MSIE")||StringUtils.contains(userAgent,"Trident")){//IE浏览器
                finalFileName = URLEncoder.encode(showValue,"UTF8");
                System.out.println("IE浏览器");
            }else if(StringUtils.contains(userAgent, "Mozilla")){//google,火狐浏览器
                finalFileName = new String(showValue.getBytes(), "ISO8859-1");
            }else{
                finalFileName = URLEncoder.encode(showValue,"UTF8");//其他浏览器
            }
            //设置HTTP响应头
            response.reset();//重置 响应头
            response.setContentType("application/x-download");//告知浏览器下载文件，而不是直接打开，浏览器默认为打开
            response.addHeader("Content-Disposition" ,"attachment;filename=\"" +finalFileName+ "\"");//下载文件的名称

            // 循环取出流中的数据
            byte[] b = new byte[1024];
            int len;
            while ((len = inStream.read(b)) > 0){
                response.getOutputStream().write(b, 0, len);
            }
            inStream.close();
            response.getOutputStream().close();
        }catch(Exception e) {
            e.printStackTrace();
        }*/

    }
}
