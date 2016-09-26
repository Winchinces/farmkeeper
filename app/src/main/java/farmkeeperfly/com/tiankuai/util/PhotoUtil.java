package farmkeeperfly.com.tiankuai.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.text.TextUtils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;

/**
 * Created by NTGJ on 2016/9/19.
 */
public class PhotoUtil {

    /**
     * 压缩Bitmap的大小
     */
    public static Bitmap decodeBitmapFromFile(String imagePath, int requestWidth, int requestHeight) {
        if (!TextUtils.isEmpty(imagePath)) {
            Bitmap bitmap = BitmapFactory.decodeFile(imagePath);
            if (null == bitmap || requestWidth <= 0 || requestHeight <= 0) {
                return bitmap;
            }

            // suppose that width is shorter than height.
            int dstW = requestWidth;
            int dstH = requestHeight;
            if (dstW > dstH) {
                int tmp = dstW;
                dstW = dstH;
                dstH = tmp;
            }

            int srcW = bitmap.getWidth();
            int srcH = bitmap.getHeight();
            if (srcW > srcH) {
                int tmp = srcW;
                srcW = srcH;
                srcH = tmp;
            }

            if (srcW <= dstW && srcH <= dstH) {
                return bitmap;
            }

            float sx = dstW / (float)srcW;
            float sy = dstH / (float)srcH;
            float ratio = (sx < sy) ? sx : sy;
            Matrix matrix = new Matrix();
            matrix.postScale(ratio, ratio);

            return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } else {
            return null;
        }
    }

    /**
     * 质量压缩到指定大小后存储在指定路径。
     * @param image
     * @param reqSize   Max expected size of the compressed image, in KBytes.
     *                    Note the actual compressed image may be larger than "reqSize" in case of too low quantity.
     * @return
     */
    public static void compressImageAndSaveAsJpg(Bitmap image, int reqSize, String path) {
        if (null == image || null == path) {
            return;
        }

        final int MAX_SIZE_IN_BYTES = reqSize * 1024;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int options = 105;
        do {
            baos.reset();//重置baos即清空baos
            options -= 5;//每次都减少5
            image.compress(Bitmap.CompressFormat.JPEG, options, baos);//这里压缩options%，把压缩后的数据存放到baos中
        } while (baos.toByteArray().length > MAX_SIZE_IN_BYTES && options > 50);

        try {
            FileOutputStream fos = new FileOutputStream(new File(path));
            fos.write(baos.toByteArray());
            fos.flush();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
     * Construct oss image service thumbnail url from original oss object url.
     *
     * Say http://farmlandbucket.oss-cn-beijing.aliyuncs.com/F14743614690351.jpg
     * to http://farmlandbucket.img-cn-beijing.aliyuncs.com/F14743614690351.jpg@100w_100h.jpg
     *
     * @param wLimit   Max expected width pixels.
     * @param hLimit   Max expected height pixels.
     * @return thumbnail url or null if parameters are invalid.
     */
    public static String getOssImgThumbnailUrl(String rawUrl, int wLimit, int hLimit) {
        if (null == rawUrl) {
            return null;
        }

        return rawUrl.replace(".oss-", ".img-")
                + String.format(Locale.CHINESE, "@%dw_%dh.jpg", wLimit, hLimit);
    }
}
