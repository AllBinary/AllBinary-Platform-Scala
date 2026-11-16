/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.resource

import _root_.org.allbinary.game.configuration.feature.GameFeatureControlledInterface
import _root_.org.allbinary.graphics.RelativeRelationship
import _root_.org.allbinary.util.BasicArrayList

/**  *  * @author user  */
trait ResourceRelativeRelationshipFactoryInterface extends GameFeatureControlledInterface {

    def getResourceRelativeRelationshipList(resource : String) : BasicArrayList

    def addResourceRelativeRelationship(resource : String, relativeRelationship : RelativeRelationship) : Unit

}


