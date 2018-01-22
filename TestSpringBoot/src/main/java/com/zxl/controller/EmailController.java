package com.zxl.controller;

import org.junit.Test;
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
	public void testSimpleMail() throws Exception {
        mailService.sendSimpleMail("229298975@qq.com","test simple mail"," hello this is simple mail");
    }

	@RequestMapping("/htmlMail")
    public void testHtmlMail() throws Exception {
        String content="<html>\n" +
                "<body>\n" +
                "    <h3>hello world ! 这是一封html邮件!</h3>\n" +
                "</body>\n" +
                "</html>";
        mailService.sendHtmlMail("229298975@qq.com","test simple mail",content);
    }

	@RequestMapping("/attachmentsMail")
    public void sendAttachmentsMail() {
        String filePath="e:\\tmp\\application.log";
        mailService.sendAttachmentsMail("229298975@qq.com", "主题：带附件的邮件", "有附件，请查收！", filePath);
    }
	
	@RequestMapping("/inlineMail")
	public void sendInlineResourceMail() {
        String rscId = "neo006";
        String content="<html><body>这是有图片的邮件：<img src=\'cid:" + rscId + "\' ></body></html>";
        String imgPath = "C:\\Users\\summer\\Pictures\\favicon.png";

        mailService.sendInlineResourceMail("229298975@qq.com", "主题：这是有图片的邮件", content, imgPath, rscId);
    }


	@RequestMapping("/templateMail")
    public void sendTemplateMail() {
        //创建邮件正文
        Context context = new Context();
        context.setVariable("id", "006");
        String emailContent = templateEngine.process("emailTemplate", context);

        mailService.sendHtmlMail("229298975@qq.com","主题：这是模板邮件",emailContent);
    }
}
