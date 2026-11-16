/* Generated Code Do Not Modify */
package org.allbinary.android

import _root_.android.content.Context
import _root_.android.view.View
import _root_.android.widget.Toast
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings

class ToastUtil {
    import _root_.org.allbinary.android.ToastUtil.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    def makeToast(view : View, context : Context, message : String, time : Int) : Unit = {
        view.post(new MakeToast(context, message, time))
    }

}

object ToastUtil {
    private val instance : ToastUtil = new ToastUtil()

    def getInstance() : ToastUtil = {
        return ToastUtil.instance
    }

    //A member class instead of a local class using the method parameters since most of the converted languages do not have local classes.
    class MakeToast(param_context : Context, param_string : String, param_time : Int) extends Runnable {

        private[MakeToast] var context : Context = null

        private[MakeToast] var string : String = null

        private[MakeToast] var time : Int = 0

        //Constructor
        {
            val context : Context = param_context
            val string : String = param_string
            val time : Int = param_time
            this.context = context
            this.string = string
            this.time = time
        }

        override def run() : Unit = {
            val logUtil : LogUtil = LogUtil.getInstance()
            try {
                //PreLogUtil.put("Trying to Toast: "+ string, this, this.commonStrings.RUN);
                Toast.makeText(this.context, this.string, this.time).show()
            } catch {
                case e : Exception => {
                    val commonStrings : CommonStrings = CommonStrings.getInstance()
                    logUtil.put(commonStrings.EXCEPTION, this, commonStrings.RUN, e)
                }
            }
        }

    }

}


