/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.canvas.transition.progress

import _root_.org.allbinary.canvas.Processor
import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.graphics.paint.NullPaintable
import _root_.org.allbinary.image.ImageCacheFactory

/**  *  * @author User  */
class LazyProgressCanvas(param_title : String, param_backgroundBasicColor : BasicColor, param_foregroundBasicColor : BasicColor) extends ProgressCanvas(param_title, param_backgroundBasicColor, param_foregroundBasicColor) {

    //Constructor
    {
        val title : String = param_title
        val backgroundBasicColor : BasicColor = param_backgroundBasicColor
        val foregroundBasicColor : BasicColor = param_foregroundBasicColor
    }

    override def start() : Unit = {
        super.start()
        this.hasPainted = false
    }

    override def end() : Unit = {
        try {
            this.logUtil.putF(this.commonStrings.START, this, this.commonStrings.END_METHOD_NAME)
            this.endActual()
            this.paintable = this.GAUGE_PAINTABLE
            ImageCacheFactory.getInstance().runTask()
            ImageCacheFactory.getInstance().progressEnded()
        } catch {
            case e : Exception => {
                this.logUtil.putF(this.commonStrings.EXCEPTION, this, this.commonStrings.END_METHOD_NAME)
            }
        }
    }

    override def inGame() : Unit = {
        this.inGameProcessor = Processor.getInstance()
    }

    override def endFromInitialLazyLoadingComplete() : Unit = {
        super.endFromInitialLazyLoadingComplete()
        //this.logUtil.putF(this.commonStrings.START, this, END_FROM_INITIAL_LAZY_LOADING_COMPLETE);
        this.paintable = NullPaintable.getInstance()
    }

    override def endIfPaintedSinceStart() : Unit = {
        if ((this.paintable eq this.GAUGE_PAINTABLE) && this.hasPainted) {
            this.endFromInitialLazyLoadingComplete()
        }
    }

}


