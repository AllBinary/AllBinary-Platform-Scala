/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.j2me.workarea.tools.event


class MyGraphicItemEventService private() {
    import _root_.org.allbinary.graphics.j2me.workarea.tools.event.MyGraphicItemEventService.{*}

}

object MyGraphicItemEventService {
    private var listenerList : _root_.javax.swing.event.EventListenerList = new _root_.javax.swing.event.EventListenerList()

    var DELETE : String = "delete"

    var DESELECT : String = "deselect"

    var SELECT : String = "select"

    var DUPLICATE : String = "duplicate"

    var ROTATE : String = "rotate"

    def addListener(listener : MyGraphicItemEventListener) : Unit = this.synchronized {
        //MyGraphicItemEventListener.class
        MyGraphicItemEventService.listenerList.add((listener.getClass().asInstanceOf[Class[?]]).asInstanceOf[Class[_root_.java.util.EventListener]], listener.asInstanceOf[_root_.java.util.EventListener])
    }

    def removeListener(listener : MyGraphicItemEventListener) : Unit = this.synchronized {
        //MyGraphicItemEventListener.class
        MyGraphicItemEventService.listenerList.remove((listener.getClass().asInstanceOf[Class[?]]).asInstanceOf[Class[_root_.java.util.EventListener]], listener.asInstanceOf[_root_.java.util.EventListener])
    }

    def fire(evt : MyGraphicItemEvent) : Unit = this.synchronized {
        var listeners : Array[Object] = listenerList.getListenerList()

        {
            var i : Int = 0
            while (i < listeners.length) {
                //MyGraphicItemEventListener.class
                if (listeners(i) eq listeners(i + 1).getClass()) {
                    if (evt.getCommand().compareTo(MyGraphicItemEventService.SELECT) == 0) {
                        (listeners(i + 1).asInstanceOf[MyGraphicItemEventListener]).highlight(evt)
                    } else if (evt.getCommand().compareTo(MyGraphicItemEventService.DESELECT) == 0) {
                        (listeners(i + 1).asInstanceOf[MyGraphicItemEventListener]).deselect(evt)
                    } else if (evt.getCommand().compareTo(MyGraphicItemEventService.DELETE) == 0) {
                        (listeners(i + 1).asInstanceOf[MyGraphicItemEventListener]).delete(evt)
                    } else if (evt.getCommand().compareTo(MyGraphicItemEventService.DUPLICATE) == 0) {
                        (listeners(i + 1).asInstanceOf[MyGraphicItemEventListener]).duplicate(evt)
                    } else if (evt.getCommand().compareTo(MyGraphicItemEventService.ROTATE) == 0) {
                        (listeners(i + 1).asInstanceOf[MyGraphicItemEventListener]).rotate(evt)
                    }
                }
                i += 2
            }
        }
    }

}


