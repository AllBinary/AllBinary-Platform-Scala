/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.smtp.queue

import _root_.javax.mail.Transport
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.communication.smtp.EmailInterface
import _root_.org.allbinary.logic.util.queue.BasicQueue

class BasicEmailQueue private() extends BasicQueue with EmailQueueInterface {
    import _root_.org.allbinary.logic.communication.smtp.queue.BasicEmailQueue.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    def offer(emailInterface : EmailInterface) : Boolean = this.synchronized {
        this.offer(emailInterface.asInstanceOf[Object])
        this.post(emailInterface)
        return true
    }

    private def remove(emailInterface : EmailInterface) : Unit = this.synchronized {
        this.remove(emailInterface.asInstanceOf[Object])
    }

    def remove() : EmailInterface = this.synchronized {
        return null
    }

    private def post(emailInterface : EmailInterface) : Unit = this.synchronized {
        if (this.send(emailInterface)) {
            this.remove(emailInterface)
            this.processAllUnsent()
        }
    }

    def processAllUnsent() : Unit = this.synchronized {
        val size : Int = queueVector.size()

        {
            var index : Int = 0
            while (index < size) {
                var emailInterface : EmailInterface = queueVector.get(index).asInstanceOf[EmailInterface]
                if (this.send(emailInterface)) {
                    //if(emailInterface.getEvent())
                    this.remove(emailInterface)
                    this.processAllUnsent()
                }
                index += 1
            }
        }
    }

    private def send(emailInterface : EmailInterface) : Boolean = this.synchronized {
        try {
            //Should start thread here
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().EMAILLOGGING)) {
                this.logUtil.putF("Sending: " + emailInterface.log(), this, "send")
            }
            Transport.send(emailInterface.getMimeMessage())
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().EMAILLOGGING)) {
                this.logUtil.putF("Email Send Debug: " + emailInterface.getDebugInfo(), this, "send")
            }
            return true
        } catch {
            case e : Exception => {
                //Should fire email send event error
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().EMAILLOGGING)) {
                    this.logUtil.put("Failed Email Send Debug: " + emailInterface.getDebugInfo(), this, "send", e)
                }
                return false
            }
        }
        throw new IllegalStateException()
    }

}

object BasicEmailQueue {
    private val instance : BasicEmailQueue = new BasicEmailQueue()

    private var basicEmailQueue : BasicEmailQueue = null

    def getInstance() : BasicEmailQueue = this.synchronized {
        if (BasicEmailQueue.basicEmailQueue == null) {
            BasicEmailQueue.basicEmailQueue = new BasicEmailQueue()
        }
        return BasicEmailQueue.basicEmailQueue
    }

}


