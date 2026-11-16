/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.opengles

import _root_.javax.microedition.lcdui.Displayable
import _root_.org.allbinary.J2MEUtil
import _root_.org.allbinary.game.configuration.feature.Features
import _root_.org.allbinary.game.displayable.canvas.AllBinaryGameCanvas
import _root_.org.allbinary.game.displayable.canvas.DemoCanvas
import _root_.org.allbinary.game.displayable.canvas.GameInputMappingCanvas
import _root_.org.allbinary.game.displayable.canvas.GameInputMappingInstructionsCanvas
import _root_.org.allbinary.game.displayable.canvas.GameRunnable
import _root_.org.allbinary.game.displayable.canvas.NullDisplayable
import _root_.org.allbinary.game.displayable.canvas.NullWaitGameRunnable
import _root_.org.allbinary.game.layer.SWTUtil
import _root_.org.allbinary.game.score.displayable.HighScoresCanvas
import _root_.org.allbinary.graphics.GraphicsStrings
import _root_.org.allbinary.graphics.displayable.CanvasStrings
import _root_.org.allbinary.graphics.displayable.MyCanvas
import _root_.org.allbinary.logic.communication.log.PreLogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.string.CommonSeps
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.thread.NullRunnable
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD

/*//JSNI Expose so JSNI can access this class *** 
 globalThis.org = globalThis.org || {}; 
 globalThis.org.allbinary = globalThis.org.allbinary || {}; 
 globalThis.org.allbinary.graphics = globalThis.org.allbinary.graphics || {}; 
 globalThis.org.allbinary.graphics.opengles = globalThis.org.allbinary.graphics.opengles || {}; 
 globalThis.org.allbinary.graphics.opengles.CurrentDisplayableFactory = CurrentDisplayableFactory; 
 console.log('Exported CurrentDisplayableFactory as globalThis'); 
 */
class CurrentDisplayableFactory private() {
    import _root_.org.allbinary.graphics.opengles.CurrentDisplayableFactory.{*}

    private val commonStrings : CommonStrings = CommonStrings.getInstance()

    private val canvasStrings : CanvasStrings = CanvasStrings.getInstance()

    private val stringUtil : StringUtil = StringUtil.getInstance()

    private val SET_DISPLAYABLE : String = "setDisplayable"

    private val SET_RUNNABLE : String = "setRunnable"

    private val CLEAR_RUNNABLE : String = "clearRunnable"

    private val SET_USED_RUNNABLE : String = "setUsedRunnable"

    private val RUNNABLE : String = "Runnable: "

    private val RUNNABLE_WAS_ALREADY_IN_USE : String = "Runnable was already in use: "

    val DEFAULT_CHILD_NAME_LIST : BasicArrayList = new BasicArrayListD()

    private var displayable : Displayable = NullDisplayable.getInstance()

    private var openGlReadydisplayable : Displayable = NullDisplayable.getInstance()

    private var runnable : GameRunnable = NullWaitGameRunnable.getInstance()

    private var usedRunnable : GameRunnable = NullWaitGameRunnable.getInstance()

    //Constructor
    {
        this.DEFAULT_CHILD_NAME_LIST.add(this.canvasStrings.ABOUT)
        this.DEFAULT_CHILD_NAME_LIST.add(this.canvasStrings.OPTIONS)
        this.DEFAULT_CHILD_NAME_LIST.add(GameInputMappingCanvas.NAME)
        this.DEFAULT_CHILD_NAME_LIST.add(GameInputMappingInstructionsCanvas.NAME)
        this.DEFAULT_CHILD_NAME_LIST.add(HighScoresCanvas.NAME)
    }

    def setMyCanvas(displayable : MyCanvas) : Unit = {
        if (this.displayable.isInstanceOf[MyCanvas]) {
            if (displayable.hasChild(this.displayable.asInstanceOf[MyCanvas])) {
                PreLogUtil.put(new StringMaker().append("Child Displayable is already set for: ").append(this.stringUtil.toString(displayable)).toString(), this, this.SET_DISPLAYABLE)
                return
            }
        }
        this.setDisplayable(displayable)
    }

    def setDisplayable(displayable : Displayable) : Unit = {
        //ForcedLogUtil.log(SET_DISPLAYABLE + displayable, this);
        this.displayable = displayable
        this.setOpenGlReadydisplayable(displayable)
    }

    def setOpenGlReadydisplayable(openGlReadydisplayable : Displayable) : Unit = {
        //if(RendererStateFactory.getInstance().isSurfaceChanged())
        this.openGlReadydisplayable = openGlReadydisplayable
        this.update()
    }

    def getOpenGlReadydisplayable() : Displayable = {
        return this.openGlReadydisplayable
    }

    def setRunnable(runnable : GameRunnable) : Unit = {
        PreLogUtil.put(new StringMaker().append(this.RUNNABLE).append(this.stringUtil.toString(runnable)).toString(), this, this.SET_RUNNABLE)
        this.runnable = runnable
        if (this.usedRunnable ne this.runnable) {
            //this.usedRunnable = runnable;
            this.update()
        } else {
            PreLogUtil.put(new StringMaker().append(this.RUNNABLE_WAS_ALREADY_IN_USE).append(this.stringUtil.toString(runnable)).toString(), this, this.SET_RUNNABLE)
        }
    }

    def clearRunnable() : Unit = {
        PreLogUtil.put(new StringMaker().append(this.RUNNABLE).append(this.stringUtil.toString(NullRunnable.getInstance())).toString(), this, this.CLEAR_RUNNABLE)
        this.setUsedRunnable(NullWaitGameRunnable.getInstance())
    }

    private def update() : Unit = {
        this.synchronized {
            val commonSeps : CommonSeps = CommonSeps.getInstance()
            val features : Features = Features.getInstance()
            val stringMaker : StringMaker = new StringMaker()
            stringMaker.append(this.stringUtil.toString(this.openGlReadydisplayable))
            if (SWTUtil.isSWT && !features.isDefault(OpenGLFeatureFactory.getInstance().OPENGL)) {
                PreLogUtil.put(stringMaker.append(commonSeps.SPACE).append(SWTUtil.SWT).append(commonSeps.SPACE).append(this.RUNNABLE).append(this.stringUtil.toString(NullRunnable.getInstance())).toString(), this, this.commonStrings.UPDATE)
                this.setUsedRunnable(NullWaitGameRunnable.getInstance())
            } else if (J2MEUtil.isHTML()) {
                PreLogUtil.put(stringMaker.append(commonSeps.SPACE).append(GraphicsStrings.getInstance().HTML).append(commonSeps.SPACE).append(this.RUNNABLE).append(this.stringUtil.toString(this.runnable)).toString(), this, this.commonStrings.UPDATE)
                this.setUsedRunnable(this.runnable)
            } else if ((this.openGlReadydisplayable.isInstanceOf[DemoCanvas] || this.openGlReadydisplayable.isInstanceOf[AllBinaryGameCanvas]) || features.isDefault(OpenGLFeatureFactory.getInstance().OPENGL)) {
                PreLogUtil.put(stringMaker.append(commonSeps.SPACE).append(OpenGLFeatureFactory.getInstance().OPENGL.toString()).append(commonSeps.SPACE).append(this.RUNNABLE).append(this.stringUtil.toString(this.runnable)).toString(), this, this.commonStrings.UPDATE)
                this.setUsedRunnable(this.runnable)
            } else {
                PreLogUtil.put(stringMaker.append(this.RUNNABLE).append(this.stringUtil.toString(NullRunnable.getInstance())).toString(), this, this.commonStrings.UPDATE)
                this.setUsedRunnable(NullWaitGameRunnable.getInstance())
            }
        }
    }

    /*     public void onDrawFrame(GL10 gl)     {         this.usedRunnable.run();          //Now we're ready to draw some 3D objects          // gl.glMatrixMode(GL10.GL_MODELVIEW);         // gl.glLoadIdentity();          // GLU.gluLookAt(gl, 0, 0, -5, 0f, 0f, 0f, 0f, 1.0f, 0.0f);          this.openGlReadydisplayable.draw(gl);          //x++; if(x > DisplayInfoSingleton.getInstance().getLastWidth()) { x = 0; }          //if(this.image != null) this.image.draw(gl, x, y, z);     }     */
    def getDisplayable() : Displayable = {
        return this.displayable
    }

    def getUsedRunnable() : GameRunnable = {
        return this.usedRunnable
    }

    /**      * @param usedRunnable the usedRunnable to set      */
    def setUsedRunnable(usedRunnable : GameRunnable) : Unit = {
        PreLogUtil.put(new StringMaker().append(this.RUNNABLE).append(this.stringUtil.toString(this.runnable)).append(CommonSeps.getInstance().COLON_SEP).append(this.stringUtil.toString(usedRunnable)).toString(), this, this.SET_USED_RUNNABLE)
        this.usedRunnable = usedRunnable
    }

}

object CurrentDisplayableFactory {
    //protected final LogUtil logUtil = LogUtil.getInstance();
    private val instance : CurrentDisplayableFactory = new CurrentDisplayableFactory()

    def getInstance() : CurrentDisplayableFactory = {
        return CurrentDisplayableFactory.instance
    }

}


