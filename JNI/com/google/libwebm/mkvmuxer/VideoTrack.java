// Author: mszal@google.com (Michael Szal)

package com.google.libwebm.mkvmuxer;

import com.google.libwebm.Common;
import java.util.HashMap;
import java.util.Map;

public class VideoTrack extends Track {

  public enum StereoMode {
    kMono(0),
    kSideBySideLeftIsFirst(1),
    kTopBottomRightIsFirst(2),
    kTopBottomLeftIsFirst(3),
    kSideBySideRightIsFirst(11);

    private static final Map<Integer, StereoMode> stereoModes = new HashMap<Integer, StereoMode>();

    static {
      for (StereoMode mode : StereoMode.values()) {
        stereoModes.put(mode.toInt(), mode);
      }
    }

    private final int value;

    public static StereoMode toStereoMode(int value) {
      return stereoModes.get(value);
    }

    public int toInt() {
      return value;
    }

    private StereoMode(int value) {
      this.value = value;
    }
  };

  public VideoTrack(int seed) {
    nativePointer = newVideoTrack(seed);
  }

  public long displayHeight() {
    return displayHeight(nativePointer);
  }

  public long displayWidth() {
    return displayWidth(nativePointer);
  }

  public double frameRate() {
    return frameRate(nativePointer);
  }

  public long height() {
    return height(nativePointer);
  }

  public long payloadSize() {
    return PayloadSize(nativePointer);
  }

  public void setDisplayHeight(long height) {
    setDisplayHeight(nativePointer, height);
  }

  public void setDisplayWidth(long width) {
    setDisplayWidth(nativePointer, width);
  }

  public void setFrameRate(double frameRate) {
    setFrameRate(nativePointer, frameRate);
  }

  public void setHeight(long height) {
    setHeight(nativePointer, height);
  }

  public void setStereoMode(StereoMode stereoMode) {
    SetStereoMode(nativePointer, stereoMode.toInt());
  }

  public void setWidth(long width) {
    setWidth(nativePointer, width);
  }

  public StereoMode stereoMode() {
    return StereoMode.toStereoMode((int) stereoMode(nativePointer));
  }

  public long width() {
    return width(nativePointer);
  }

  public boolean write(IMkvWriter writer) {
    return Write(nativePointer, writer.getNativePointer());
  }

  protected VideoTrack(long nativePointer) {
    super(nativePointer);
  }

  protected void deleteObject() {
    deleteVideoTrack(nativePointer);
  }

  private native void deleteVideoTrack(long jVideoTrack);
  private native long displayHeight(long jVideoTrack);
  private native long displayWidth(long jVideoTrack);
  private native double frameRate(long jVideoTrack);
  private native long height(long jVideoTrack);
  private native long newVideoTrack(int jSeed);
  private native long PayloadSize(long jVideoTrack);
  private native void setDisplayHeight(long jVideoTrack, long height);
  private native void setDisplayWidth(long jVideoTrack, long width);
  private native void setFrameRate(long jVideoTrack, double frame_rate);
  private native void setHeight(long jVideoTrack, long height);
  private native void setWidth(long jVideoTrack, long width);
  private native void SetStereoMode(long jVideoTrack, long stereo_mode);
  private native long stereoMode(long jVideoTrack);
  private native long width(long jVideoTrack);
  private native boolean Write(long jVideoTrack, long jWriter);
}
