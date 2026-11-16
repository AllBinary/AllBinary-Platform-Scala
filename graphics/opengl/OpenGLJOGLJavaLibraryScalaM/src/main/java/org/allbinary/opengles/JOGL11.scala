/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *   */
/* Generated Code Do Not Modify */
package org.allbinary.opengles

import _root_.com.jogamp.opengl.GL
import _root_.com.jogamp.opengl.GL2

//JOGLEToKhronosGL11
class JOGL11(param_gl : GL, param_gl2 : _root_.com.jogamp.opengl.GL2) extends JOGL10(param_gl, param_gl2) with _root_.javax.microedition.khronos.opengles.GL11 {

    //    private final String TARGET = "target: ";
    private var gl11 : GL2 = null

    //Constructor
    {
        val gl : GL = param_gl
        val gl2 : _root_.com.jogamp.opengl.GL2 = param_gl2
        //PreLogUtil.put(StringUtil.getInstance().EMPTY_STRING, this, this.commonStrings.CONSTRUCTOR);
        this.gl11 = getJOGLGL()
    }

    def this(gl : GL) = {
        this(gl, gl.asInstanceOf[_root_.com.jogamp.opengl.GL2])
    }

    //    }
    def glBindBuffer(target : Int, buffer : Int) : Unit = {
        //PreLogUtil.put(stringBuilder.append(TARGET).append(target).append(" buffer: ").append(buffer).toString(), this, "GL11.glBindBuffer");
        this.gl11.glBindBuffer(target, buffer)
    }

    def glBufferData(target : Int, size : Int, data : _root_.java.nio.Buffer, usage : Int) : Unit = {
        //PreLogUtil.put(stringBuilder.append(TARGET).append(target).append(" size: ").append(size).append(" data: ").append(data).append(" usage: ").append(usage).toString(), this, "GL11.glBufferData");
        this.gl11.glBufferData(target, size, data, usage)
    }

    def glBufferSubData(target : Int, offset : Int, size : Int, data : _root_.java.nio.Buffer) : Unit = {
        //PreLogUtil.put(stringBuilder.append(TARGET).append(target).append(" size: ").append(size).append(" data: ").append(data).toString(), this, "GL11.glBufferSubData");
        this.gl11.glBufferSubData(target, offset, size, data)
    }

    def glClipPlanef(plane : Int, equation : Array[Float], offset : Int) : Unit = {
        //PreLogUtil.put(stringBuilder.append("plane: ").append(plane).append(" equation: ").append(equation.length).toString(), this, "GL11.glClipPlanef");
        this.gl11.glClipPlanef(plane, equation, offset)
    }

    def glClipPlanef(plane : Int, equation : _root_.java.nio.FloatBuffer) : Unit = {
        //PreLogUtil.put(stringBuilder.append("plane: ").append(plane).append(" equation: ").append(equation).toString(), this, "GL11.glClipPlanef");
        this.gl11.glClipPlanef(plane, equation)
    }

    //    }
    def glColor4ub(red : Byte, green : Byte, blue : Byte, alpha : Byte) : Unit = {
        //PreLogUtil.put(stringBuilder.append(RED).append(red).append(GREEN).append(green).append(BLUE).append(blue).append(ALPHA).append(alpha).toString(), this, "GL11.glColor4ub");
        this.gl11.glColor4ub(red, green, blue, alpha)
    }

    def glColorPointer(size : Int, `type` : Int, stride : Int, offset : Int) : Unit = {
        //PreLogUtil.put(stringBuilder.append(" size: ").append(size).append(" type: ").append(type).toString(), this, "GL11.glColorPointer");
        this.gl11.glColorPointer(size, `type`, stride, offset)
    }

    def glDeleteBuffers(n : Int, buffers : Array[Int], offset : Int) : Unit = {
        //PreLogUtil.put(stringBuilder.append(" n: ").append(n).append(" buffers: ").append(buffers.length).toString(), this, "GL11.glDeleteBuffers");
        this.gl11.glDeleteBuffers(n, buffers, offset)
    }

    def glDeleteBuffers(n : Int, buffers : _root_.java.nio.IntBuffer) : Unit = {
        //PreLogUtil.put(stringBuilder.append(" n: ").append(n).append(" buffers: ").append(buffers).toString(), this, "GL11.glDeleteBuffers");
        this.gl11.glDeleteBuffers(n, buffers)
    }

    def glDrawElements(mode : Int, count : Int, `type` : Int, offset : Int) : Unit = {
        //PreLogUtil.put(stringBuilder.append(" mode: ").append(mode).append(" count: ").append(count).append(" type: ").append(type).toString(), this, "GL11.glDrawElements");
        this.gl11.glDrawElements(mode, count, `type`, offset)
    }

    def glGenBuffers(n : Int, buffers : Array[Int], offset : Int) : Unit = {
        //PreLogUtil.put(stringBuilder.append(" n: ").append(n).append(" buffers: ").append(buffers.length).toString(), this, "GL11.glGenBuffers");
        this.gl11.glGenBuffers(n, buffers, offset)
    }

    def glGenBuffers(n : Int, buffers : _root_.java.nio.IntBuffer) : Unit = {
        //PreLogUtil.put(stringBuilder.append(" n: ").append(n).append(" buffers: ").append(buffers).toString(), this, "GL11.glGenBuffers");
        this.gl11.glGenBuffers(n, buffers)
    }

    //    }
    def glGetBufferParameteriv(target : Int, pname : Int, params : Array[Int], offset : Int) : Unit = {
        //PreLogUtil.put(stringBuilder.append(TARGET).append(target).append(PNAME).append(pname).append(PARAMS).append(params.length).toString(), this, "GL11.glGetBufferParameteriv");
        this.gl11.glGetBufferParameteriv(target, pname, params, offset)
    }

    def glGetBufferParameteriv(target : Int, pname : Int, params : _root_.java.nio.IntBuffer) : Unit = {
        //PreLogUtil.put(stringBuilder.append(TARGET).append(target).append(PNAME).append(pname).append(PARAMS).append(params).toString(), this, "GL11.glGetBufferParameteriv");
        this.gl11.glGetBufferParameteriv(target, pname, params)
    }

    def glGetClipPlanef(pname : Int, eqn : Array[Float], offset : Int) : Unit = {
        //PreLogUtil.put(stringBuilder.append(PNAME).append(pname).append(" eqn: ").append(eqn.length).toString(), this, "GL11.glGetClipPlanef");
        this.gl11.glGetClipPlanef(pname, eqn, offset)
    }

    def glGetClipPlanef(pname : Int, eqn : _root_.java.nio.FloatBuffer) : Unit = {
        //PreLogUtil.put(stringBuilder.append(PNAME).append(pname).append(" eqn: ").append(eqn).toString(), this, "GL11.glGetClipPlanef");
        this.gl11.glGetClipPlanef(pname, eqn)
    }

    //    }
    def glGetFloatv(pname : Int, params : Array[Float], offset : Int) : Unit = {
        //PreLogUtil.put(stringBuilder.append(PNAME).append(pname).append(PARAMS).append(params).toString(), this, "GL11.glGetFloatv");
        this.gl11.glGetFloatv(pname, params, offset)
    }

    def glGetFloatv(pname : Int, params : _root_.java.nio.FloatBuffer) : Unit = {
        //PreLogUtil.put(stringBuilder.append(PNAME).append(pname).append(PARAMS).append(params).toString(), this, "GL11.glGetFloatv");
        this.gl11.glGetFloatv(pname, params)
    }

    def glGetLightfv(light : Int, pname : Int, params : Array[Float], offset : Int) : Unit = {
        //PreLogUtil.put(stringBuilder.append(LIGHT).append(light).append(PNAME).append(pname).append(PARAMS).append(params).toString(), this, "GL11.glGetLightfv");
        this.gl11.glGetLightfv(light, pname, params, offset)
    }

    def glGetLightfv(light : Int, pname : Int, params : _root_.java.nio.FloatBuffer) : Unit = {
        //PreLogUtil.put(stringBuilder.append(LIGHT).append(light).append(PNAME).append(pname).append(PARAMS).append(params).toString(), this, "GL11.glGetLightfv");
        this.gl11.glGetLightfv(light, pname, params)
    }

    //    }
    def glGetMaterialfv(face : Int, pname : Int, params : Array[Float], offset : Int) : Unit = {
        //PreLogUtil.put(stringBuilder.append(FACE).append(face).append(PNAME).append(pname).append(PARAMS).append(params.length).toString(), this, "GL11.glGetMaterialfv");
        this.gl11.glGetMaterialfv(face, pname, params, offset)
    }

    def glGetMaterialfv(face : Int, pname : Int, params : _root_.java.nio.FloatBuffer) : Unit = {
        //PreLogUtil.put(stringBuilder.append(FACE).append(face).append(PNAME).append(pname).append(PARAMS).append(params).toString(), this, "GL11.glGetMaterialfv");
        this.gl11.glGetMaterialfv(face, pname, params)
    }

    //    }
    def glGetTexEnviv(env : Int, pname : Int, params : Array[Int], offset : Int) : Unit = {
        //PreLogUtil.put(stringBuilder.append("env: ").append(env).append(PNAME).append(pname).append(PARAMS).append(params).toString(), this, "GL11.glGetTexEnviv");
        this.gl11.glGetTexEnviv(env, pname, params, offset)
    }

    def glGetTexEnviv(env : Int, pname : Int, params : _root_.java.nio.IntBuffer) : Unit = {
        //PreLogUtil.put(stringBuilder.append("env: ").append(env).append(PNAME).append(pname).append(PARAMS).append(params).toString(), this, "GL11.glGetTexEnviv");
        this.gl11.glGetTexEnviv(env, pname, params)
    }

    //    }
    def glGetTexParameterfv(target : Int, pname : Int, params : Array[Float], offset : Int) : Unit = {
        //PreLogUtil.put(stringBuilder.append(TARGET).append(target).append(PNAME).append(pname).append(PARAMS).append(params.length).toString(), this, "GL11.glGetTexParameterfv");
        this.gl11.glGetTexParameterfv(target, pname, params, offset)
    }

    def glGetTexParameterfv(target : Int, pname : Int, params : _root_.java.nio.FloatBuffer) : Unit = {
        //PreLogUtil.put(stringBuilder.append(TARGET).append(target).append(PNAME).append(pname).append(PARAMS).append(params).toString(), this, "GL11.glGetTexParameterfv");
        this.gl11.glGetTexParameterfv(target, pname, params)
    }

    def glGetTexParameteriv(target : Int, pname : Int, params : Array[Int], offset : Int) : Unit = {
        //PreLogUtil.put(stringBuilder.append(TARGET).append(target).append(PNAME).append(pname).append(PARAMS).append(params).toString(), this, "GL11.glGetTexParameteriv");
        this.gl11.glGetTexParameteriv(target, pname, params, offset)
    }

    def glGetTexParameteriv(target : Int, pname : Int, params : _root_.java.nio.IntBuffer) : Unit = {
        //PreLogUtil.put(stringBuilder.append(TARGET).append(target).append(PNAME).append(pname).append(PARAMS).append(params).toString(), this, "GL11.glGetTexParameteriv");
        this.gl11.glGetTexParameteriv(target, pname, params)
    }

    //    }
    def glIsBuffer(buffer : Int) : Boolean = {
        //PreLogUtil.put(stringBuilder.append("buffer: ").append(buffer).toString(), this, "GL11.glIsBuffer");
        return this.gl11.glIsBuffer(buffer)
    }

    def glIsEnabled(cap : Int) : Boolean = {
        //PreLogUtil.put(stringBuilder.append("cap: ").append(cap).toString(), this, "GL11.glIsEnabled");
        return this.gl11.glIsEnabled(cap)
    }

    def glIsTexture(texture : Int) : Boolean = {
        //PreLogUtil.put(stringBuilder.append("texture: ").append(texture).toString(), this, "GL11.texture");
        return this.gl11.glIsTexture(texture)
    }

    def glNormalPointer(`type` : Int, stride : Int, offset : Int) : Unit = {
        //PreLogUtil.put(stringBuilder.append("type: ").append(type).append(" stride: ").append(stride).toString(), this, "GL11.glNormalPointer");
        this.gl11.glNormalPointer(`type`, stride, offset)
    }

    def glPointParameterf(pname : Int, param : Float) : Unit = {
        //PreLogUtil.put(stringBuilder.append(PNAME).append(pname).append(PARAM).append(param).toString(), this, "GL11.glPointParameterf");
        this.gl11.glPointParameterf(pname, param)
    }

    def glPointParameterfv(pname : Int, params : Array[Float], offset : Int) : Unit = {
        //PreLogUtil.put(stringBuilder.append(PNAME).append(pname).append(PARAMS).append(params).toString(), this, "GL11.glPointParameterfv");
        this.gl11.glPointParameterfv(pname, params, offset)
    }

    def glPointParameterfv(pname : Int, params : _root_.java.nio.FloatBuffer) : Unit = {
        //PreLogUtil.put(stringBuilder.append(PNAME).append(pname).append(PARAMS).append(params).toString(), this, "GL11.glPointParameterfv");
        this.gl11.glPointParameterfv(pname, params)
    }

    //    }
    def glTexCoordPointer(size : Int, `type` : Int, stride : Int, offset : Int) : Unit = {
        //PreLogUtil.put(stringBuilder.append("size: ").append(size).append(" type: ").append(type).append(" stride: ").append(stride).toString(), this, "GL11.glTexCoordPointer");
        this.gl11.glTexCoordPointer(size, `type`, stride, offset)
    }

    def glTexEnvi(target : Int, pname : Int, param : Int) : Unit = {
        //PreLogUtil.put(stringBuilder.append(TARGET).append(target).append(PNAME).append(pname).append(PARAM).append(param).toString(), this, "GL11.glTexEnvi");
        this.gl11.glTexEnvi(target, pname, param)
    }

    def glTexEnviv(target : Int, pname : Int, params : Array[Int], offset : Int) : Unit = {
        //PreLogUtil.put(stringBuilder.append(TARGET).append(target).append(PNAME).append(pname).append(PARAMS).append(params.length).toString(), this, "GL11.glTexEnvi");
        this.gl11.glTexEnviv(target, pname, params, offset)
    }

    def glTexEnviv(target : Int, pname : Int, params : _root_.java.nio.IntBuffer) : Unit = {
        //PreLogUtil.put(stringBuilder.append(TARGET).append(target).append(PNAME).append(pname).append(PARAMS).append(params).toString(), this, "GL11.glTexEnvi");
        this.gl11.glTexEnviv(target, pname, params)
    }

    def glTexParameterfv(target : Int, pname : Int, params : Array[Float], offset : Int) : Unit = {
        //PreLogUtil.put(stringBuilder.append(TARGET).append(target).append(PNAME).append(pname).append(PARAMS).append(params).toString(), this, "GL11.glTexParameterfv");
        this.gl11.glTexParameterfv(target, pname, params, offset)
    }

    def glTexParameterfv(target : Int, pname : Int, params : _root_.java.nio.FloatBuffer) : Unit = {
        //PreLogUtil.put(stringBuilder.append(TARGET).append(target).append(PNAME).append(pname).append(PARAMS).append(params).toString(), this, "GL11.glTexParameterfv");
        this.gl11.glTexParameterfv(target, pname, params)
    }

    override def glTexParameteri(target : Int, pname : Int, param : Int) : Unit = {
        //PreLogUtil.put(stringBuilder.append(TARGET).append(target).append(PNAME).append(pname).append(PARAM).append(param).toString(), this, "GL11.glTexParameteri");
        this.gl11.glTexParameteri(target, pname, param)
    }

    def glTexParameteriv(target : Int, pname : Int, params : Array[Int], offset : Int) : Unit = {
        //PreLogUtil.put(stringBuilder.append(TARGET).append(target).append(PNAME).append(pname).append(PARAMS).append(params).toString(), this, "GL11.glTexParameteriv");
        this.gl11.glTexParameteriv(target, pname, params, offset)
    }

    def glTexParameteriv(target : Int, pname : Int, params : _root_.java.nio.IntBuffer) : Unit = {
        //PreLogUtil.put(stringBuilder.append(TARGET).append(target).append(PNAME).append(pname).append(PARAMS).append(params).toString(), this, "GL11.glTexParameteriv");
        this.gl11.glTexParameteriv(target, pname, params)
    }

    def glTexParameterxv(target : Int, pname : Int, params : Array[Int], offset : Int) : Unit = {
        //PreLogUtil.put(stringBuilder.append(TARGET).append(target).append(PNAME).append(pname).append(PARAMS).append(params).toString(), this, "GL11.glTexParameteriv");
        this.gl11.glTexParameteriv(target, pname, params, offset)
    }

    //    }
    def glVertexPointer(size : Int, `type` : Int, stride : Int, offset : Int) : Unit = {
        //PreLogUtil.put(stringBuilder.append(" size: ").append(size).append(" type: ").append(type).toString(), this, "GL11.glVertexPointer");
        this.gl11.glVertexPointer(size, `type`, stride, offset)
    }

}


