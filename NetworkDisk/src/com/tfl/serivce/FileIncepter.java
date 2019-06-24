package com.tfl.serivce;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class FileIncepter {
	public FileIncepter() {
	}

	public void getFile(String savePath, String ip, int port) {
		// 建立socket连接
		Socket socket = null;
		try {
			socket = new Socket(ip, port);
		} catch (UnknownHostException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		// 建立socket输入流
		DataInputStream inputStream = null;
		try {
			inputStream = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			// 缓冲区大小
			int bufferSize = 8192;
			// 缓冲区
			byte[] buf = new byte[bufferSize];
			int passedlen = 0;
			long len = 0;
			// 获取文件名称
			savePath += inputStream.readUTF();
			DataOutputStream fileOut = new DataOutputStream(
					new BufferedOutputStream(new BufferedOutputStream(new FileOutputStream(savePath))));
			// 获取文件长度
			len = inputStream.readLong();
			System.out.println("文件的长度为:" + len + "    KB");
			System.out.println("开始接收文件!");
			// 获取文件
			while (true) {
				int read = 0;
				if (inputStream != null) {
					read = inputStream.read(buf);
				}
				passedlen += read;
				if (read == -1) {
					break;
				}
				System.out.println("文件接收了" + (passedlen * 100 / len) + "%");
				fileOut.write(buf, 0, read);
			}
			System.out.println("接收完成，文件存为" + savePath);
			fileOut.close();
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}

	public static void main(String[] args) {   
        new FileIncepter().getFile("F://", "localhost", 8821);   
      }
}
