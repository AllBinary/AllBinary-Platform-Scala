/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *   */
/* Generated Code Do Not Modify */
package org.allbinary.opengles

import _root_.java.nio.Buffer
import _root_.java.nio.ByteBuffer
import _root_.java.nio.ByteOrder
import _root_.java.nio.FloatBuffer

/**  *  * @author User  */
class GLUtil {
    import _root_.org.allbinary.opengles.GLUtil.{*}

    private val BYTES_PER_FLOAT : Int = 4

    val NULL_FLOAT_BUFFER : FloatBuffer = ByteBuffer.allocateDirect(0).asFloatBuffer()

    def makeFloatBuffer3(p_a : Float, p_b : Float, p_c : Float) : FloatBuffer = {
        val b : ByteBuffer = ByteBuffer.allocateDirect(3 * this.BYTES_PER_FLOAT)
        b.order(ByteOrder.nativeOrder())
        val buffer : FloatBuffer = b.asFloatBuffer()
        buffer.put(p_a)
        buffer.put(p_b)
        buffer.put(p_c)
        this.position(buffer, 0)
        return buffer
    }

    def makeFloatBuffer4(p_a : Float, p_b : Float, p_c : Float, p_d : Float) : FloatBuffer = {
        val b : ByteBuffer = ByteBuffer.allocateDirect(4 * this.BYTES_PER_FLOAT)
        b.order(ByteOrder.nativeOrder())
        val buffer : FloatBuffer = b.asFloatBuffer()
        buffer.put(p_a)
        buffer.put(p_b)
        buffer.put(p_c)
        buffer.put(p_d)
        this.position(buffer, 0)
        return buffer
    }

    def makeFloatBuffer(byteBuffer : ByteBuffer) : FloatBuffer = {
        val b : ByteBuffer = ByteBuffer.allocateDirect(byteBuffer.limit() * this.BYTES_PER_FLOAT)
        b.order(ByteOrder.nativeOrder())
        val buffer : FloatBuffer = b.asFloatBuffer()
        var unsigned : Int = 0
        var v : Float = 0.0f

        {
            while (byteBuffer.hasRemaining()) {
                unsigned = (byteBuffer.get().toInt) & 0xFF
                v = (unsigned.toFloat) / 255f
                buffer.put(v)
            }
        }
        this.position(buffer, 0)
        return buffer
    }

    //Hack for Android Studio using internal JDK 11 or newer in builds.
    def position(buffer : Buffer, newPosition : Int) : Buffer = {
        return buffer.position(newPosition)
    }

    //When Shaders are enabled this should be done on the GPU
    def rotateUVs(uvs : Array[Float], angleDegrees : Float, pivotU : Float, pivotV : Float) : Unit = {
        val angleRad : Double = Math.toRadians(angleDegrees.toDouble)
        val cosA : Double = Math.cos(angleRad)
        val sinA : Double = Math.sin(angleRad)

        {
            var i : Int = 0
            while (i < uvs.length) {
                var u : Float = uvs(i)
                var v : Float = uvs(i + 1)
                var du : Float = u - pivotU
                var dv : Float = v - pivotV
                var ru : Float = ((du * cosA) - (dv * sinA)).toFloat + pivotU
                var rv : Float = ((du * sinA) + (dv * cosA)).toFloat + pivotV
                uvs(i) = ru
                uvs(i + 1) = rv
                i += 2
            }
        }
    }

}

object GLUtil {
    private val instance : GLUtil = new GLUtil()

    /**      * @return the instance      */
    def getInstance() : GLUtil = {
        return GLUtil.instance
    }

}


