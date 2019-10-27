package com.hegp.examples.exam003;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.Java2DFrameConverter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
 
/**
 * TODO：处理视频.（1.将视频提取成帧图片）
 */
public class VideoProcessing {
 
    //视频文件路径
    private static String videoPath = "/home/hgp/aa/vedio";
 
    //视频帧图片存储路径
    public static String videoFramesPath = "/home/hgp/aa/vedio/imgs";

    public static Java2DFrameConverter converter = new Java2DFrameConverter();

    /**
     * TODO 将视频文件帧处理并以“jpg”格式进行存储。
     * 依赖FrameToBufferedImage方法：将frame转换为bufferedImage对象
     * @param videoFileName
     */
    public static void grabberVideoFramer(String videoFileName) {
        //标识
        int flag = 0;
        FFmpegFrameGrabber fFmpegFrameGrabber = new FFmpegFrameGrabber(videoPath + "/" + videoFileName);
 
        try {
            fFmpegFrameGrabber.start();
            int ftp = fFmpegFrameGrabber.getLengthInFrames();
            long start = System.currentTimeMillis();
            while (flag <= ftp) {
                //文件绝对路径+名字
                String fileName = videoFramesPath + "/img_" + flag + ".jpg";
                //获取帧
                Frame frame = fFmpegFrameGrabber.grabImage();
                if (frame != null) {
                    long start1 = System.currentTimeMillis();
                    ImageIO.write(frame2BufferedImage(frame), "jpg", new File(fileName));
                    long end1 = System.currentTimeMillis();
                    System.out.println(end1-start1);
                }
                flag++;//=fFmpegFrameGrabber.getFrameRate();
            }
            long end = System.currentTimeMillis();
            System.out.println((end-start)/1000);
            System.out.println("============运行结束============");
            fFmpegFrameGrabber.stop();
        } catch (IOException E) {
        }
    }

    public static BufferedImage frame2BufferedImage(Frame frame) {
        //创建BufferedImage对象
        BufferedImage bufferedImage = converter.getBufferedImage(frame);
        return bufferedImage;
    }

    public static void main(String[] args) {
        String videoFileName = "AgileBPM流程实施演示.mp4";
        grabberVideoFramer(videoFileName);
    }

    public static String getVideoPath() {
        return videoPath;
    }

    public static void setVideoPath(String videoPath) {
        VideoProcessing.videoPath = videoPath;
    }
}