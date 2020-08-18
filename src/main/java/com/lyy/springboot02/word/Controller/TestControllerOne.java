package com.lyy.springboot02.word.Controller;

import com.lyy.springboot02.word.pojo.City;
import com.lyy.springboot02.word.pojo.Country;
import com.lyy.springboot02.word.service.CityService;
import com.lyy.springboot02.word.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @program: spring-boot-02
 * @description
 * @author: lyy
 * @create: 2020-08-16 16:28
 **/
@Controller
@RequestMapping("/test")
public class TestControllerOne {
    @Autowired
    private CityService cityService;
    @Autowired
    private CountryService countryService;
    @RequestMapping("/index2")
    public String index(ModelMap map){

        map.addAttribute("template","test/index2");
        return "index";
    }
    @RequestMapping("/index")
    public String index2(ModelMap map){
        int countryId = 522;
        List<City> cities = cityService.selectCity(countryId);
        cities = cities.stream().limit(10).collect(Collectors.toList());
        List<Country> country = countryService.selectByCountyId(countryId);

        map.addAttribute("thymeleafTitle", "scdscsadcsacd");
        map.addAttribute("checked", true);
        map.addAttribute("currentNumber", 99);
        map.addAttribute("changeType", "checkbox");
        map.addAttribute("baiduUrl", "/test/log");
        map.addAttribute("city", cities.get(0));
//        map.addAttribute("shopLogo",
//                "http://cdn.duitang.com/uploads/item/201308/13/20130813115619_EJCWm.thumb.700_0.jpeg");
        map.addAttribute("shopLogo",
                "/img/111.png");
        map.addAttribute("country", country);
        map.addAttribute("cities", cities);
        map.addAttribute("updateCityUri", "/api/city");
//        map.addAttribute("template","test/index");
        return "index";
    }

    @GetMapping("/file")
    public ResponseEntity<Resource> downloadFile(@RequestParam String fileName) {
        Resource resource = null;
        try {
            resource = new UrlResource(
                    Paths.get("D:\\1\\upload\\" + fileName).toUri());
            if (resource.exists() && resource.isReadable()) {
                return ResponseEntity
                        .ok()
                        .header(HttpHeaders.CONTENT_TYPE, "application/octet-stream")
                        .header(HttpHeaders.CONTENT_DISPOSITION,
                                String.format("attachment; filename=\"%s\"", resource.getFilename()))
                        .body(resource);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
//
        return null;
    }

    @PostMapping(value = "/files",consumes = "multipart/form-data")
    public String uploadFiles(@RequestParam MultipartFile[] files, RedirectAttributes redirectAttributes) {
        if (files == null) {
            redirectAttributes.addFlashAttribute(
                    "message", "Please select file.");
            try {
                for (MultipartFile file : files) {
                    if (file.isEmpty()) {
                        continue;
                    }
                    String destFilePath = "D:\\1\\upload\\" + file.getOriginalFilename();
                    File destFile = new File(destFilePath);
                    file.transferTo(destFile);
                    redirectAttributes.addFlashAttribute("message", "Upload file success.");
                }
            } catch (IOException e) {
                e.printStackTrace();
                redirectAttributes.addFlashAttribute(
                        "message", "Upload file failed.");
            }
        }
        return "redirect:/test/index";

    }
    @PostMapping(value = "/file", consumes = "multipart/form-data")
    public String uploadFile(@RequestParam MultipartFile file, RedirectAttributes redirectAttributes) {
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select file.");

            return "redirect:test/index";
        }

        try {
            String destFilePath = "D:\\1\\upload\\" + file.getOriginalFilename();
            File destFile = new File(destFilePath);
            file.transferTo(destFile);
            // 使用工具类Files来上传文件
            redirectAttributes.addFlashAttribute("message", "Upload file success.");
        } catch (IOException e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("message", "Upload file failed.");
        }

        return "redirect:/test/index";
    }

}
