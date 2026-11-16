/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *   */
/* Generated Code Do Not Modify */
package org.allbinary.opengles

import _root_.com.jogamp.opengl.glu.GLU

//JOGLEToKhronosGL10
class JOGL10(param_gl : _root_.com.jogamp.opengl.GL, param_gl2 : _root_.com.jogamp.opengl.GL2) extends _root_.javax.microedition.khronos.opengles.GL10 {

    //private final StringMaker stringBuilder = new StringMaker();
    val RED : String = "red: "

    val GREEN : String = " green: "

    val BLUE : String = " blue: "

    val ALPHA : String = " alpha: "

    val PNAME : String = "pname: "

    val _PNAME : String = " pname: "

    val PARAM : String = " param: "

    val PARAMS : String = " params: "

    val LIGHT : String = "light: "

    val FACE : String = "face: "

    val TARGET : String = "target: "

    //private final com.jogamp.opengl.GL2 gl2;
    private var gl10 : _root_.com.jogamp.opengl.GL2 = null

    var glu : GLU = null

    var GL_LINE : Int = 0

    var GL_QUAD_STRIP : Int = 0

    //    private final com.jogamp.opengl.GL4 gl4;
    //Constructor
    {
        val gl : _root_.com.jogamp.opengl.GL = param_gl
        val gl2 : _root_.com.jogamp.opengl.GL2 = param_gl2
        //this.gl10 = gl2es1;
        this.gl10 = gl2
        this.glu = GLU.createGLU(this.gl10)
        this.GL_LINE = _root_.com.jogamp.opengl.GL2.GL_LINE
        this.GL_QUAD_STRIP = _root_.com.jogamp.opengl.GL2.GL_QUAD_STRIP
    }

    def getJOGLGL() : _root_.com.jogamp.opengl.GL2 = {
        //return this.gl2;
        return this.gl10
    }

    //    }
    def glActiveTexture(texture : Int) : Unit = {
        //PreLogUtil.put("texture: " + texture, this, "GL10.glActiveTexture");
        this.gl10.glActiveTexture(texture)
    }

    def glAlphaFunc(func : Int, ref : Float) : Unit = {
        //PreLogUtil.put("func: " + func, this, "GL10.glAlphaFunc");
        this.gl10.glAlphaFunc(func, ref)
    }

    //    }
    def glBindTexture(target : Int, texture : Int) : Unit = {
        //PreLogUtil.put(stringBuilder.append(TARGET).append(target).append(" texture: ").append(texture).toString(), this, "GL10.glBindTexture");
        this.gl10.glBindTexture(target, texture)
    }

    def glBlendFunc(sfactor : Int, dfactor : Int) : Unit = {
        //PreLogUtil.put(stringBuilder.append("sfactor: ").append(sfactor).append(" dfactor: ").append(dfactor).toString(), this, "GL10.glBlendFunc");
        this.gl10.glBlendFunc(sfactor, dfactor)
    }

    def glClear(mask : Int) : Unit = {
        //PreLogUtil.put("mask: " + mask, this, "GL10.glClear");
        this.gl10.glClear(mask)
    }

    def glClearColor(red : Float, green : Float, blue : Float, alpha : Float) : Unit = {
        //PreLogUtil.put(stringBuilder.append(RED).append(red).append(GREEN).append(green).append(BLUE).append(blue).append(ALPHA).append(alpha).toString(), this, "GL10.glClearColor");
        this.gl10.glClearColor(red, green, blue, alpha)
    }

    //    }
    def glClearDepthf(depth : Float) : Unit = {
        //PreLogUtil.put("depth: " + depth, this, "GL10.glClearDepthf");
        this.gl10.glClearDepthf(depth)
    }

    //    }
    def glClearStencil(s : Int) : Unit = {
        //PreLogUtil.put("s: " + s, this, "GL10.glClearStencil");
        this.gl10.glClearStencil(s)
    }

    def glClientActiveTexture(texture : Int) : Unit = {
        //PreLogUtil.put("texture: " + texture, this, "GL10.glClientActiveTexture");
        this.gl10.glClientActiveTexture(texture)
    }

    def glColor4f(red : Float, green : Float, blue : Float, alpha : Float) : Unit = {
        //PreLogUtil.put(stringBuilder.append(RED).append(red).append(GREEN).append(green).append(BLUE).append(blue).append(ALPHA).append(alpha).toString(), this, "GL10.glColor4f");
        this.gl10.glColor4f(red, green, blue, alpha)
    }

    //    }
    def glColorMask(red : Boolean, green : Boolean, blue : Boolean, alpha : Boolean) : Unit = {
        //PreLogUtil.put(stringBuilder.append(RED).append(red).append(GREEN).append(green).append(BLUE).append(blue).append(ALPHA).append(alpha).toString(), this, "GL10.glColorMask");
        this.gl10.glColorMask(red, green, blue, alpha)
    }

    def glColorPointer(size : Int, `type` : Int, stride : Int, pointer : _root_.java.nio.Buffer) : Unit = {
        //PreLogUtil.put(stringBuilder.append("size: ").append(size).append(" type: ").append(type).append(" stride: ").append(stride).append(" pointer: ").append(pointer).toString(), this, "GL10.glColorPointer");
        this.gl10.glColorPointer(size, `type`, stride, pointer)
    }

    def glCompressedTexImage2D(target : Int, level : Int, internalformat : Int, width : Int, height : Int, border : Int, imageSize : Int, data : _root_.java.nio.Buffer) : Unit = {
        //PreLogUtil.put(stringBuilder.append("target: ").append(target).append(" level: ").append(level).append(" internalformat: ").append(internalformat).toString(), this, "GL10.glCompressedTexImage2D");
        this.gl10.glCompressedTexImage2D(target, level, internalformat, width, height, border, imageSize, data)
    }

    def glCompressedTexSubImage2D(target : Int, level : Int, xoffset : Int, yoffset : Int, width : Int, height : Int, format : Int, imageSize : Int, data : _root_.java.nio.Buffer) : Unit = {
        //PreLogUtil.put(stringBuilder.append("target: ").append(target).append(" level: ").append(level).append(" xoffset: ").append(xoffset).append(" yoffset: ").append(yoffset).toString(), this, "GL10.glCompressedTexSubImage2D");
        this.gl10.glCompressedTexSubImage2D(target, level, xoffset, yoffset, width, height, format, imageSize, data)
    }

    def glCopyTexImage2D(target : Int, level : Int, internalformat : Int, x : Int, y : Int, width : Int, height : Int, border : Int) : Unit = {
        //PreLogUtil.put(stringBuilder.append("target: ").append(target).append(" level: ").append(level).toString(), this, "GL10.glCopyTexImage2D");
        this.gl10.glCopyTexImage2D(target, level, internalformat, x, y, width, height, border)
    }

    def glCopyTexSubImage2D(target : Int, level : Int, xoffset : Int, yoffset : Int, x : Int, y : Int, width : Int, height : Int) : Unit = {
        //PreLogUtil.put(stringBuilder.append("target: ").append(target).append(" level: ").append(level).append(" xoffset: ").append(xoffset).append(" yoffset: ").append(yoffset).toString(), this, "GL10.glCompressedTexSubImage2D");
        this.gl10.glCopyTexSubImage2D(target, level, xoffset, yoffset, x, y, width, height)
    }

    def glCullFace(mode : Int) : Unit = {
        //PreLogUtil.put("mode: " + mode, this, "GL10.glCullFace");
        this.gl10.glCullFace(mode)
    }

    def glDeleteTextures(n : Int, textures : Array[Int], offset : Int) : Unit = {
        //PreLogUtil.put(stringBuilder.append("n: ").append(n).append(" textures: ").append(textures.length).toString(), this, "GL10.glDeleteTextures");
        this.gl10.glDeleteTextures(n, textures, offset)
    }

    def glDeleteTextures(n : Int, textures : _root_.java.nio.IntBuffer) : Unit = {
        //PreLogUtil.put(stringBuilder.append("n: ").append(n).append(" textures: ").append(textures).toString(), this, "GL10.glDeleteTextures");
        this.gl10.glDeleteTextures(n, textures)
    }

    def glDepthFunc(func : Int) : Unit = {
        //PreLogUtil.put("func: " + func, this, "GL10.glDepthFunc");
        this.gl10.glDepthFunc(func)
    }

    def glDepthMask(flag : Boolean) : Unit = {
        //PreLogUtil.put("flag: " + flag, this, "GL10.glDepthMask");
        this.gl10.glDepthMask(flag)
    }

    def glDepthRangef(zNear : Float, zFar : Float) : Unit = {
        //PreLogUtil.put(stringBuilder.append("zNear: ").append(zNear).append(" zFar: ").append(zFar).toString(), this, "GL10.glDepthRangef");
        this.gl10.glDepthRangef(zNear, zFar)
    }

    //    }
    def glDisable(cap : Int) : Unit = {
        //PreLogUtil.put("cap: " + cap, this, "GL10.glDisable");
        this.gl10.glDisable(cap)
    }

    def glDisableClientState(array : Int) : Unit = {
        //PreLogUtil.put("array: " + array, this, "GL10.glDisableClientState");
        this.gl10.glDisableClientState(array)
    }

    def glDrawArrays(mode : Int, first : Int, count : Int) : Unit = {
        //PreLogUtil.put(stringBuilder.append("mode: ").append(mode).append(" first: ").append(first).append(" count: ").append(count).toString(), this, "GL10.glDrawArrays");
        this.gl10.glDrawArrays(mode, first, count)
    }

    def glDrawElements(mode : Int, count : Int, `type` : Int, indices : _root_.java.nio.Buffer) : Unit = {
        //PreLogUtil.put(stringBuilder.append("mode: ").append(mode).append(" count: ").append(count).append(" type: ").append(type).append(" indices: ").append(indices).toString(), this, "GL10.glDrawElements");
        this.gl10.glDrawElements(mode, count, `type`, indices)
    }

    def glEnable(cap : Int) : Unit = {
        //PreLogUtil.put("cap: " + cap, this, "GL10.glEnable");
        this.gl10.glEnable(cap)
    }

    def glEnableClientState(array : Int) : Unit = {
        //PreLogUtil.put("array: " + array, this, "GL10.glEnableClientState");
        this.gl10.glEnableClientState(array)
    }

    def glFinish() : Unit = {
        //PreLogUtil.put(StringUtil.getInstance().EMPTY_STRING, this, "GL10.glFinish");
        this.gl10.glFinish()
    }

    def glFlush() : Unit = {
        //PreLogUtil.put(StringUtil.getInstance().EMPTY_STRING, this, "GL10.glFlush");
        this.gl10.glFlush()
    }

    def glFogf(pname : Int, param : Float) : Unit = {
        //PreLogUtil.put(stringBuilder.append(PNAME).append(pname).append(PARAM).append(param).toString(), this, "GL10.glFogf");
        this.gl10.glFogf(pname, param)
    }

    def glFogfv(pname : Int, params : Array[Float], offset : Int) : Unit = {
        //PreLogUtil.put(stringBuilder.append(PNAME).append(pname).append(PARAMS).append(params.length).toString(), this, "GL10.glFogfv");
        this.gl10.glFogfv(pname, params, offset)
    }

    def glFogfv(pname : Int, params : _root_.java.nio.FloatBuffer) : Unit = {
        //PreLogUtil.put(stringBuilder.append(PNAME).append(pname).append(PARAMS).append(params).toString(), this, "GL10.glFogfv");
        this.gl10.glFogfv(pname, params)
    }

    //    }
    def glFrontFace(mode : Int) : Unit = {
        //PreLogUtil.put("mode: " + mode, this, "GL10.glFrontFace");
        this.gl10.glFrontFace(mode)
    }

    def glFrustumf(left : Float, right : Float, bottom : Float, top : Float, zNear : Float, zFar : Float) : Unit = {
        //PreLogUtil.put(stringBuilder.append("left: ").append(left).append(" right: ").append(right).append(" bottom: ").append(bottom).append(" top: ").append(top).toString(), this, "GL10.glFrustumf");
        this.gl10.glFrustumf(left, right, bottom, top, zNear, zFar)
    }

    //    }
    def glGenTextures(n : Int, textures : Array[Int], offset : Int) : Unit = {
        //PreLogUtil.put(stringBuilder.append("n: ").append(n).append(" textures: ").append(textures.length).toString(), this, "GL10.glGenTextures");
        this.gl10.glGenTextures(n, textures, offset)
    }

    def glGenTextures(n : Int, textures : _root_.java.nio.IntBuffer) : Unit = {
        //PreLogUtil.put(stringBuilder.append("n: ").append(n).append(" textures: ").append(textures).toString(), this, "GL10.glGenTextures");
        this.gl10.glGenTextures(n, textures)
    }

    def glGetError() : Int = {
        return this.gl10.glGetError()
    }

    def glGetIntegerv(pname : Int, params : Array[Int], offset : Int) : Unit = {
        //PreLogUtil.put(stringBuilder.append(PNAME).append(pname).append(PARAMS).append(params.length).toString(), this, "GL10.glGetIntegerv");
        this.gl10.glGetIntegerv(pname, params, offset)
    }

    def glGetIntegerv(pname : Int, params : _root_.java.nio.IntBuffer) : Unit = {
        //PreLogUtil.put(stringBuilder.append(PNAME).append(pname).append(PARAMS).append(params).toString(), this, "GL10.glGetIntegerv");
        this.gl10.glGetIntegerv(pname, params)
    }

    def glGetString(name : Int) : String = {
        return this.gl10.glGetString(name)
    }

    def glHint(target : Int, mode : Int) : Unit = {
        //PreLogUtil.put(stringBuilder.append(TARGET).append(target).append(" mode: ").append(mode).toString(), this, "GL10.glHint");
        this.gl10.glHint(target, mode)
    }

    def glLightModelf(pname : Int, param : Float) : Unit = {
        //PreLogUtil.put(stringBuilder.append(PNAME).append(pname).append(PARAM).append(param).toString(), this, "GL10.glLightModelf");
        this.gl10.glLightModelf(pname, param)
    }

    def glLightModelfv(pname : Int, params : Array[Float], offset : Int) : Unit = {
        //PreLogUtil.put(stringBuilder.append(PNAME).append(pname).append(PARAMS).append(params.length).toString(), this, "GL10.glLightModelfv");
        this.gl10.glLightModelfv(pname, params, offset)
    }

    def glLightModelfv(pname : Int, params : _root_.java.nio.FloatBuffer) : Unit = {
        //PreLogUtil.put(stringBuilder.append(PNAME).append(pname).append(PARAMS).append(params).toString(), this, "GL10.glLightModelfv");
        this.gl10.glLightModelfv(pname, params)
    }

    //    }
    def glLightf(light : Int, pname : Int, param : Float) : Unit = {
        //PreLogUtil.put(stringBuilder.append(LIGHT).append(light).append(PNAME).append(pname).append(PARAM).append(param).toString(), this, "GL10.glLightf");
        this.gl10.glLightf(light, pname, param)
    }

    def glLightfv(light : Int, pname : Int, params : Array[Float], offset : Int) : Unit = {
        //PreLogUtil.put(stringBuilder.append(LIGHT).append(light).append(PNAME).append(pname).append(PARAMS).append(params).toString(), this, "GL10.glLightfv");
        this.gl10.glLightfv(light, pname, params, offset)
    }

    def glLightfv(light : Int, pname : Int, params : _root_.java.nio.FloatBuffer) : Unit = {
        //PreLogUtil.put(stringBuilder.append(LIGHT).append(light).append(PNAME).append(pname).append(PARAMS).append(params).toString(), this, "GL10.glLightfv");
        this.gl10.glLightfv(light, pname, params)
    }

    //    }
    def glLineWidth(width : Float) : Unit = {
        //PreLogUtil.put(commonLabels.W + width, this, "GL10.glLineWidth");
        this.gl10.glLineWidth(width)
    }

    //    }
    def glLoadIdentity() : Unit = {
        //PreLogUtil.put(StringUtil.getInstance().EMPTY_STRING, this, "GL10.glLoadIdentity");
        this.gl10.glLoadIdentity()
    }

    def glLoadMatrixf(m : Array[Float], offset : Int) : Unit = {
        //PreLogUtil.put("m: " + m.length, this, "GL10.glLoadMatrixf");
        this.gl10.glLoadMatrixf(m, offset)
    }

    def glLoadMatrixf(m : _root_.java.nio.FloatBuffer) : Unit = {
        //PreLogUtil.put("m: " + m, this, "GL10.glLoadMatrixf");
        this.gl10.glLoadMatrixf(m)
    }

    //    }
    def glLogicOp(opcode : Int) : Unit = {
        //PreLogUtil.put("opcode: " + opcode, this, "GL10.glLogicOp");
        this.gl10.glLogicOp(opcode)
    }

    def glMaterialf(face : Int, pname : Int, param : Float) : Unit = {
        //PreLogUtil.put(stringBuilder.append(FACE).append(face).append(PNAME).append(pname).append(PARAM).append(param).toString(), this, "GL10.glMaterialf");
        this.gl10.glMaterialf(face, pname, param)
    }

    def glMaterialfv(face : Int, pname : Int, params : Array[Float], offset : Int) : Unit = {
        //PreLogUtil.put(stringBuilder.append(FACE).append(face).append(PNAME).append(pname).append(PARAMS).append(params).toString(), this, "GL10.glMaterialfv");
        this.gl10.glMaterialfv(face, pname, params, offset)
    }

    def glMaterialfv(face : Int, pname : Int, params : _root_.java.nio.FloatBuffer) : Unit = {
        //PreLogUtil.put(stringBuilder.append(FACE).append(face).append(PNAME).append(pname).append(PARAMS).append(params).toString(), this, "GL10.glMaterialfv");
        this.gl10.glMaterialfv(face, pname, params)
    }

    //    }
    def glMatrixMode(mode : Int) : Unit = {
        //PreLogUtil.put("mode: " + mode, this, "GL10.glMatrixMode");
        this.gl10.glMatrixMode(mode)
    }

    def glMultMatrixf(m : Array[Float], offset : Int) : Unit = {
        //PreLogUtil.put("m: " + m, this, "GL10.glMultMatrixf");
        this.gl10.glMultMatrixf(m, offset)
    }

    def glMultMatrixf(m : _root_.java.nio.FloatBuffer) : Unit = {
        //PreLogUtil.put("m: " + m, this, "GL10.glMultMatrixf");
        this.gl10.glMultMatrixf(m)
    }

    //    }
    def glMultiTexCoord4f(target : Int, s : Float, t : Float, r : Float, q : Float) : Unit = {
        //PreLogUtil.put(stringBuilder.append(TARGET).append(target).append(" s: ").append(s).append(" t: ").append(t).append(" r: ").append(r).append(" q: ").append(q).toString(), this, "GL10.glMultiTexCoord4f");
        this.gl10.glMultiTexCoord4f(target, s, t, r, q)
    }

    //    }
    def glNormal3f(nx : Float, ny : Float, nz : Float) : Unit = {
        //PreLogUtil.put(stringBuilder.append(TARGET).append(nx).append(" nx: ").append(nx).append(" ny: ").append(ny).append(" nz: ").append(nz).toString(), this, "GL10.glNormal3f");
        this.gl10.glNormal3f(nx, ny, nz)
    }

    //    }
    def glNormalPointer(`type` : Int, stride : Int, pointer : _root_.java.nio.Buffer) : Unit = {
        //PreLogUtil.put(stringBuilder.append("type: ").append(type).append(" stride: ").append(stride).toString(), this, "GL10.glNormalPointer");
        this.gl10.glNormalPointer(`type`, stride, pointer)
    }

    def glOrthof(left : Float, right : Float, bottom : Float, top : Float, zNear : Float, zFar : Float) : Unit = {
        //PreLogUtil.put(stringBuilder.append("left: ").append(left).append(" right: ").append(right).append(" bottom: ").append(bottom).append(" top: ").append(top).toString(), this, "GL10.glOrthof");
        this.gl10.glOrthof(left, right, bottom, top, zNear, zFar)
    }

    //    }
    def glPixelStorei(pname : Int, param : Int) : Unit = {
        //PreLogUtil.put(stringBuilder.append(PNAME).append(pname).append(PARAM).append(param).toString(), this, "GL10.glPixelStorei");
        this.gl10.glPixelStorei(pname, param)
    }

    def glPointSize(size : Float) : Unit = {
        //PreLogUtil.put("size: " + size, this, "GL10.glPointSize");
        this.gl10.glPointSize(size)
    }

    //    }
    def glPolygonOffset(factor : Float, units : Float) : Unit = {
        //PreLogUtil.put(stringBuilder.append("factor: ").append(factor).append(" units: ").append(units).toString(), this, "GL10.glPolygonOffset");
        this.gl10.glPolygonOffset(factor, units)
    }

    //    }
    def glPopMatrix() : Unit = {
        //PreLogUtil.put(StringUtil.getInstance().EMPTY_STRING, this, "GL10.glPopMatrix");
        this.gl10.glPopMatrix()
    }

    def glPushMatrix() : Unit = {
        //PreLogUtil.put(StringUtil.getInstance().EMPTY_STRING, this, "GL10.glPushMatrix");
        this.gl10.glPushMatrix()
    }

    def glReadPixels(x : Int, y : Int, width : Int, height : Int, format : Int, `type` : Int, pixels : _root_.java.nio.Buffer) : Unit = {
        //PreLogUtil.put(stringBuilder.append("x: ").append(x).append(" y: ").append(y).append(commonLabels.W).append(width).append(commonLabels.H).append(height).toString(), this, "GL10.glReadPixels");
        this.gl10.glReadPixels(x, y, width, height, format, `type`, pixels)
    }

    def glRotatef(angle : Float, x : Float, y : Float, z : Float) : Unit = {
        //PreLogUtil.put(stringBuilder.append("x: ").append(x).append(" y: ").append(y).append(" z: ").append(z).toString(), this, "GL10.glRotatef");
        this.gl10.glRotatef(angle, x, y, z)
    }

    def glRotatex(angle : Int, x : Int, y : Int, z : Int) : Unit = {
        //this.gl10.glRotatex(angle, x, y, z);
        this.gl10.glRotatef(angle, x, y, z)
    }

    def glSampleCoverage(value : Float, invert : Boolean) : Unit = {
        //PreLogUtil.put(stringBuilder.append("value: ").append(value).append(" invert: ").append(invert).toString(), this, "GL10.glSampleCoverage");
        this.gl10.glSampleCoverage(value, invert)
    }

    //    }
    def glScalef(x : Float, y : Float, z : Float) : Unit = {
        //PreLogUtil.put(stringBuilder.append("x: ").append(x).append(" y: ").append(y).append(" z: ").append(z).toString(), this, "GL10.glScalef");
        this.gl10.glScalef(x, y, z)
    }

    def glScalex(x : Int, y : Int, z : Int) : Unit = {
        //this.gl10.glScalex(x, y, z);
        this.gl10.glScalef(x, y, z)
    }

    def glScissor(x : Int, y : Int, width : Int, height : Int) : Unit = {
        //PreLogUtil.put(stringBuilder.append("x: ").append(x).append(" y: ").append(y).append(commonLabels.W).append(width).append(commonLabels.H).append(height).toString(), this, "GL10.glScissor");
        this.gl10.glScissor(x, y, width, height)
    }

    def glShadeModel(mode : Int) : Unit = {
        //PreLogUtil.put("mode: " + mode, this, "GL10.glShadeModel");
        this.gl10.glShadeModel(mode)
    }

    def glStencilFunc(func : Int, ref : Int, mask : Int) : Unit = {
        //PreLogUtil.put(stringBuilder.append("func: ").append(func).append(" ref: ").append(ref).append(" mask: ").append(mask).toString(), this, "GL10.glStencilFunc");
        this.gl10.glStencilFunc(func, ref, mask)
    }

    def glStencilMask(mask : Int) : Unit = {
        //PreLogUtil.put("mask: " + mask, this, "GL10.glStencilMask");
        this.gl10.glStencilMask(mask)
    }

    def glStencilOp(fail : Int, zfail : Int, zpass : Int) : Unit = {
        //PreLogUtil.put(stringBuilder.append("fail: ").append(fail).append(" zfail: ").append(zfail).append(" zpass: ").append(zpass).toString(), this, "GL10.glStencilOp");
        this.gl10.glStencilOp(fail, zfail, zpass)
    }

    def glTexCoordPointer(size : Int, `type` : Int, stride : Int, pointer : _root_.java.nio.Buffer) : Unit = {
        //PreLogUtil.put(stringBuilder.append("size: ").append(size).append(" type: ").append(type).append(" stride: ").append(stride).toString(), this, "GL10.glTexCoordPointer");
        this.gl10.glTexCoordPointer(size, `type`, stride, pointer)
    }

    def glTexEnvf(target : Int, pname : Int, param : Float) : Unit = {
        //PreLogUtil.put(stringBuilder.append(TARGET).append(target).append(_PNAME).append(pname).append(PARAM).append(param).toString(), this, "GL10.glTexEnvf");
        this.gl10.glTexEnvf(target, pname, param)
    }

    def glTexEnvfv(target : Int, pname : Int, params : Array[Float], offset : Int) : Unit = {
        //PreLogUtil.put(stringBuilder.append(TARGET).append(target).append(_PNAME).append(pname).append(PARAMS).append(params).toString(), this, "GL10.glTexEnvf");
        this.gl10.glTexEnvfv(target, pname, params, offset)
    }

    def glTexEnvfv(target : Int, pname : Int, params : _root_.java.nio.FloatBuffer) : Unit = {
        //PreLogUtil.put(stringBuilder.append(TARGET).append(target).append(_PNAME).append(pname).append(PARAMS).append(params).toString(), this, "GL10.glTexEnvf");
        this.gl10.glTexEnvfv(target, pname, params)
    }

    //    }
    def glTexImage2D(target : Int, level : Int, internalformat : Int, width : Int, height : Int, border : Int, format : Int, `type` : Int, pixels : _root_.java.nio.Buffer) : Unit = {
        //PreLogUtil.put(stringBuilder.append(TARGET).append(target).append(" level: ").append(level).append(" internalformat: ").append(internalformat).toString(), this, "GL10.glTexImage2D");
        this.gl10.glTexImage2D(target, level, internalformat, width, height, border, format, `type`, pixels)
    }

    def glTexParameterf(target : Int, pname : Int, param : Float) : Unit = {
        //PreLogUtil.put(stringBuilder.append(TARGET).append(target).append(_PNAME).append(pname).append(PARAM).append(param).toString(), this, "GL10.glTexParameterf");
        this.gl10.glTexParameterf(target, pname, param)
    }

    def glTexParameteri(target : Int, pname : Int, param : Int) : Unit = {
        //PreLogUtil.put(stringBuilder.append(TARGET).append(target).append(_PNAME).append(pname).append(PARAM).append(param).toString(), this, "GL10.glTexParameterx");
        this.gl10.glTexParameteri(target, pname, param)
    }

    //    }
    def glTexSubImage2D(target : Int, level : Int, xoffset : Int, yoffset : Int, width : Int, height : Int, format : Int, `type` : Int, pixels : _root_.java.nio.Buffer) : Unit = {
        //PreLogUtil.put(stringBuilder.append(TARGET).append(target).append(" level: ").append(level).append(" xoffset: ").append(xoffset).toString(), this, "GL10.glTexSubImage2D");
        this.gl10.glTexSubImage2D(target, level, xoffset, yoffset, width, height, format, `type`, pixels)
    }

    def glTranslatef(x : Float, y : Float, z : Float) : Unit = {
        //PreLogUtil.put(stringBuilder.append("x: ").append(x).append(" y: ").append(y).append(" z: ").append(z).toString(), this, "GL10.glTranslatef");
        this.gl10.glTranslatef(x, y, z)
    }

    //    }
    def glVertexPointer(size : Int, `type` : Int, stride : Int, pointer : _root_.java.nio.Buffer) : Unit = {
        //PreLogUtil.put(stringBuilder.append("size: ").append(size).append(" type: ").append(type).append(" stride: ").append(stride).toString(), this, "GL10.glVertexPointer");
        this.gl10.glVertexPointer(size, `type`, stride, pointer)
    }

    def glViewport(x : Int, y : Int, width : Int, height : Int) : Unit = {
        //PreLogUtil.put(stringBuilder.append("x: ").append(x).append(" y: ").append(y).append(commonLabels.W).append(width).append(commonLabels.H).append(height).toString(), this, "GL10.glViewport");
        this.gl10.glViewport(x, y, width, height)
    }

    //These below are for the example only
    def glBegin(i : Int) : Unit = {
        //PreLogUtil.put(stringBuilder.append("x: ").append(x).append(" y: ").append(y).append(commonLabels.W).append(width).append(commonLabels.H).append(height).toString(), this, "GL10.glViewport");
        this.gl10.glBegin(i)
    }

    def glEnd() : Unit = {
        //PreLogUtil.put(stringBuilder.append("x: ").append(x).append(" y: ").append(y).append(commonLabels.W).append(width).append(commonLabels.H).append(height).toString(), this, "GL10.glViewport");
        this.gl10.glEnd()
    }

    def glVertex3f(f : Float, f2 : Float, f3 : Float) : Unit = {
        this.gl10.glVertex3f(f, f2, f3)
    }

    def glPolygonMode(i : Int, i1 : Int) : Unit = {
        this.gl10.glPolygonMode(i, i1)
    }

}


