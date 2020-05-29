package com.cmgcode.dailies.xml

import org.junit.Test

class ParserTest{
    @Test
    fun name() {
        val file = Parser().parseInputStream("C:\\Users\\campbell\\IdeaProjects\\Test Projects\\daily-programmer\\src\\test\\kotlin\\com\\cmgcode\\dailies\\xml\\config.xml")
        val flatMap = file.rootNode.flatten()
        print(file.toString())
    }
}
