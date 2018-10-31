package com.cmgcode.dailies.binarytreeserialization

data class Node(
        var name: String,
        var leftNode: Node?,
        var rightNode: Node?
){
    constructor(name: String): this(name, null, null)

    fun clone(): Node = copy().apply {
        leftNode = leftNode?.clone()
        rightNode = rightNode?.clone()
    }

    override fun toString(): String
            = "($name, ${leftNode.toString()}, ${rightNode.toString()})"

    companion object {
        fun deserialize(serializedNode: String): Node? {
            var nodeString = serializedNode.trim()

            if(nodeString.first() == '('){
                nodeString = nodeString.drop(1).dropLast(1)
            }

            val nodeParts = nodeString.split(",").toMutableList()

            return Node(nodeParts.first()).apply {
                nodeParts.removeAt(0)

                try{
                    if(nodeParts[0].contains('(')){
                        leftNode = deserialize(nodeParts.subList(0, 3).joinToString(","))
                        for(i in 0..2){
                            nodeParts.removeAt(0)
                        }
                    }else{
                        nodeParts.removeAt(0)
                    }

                    if(nodeParts[0].contains('(')){
                        rightNode = deserialize(nodeParts.subList(0, 3).joinToString(","))
                    }
                }catch (e: IllegalArgumentException){ }
            }
        }
    }
}