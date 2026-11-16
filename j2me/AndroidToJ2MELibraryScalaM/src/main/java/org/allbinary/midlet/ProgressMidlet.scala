/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.midlet

import _root_.org.allbinary.TsUtil
import _root_.org.allbinary.canvas.Processor
import _root_.org.allbinary.globals.Globals
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.system.security.licensing.AbeClientInformationInterface
import _root_.org.allbinary.logic.system.security.licensing.ClientInformationFactory
import _root_.org.allbinary.thread.PrimaryThreadPool
import _root_.org.allbinary.thread.ThreadPool

//AndroidToJ2ME
class ProgressMidlet(param_clientInformationFactory : ClientInformationFactory) extends AllBinaryMidlet {

    var abeClientInformation : AbeClientInformationInterface = null

    //Constructor
    {
        val clientInformationFactory : ClientInformationFactory = param_clientInformationFactory
        Globals.getInstance().init(TsUtil.getInstance().getClassClassLoader(this), StringUtil.getInstance().EMPTY_STRING)
        this.preInit()
        this.abeClientInformation = clientInformationFactory.getInstance()
    }

    def preInit() : Unit = {
    }

    def exitProgress(isProgress : Boolean) : Unit = {
        val processor : Processor = MidletExitProcessorFactory.getInstance().getExitInstance(this)
        try {
            //this.logUtil.put("isProgress: " + isProgress, this, "exit", new Exception());
            val primaryThreadPool : ThreadPool = PrimaryThreadPool.getInstance()
            val runnable : Runnable = new ExitRunnable(this, processor, isProgress)
            primaryThreadPool.runTask(runnable)
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, "exit", e)
                try {
                    processor.process()
                } catch {
                    case e2 : Exception => {
                        this.logUtil.put(this.commonStrings.EXCEPTION, this, "exit", e)
                    }
                }
            }
        }
    }

}


