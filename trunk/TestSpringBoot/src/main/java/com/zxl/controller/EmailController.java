package com.zxl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.zxl.service.IMailService;

@Controller
@RequestMapping("/email")
public class EmailController {
	
	@Autowired
	private IMailService mailService;
	
	@Autowired
    private TemplateEngine templateEngine;
	
	@RequestMapping("/")
	public String index() {
		return "email/index";
	}
	
	@RequestMapping("/simpleMail")
	public String testSimpleMail() throws Exception {
        mailService.sendSimpleMail("za59418@163.com","test simple mail"," hello this is simple mail");
        return "email/sendOk";
    }

	@RequestMapping("/htmlMail")
    public String testHtmlMail() throws Exception {
        String content="<html>\n" +
                "<body>\n" +
                "    <h3>hello world ! 这是一封html邮件!</h3>\n" +
                "</body>\n" +
                "</html>";
        mailService.sendHtmlMail("za59418@163.com","test simple mail",content);
        return "email/sendOk";
    }

	@RequestMapping("/attachmentsMail")
    public String sendAttachmentsMail() {
        String filePath="e:\\tmp\\application.log";
        mailService.sendAttachmentsMail("za59418@163.com", "主题：带附件的邮件", "有附件，请查收！", filePath);
        return "sendOk";
    }
	
	@RequestMapping("/inlineMail")
	public String sendInlineResourceMail() {
        String rscId = "neo006";
        String content="<html><body>这是有图片的邮件：<img src=\'cid:" + rscId + "\' ></body></html>";
        String imgPath = "e:\\tmp\\favicon.png";

        mailService.sendInlineResourceMail("za59418@163.com", "主题：这是有图片的邮件", content, imgPath, rscId);
        return "email/sendOk";
    }


	@RequestMapping("/templateMail")
    public String sendTemplateMail() {
        //创建邮件正文
        Context context = new Context();
        context.setVariable("id", "006");
        String emailContent = templateEngine.process("email/emailTemplate", context);

        mailService.sendHtmlMail("za59418@163.com","主题：这是模板邮件",emailContent);
        return "email/sendOk";
    }
}
