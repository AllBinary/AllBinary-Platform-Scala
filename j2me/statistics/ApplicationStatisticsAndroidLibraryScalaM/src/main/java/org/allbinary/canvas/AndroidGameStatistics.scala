/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.canvas

import _root_.android.view.View
import _root_.org.allbinary.android.view.BaseViewWrapper
import _root_.org.allbinary.android.view.ViewWrapper
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil

class AndroidGameStatistics() extends BaseGameStatistics {

    //protected final LogUtil logUtil = LogUtil.getInstance();
    private var view : BaseViewWrapper = BaseViewWrapper.NULL_VIEW_WRAPPER

    private var totalOnDraws : Long = 0L

    private val ANDROID_STRING_ARRAY : Array[String] = new Array[String](14)

    private val TOTAL_ONDRAWS : String = " Total onDraws: "

    private val ONDRAWS_RATE : String = " onDraws(/10) Sec: "

    //Constructor
    {
        val stringUtil : StringUtil = StringUtil.getInstance()

        {
            var index : Int = 0
            while (index < this.ANDROID_STRING_ARRAY.length) {
                this.ANDROID_STRING_ARRAY(index) = stringUtil.EMPTY_STRING
                index += 1
            }
        }
    }

    def initView(view : View) : Unit = {
        super.init()
        this.view = new ViewWrapper(view)
        this.totalOnDraws = 0
    }

    override def process() : Unit = {
        // {
        this.view.postInvalidate()
    }

    def nextOnDraw() : Unit = {
        this.totalOnDraws += 1
    }

    override def toStringArray() : Array[String] = {
        val stringArray : Array[String] = super.toStringArray()

        {
            var index : Int = 0
            while (index < stringArray.length) {
                this.ANDROID_STRING_ARRAY(index) = stringArray(index)
                index += 1
            }
        }
        var totalTime : Long = this.getTimeDelayHelper().getElapsed(this.gameTickTimeDelayHelper.startTime)
        totalTime = (totalTime / 10000)
        this.ANDROID_STRING_ARRAY(10) = this.TOTAL_ONDRAWS
        this.ANDROID_STRING_ARRAY(11) = _root_.java.lang.Long.toString(this.totalOnDraws)
        this.ANDROID_STRING_ARRAY(12) = this.ONDRAWS_RATE
        this.ANDROID_STRING_ARRAY(13) = _root_.java.lang.Long.toString(this.totalOnDraws / totalTime)
        return this.ANDROID_STRING_ARRAY
    }

    override def toString() : String = {
        var totalTime : Long = this.getTimeDelayHelper().getElapsed(this.gameTickTimeDelayHelper.startTime)
        totalTime = (totalTime / 1000)
        if (totalTime > 0) {
            val stringBuffer : StringMaker = new StringMaker()
            stringBuffer.append(super.toStringAt(totalTime))
            if (this.totalOnDraws > 0) {
                stringBuffer.append(this.TOTAL_ONDRAWS)
                stringBuffer.append(_root_.java.lang.Long.toString(this.totalOnDraws))
                stringBuffer.append(this.ONDRAWS_RATE)
                val drawsOverTime : String = _root_.java.lang.Long.toString(this.totalOnDraws / totalTime)
                stringBuffer.append(drawsOverTime)
            }
            return stringBuffer.toString()
        } else {
            return this.NOT
        }
        throw new IllegalStateException()
    }

}


