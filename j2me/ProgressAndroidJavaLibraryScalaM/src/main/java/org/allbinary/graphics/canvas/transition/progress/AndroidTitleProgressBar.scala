/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.canvas.transition.progress

import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.android.activity.NullProgressActivity
import _root_.org.allbinary.android.activity.ProgressActivityInterface
import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings

class AndroidTitleProgressBar(param_title : String, param_backgroundBasicColor : BasicColor, param_foregroundBasicColor : BasicColor) extends ProgressCanvas(param_title, param_backgroundBasicColor, param_foregroundBasicColor) {

    private var showTitleProgressBarRunnable : ShowTitleProgressBarRunnable = new ShowTitleProgressBarRunnable(this)

    private var dismissTitleProgressBarRunnable : DismissTitleProgressBarRunnable = new DismissTitleProgressBarRunnable(this)

    private var progressDialogPortionSetProgressRunnable : TitleProgressBarPortionSetProgressRunnable = new TitleProgressBarPortionSetProgressRunnable(this)

    private var progressDialogSetProgressRunnable : TitleProgressBarSetProgressRunnable = new TitleProgressBarSetProgressRunnable(this)

    //private MidletActivity midletActivity;
    private var progressActivity : ProgressActivityInterface = NullProgressActivity.NULL_PROGRESS_ACTIVITY

    private var portion : Int = 0

    //Constructor
    {
        val title : String = param_title
        val backgroundBasicColor : BasicColor = param_backgroundBasicColor
        val foregroundBasicColor : BasicColor = param_foregroundBasicColor
    }

    class TitleProgressBarSetProgressRunnable(param_androidTitleProgressBar : AndroidTitleProgressBar) extends Runnable {

        private[TitleProgressBarSetProgressRunnable] var androidTitleProgressBar : AndroidTitleProgressBar = null

        //Constructor
        {
            val androidTitleProgressBar : AndroidTitleProgressBar = param_androidTitleProgressBar
            this.androidTitleProgressBar = androidTitleProgressBar
        }

        override def run() : Unit = {
            val logUtil : LogUtil = LogUtil.getInstance()
            val commonStrings : CommonStrings = CommonStrings.getInstance()
            try {
                val value : Int = this.androidTitleProgressBar.getValue().toInt
                this.androidTitleProgressBar.progressActivity.onTitleProgressBarSetProgress(value)
            } catch {
                case e : Exception => {
                    logUtil.put(commonStrings.EXCEPTION, this, commonStrings.RUN, e)
                }
            }
        }

    }

    class TitleProgressBarPortionSetProgressRunnable(param_androidTitleProgressBar : AndroidTitleProgressBar) extends Runnable {

        private[TitleProgressBarPortionSetProgressRunnable] var androidTitleProgressBar : AndroidTitleProgressBar = null

        //Constructor
        {
            val androidTitleProgressBar : AndroidTitleProgressBar = param_androidTitleProgressBar
            this.androidTitleProgressBar = androidTitleProgressBar
        }

        override def run() : Unit = {
            val logUtil : LogUtil = LogUtil.getInstance()
            val commonStrings : CommonStrings = CommonStrings.getInstance()
            try {
                val value : Int = (this.androidTitleProgressBar.getValue() + (this.androidTitleProgressBar.getMaxValue() / this.androidTitleProgressBar.portion)).toInt
                this.androidTitleProgressBar.progressActivity.onTitleProgressBarSetProgress(value)
            } catch {
                case e : Exception => {
                    logUtil.put(commonStrings.EXCEPTION, this, commonStrings.RUN, e)
                }
            }
        }

    }

    class ShowTitleProgressBarRunnable(param_androidTitleProgressBar : AndroidTitleProgressBar) extends Runnable {

        private[ShowTitleProgressBarRunnable] var androidTitleProgressBar : AndroidTitleProgressBar = null

        //Constructor
        {
            val androidTitleProgressBar : AndroidTitleProgressBar = param_androidTitleProgressBar
            this.androidTitleProgressBar = androidTitleProgressBar
        }

        override def run() : Unit = {
            val logUtil : LogUtil = LogUtil.getInstance()
            val commonStrings : CommonStrings = CommonStrings.getInstance()
            try {
                val maxValue : Int = this.androidTitleProgressBar.getMaxValue().toInt
                this.androidTitleProgressBar.progressActivity.onShowTitleProgressBar(maxValue, false)
            } catch {
                case e : Exception => {
                    logUtil.put(commonStrings.EXCEPTION, this, commonStrings.RUN, e)
                }
            }
        }

    }

    class DismissTitleProgressBarRunnable(param_androidTitleProgressBar : AndroidTitleProgressBar) extends Runnable {

        private[DismissTitleProgressBarRunnable] var androidTitleProgressBar : AndroidTitleProgressBar = null

        //Constructor
        {
            val androidTitleProgressBar : AndroidTitleProgressBar = param_androidTitleProgressBar
            this.androidTitleProgressBar = androidTitleProgressBar
        }

        override def run() : Unit = {
            val logUtil : LogUtil = LogUtil.getInstance()
            val commonStrings : CommonStrings = CommonStrings.getInstance()
            try {
                this.androidTitleProgressBar.progressActivity.onDismissTitleProgressBar()
            } catch {
                case e : Exception => {
                    logUtil.put(commonStrings.EXCEPTION, this, commonStrings.RUN, e)
                }
            }
        }

    }

    //    }
    def init(activity : ProgressActivityInterface) : Unit = {
        this.progressActivity = activity
    }

    def isInitialized() : Boolean = {
        if (this.progressActivity ne NullProgressActivity.NULL_PROGRESS_ACTIVITY) {
            // && this.midletActivity != null)
            return true
        } else {
            return false
        }
        throw new IllegalStateException()
    }

    override def start() : Unit = {
        try {
            this.logUtil.putF(this.commonStrings.START, this, this.commonStrings.START_METHOD_NAME)
            super.start()
            // this.midletActivity.startProgressActivity();
            this.progressActivity.runOnUiThread(this.showTitleProgressBarRunnable)
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, this.commonStrings.START_METHOD_NAME, e)
            }
        }
    }

    override def end() : Unit = {
        try {
            this.logUtil.putF(this.commonStrings.START, this, this.commonStrings.END_METHOD_NAME)
            this.progressActivity.runOnUiThread(this.dismissTitleProgressBarRunnable)
            // this.progressActivity = null;
            super.end()
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, this.commonStrings.END_METHOD_NAME, e)
            }
        }
    }

    override def addPortion(value : Int, text : String, index : Int) : Unit = {
        try {
            //this.logUtil.putF(this.commonStrings.START, this, ADD_PORTION);
            super.addPortion(value, text, index)
            this.portion = value
            this.progressActivity.runOnUiThread(this.progressDialogPortionSetProgressRunnable)
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, this.ADD_PORTION, e)
            }
        }
    }

    override def addNormalPortion(value : Int, text : String) : Unit = {
        try {
            //this.logUtil.putF(this.commonStrings.START, this, ADD_PORTION);
            super.addNormalPortion(value, text)
            this.portion = value
            this.progressActivity.runOnUiThread(this.progressDialogPortionSetProgressRunnable)
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, this.ADD_PORTION, e)
            }
        }
    }

    override def setValue(value : Int) : Unit = {
        try {
            super.setValue(value)
            this.progressActivity.runOnUiThread(this.progressDialogSetProgressRunnable)
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, "setValue", e)
            }
        }
    }

    def waitUntilDisplayed() : Unit = {
    }

    override def paint(graphics : Graphics) : Unit = {
    }

}


