package com.example.demo.controller.backManage;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("backManage/qrCode")
public class QrCodeController{

    private static final Logger logger = LogManager.getLogger(QrCodeController.class);

    @RequestMapping(value = "list")
    public ModelAndView serialList(HttpServletRequest request) {
        return new ModelAndView("/backManage/qrCode/list");
    }

    @RequestMapping(value = "generatorCode")
    public void generatorCode(HttpServletRequest request, HttpServletResponse response) {
        String text = "h5Url";
        int width = 240;
        int height = 240;
        String format = "png";
        logger.debug("====generatorCode====生成二维码开始====内容：" + text);

        Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H); //容错率s
        hints.put(EncodeHintType.MARGIN, 1);//空白区域大小取值范围0~4
        BitMatrix bitMatrix;
        try {
            bitMatrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, width, height, hints);
            MatrixToImageWriter.writeToStream(bitMatrix, format, response.getOutputStream());
            logger.debug("====generatorCode====生成二维码成功");
        } catch (Exception e) {
            logger.error("生成二维码异常", e);
        }

    }
}
