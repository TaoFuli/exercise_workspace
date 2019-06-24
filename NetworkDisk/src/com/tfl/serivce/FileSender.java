package com.tfl.serivce;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class FileSender {   
      private ServerSocket ss = null;   
      public FileSender() {   
      }   
      public void startSend(String filePath, int port) {   
        // socket输出流   
        DataOutputStream os = null;   
        // 文件输入流   
        DataInputStream is = null;   
        // 建立socket连接   
        Socket socket = null;   
        try {   
          // 选择进行传输的文件   
          File file = new File(filePath);   
          // 建立socket监听   
          ss = new ServerSocket(port);   
          socket = ss.accept();   
          os = new DataOutputStream(socket.getOutputStream());   
          // 将文件名及长度传给客户端。这里要真正适用所有平台，例如中文名的处理，还需要加工，   
          // 具体可以参见Think In Java 4th里有现成的代码。   
          os.writeUTF(file.getName());   
          os.flush();   
          os.writeLong((long) file.length());   
          os.flush();   
          is = new DataInputStream(new BufferedInputStream(   
              new FileInputStream(filePath)));   
          // 缓冲区大小   
          int bufferSize = 8192;   
          // 缓冲区   
          byte[] buf = new byte[bufferSize];   
          // 传输文件   
          while (true) {   
            int read = 0;   
            if (is != null) {   
              read = is.read(buf);   
            }   
            if (read == -1) {   
              break;   
            }   
            os.write(buf, 0, read);   
          }   
          os.flush();   
        } catch (IOException e) {   
          e.printStackTrace();   
        } finally {   
          // 关闭所有连接   
          try {   
            if (os != null)   
              os.close();   
          } catch (IOException e) {   
          }   
          try {   
            if (is != null)   
              is.close();   
          } catch (IOException e) {   
          }   
          try {   
            if (socket != null)   
              socket.close();   
          } catch (IOException e) {   
          }   
          try {   
            if (ss != null)   
              ss.close();   
          } catch (IOException e) {   
          }   
        }   
      }   
      public static void main(String[] args) {   
        new FileSender().startSend("E://JDK_API_1_6_zh_CN.CHM", 8821);   
      }   
    }


