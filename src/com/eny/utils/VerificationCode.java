package com.eny.utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

/**
 * ��֤�봦��ӿ�ʵ��
 * 
 * @author ������
 *
 */
public class VerificationCode {

	private static Integer CodeWidth = 100;
	private static Integer CodeHeight = 30;

	/**
	 * ��֤����
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

		// ��ʼ����֤����
		consequence = null;

		BufferedImage buffImg = new BufferedImage(CodeWidth, CodeHeight, BufferedImage.TYPE_INT_RGB);

		Graphics2D g = buffImg.createGraphics();

		// ����һ��������������ࡣ
		Random random = new Random();

		// �趨ͼ�񱳾�ɫ(��Ϊ��������������ƫ��)
		g.setColor(GetRandColor(200, 250));
		g.fillRect(0, 0, CodeWidth, CodeHeight);
		// �������壬����Ĵ�СӦ�ø���ͼƬ�ĸ߶�������
		Font font = new Font("Times New Roman", Font.HANGING_BASELINE, 28);
		// �������塣
		g.setFont(font);

		// ���߿�
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, CodeWidth - 1, CodeHeight - 1);
		// �������155�������ߣ�ʹͼ���е���֤�벻�ױ���������̽�⵽��
		// g.setColor(Color.GRAY);
		g.setColor(GetRandColor(100, 200));
		for (int i = 0; i < 155; i++) {
			int x = random.nextInt(CodeWidth);
			int y = random.nextInt(CodeHeight);
			int xl = random.nextInt(12);
			int yl = random.nextInt(12);
			g.drawLine(x, y, x + xl, y + yl);
		}
		// ����λ���ֵ���֤�뱣�浽Session�С�
		consequence = Calculation_result_Code(g, 0, 24);

		// ͼ����Ч
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
	 * ������ɫ��Χ
	 * 
	 * @param fc
	 *            ��ɫ��Χ
	 * @param bc
	 *            ��ɫ��Χ
	 * @return ��ɫColor����
	 */
	private static Color GetRandColor(int fc, int bc) {// ������Χ��������ɫ
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

		// ����10���ڵ��������num1
		String num1 = String.valueOf(random.nextInt(9));

		// ����10���ڵ��������num1
		String num2 = String.valueOf(random.nextInt(9));

		// ����10���ڵ��������num1
		String num3 = String.valueOf(random.nextInt(9));

		// ����10���ڵ��������num1
		String num4 = String.valueOf(random.nextInt(9));

		// ������
		String calculation = num1 + num2 + num3 + num4;

		graphics.drawString(calculation, 15 * x + 6, y);
		return calculation;
	}

	@SuppressWarnings("unused")
	private static String Calculation_result(Graphics2D graphics, int x, int y) {
		Random random = new Random();

		graphics.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));

		// ����10���ڵ��������num1
		int num1 = random.nextInt(9);

		// ����һ��0-4֮����������operate
		int operate = random.nextInt(1);

		// ����10���ڵ��������num1
		int num2 = random.nextInt(9);

		// ������ֳ���Ϊ0�����
		if (operate == 3) {
			// ����ǳ���,�ǳ������벻��Ϊ0�����Ϊ0���ٴ�����num2
			while (num2 == 0) {
				num2 = random.nextInt(9);
			}
		}

		// ������
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
	 * �����֤��ͼƬ
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
//		// ��ֹͼ�񻺴档
//		
//
//		// ��ͼ�������Servlet������С�
//		ServletOutputStream sos = response.getOutputStream();
//		ImageIO.write(img, imgtype[1], sos);
//		sos.flush();
//		sos.close();
//	    
//	}
}
