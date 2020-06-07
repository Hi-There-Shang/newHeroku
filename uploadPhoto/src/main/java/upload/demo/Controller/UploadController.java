package upload.demo.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

@RestController
public class UploadController {

    private static String file_path = "/Users/shangchengcheng/Desktop/photo";


    @RequestMapping(path = "upload" , method = {RequestMethod.POST})
    public void uploadPhoto(@RequestParam(value = "photos", required = false) MultipartFile file, HttpServletRequest request) throws IOException {
//        String path = null;
        double size = file.getSize();

        File file1 = new File(file_path);

        System.out.println(file1);

        byte[] bytes = file.getBytes();

        if (file != null) {
            String type = null;
            String originalFilename = file.getOriginalFilename();

//            int index = originalFilename.lastIndexOf(".");
            String fileName = "1234";//(index != -1) ? originalFilename.substring(index + 1, originalFilename.length()) : null;



                // 项目在容器中实际发布运行的根路径
//                String realPath = request.getSession().getServletContext().getRealPath("/");
                // 自定义的文件名称
//                String trueFileName = System.currentTimeMillis() + "." + type;
                // 设置存放图片文件的路径

                String path = file_path+fileName + ".jpg";
                System.out.println("存放图片文件的路径:" + path);

                // 转存文件到指定的路径
                file.transferTo(new File(path));
                System.out.println("文件成功上传到指定目录下");

            }


    }

}
