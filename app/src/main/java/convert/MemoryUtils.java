package convert;

import android.annotation.SuppressLint;

import constant.MemoryConstants;

/**
 * Created by liulh on 2018/3/31.
 */

public class MemoryUtils {
    private MemoryUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /**
     * Size of memory in unit to size of byte.
     *
     * @param memorySize Size of memory.
     * @param unit       The unit of memory size.
     *                   <ul>
     *                   <li>{@link MemoryConstants#BYTE}</li>
     *                   <li>{@link MemoryConstants#KB}</li>
     *                   <li>{@link MemoryConstants#MB}</li>
     *                   <li>{@link MemoryConstants#GB}</li>
     *                   </ul>
     * @return size of byte
     */
    public static long memorySize2Byte(final long memorySize,
                                       @MemoryConstants.Unit final int unit) {
        if (memorySize < 0) return -1;
        return memorySize * unit;
    }

    /**
     * Size of byte to size of memory in unit.
     *
     * @param byteSize Size of byte.
     * @param unit     The unit of memory size.
     *                 <ul>
     *                 <li>{@link MemoryConstants#BYTE}</li>
     *                 <li>{@link MemoryConstants#KB}</li>
     *                 <li>{@link MemoryConstants#MB}</li>
     *                 <li>{@link MemoryConstants#GB}</li>
     *                 </ul>
     * @return size of memory in unit
     */
    public static double byte2MemorySize(final long byteSize,
                                         @MemoryConstants.Unit final int unit) {
        if (byteSize < 0) return -1;
        return (double) byteSize / unit;
    }


    /**
     * Size of byte to fit size of memory.
     * <p>to three decimal places</p>
     *
     * @param byteSize Size of byte.
     * @return fit size of memory
     */
    @SuppressLint("DefaultLocale")
    public static String byte2FitMemorySize(final long byteSize) {
        if (byteSize < 0) {
            return "shouldn't be less than zero!";
        } else if (byteSize < MemoryConstants.KB) {
            return String.format("%.3fB", (double) byteSize);
        } else if (byteSize < MemoryConstants.MB) {
            return String.format("%.3fKB", (double) byteSize / MemoryConstants.KB);
        } else if (byteSize < MemoryConstants.GB) {
            return String.format("%.3fMB", (double) byteSize / MemoryConstants.MB);
        } else {
            return String.format("%.3fGB", (double) byteSize / MemoryConstants.GB);
        }
    }
}
