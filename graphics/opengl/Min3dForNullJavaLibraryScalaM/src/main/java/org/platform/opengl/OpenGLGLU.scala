/* Generated Code Do Not Modify */
package org.platform.opengl

import _root_.javax.microedition.khronos.opengles.GL10

/**  *  * @author User  */
class OpenGLGLU {
    import _root_.org.platform.opengl.OpenGLGLU.{*}

    def gluLookAt(gl : GL10, eyeX : Float, eyeY : Float, eyeZ : Float, centerX : Float, centerY : Float, centerZ : Float, upX : Float, upY : Float, upZ : Float) : Unit = {
        throw new RuntimeException()
    }

    def gluProject(gl : GL10, objX : Float, objY : Float, objZ : Float, model : Array[Float], modelOffset : Int, project : Array[Float], projectOffset : Int, view : Array[Int], viewOffset : Int, win : Array[Float], winOffset : Int) : Int = {
        throw new RuntimeException()
    }

    def gluUnProject(gl : GL10, winX : Float, winY : Float, winZ : Float, model : Array[Float], modelOffset : Int, project : Array[Float], projectOffset : Int, view : Array[Int], viewOffset : Int, obj : Array[Float], objOffset : Int) : Int = {
        throw new RuntimeException()
    }

    //    }
    def glFrustumf(gl : GL10, lt : Float, rt : Float, btm : Float, top : Float, zNear : Float, zFar : Float) : Unit = {
        throw new RuntimeException()
    }

}

object OpenGLGLU {
    private val instance : OpenGLGLU = new OpenGLGLU()

    /**      * @return the instance      */
    def getInstance() : OpenGLGLU = {
        return OpenGLGLU.instance
    }

}


