/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.j2me.workarea.canvas.event


class MyCanvasEventService private() {
    import _root_.org.allbinary.graphics.j2me.workarea.canvas.event.MyCanvasEventService.{*}

}

object MyCanvasEventService {
    private var listenerList : _root_.javax.swing.event.EventListenerList = new _root_.javax.swing.event.EventListenerList()

    var DELETE : String = "delete"

    var DUPLICATE : String = "duplicate"

    var SELECT : String = "select"

    var ROTATE : String = "rotate"

    var EXPLODE : String = "explode"

    var AUTOEXPLODE : String = "autoExplode"

    var CENTER : String = "center"

    def addListener(listener : MyCanvasEventListener) : Unit = this.synchronized {
        MyCanvasEventService.listenerList.add((listener.getClass().asInstanceOf[Class[?]]).asInstanceOf[Class[_root_.java.util.EventListener]], listener.asInstanceOf[_root_.java.util.EventListener])
    }

    def removeListener(listener : MyCanvasEventListener) : Unit = this.synchronized {
        MyCanvasEventService.listenerList.remove((listener.getClass().asInstanceOf[Class[?]]).asInstanceOf[Class[_root_.java.util.EventListener]], listener.asInstanceOf[_root_.java.util.EventListener])
    }

    def fire(evt : MyCanvasEvent) : Unit = this.synchronized {
        var listeners : Array[Object] = listenerList.getListenerList()

        {
            var i : Int = 0
            while (i < listeners.length) {
                if (listeners(i) eq listeners(i + 1).getClass()) {
                    if (evt.getCommand().compareTo(MyCanvasEventService.DELETE) == 0) {
                        (listeners(i + 1).asInstanceOf[MyCanvasEventListener]).delete(evt)
                    } else if (evt.getCommand().compareTo(MyCanvasEventService.DUPLICATE) == 0) {
                        (listeners(i + 1).asInstanceOf[MyCanvasEventListener]).duplicate(evt)
                    } else if (evt.getCommand().compareTo(MyCanvasEventService.SELECT) == 0) {
                        (listeners(i + 1).asInstanceOf[MyCanvasEventListener]).select(evt)
                    } else if (evt.getCommand().compareTo(MyCanvasEventService.ROTATE) == 0) {
                        (listeners(i + 1).asInstanceOf[MyCanvasEventListener]).rotate(evt)
                    } else if (evt.getCommand().compareTo(MyCanvasEventService.EXPLODE) == 0) {
                        (listeners(i + 1).asInstanceOf[MyCanvasEventListener]).explode(evt)
                    } else if (evt.getCommand().compareTo(MyCanvasEventService.AUTOEXPLODE) == 0) {
                        (listeners(i + 1).asInstanceOf[MyCanvasEventListener]).autoExplode(evt)
                    } else if (evt.getCommand().compareTo(MyCanvasEventService.CENTER) == 0) {
                        (listeners(i + 1).asInstanceOf[MyCanvasEventListener]).center(evt)
                    }
                }
                i += 2
            }
        }
    }

}


