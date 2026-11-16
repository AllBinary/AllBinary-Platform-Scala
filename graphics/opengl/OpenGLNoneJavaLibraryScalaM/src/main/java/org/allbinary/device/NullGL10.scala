/*  * AllBinary Open License Version 1  * Copyright (c) 2025 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.device

import _root_.javax.microedition.khronos.opengles.GL10
import _root_.java.nio.Buffer
import _root_.java.nio.FloatBuffer
import _root_.java.nio.IntBuffer
import _root_.org.allbinary.logic.string.StringUtil

/**  *  * @author User  */
class NullGL10 extends GL10 {
    import _root_.org.allbinary.device.NullGL10.{NULL_GL10 as _, *}
    def NULL_GL10 : NullGL10 = _root_.org.allbinary.device.NullGL10.NULL_GL10

    override def glActiveTexture(texture : Int) : Unit = {
        return
    }

    override def glAlphaFunc(func : Int, ref : Float) : Unit = {
        return
    }

    override def glBindTexture(target : Int, texture : Int) : Unit = {
        return
    }

    override def glBlendFunc(sfactor : Int, dfactor : Int) : Unit = {
        return
    }

    override def glClear(mask : Int) : Unit = {
        return
    }

    override def glClearColor(red : Float, green : Float, blue : Float, alpha : Float) : Unit = {
        return
    }

    override def glClearDepthf(depth : Float) : Unit = {
        return
    }

    override def glClearStencil(s : Int) : Unit = {
        return
    }

    override def glClientActiveTexture(texture : Int) : Unit = {
        return
    }

    override def glColor4f(red : Float, green : Float, blue : Float, alpha : Float) : Unit = {
        return
    }

    override def glColorMask(red : Boolean, green : Boolean, blue : Boolean, alpha : Boolean) : Unit = {
        return
    }

    override def glColorPointer(size : Int, `type` : Int, stride : Int, pointer : Buffer) : Unit = {
        return
    }

    override def glCompressedTexImage2D(target : Int, level : Int, internalformat : Int, width : Int, height : Int, border : Int, imageSize : Int, data : Buffer) : Unit = {
        return
    }

    override def glCompressedTexSubImage2D(target : Int, level : Int, xoffset : Int, yoffset : Int, width : Int, height : Int, format : Int, imageSize : Int, data : Buffer) : Unit = {
        return
    }

    override def glCopyTexImage2D(target : Int, level : Int, internalformat : Int, x : Int, y : Int, width : Int, height : Int, border : Int) : Unit = {
        return
    }

    override def glCopyTexSubImage2D(target : Int, level : Int, xoffset : Int, yoffset : Int, x : Int, y : Int, width : Int, height : Int) : Unit = {
        return
    }

    override def glCullFace(mode : Int) : Unit = {
        return
    }

    override def glDeleteTextures(n : Int, textures : Array[Int], offset : Int) : Unit = {
        return
    }

    override def glDeleteTextures(n : Int, textures : IntBuffer) : Unit = {
        return
    }

    override def glDepthFunc(func : Int) : Unit = {
        return
    }

    override def glDepthMask(flag : Boolean) : Unit = {
        return
    }

    override def glDepthRangef(zNear : Float, zFar : Float) : Unit = {
        return
    }

    override def glDisable(cap : Int) : Unit = {
        return
    }

    override def glDisableClientState(array : Int) : Unit = {
        return
    }

    override def glDrawArrays(mode : Int, first : Int, count : Int) : Unit = {
        return
    }

    override def glDrawElements(mode : Int, count : Int, `type` : Int, indices : Buffer) : Unit = {
        return
    }

    override def glEnable(cap : Int) : Unit = {
        return
    }

    override def glEnableClientState(array : Int) : Unit = {
        return
    }

    override def glFinish() : Unit = {
        return
    }

    override def glFlush() : Unit = {
        return
    }

    override def glFogf(pname : Int, param : Float) : Unit = {
        return
    }

    override def glFogfv(pname : Int, params : Array[Float], offset : Int) : Unit = {
        return
    }

    override def glFogfv(pname : Int, params : FloatBuffer) : Unit = {
        return
    }

    override def glFrontFace(mode : Int) : Unit = {
        return
    }

    override def glFrustumf(left : Float, right : Float, bottom : Float, top : Float, zNear : Float, zFar : Float) : Unit = {
        return
    }

    override def glGenTextures(n : Int, textures : Array[Int], offset : Int) : Unit = {
        return
    }

    override def glGenTextures(n : Int, textures : IntBuffer) : Unit = {
        return
    }

    override def glGetError() : Int = {
        return 0
    }

    override def glGetIntegerv(pname : Int, params : Array[Int], offset : Int) : Unit = {
        return
    }

    override def glGetIntegerv(pname : Int, params : IntBuffer) : Unit = {
        return
    }

    override def glGetString(name : Int) : String = {
        return StringUtil.getInstance().EMPTY_STRING
    }

    override def glHint(target : Int, mode : Int) : Unit = {
        return
    }

    override def glLightModelf(pname : Int, param : Float) : Unit = {
        return
    }

    override def glLightModelfv(pname : Int, params : Array[Float], offset : Int) : Unit = {
        return
    }

    override def glLightModelfv(pname : Int, params : FloatBuffer) : Unit = {
        return
    }

    override def glLightf(light : Int, pname : Int, param : Float) : Unit = {
        return
    }

    override def glLightfv(light : Int, pname : Int, params : Array[Float], offset : Int) : Unit = {
        return
    }

    override def glLightfv(light : Int, pname : Int, params : FloatBuffer) : Unit = {
        return
    }

    override def glLineWidth(width : Float) : Unit = {
        return
    }

    override def glLoadIdentity() : Unit = {
        return
    }

    override def glLoadMatrixf(m : Array[Float], offset : Int) : Unit = {
        return
    }

    override def glLoadMatrixf(m : FloatBuffer) : Unit = {
        return
    }

    override def glLogicOp(opcode : Int) : Unit = {
        return
    }

    override def glMaterialf(face : Int, pname : Int, param : Float) : Unit = {
        return
    }

    override def glMaterialfv(face : Int, pname : Int, params : Array[Float], offset : Int) : Unit = {
        return
    }

    override def glMaterialfv(face : Int, pname : Int, params : FloatBuffer) : Unit = {
        return
    }

    override def glMatrixMode(mode : Int) : Unit = {
        return
    }

    override def glMultMatrixf(m : Array[Float], offset : Int) : Unit = {
        return
    }

    override def glMultMatrixf(m : FloatBuffer) : Unit = {
        return
    }

    override def glMultiTexCoord4f(target : Int, s : Float, t : Float, r : Float, q : Float) : Unit = {
        return
    }

    override def glNormal3f(nx : Float, ny : Float, nz : Float) : Unit = {
        return
    }

    override def glNormalPointer(`type` : Int, stride : Int, pointer : Buffer) : Unit = {
        return
    }

    override def glOrthof(left : Float, right : Float, bottom : Float, top : Float, zNear : Float, zFar : Float) : Unit = {
        return
    }

    override def glPixelStorei(pname : Int, param : Int) : Unit = {
        return
    }

    override def glPointSize(size : Float) : Unit = {
        return
    }

    override def glPolygonOffset(factor : Float, units : Float) : Unit = {
        return
    }

    override def glPopMatrix() : Unit = {
        return
    }

    override def glPushMatrix() : Unit = {
        return
    }

    override def glReadPixels(x : Int, y : Int, width : Int, height : Int, format : Int, `type` : Int, pixels : Buffer) : Unit = {
        return
    }

    override def glRotatef(angle : Float, x : Float, y : Float, z : Float) : Unit = {
        return
    }

    override def glRotatex(angle : Int, x : Int, y : Int, z : Int) : Unit = {
        return
    }

    override def glSampleCoverage(value : Float, invert : Boolean) : Unit = {
        return
    }

    override def glScalef(x : Float, y : Float, z : Float) : Unit = {
        return
    }

    override def glScalex(x : Int, y : Int, z : Int) : Unit = {
        return
    }

    override def glScissor(x : Int, y : Int, width : Int, height : Int) : Unit = {
        return
    }

    override def glShadeModel(mode : Int) : Unit = {
        return
    }

    override def glStencilFunc(func : Int, ref : Int, mask : Int) : Unit = {
        return
    }

    override def glStencilMask(mask : Int) : Unit = {
        return
    }

    override def glStencilOp(fail : Int, zfail : Int, zpass : Int) : Unit = {
        return
    }

    override def glTexCoordPointer(size : Int, `type` : Int, stride : Int, pointer : Buffer) : Unit = {
        return
    }

    override def glTexEnvf(target : Int, pname : Int, param : Float) : Unit = {
        return
    }

    override def glTexEnvfv(target : Int, pname : Int, params : Array[Float], offset : Int) : Unit = {
        return
    }

    override def glTexEnvfv(target : Int, pname : Int, params : FloatBuffer) : Unit = {
        return
    }

    override def glTexImage2D(target : Int, level : Int, internalformat : Int, width : Int, height : Int, border : Int, format : Int, `type` : Int, pixels : Buffer) : Unit = {
        return
    }

    override def glTexParameterf(target : Int, pname : Int, param : Float) : Unit = {
        return
    }

    override def glTexParameteri(target : Int, pname : Int, param : Int) : Unit = {
        return
    }

    override def glTexSubImage2D(target : Int, level : Int, xoffset : Int, yoffset : Int, width : Int, height : Int, format : Int, `type` : Int, pixels : Buffer) : Unit = {
        return
    }

    override def glTranslatef(x : Float, y : Float, z : Float) : Unit = {
        return
    }

    override def glVertexPointer(size : Int, `type` : Int, stride : Int, pointer : Buffer) : Unit = {
        return
    }

    override def glViewport(x : Int, y : Int, width : Int, height : Int) : Unit = {
        return
    }

    override def glBegin(i : Int) : Unit = {
        return
    }

    override def glEnd() : Unit = {
        return
    }

    override def glVertex3f(f : Float, f2 : Float, f3 : Float) : Unit = {
        return
    }

    override def glPolygonMode(i : Int, i1 : Int) : Unit = {
        return
    }

}

object NullGL10 {
    val NULL_GL10 : NullGL10 = new NullGL10()

}


