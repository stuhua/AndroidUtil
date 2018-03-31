package convert;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * Created by liulh on 2018/3/31.
 */

public class ByteUtils {

    private ByteUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /**
     * 将byte数组按16进制的方式输出
     *
     * @param buffer
     * @return
     */
    public static String byte2Hex(byte[] buffer) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < buffer.length; i++) {
            String temp = Integer.toHexString(buffer[i] & 0xFF);
            str.append("[").append(temp).append("] ");
        }
        return str.toString();
    }

    /**
     * 將byte转换成int值
     *
     * @param buffer
     * @return
     */
    public static int byte2Int(byte buffer) {
        return 0xFF & buffer;
    }

    /**
     * 根据byte数组转换为int数值
     *
     * @param buffer
     * @return
     * @throws IOException
     */
    public static int byteArray2Int(byte[] buffer) throws IOException {
        ByteArrayInputStream buf = new ByteArrayInputStream(buffer);
        DataInputStream dis = new DataInputStream(buf);
        return dis.readInt();
    }

    /**
     * 根据int大小转换成byte数组
     *
     * @param data
     * @return
     */
    public static byte[] int2Byte(int data) throws IOException {
        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(buf);
        dos.writeInt(data);
        byte[] b = buf.toByteArray();
        dos.close();
        buf.close();
        return b;
    }


}
