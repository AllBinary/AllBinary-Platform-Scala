/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.tracking

import _root_.org.allbinary.logic.util.event.AllBinaryEventObject
import _root_.org.allbinary.logic.util.event.EventListenerInterface
import _root_.org.allbinary.logic.util.event.handler.BasicEventHandler

class TrackingEventHandler private() extends BasicEventHandler {
    import _root_.org.allbinary.game.tracking.TrackingEventHandler.{*}

    /*    public void addListener(CollidableDestroyableDamageableLayer collidableDestroyableDamageableLayer)    {        if(!list.contains(collidableDestroyableDamageableLayer))        {            list.add(collidableDestroyableDamageableLayer);        }    }     public void removeAllListeners()    {        this.list.clear();        super.removeAllListeners();    }     public void removeListener(EventListenerInterface eventListenerInterface)    {        this.list.remove(eventListenerInterface);        super.removeListener(eventListenerInterface);    }     public void fireEvent(AllBinaryEventObject eventObject) throws Exception    {                for (int index = this.list.size(); --index >= 0;)        {            try            {                CollidableDestroyableDamageableLayer collidableDestroyableDamageableLayer =                         (CollidableDestroyableDamageableLayer) this.list.get(index);                collidableDestroyableDamageableLayer.onMovement((TrackingEvent) eventObject);            }            catch (Exception e)            {                this.logUtil.put(this.commonStrings.EXCEPTION, this, EventStrings.getInstance().FIRE_EVENT, e);            }        }         super.fireEvent(eventObject);    }    */
    override def process(eventObject : AllBinaryEventObject, eventListenerInterface : EventListenerInterface) : Unit = {
        val trackingEventListenerInterface : TrackingEventListenerInterface = eventListenerInterface.asInstanceOf[TrackingEventListenerInterface]
        trackingEventListenerInterface.onMovement(eventObject.asInstanceOf[TrackingEvent])
    }

}

object TrackingEventHandler {
    //protected final LogUtil logUtil = LogUtil.getInstance();
    private val instance : TrackingEventHandler = new TrackingEventHandler()

    def getInstance() : TrackingEventHandler = {
        return TrackingEventHandler.instance
    }

}


