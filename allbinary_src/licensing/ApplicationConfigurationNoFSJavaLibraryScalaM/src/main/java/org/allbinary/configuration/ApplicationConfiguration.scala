/* Generated Code Do Not Modify */
package org.allbinary.configuration

import _root_.org.allbinary.game.configuration.feature.Feature
import _root_.org.allbinary.game.configuration.feature.Features
import _root_.org.allbinary.game.configuration.feature.MainFeatureFactory
import _root_.org.allbinary.logic.NullUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.string.CommonStrings

class ApplicationConfiguration private() {
    import _root_.org.allbinary.configuration.ApplicationConfiguration.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    /*      * private boolean fullscreen = true; private boolean showTitleBar = true;      * protected boolean progressBarView = true;      */
    private var fullscreen : Boolean = true

    private var showTitleBar : Boolean = false

    private var progressBarView : Boolean = false

    //private final String FILE = "ReloadConfiguration.dat";
    //Constructor
    {
        try {
            //            {
            this.read()
        } catch {
            case e : Exception => {
                val commonStrings : CommonStrings = CommonStrings.getInstance()
                this.logUtil.put(commonStrings.EXCEPTION, this, commonStrings.CONSTRUCTOR, e)
            }
        }
    }

    private def read() : Unit = {
        //        {
        this.setFullscreen(true)
        //        {
        this.setProgressBarView(false)
        //        {
        this.setShowTitleBar(false)
        //PreLogUtil.put("Read Configuration: " + this.toString(), this, "read");
        this.logUtil.putF("Read Configuration: " + this.toString(), this, "read")
    }

    def write() : Unit = {
    }

    def update(gameFeature : Feature) : Unit = {
        if (gameFeature eq MainFeatureFactory.getInstance().FULL_SCREEN) {
            val features : Features = Features.getInstance()
            if (features.isFeature(gameFeature)) {
                if (!this.isFullscreen()) {
                    this.setFullscreen(true)
                    this.write()
                }
            } else {
                if (this.isFullscreen()) {
                    this.setFullscreen(false)
                    this.write()
                }
            }
        }
    }

    def setFullscreen(fullscreen : Boolean) : Unit = {
        this.fullscreen = fullscreen
    }

    def isFullscreen() : Boolean = {
        return this.fullscreen
    }

    def setShowTitleBar(showTitleBar : Boolean) : Unit = {
        this.showTitleBar = showTitleBar
    }

    def isShowTitleBar() : Boolean = {
        return this.showTitleBar
    }

    def setProgressBarView(progressBarView : Boolean) : Unit = {
        this.progressBarView = progressBarView
    }

    def isProgressBarView() : Boolean = {
        return this.progressBarView
    }

    override def toString() : String = {
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append("isFullscreen: ")
        stringBuffer.appendboolean(this.isFullscreen())
        stringBuffer.append(" isProgressBarView: ")
        stringBuffer.appendboolean(this.isProgressBarView())
        stringBuffer.append(" isShowTitleBar: ")
        stringBuffer.appendboolean(this.isShowTitleBar())
        return stringBuffer.toString()
    }

}

object ApplicationConfiguration {
    private var instance : Object = NullUtil.getInstance().NULL_OBJECT

    def getInstance() : ApplicationConfiguration = {
        if (ApplicationConfiguration.instance eq NullUtil.getInstance().NULL_OBJECT) {
            ApplicationConfiguration.instance = new ApplicationConfiguration()
        }
        return ApplicationConfiguration.instance.asInstanceOf[ApplicationConfiguration]
    }

}


