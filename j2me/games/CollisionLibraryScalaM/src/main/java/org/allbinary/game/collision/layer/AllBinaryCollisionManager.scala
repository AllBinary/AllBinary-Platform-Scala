/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.collision.layer

import _root_.org.allbinary.game.collision.CollidableBaseBehavior
import _root_.org.allbinary.game.collision.CollidableInterfaceCompositeInterface
import _root_.org.allbinary.game.layer.CollidableCompositeLayer
import _root_.org.allbinary.layer.LayerManager

class AllBinaryCollisionManager private() {
    import _root_.org.allbinary.game.collision.layer.AllBinaryCollisionManager.{*}

    /*    public void process(AllBinaryLayerManager myLayerManager)            throws Exception    {       int size = myLayerManager.getSize();       for(int index = 0; index < size; index++)       {          LayerInterface myLayerInterface = myLayerManager.getLayerAt(index);          if(myLayerInterface instance of CollidableInterface)          {             CollidableInterfaceCompositeInterface collidableInterfaceCompositeInterface =                 (CollidableInterfaceCompositeInterface) myLayerInterface;             if(collidableInterfaceCompositeInterface.isCollidable())             {                this.process(myLayerManager, collidableInterface, index);             }          }       }    }    */
    def process(layerManager : LayerManager, collidableInterfaceCompositeInterface : CollidableInterfaceCompositeInterface, startIndex : Int) : Unit = {
        var size : Int = layerManager.getSize()

        {
            var index : Int = startIndex + 1
            while (index < size) {
                var collidableInterfaceCompositeInterface2 : CollidableInterfaceCompositeInterface = layerManager.getLayerAt(index).asInstanceOf[CollidableInterfaceCompositeInterface]
                // {
                this.collide(layerManager, collidableInterfaceCompositeInterface, collidableInterfaceCompositeInterface2)
                index += 1
            }
        }
    }

    private def collide(layerManager : LayerManager, collidableInterfaceCompositeInterface : CollidableInterfaceCompositeInterface, collidableInterfaceCompositeInterface2 : CollidableInterfaceCompositeInterface) : Unit = {
        var collidableBase2 : CollidableBaseBehavior = collidableInterfaceCompositeInterface2.getCollidableInferface()
        var collidableBase : CollidableBaseBehavior = collidableInterfaceCompositeInterface.getCollidableInferface()
        if (collidableBase2.isCollidable(collidableInterfaceCompositeInterface.asInstanceOf[CollidableCompositeLayer])) {
            if (collidableBase.isCollisionInterface(collidableInterfaceCompositeInterface.asInstanceOf[CollidableCompositeLayer], collidableInterfaceCompositeInterface2)) {
                collidableBase.collideInterface(collidableInterfaceCompositeInterface.asInstanceOf[CollidableCompositeLayer], collidableInterfaceCompositeInterface2)
                collidableBase2.collideInterface(collidableInterfaceCompositeInterface.asInstanceOf[CollidableCompositeLayer], collidableInterfaceCompositeInterface)
            }
        }
    }

}

object AllBinaryCollisionManager {
    private var allBinaryCollisionManager : AllBinaryCollisionManager = new AllBinaryCollisionManager()

    def getInstance() : AllBinaryCollisionManager = {
        return AllBinaryCollisionManager.allBinaryCollisionManager
    }

}


