/* Generated Code Do Not Modify */
package javax.microedition.khronos.opengles

import _root_.java.nio.Buffer
import _root_.java.nio.FloatBuffer
import _root_.java.nio.IntBuffer
import _root_.java.nio.ShortBuffer

trait GL11Ext extends GL {
    import _root_.javax.microedition.khronos.opengles.GL11Ext.{*}

    def glTexParameterfv(target : Int, pname : Int, param : Array[Float], offset : Int) : Unit

    def glCurrentPaletteMatrixOES(matrixpaletteindex : Int) : Unit

    def glDrawTexfOES(x : Float, y : Float, z : Float, width : Float, height : Float) : Unit

    def glDrawTexfvOES(coords : Array[Float], offset : Int) : Unit

    def glDrawTexfvOES(coords : FloatBuffer) : Unit

    def glDrawTexiOES(x : Int, y : Int, z : Int, width : Int, height : Int) : Unit

    def glDrawTexivOES(coords : Array[Int], offset : Int) : Unit

    def glDrawTexivOES(coords : IntBuffer) : Unit

    def glDrawTexsOES(x : Short, y : Short, z : Short, width : Short, height : Short) : Unit

    def glDrawTexsvOES(coords : Array[Short], offset : Int) : Unit

    def glDrawTexsvOES(coords : ShortBuffer) : Unit

    def glDrawTexxOES(x : Int, y : Int, z : Int, width : Int, height : Int) : Unit

    def glDrawTexxvOES(coords : Array[Int], offset : Int) : Unit

    def glDrawTexxvOES(coords : IntBuffer) : Unit

    def glEnable(cap : Int) : Unit

    def glEnableClientState(array : Int) : Unit

    def glLoadPaletteFromModelViewMatrixOES() : Unit

    def glMatrixIndexPointerOES(size : Int, `type` : Int, stride : Int, pointer : Buffer) : Unit

    def glMatrixIndexPointerOES(size : Int, `type` : Int, stride : Int, offset : Int) : Unit

    def glWeightPointerOES(size : Int, `type` : Int, stride : Int, pointer : Buffer) : Unit

    def glWeightPointerOES(size : Int, `type` : Int, stride : Int, offset : Int) : Unit

}

object GL11Ext {
    val GL_MATRIX_INDEX_ARRAY_BUFFER_BINDING_OES : Int = 35742

    val GL_MATRIX_INDEX_ARRAY_OES : Int = 34884

    val GL_MATRIX_INDEX_ARRAY_POINTER_OES : Int = 34889

    val GL_MATRIX_INDEX_ARRAY_SIZE_OES : Int = 34886

    val GL_MATRIX_INDEX_ARRAY_STRIDE_OES : Int = 34888

    val GL_MATRIX_INDEX_ARRAY_TYPE_OES : Int = 34887

    val GL_MATRIX_PALETTE_OES : Int = 34880

    val GL_MAX_PALETTE_MATRICES_OES : Int = 34882

    val GL_MAX_VERTEX_UNITS_OES : Int = 34468

    val GL_TEXTURE_CROP_RECT_OES : Int = 35741

    val GL_WEIGHT_ARRAY_BUFFER_BINDING_OES : Int = 34974

    val GL_WEIGHT_ARRAY_OES : Int = 34477

    val GL_WEIGHT_ARRAY_POINTER_OES : Int = 34476

    val GL_WEIGHT_ARRAY_SIZE_OES : Int = 34475

    val GL_WEIGHT_ARRAY_STRIDE_OES : Int = 34474

    val GL_WEIGHT_ARRAY_TYPE_OES : Int = 34473

}


