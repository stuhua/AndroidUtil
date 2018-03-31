package convert;

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
     * 将byte数组，转换为int
     *
     * @param buffer size需要大于0，小于等于4
     * @return
     */
    public static int byte2Int(byte[] buffer) {
        int len = buffer.length;
        if (len < 0 || len > 4) {
            return -1;
        }
        int value = 0;
        for (int i = 0; i < len; i++) {
            int valueCur = ((buffer[i] & 0xFF) << (8 * (buffer.length - i - 1)));
            value |= valueCur;
        }
        return value;
    }

    /**
     * 根据int大小转换成byte数组
     *
     * @param data
     * @return
     */
    public static byte[] int2Byte(int data) {
        if (data < 0 || data > 0xFFFFFFFF) {
            return null;
        }
        byte[] bytes = null;
        int len = 0;
        if (data <= 0xFF) {
            bytes = new byte[len];
            for (int i = 0; i < len; i++) {
                bytes[i] = (byte) ((data >> (8 * (len - i - 1))) & 0xFF);
            }
        } else if (data <= 0xFFFF) {
            bytes = new byte[len];
            for (int i = 0; i < len; i++) {
                bytes[i] = (byte) ((data >> (8 * (len - i - 1))) & 0xFF);
            }
        } else if (data <= 0xFFFFFF) {
            bytes = new byte[len];
            for (int i = 0; i < len; i++) {
                bytes[i] = (byte) ((data >> (8 * (len - i - 1))) & 0xFF);
            }
        } else {
            bytes = new byte[len];
            for (int i = 0; i < len; i++) {
                bytes[i] = (byte) ((data >> (8 * (len - i - 1))) & 0xFF);
            }
        }
        return bytes;
    }


}
