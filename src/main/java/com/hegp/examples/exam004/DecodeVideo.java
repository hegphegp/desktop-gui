package com.hegp.examples.exam004;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.VideoCapture;
 
public class DecodeVideo {
	
	public static void main(String[] args) {
		System.loadLibrary("opencv_ffmpeg330_64");
		// 加载本地的OpenCV库，这样就可以用它来调用Java API
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		run2();
	}
 
	public static void run2() {
		/**
		// 读取视频文件
		VideoCapture cap = new VideoCapture("F:/mysour/csdn/2.mp4");
		System.out.println(cap.isOpened());
		// 判断视频是否打开
		if (cap.isOpened()) {
			// 总帧数
			double frameCount = cap.get();
			System.out.println("视频总帧数:" + frameCount);
			// 帧率
			double fps = cap.get(opencv_highgui.CV_CAP_PROP_FPS);
			System.out.println("视频帧率" + fps);
			// 时间长度
			double len = frameCount / fps;
			System.out.println("视频总时长:" + len);
			Double d_s = new Double(len);
			System.out.println(d_s.intValue());
			Mat frame = new Mat();
			for (int i = 0; i < d_s.intValue(); i++) {
				// 设置视频的位置(单位:毫秒)
				cap.set(opencv_highgui.CV_CAP_PROP_POS_MSEC, i * 1000);
				// 读取下一帧画面
				if (cap.read(frame)) {
					System.out.println("正在保存");
					// 保存画面到本地目录
					Imgcodecs.imwrite("F:/mysour/video/output/" + i + ".jpg", frame);					
				}
			}
			// 关闭视频文件
			cap.release();
		}
		 */
	}
}