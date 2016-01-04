package com.xiaomo.timeMachine.core.util;//package com.xiaomo.lol.core.util;
//
//import java.io.*;
//import java.security.MessageDigest;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.ThreadLocalRandom;
//import java.util.zip.CRC32;
//
//import org.apache.commons.codec.binary.Base64;
//
//public class Card {
//
//	private static final String PASSWORD = "Vpywlb6ulB5zq@Z5m1yCO0zC6o29WixPzX5+xhuiqcAC2zjx_lb6rREs3o29yGKlwpdldcKJWPEZAL;WE'SDPWE,D";
//
//	private static int INDEX = 0;
//
//	/**
//	 * 当前秒数
//	 */
//	private static int cursec = (int) (System.currentTimeMillis() / 1000L);
//
//	/**
//	 * 平台id
//	 */
//	private byte platformId;
//	/**
//	 * cardId
//	 */
//	private short cardId;
//	/**
//	 * 时间戳
//	 */
//	private long time;
//
//	/**
//	 * MD5秘钥
//	 */
//	private long sign;
//
//	/**
//	 * 礼包卡
//	 */
//	private String code;
//	/**
//	 * random
//	 */
//	private short random;
//
//	public Card(String code) {
//		try {
//			byte[] bytes = Base64.decodeBase64(code.getBytes());
//			ByteArrayInputStream instream = new ByteArrayInputStream(bytes);
//			DataInputStream in = new DataInputStream(instream);
//			this.platformId = in.readByte(); // pid + cardid + 随机数 + md5 pid +
//			this.sign = in.readLong();
//			this.cardId = in.readShort();
//			this.time = in.readLong();
//			this.random = in.readShort();
//			this.code = code;
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		System.out.println(this);
//	}
//
//	private String getPassword(int platformId, int cardId) {
//		return PASSWORD;
//	}
//
//	public Card(byte platformId, short cardId) {
//		try {
//			this.platformId = platformId;
//			this.cardId = cardId;
//			this.time = System.currentTimeMillis();
//			int rand = ThreadLocalRandom.current().nextInt();
//			this.random = (short)rand;
//			CRC32 crc = new CRC32();
//			String pass = getPassword(platformId, cardId);
//			String md5 = md5(this.platformId + "" + this.cardId + "" + pass + "" + this.time +"" + random);
//			String signString = this.platformId + "" + this.cardId + "" + pass + "" + this.time + "" + md5;
//			crc.update(signString.getBytes());
//			this.sign = crc.getValue();
//			ByteArrayOutputStream stream = new ByteArrayOutputStream();
//			DataOutputStream out = new DataOutputStream(stream);
//			out.writeByte(this.platformId);
//			out.writeLong(this.sign);
//			out.writeShort(this.cardId);
//			out.writeLong(this.time);
//			out.writeShort(random);
//			byte[] byteArray = stream.toByteArray();
//			byte[] encodeByteBase64 = Base64.encodeBase64(byteArray);
//			this.code = new String(encodeByteBase64);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//
//	public byte getPlatformId() {
//		return platformId;
//	}
//
//	public void setPlatformId(byte platformId) {
//		this.platformId = platformId;
//	}
//
//	public short getCardId() {
//		return cardId;
//	}
//
//	public void setCardId(short cardId) {
//		this.cardId = cardId;
//	}
//
//	public long getSign() {
//		return this.sign;
//	}
//
//	public void setSign(long sign) {
//		this.sign = sign;
//	}
//
//	public String getCode() {
//		return this.code;
//	}
//
//	public void setCode(String code) {
//		this.code = code;
//	}
//
//	public long getTime() {
//		return time;
//	}
//
//	public void setTime(long time) {
//		this.time = time;
//	}
//
//	public short getRandom() {
//		return random;
//	}
//
//	public void setRandom(short random) {
//		this.random = random;
//	}
//
//	public boolean check() {
//		String pass = getPassword(this.platformId, this.cardId);
//		if (pass == null)
//			return false;
//		CRC32 crc = new CRC32();
//		String md5 = md5(this.platformId + "" + this.cardId + "" + pass + "" + this.time + "" + this.random);
//		String signString = this.platformId + "" + this.cardId + "" + pass + "" + this.time + "" + md5;
//		crc.update(signString.getBytes());
//		return crc.getValue() == getSign();
//	}
//
//	public String toString() {
//		return "Card [platformId=" + this.platformId + ", cardId=" + this.cardId + ", time=" + this.time + ", sign="
//				+ this.sign + ", code=" + this.code + "]";
//	}
//
//	public static void genCode(byte platformId, short cardId, int cardNumber, String fileName) throws IOException {
//		List<String> codes = new ArrayList<String>();
//		for (int i = 0; i < cardNumber; i++) {
//			Card card = new Card(platformId, cardId);
//			codes.add(card.getCode());
//		}
//		FileWriter write = new FileWriter(fileName + ".txt");
//		for (String string : codes) {
//			write.write(string + "\r\n");
//		}
//		write.close();
//	}
//
//	private static String md5(String str) {
//		if (str == null) {
//			return null;
//		}
//		try {
//			MessageDigest md5 = MessageDigest.getInstance("MD5");
//			byte[] bytes = md5.digest(str.getBytes("UTF-8"));
//			StringBuilder ret = new StringBuilder(bytes.length << 1);
//			for (int i = 0; i < bytes.length; i++) {
//				ret.append(Character.forDigit((bytes[i] >> 4) & 0xf, 16));
//				ret.append(Character.forDigit(bytes[i] & 0xf, 16));
//			}
//			return ret.toString();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
//
//
//	public static void main(String[] args) throws FileNotFoundException {
//        Card card = new Card((byte)38,(byte)88);
//        for (int i=0;i<10;i++){
//            File file = new File("D:/key.txt");
//            InputStream is = new FileInputStream(file);
////            is.
////            FileUtil.write(file,is);
//        }
//      }
//    }
