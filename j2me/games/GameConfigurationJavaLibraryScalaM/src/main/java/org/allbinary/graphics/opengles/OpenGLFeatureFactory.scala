/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.opengles


class OpenGLFeatureFactory private() {
    import _root_.org.allbinary.graphics.opengles.OpenGLFeatureFactory.{*}

    val OPENGL_OPTIONS : OpenGLFeature = new OpenGLFeature("OpenGL Options")

    val OPENGL : OpenGLFeature = new OpenGLFeature("OpenGL")

    val OPENGL_SURFACE_VIEW : OpenGLFeature = new OpenGLFeature("GLSurfaceView")

    val OPENGL_2D : OpenGLFeature = new OpenGLFeature("OpenGL 2D")

    val OPENGL_3D : OpenGLFeature = new OpenGLFeature("OpenGL 3D")

    val OPENGL_2D_AND_3D : OpenGLFeature = new OpenGLFeature("OpenGL 2D/3D")

    // OpenGL Version
    val OPENGL_AUTO_SELECT : OpenGLFeature = new OpenGLFeature("Auto Select")

    val OPENGL_MINIMUM : OpenGLFeature = new OpenGLFeature("Minimum")

    // Threading
    val OPENGL_AS_GAME_THREAD : OpenGLFeature = new OpenGLFeature("As game thread")

    val OPENGL_AND_GAME_HAVE_DIFFERENT_THREADS : OpenGLFeature = new OpenGLFeature("As different threads")

    // Image Color Depth
    val IMAGE_COLOR_DEPTH_4444 : OpenGLFeature = new OpenGLFeature("4444")

    val IMAGE_COLOR_DEPTH_8888 : OpenGLFeature = new OpenGLFeature("8888")

    val IMAGE_COLOR_DEPTH_565 : OpenGLFeature = new OpenGLFeature("565")

    // OpenGL Color Depth
    val OPENGL_COLOR_DEPTH_4444 : OpenGLFeature = new OpenGLFeature("4444")

    val OPENGL_COLOR_DEPTH_8888 : OpenGLFeature = new OpenGLFeature("8888")

    val OPENGL_COLOR_DEPTH_565 : OpenGLFeature = new OpenGLFeature("565")

    val OPENGL_DRAW_TEXTURE : OpenGLFeature = new OpenGLFeature("GL_OES_draw_texture")

    val OPENGL_VERTEX_BUFFER_OBJECT : OpenGLFeature = new OpenGLFeature("vertex_buffer_object")

    val OPENGL_SIMPLE_OBJECT3D_PROCESSOR : OpenGLFeature = new OpenGLFeature("Simple Object3d Processor")

    val OPENGL_COMPLEX_OBJECT3D_PROCESSOR : OpenGLFeature = new OpenGLFeature("Complex Object3d Processor")

    val OPENGL_SIMPLE_TEXTURE_PROCESSOR : OpenGLFeature = new OpenGLFeature("Simple Texture Processor")

    val OPENGL_COMPLEX_TEXTURE_PROCESSOR : OpenGLFeature = new OpenGLFeature("Complex Texture Processor")

}

object OpenGLFeatureFactory {
    private val instance : OpenGLFeatureFactory = new OpenGLFeatureFactory()

    def getInstance() : OpenGLFeatureFactory = {
        return OpenGLFeatureFactory.instance
    }

}


