package com.xiaomo.timeMachine.core.util;

/**
 * 把今天最好的表现当作明天最新的起点．．～
 * いま 最高の表現 として 明日最新の始発．．～
 * Today the best performance  as tomorrow newest starter!
 * Created by IntelliJ IDEA.
 *
 * @author: xiaomo
 * @github: https://github.com/qq83387856
 * @email: hupengbest@163.com
 * @QQ_NO: 83387856
 * @Date: 12:58 2016/1/5
 * @Description: google的zxing 二维码相关
 * @Copyright(©) 2015 by xiaomo.
 */

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeWriter;
import com.xiaomo.timeMachine.core.constant.ImageType;
import com.xiaomo.timeMachine.core.constant.Symbol;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class QRCodeCreateUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(QRCodeCreateUtil.class);

    private String fileName;

    /**
     * 传入路径和要生成的内容，生成二维码 生成的
     *
     * @param path     for example: d:/test/   支持主流图片格式
     * @param name     图片的名字 不能加后缀
     * @param contents for example 张小贤
     * @throws IOException
     * @throws WriterException
     */
    public static void createQRCode(String path, String name, String contents) {
        try {
            contents = new String(contents.getBytes("UTF-8"), "ISO-8859-1");

            Map<EncodeHintType, Object> hints = new HashMap<>();
            hints.put(EncodeHintType.MARGIN, 0);
            BitMatrix bitMatrix = new QRCodeWriter().encode(contents, BarcodeFormat.QR_CODE, 256, 256, hints);
            int width = bitMatrix.getWidth();
            int height = bitMatrix.getHeight();
            BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    image.setRGB(x, y, bitMatrix.get(x, y) ? Color.BLACK.getRGB() : Color.WHITE.getRGB());
                }
            }
            File file = new File(path);
            if (!file.exists()) {
                file.mkdir();
                LOGGER.info("路径不存在，创建{}", path);
            }
            //生成的图片格式为 今天的日期-name.jpg    例如：20160106-test.jpg
            String fileName = TimeUtil.getFormatDateToday() + Symbol.HENGXIAN + name + ImageType.JPG;
            ImageIO.write(image, "png", new File(path + fileName));
            LOGGER.info("生成二维码成功，存储地址：[{}],名字是[{}]", path, fileName);
        } catch (WriterException | IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 识别二维码内容
     *
     * @param imgPath 图片地址
     * @return string
     */
    public static String decode(String imgPath) {
        BufferedImage image;
        Result result;
        try {
            image = ImageIO.read(new File(imgPath));
            LuminanceSource source = new BufferedImageLuminanceSource(image);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

            Hashtable<DecodeHintType, Object> hints = new Hashtable<>();
            // 注意要使用 utf-8，因为刚才生成二维码时，使用了utf-8
            hints.put(DecodeHintType.CHARACTER_SET, "utf-8");
            result = new MultiFormatReader().decode(bitmap, hints);
            LOGGER.info("解析二维码成功！");
            LOGGER.info("二维码内容为[{}]", result.getText());
            return result.getText();
        } catch (Exception e) {
            LOGGER.error("识别二维码过程中出错，原因是", e);
        }
        return null;
    }


    /**
     * 功能测试
     *
     * @param args null
     */
    public static void main(String[] args) {
        //生成二维码
        createQRCode("D:/images/", "test", "测试测试 http://www.baidu.com");
        //解析二维码
        decode("d:/images/20160105-test.jpg");
    }
}
