/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.input

import _root_.javax.microedition.lcdui.Graphics

class TestInputExample extends TestInputInterface {

    private var testValue : Int = 0

    override def up() : Unit = {
    }

    override def down() : Unit = {
    }

    override def left() : Unit = {
        this.testValue += 1
    }

    override def right() : Unit = {
        this.testValue -= 1
    }

    override def strafeLeft() : Unit = {
    }

    override def strafeRight() : Unit = {
    }

    override def paint(graphics : Graphics) : Unit = {
    }

    override def paintThreed(graphics : Graphics) : Unit = {
    }

}


