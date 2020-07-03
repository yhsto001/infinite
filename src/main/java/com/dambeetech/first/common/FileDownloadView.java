package com.dambeetech.first.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

@Component("downFile")
public class FileDownloadView extends AbstractView {
   
   @Override
   protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
         HttpServletResponse response) throws Exception {
      //   컨트롤러에서 뷰 리졸버로 리턴한 model 정보가 자동 전달됨
      //   System.out.println("file : " + ((File)model.get("fileDown")).getName());
      // 실행결과 file : bsjzzang3_20200330180101.txt
      File downFile = (File)model.get("fileDown");
      
      //한글 파일명 인코딩 처리 위해 파일명 추출
      //String fileName = downFile.getName(); 이건 바꾼 파일명
      String fileName = (String)model.get("originalFileName");
      
      response.setContentType("text/plain; charset=utf-8");
      //filename 안정해주면 뷰 네임으로 파일 전송됨
      response.addHeader("Content-Disposition", "attatchment; filename=\"" + new String(fileName.getBytes("utf-8"), "ISO-8859-1") + "\"");
      response.setContentLength((int)downFile.length());
      
      OutputStream out = response.getOutputStream();
      FileInputStream fin = null;
      
      fin = new FileInputStream(downFile);
      FileCopyUtils.copy(fin, out);
      
      if(fin != null) {
         fin.close();
      }
      out.flush();
      out.close();
      
   }

}
