/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.input

import _root_.org.allbinary.game.configuration.persistance.GamePersistanceStrings
import _root_.org.allbinary.game.input.mapping.InputToGameKeyMapping
import _root_.org.allbinary.game.input.mapping.PersistentInputMapping

class NormalJ2MEDefaultGameInputMapping() extends PersistentInputMapping(GamePersistanceStrings.getInstance().DEFAULT_INPUT_MAPPING_RECORD_ID) {

    //Constructor
    {
        var inputToGameKeyMapping : InputToGameKeyMapping = this.getInputMapping()
        val gameKeyFactory : GameKeyFactory = GameKeyFactory.getInstance()
        // Also up
        inputToGameKeyMapping.add(gameKeyFactory.UP, gameKeyFactory.KEY_NUM2)
        // Also left
        inputToGameKeyMapping.add(gameKeyFactory.LEFT, gameKeyFactory.KEY_NUM4)
        // Also right
        inputToGameKeyMapping.add(gameKeyFactory.RIGHT, gameKeyFactory.KEY_NUM6)
        // Also down
        inputToGameKeyMapping.add(gameKeyFactory.DOWN, gameKeyFactory.KEY_NUM8)
        inputToGameKeyMapping.add(gameKeyFactory.KEY_NUM1, gameKeyFactory.GAME_A)
        inputToGameKeyMapping.add(gameKeyFactory.KEY_NUM3, gameKeyFactory.GAME_B)
        inputToGameKeyMapping.add(gameKeyFactory.KEY_NUM7, gameKeyFactory.GAME_C)
        inputToGameKeyMapping.add(gameKeyFactory.KEY_NUM9, gameKeyFactory.GAME_D)
        /*         inputToGameKeyMapping.add(gameKeyFactory.KEY_NUM1, gameKeyFactory.KEYBOARD_Y);         inputToGameKeyMapping.add(gameKeyFactory.KEY_NUM2, gameKeyFactory.KEYBOARD_U);         inputToGameKeyMapping.add(gameKeyFactory.KEY_NUM3, gameKeyFactory.KEYBOARD_I);         inputToGameKeyMapping.add(gameKeyFactory.KEY_NUM4, gameKeyFactory.KEYBOARD_H);         inputToGameKeyMapping.add(gameKeyFactory.KEY_NUM5, gameKeyFactory.KEYBOARD_J);         inputToGameKeyMapping.add(gameKeyFactory.KEY_NUM6, gameKeyFactory.KEYBOARD_K);         inputToGameKeyMapping.add(gameKeyFactory.KEY_NUM7, gameKeyFactory.KEYBOARD_N);         inputToGameKeyMapping.add(gameKeyFactory.KEY_NUM8, gameKeyFactory.KEYBOARD_M);          inputToGameKeyMapping.add(gameKeyFactory.KEY_NUM9, gameKeyFactory.KEYBOARD_LESS);         inputToGameKeyMapping.add(gameKeyFactory.KEY_STAR, gameKeyFactory.KEYBOARD_SPACE);         inputToGameKeyMapping.add(gameKeyFactory.KEY_NUM0, gameKeyFactory.KEYBOARD_INSERT);         inputToGameKeyMapping.add(gameKeyFactory.KEY_POUND, gameKeyFactory.KEYBOARD_DELETE);          */
        inputToGameKeyMapping.add(gameKeyFactory.LEVEL_DOWN, gameKeyFactory.LEVEL_DOWN)
        inputToGameKeyMapping.add(gameKeyFactory.LEVEL_UP, gameKeyFactory.LEVEL_UP)
        inputToGameKeyMapping.add(gameKeyFactory.UP, gameKeyFactory.UP)
        inputToGameKeyMapping.add(gameKeyFactory.DOWN, gameKeyFactory.DOWN)
        inputToGameKeyMapping.add(gameKeyFactory.LEFT, gameKeyFactory.LEFT)
        inputToGameKeyMapping.add(gameKeyFactory.RIGHT, gameKeyFactory.RIGHT)
        inputToGameKeyMapping.add(gameKeyFactory.KEY_POUND, gameKeyFactory.KEY_POUND)
        inputToGameKeyMapping.add(gameKeyFactory.KEY_STAR, gameKeyFactory.KEY_STAR)
        inputToGameKeyMapping.add(gameKeyFactory.KEY_NUM1, gameKeyFactory.KEY_NUM1)
        inputToGameKeyMapping.add(gameKeyFactory.KEY_NUM3, gameKeyFactory.KEY_NUM3)
        inputToGameKeyMapping.add(gameKeyFactory.KEY_NUM5, gameKeyFactory.KEY_NUM5)
        inputToGameKeyMapping.add(gameKeyFactory.KEY_NUM7, gameKeyFactory.KEY_NUM7)
        inputToGameKeyMapping.add(gameKeyFactory.KEY_NUM9, gameKeyFactory.KEY_NUM9)
        inputToGameKeyMapping.add(gameKeyFactory.KEY_NUM0, gameKeyFactory.KEY_NUM0)
        inputToGameKeyMapping.add(gameKeyFactory.KEY_NUM1, gameKeyFactory.FIRE)
    }

}


