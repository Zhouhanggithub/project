package com.eny.utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

/**
 * 验证码处理接口实现
 * 
 * @author 梁晓檑
 *
 */
public class VerificationCode {

	private static Integer CodeWidth = 100;
	private static Integer CodeHeight = 30;

	/**
	 * 验证码结果
	 */
	private static String consequence = null;

	public static void SetCodeWidth(Integer value) {

		value = (value != null) ? value : 100;
		CodeWidth = value;
	}

	public static Integer GetCodeWidth() {

		return CodeWidth;
	}

	public static void SetCodeHeight(Integer value) {

		value = (value != null) ? value : 30;
		CodeHeight = value;
	}

	public static Integer GetCodeHeight() {

		return CodeHeight;
	}

	public static Object[] GetVerificationCode() {

		// 初始化验证码结果
		consequence = null;

		BufferedImage buffImg = new BufferedImage(CodeWidth, CodeHeight, BufferedImage.TYPE_INT_RGB);

		Graphics2D g = buffImg.createGraphics();

		// 创建一个随机数生成器类。
		Random random = new Random();

		// 设定图像背景色(因为是做背景，所以偏淡)
		g.setColor(GetRandColor(200, 250));
		g.fillRect(0, 0, CodeWidth, CodeHeight);
		// 创建字体，字体的大小应该根据图片的高度来定。
		Font font = new Font("Times New Roman", Font.HANGING_BASELINE, 28);
		// 设置字体。
		g.setFont(font);

		// 画边框。
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, CodeWidth - 1, CodeHeight - 1);
		// 随机产生155条干扰线，使图象中的认证码不易被其它程序探测到。
		// g.setColor(Color.GRAY);
		g.setColor(GetRandColor(100, 200));
		for (int i = 0; i < 155; i++) {
			int x = random.nextInt(CodeWidth);
			int y = random.nextInt(CodeHeight);
			int xl = random.nextInt(12);
			int yl = random.nextInt(12);
			g.drawLine(x, y, x + xl, y + yl);
		}
		// 将四位数字的验证码保存到Session中。
		consequence = Calculation_result_Code(g, 0, 24);

		// 图象生效
		g.dispose();
		ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
		try {
			ImageIO.write(buffImg, "jpeg", byteArray);
			System.out.println(byteArray.toByteArray());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return new Object[] { byteArray.toByteArray(), consequence };
	}

	/**
	 * 给定颜色范围
	 * 
	 * @param fc
	 *            颜色范围
	 * @param bc
	 *            颜色范围
	 * @return 颜色Color对象
	 */
	private static Color GetRandColor(int fc, int bc) {// 给定范围获得随机颜色
		Random random = new Random();
		if (fc > 255)
			fc = 255;
		if (bc > 255)
			bc = 255;
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return new Color(r, g, b);
	}

	private static String Calculation_result_Code(Graphics2D graphics, int x, int y) {
		Random random = new Random();

		graphics.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));

		// 生成10以内的随机整数num1
		String num1 = String.valueOf(random.nextInt(9));

		// 生成10以内的随机整数num1
		String num2 = String.valueOf(random.nextInt(9));

		// 生成10以内的随机整数num1
		String num3 = String.valueOf(random.nextInt(9));

		// 生成10以内的随机整数num1
		String num4 = String.valueOf(random.nextInt(9));

		// 运算结果
		String calculation = num1 + num2 + num3 + num4;

		graphics.drawString(calculation, 15 * x + 6, y);
		return calculation;
	}

	@SuppressWarnings("unused")
	private static String Calculation_result(Graphics2D graphics, int x, int y) {
		Random random = new Random();

		graphics.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));

		// 生成10以内的随机整数num1
		int num1 = random.nextInt(9);

		// 生成一个0-4之间的随机整数operate
		int operate = random.nextInt(1);

		// 生成10以内的随机整数num1
		int num2 = random.nextInt(9);

		// 避免出现除数为0的情况
		if (operate == 3) {
			// 如果是除法,那除数必须不能为0，如果为0，再次生成num2
			while (num2 == 0) {
				num2 = random.nextInt(9);
			}
		}

		// 运算结果
		int result = 0;
		String calculation = "";

		switch (operate) {
		case 0:
			calculation = num1 + "+" + num2;
			result = num1 + num2;
			break;
		case 1:
			calculation = num1 + "-" + num2;
			result = num1 - num2;
			break;
		case 2:
			calculation = num1 + "*" + num2;
			result = num1 * num2;
			break;
		case 3:
			calculation = num1 + "/" + num2;
			result = num1 / num2;
			break;
		}
		graphics.drawString(calculation + "=?", 15 * x + 6, y);
		return String.valueOf(result);
	}
	/**
	 * 输出验证码图片
	 * @param response
	 * @param request
	 * @throws IOException 
	 */
//	public void sendImgCode() throws IOException{
//		HttpServletResponse response = ServletActionContext.getResponse();
//		Object[] objects = VerificationCode.GetVerificationCode();
//		response.setHeader("Pragma", "no-cache");
//		response.setHeader("Cache-Control", "no-cache");
//		response.setDateHeader("Expires", 0);
//		response.setContentType("image/jpeg");
//
//		InputStream buffin = new ByteArrayInputStream((byte[]) objects[0]);
//		String str = "image/jpeg";
//		String imgtype[] = str.split("/");
//
//		BufferedImage img = ImageIO.read(buffin);
//		// 禁止图像缓存。
//		
//
//		// 将图像输出到Servlet输出流中。
//		ServletOutputStream sos = response.getOutputStream();
//		ImageIO.write(img, imgtype[1], sos);
//		sos.flush();
//		sos.close();
//	    
//	}
}
