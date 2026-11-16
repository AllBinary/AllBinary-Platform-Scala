/* Generated Code Do Not Modify */
package org.allbinary.game.collision

import _root_.org.allbinary.layer.AllBinaryLayer

class CollisionThreedProcessor extends CollisionProcessor {

    //protected final LogUtil logUtil = LogUtil.getInstance();
    override def isCollision(myLayer : AllBinaryLayer, myLayer2 : AllBinaryLayer) : Boolean = {
        //        }
        if ((((((myLayer2.getXP() >= myLayer.getX2()) || (myLayer2.getYP() >= myLayer.getY2())) || (myLayer2.getX2() <= myLayer.getXP())) || (myLayer2.getY2() <= myLayer.getYP())) || (myLayer2.getZP() < myLayer.getZ2())) || (myLayer2.getZ2() > myLayer.getZP())) {
            return false
        } else {
            //PreLogUtil.put(myLayer2.getZ() + " > " + myLayer.getZ2() + " || " + myLayer2.getZ2() + " < " + myLayer.getZP(), this, damageUtil.IS_COLLISION);
            return true
        }
        throw new IllegalStateException()
    }

}


