package com.cmgcode.dailies.binarytreeserialization

import org.junit.Test
import kotlin.test.assertEquals

class NodeTest {

    private val serializedNodeWithNoChildren = "(RootNode, null, null)"
    private val serializedNodeWithChildren = "(RootNode, (LeftChild, null, null), (RightChild, null, null))"
    private val serializedNodeWithGrandChildren = "(RootNode, " +
            "(LeftChild, (LeftLeftGrandchild, null, null), (LeftRightGrandchild, null, null)), " +
            "(RightChild, (RightLeftGrandchild, null, null), (RightRightGrandchild, null, null))" +
        ")"

    private val nodeWithNoChildren: Node = Node("RootNode")
    private val nodeWithChildren: Node
    private val nodeWithGrandchildren: Node

    init {
        nodeWithChildren = nodeWithNoChildren.clone()
        nodeWithChildren.leftNode = Node("LeftChild")
        nodeWithChildren.rightNode = Node("RightChild")

        nodeWithGrandchildren = nodeWithChildren.clone()
        nodeWithGrandchildren.leftNode?.leftNode = Node("LeftLeftGrandchild")
        nodeWithGrandchildren.leftNode?.rightNode = Node("LeftRightGrandchild")
        nodeWithGrandchildren.rightNode?.leftNode = Node("RightLeftGrandchild")
        nodeWithGrandchildren.rightNode?.rightNode = Node("RightRightGrandchild")
    }

    @Test
    fun childrenAreAccessible() {
        assertEquals("LeftChild", nodeWithChildren.leftNode?.name)
        assertEquals("RightChild", nodeWithChildren.rightNode?.name)
    }

    @Test
    fun nodeIsSerializable()
            = assertEquals(serializedNodeWithNoChildren, nodeWithNoChildren.toString())

    @Test
    fun nodeChildrenAreSerializable()
            = assertEquals(serializedNodeWithChildren, nodeWithChildren.toString())

    @Test
    fun nodeGrandchildrenAreSerializable() =
            assertEquals(serializedNodeWithGrandChildren, nodeWithGrandchildren.toString())

    @Test
    fun nodeIsDeserializable()
            = assertEquals("RootNode", Node.deserialize(serializedNodeWithChildren)?.name)

    @Test
    fun nodeWithChildrenIsDeserializable(){
        val deserializedChild = Node.deserialize(serializedNodeWithChildren)
        assertEquals("RootNode", deserializedChild?.name)
        assertEquals("LeftChild", deserializedChild?.leftNode?.name)
        assertEquals("RightChild", deserializedChild?.rightNode?.name)
    }

    @Test
    fun nodeWithGrandchildrenIsDeserializable(){
        val deserializedChild = Node.deserialize(serializedNodeWithGrandChildren)
        assertEquals("RootNode", deserializedChild?.name)
        assertEquals("LeftChild", deserializedChild?.leftNode?.name)
        assertEquals("LeftLeftGrandchild", deserializedChild?.leftNode?.name)
        assertEquals("LeftRightGrandchild", deserializedChild?.rightNode?.name)
        assertEquals("RightChild", deserializedChild?.rightNode?.name)
        assertEquals("RightLeftGrandchild", deserializedChild?.leftNode?.name)
        assertEquals("RightRightGrandchild", deserializedChild?.rightNode?.name)
    }
}