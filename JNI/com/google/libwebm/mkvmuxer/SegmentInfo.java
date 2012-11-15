// Author: mszal@google.com (Michael Szal)

package com.google.libwebm.mkvmuxer;

import com.google.libwebm.Common;

public class SegmentInfo extends Common {

  public SegmentInfo() {
    nativePointer = newSegmentInfo();
  }

  public double duration() {
    return duration(nativePointer);
  }

  public boolean finalizeSegmentInfo(IMkvWriter writer) {
    return Finalize(nativePointer, writer.getNativePointer());
  }

  public boolean init() {
    return Init(nativePointer);
  }

  public String muxingApp() {
    return muxingApp(nativePointer);
  }

  public void setDuration(double duration) {
    setDuration(nativePointer, duration);
  }

  public void setMuxingApp(String app) {
    setMuxingApp(nativePointer, app);
  }

  public void setTimecodeScale(long scale) {
    setTimecodeScale(nativePointer, scale);
  }

  public void setWritingApp(String app) {
    setWritingApp(nativePointer, app);
  }

  public long timecodeScale() {
    return timecodeScale(nativePointer);
  }

  public boolean write(IMkvWriter writer) {
    return Write(nativePointer, writer.getNativePointer());
  }

  public String writingApp() {
    return writingApp(nativePointer);
  }

  protected SegmentInfo(long nativePointer) {
    super(nativePointer);
  }

  protected void deleteObject() {
    deleteSegmentInfo(nativePointer);
  }

  private native void deleteSegmentInfo(long jSegmentInfo);
  private native double duration(long jSegmentInfo);
  private native boolean Finalize(long jSegmentInfo, long jWriter);
  private native boolean Init(long jSegmentInfo);
  private native String muxingApp(long jSegmentInfo);
  private native long newSegmentInfo();
  private native void setDuration(long jSegmentInfo, double duration);
  private native void setMuxingApp(long jSegmentInfo, String jApp);
  private native void setTimecodeScale(long jSegmentInfo, long scale);
  private native void setWritingApp(long jSegmentInfo, String jApp);
  private native long timecodeScale(long jSegmentInfo);
  private native boolean Write(long jSegmentInfo, long jWriter);
  private native String writingApp(long jSegmentInfo);
}
