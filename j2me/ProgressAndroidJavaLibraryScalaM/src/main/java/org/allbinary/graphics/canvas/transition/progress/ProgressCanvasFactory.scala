/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.canvas.transition.progress

import _root_.org.allbinary.graphics.color.BasicColorFactory
import _root_.org.allbinary.graphics.paint.NullPaintable
import _root_.org.allbinary.graphics.paint.PaintableInterface
import _root_.org.allbinary.logic.NullUtil
import _root_.org.allbinary.logic.string.StringUtil

class ProgressCanvasFactory {
    import _root_.org.allbinary.graphics.canvas.transition.progress.ProgressCanvasFactory.{*}

}

object ProgressCanvasFactory {
    private var PROGRESS_FORM_SCREEN : Object = NullUtil.getInstance().NULL_OBJECT

    def getInstance() : ProgressCanvas = {
        if (ProgressCanvasFactory.PROGRESS_FORM_SCREEN eq NullUtil.getInstance().NULL_OBJECT) {
            ProgressCanvasFactory.PROGRESS_FORM_SCREEN = new AndroidBasicTitleProgressBar(StringUtil.getInstance().EMPTY_STRING, BasicColorFactory.getInstance().BLACK, BasicColorFactory.getInstance().WHITE)
        }
        return ProgressCanvasFactory.PROGRESS_FORM_SCREEN.asInstanceOf[ProgressCanvas]
    }

    def getLazyInstance() : PaintableInterface = {
        return NullPaintable.getInstance()
    }

}


