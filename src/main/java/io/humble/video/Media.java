/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.0
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package io.humble.video;
import io.humble.ferry.*;
/**
 * The parent class of all media objects than can be gotten from or 
 * added to a {@link Stream}.  
 */
public class Media extends RefCounted {
  // JNIHelper.swg: Start generated code
  // >>>>>>>>>>>>>>>>>>>>>>>>>>>
  /**
   * This method is only here to use some references and remove
   * a Eclipse compiler warning.
   */
  @SuppressWarnings("unused")
  private void noop()
  {
    IBuffer.make(null, 1);
  }
   
  private volatile long swigCPtr;

  /**
   * Internal Only.
   */
  protected Media(long cPtr, boolean cMemoryOwn) {
    super(VideoJNI.SWIGMediaUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }
  
  /**
   * Internal Only.
   */
  protected Media(long cPtr, boolean cMemoryOwn,
      java.util.concurrent.atomic.AtomicLong ref)
  {
    super(VideoJNI.SWIGMediaUpcast(cPtr),
     cMemoryOwn, ref);
    swigCPtr = cPtr;
  }
    
  /**
   * Internal Only.  Not part of public API.
   *
   * Get the raw value of the native object that obj is proxying for.
   *   
   * @param obj The java proxy object for a native object.
   * @return The raw pointer obj is proxying for.
   */
  protected static long getCPtr(Media obj) {
    if (obj == null) return 0;
    return obj.getMyCPtr();
  }

  /**
   * Internal Only.  Not part of public API.
   *
   * Get the raw value of the native object that we're proxying for.
   *   
   * @return The raw pointer we're proxying for.
   */  
  protected long getMyCPtr() {
    if (swigCPtr == 0) throw new IllegalStateException("underlying native object already deleted");
    return swigCPtr;
  }
  
  /**
   * Create a new Media object that is actually referring to the
   * exact same underlying native object.
   *
   * @return the new Java object.
   */
  @Override
  public Media copyReference() {
    if (swigCPtr == 0)
      return null;
    else
      return new Media(swigCPtr, swigCMemOwn, getJavaRefCount());
  }

  /**
   * Compares two values, returning true if the underlying objects in native code are the same object.
   *
   * That means you can have two different Java objects, but when you do a comparison, you'll find out
   * they are the EXACT same object.
   *
   * @return True if the underlying native object is the same.  False otherwise.
   */
  public boolean equals(Object obj) {
    boolean equal = false;
    if (obj instanceof Media)
      equal = (((Media)obj).swigCPtr == this.swigCPtr);
    return equal;
  }
  
  /**
   * Get a hashable value for this object.
   *
   * @return the hashable value.
   */
  public int hashCode() {
     return (int)swigCPtr;
  }
  
  // <<<<<<<<<<<<<<<<<<<<<<<<<<<
  // JNIHelper.swg: End generated code
  

  // used to correct timezone offsets for timestamp format 

  private static final long TIME_OFFSET = -java.util.Calendar.getInstance()
    .getTimeZone().getRawOffset();

  /** The default time stamp format. */
  
  public static final String DEFAULT_TIME_STAMP_FORMAT =
    "%1$tH:%1$tM:%1$tS.%1$tL";

  /**
   * Get a string representation of the time stamp for this {@link
   * Media}.  The time is formatted as: <b>HH:MM:SS.ms</b>
   *
   * @return the printable string form of the time stamp of this media
   *
   * @see #getFormattedTimeStamp(String)
   * @see #DEFAULT_TIME_STAMP_FORMAT
   */

  public String getFormattedTimeStamp()
  {
    return getFormattedTimeStamp(DEFAULT_TIME_STAMP_FORMAT);
  }

  /**
   * Get a string representation of the time stamp for this {@link
   * Media}.  The format of the resulting string is specified by
   * the format parameter.  See {@link java.util.Formatter} for 
   * details on how to specify formats, however a good place to start
   * is with the following format: <b>%1$tH:%1$tM:%1$tS.%1$tL</b>
   *
   * @param format the format for the time stamp string
   *
   * @return the printable string form of the timestamp
   * 
   * @see #getFormattedTimeStamp()
   * @see #DEFAULT_TIME_STAMP_FORMAT
   * @see java.util.Formatter
   */

  public String getFormattedTimeStamp(String format)
  {
    String retval = null;
    java.util.Formatter formatter = new java.util.Formatter();

    try {
      Rational timeBase = getTimeBase();
      if (timeBase == null)
        timeBase = Rational.make(1,(int)Global.DEFAULT_PTS_PER_SECOND);
      retval = formatter.format(format,
          (long)(getTimeStamp() * timeBase.getDouble() * 1000) +
          TIME_OFFSET).toString();
      timeBase.delete();
    } finally {
      formatter.close();
    }
    return retval;
  }
  

/**
 * Get the time stamp of this object in getTimeBase() units.  
 * @return	the time stamp  
 */
  public long getTimeStamp() {
    return VideoJNI.Media_getTimeStamp(swigCPtr, this);
  }

/**
 * Set the time stamp for this object in getTimeBase() units.  
 * @param	aTimeStamp The time stamp  
 */
  public void setTimeStamp(long aTimeStamp) {
    VideoJNI.Media_setTimeStamp(swigCPtr, this, aTimeStamp);
  }

/**
 * Get the time base that time stamps of this object are represented 
 * in.  
 * Caller must release the returned value.  
 * @return	the time base.  
 */
  public Rational getTimeBase() {
    long cPtr = VideoJNI.Media_getTimeBase(swigCPtr, this);
    return (cPtr == 0) ? null : new Rational(cPtr, false);
  }

/**
 * Is this object a key object? i.e. it can be interpreted without needing 
 * any other media objects  
 * @return	true if it's a key, false if not  
 */
  public boolean isKey() {
    return VideoJNI.Media_isKey(swigCPtr, this);
  }

/**
 * Returns whether or not we think this buffer has been filled  
 * with data.  
 *  
 */
  public boolean isComplete() {
    return VideoJNI.Media_isComplete(swigCPtr, this);
  }

}