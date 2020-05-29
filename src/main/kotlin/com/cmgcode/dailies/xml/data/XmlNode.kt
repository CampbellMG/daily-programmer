package com.cmgcode.dailies.xml.data


data class XmlNode(
        val id: Int,
        var name: String,
        var value: String?,
        var attributes: MutableMap<String, String>,
        val children: MutableList<XmlNode>
) {
    fun flatten(): List<XmlNode> = listOf(this) + children.flatMap { it.flatten() }

    fun getById(id: Int): XmlNode? {
        if (this.id == id) {
            return this
        }

        return children
                .asSequence()
                .mapNotNull { it.getById(id) }
                .firstOrNull()
    }

    fun search(searchValue: String): List<XmlNode> =
            (if (matchesSearchValue(searchValue)) listOf(this) else listOf()) +
                    children.flatMap { it.search(searchValue) }

    private fun matchesSearchValue(searchValue: String): Boolean {
        val formattedSearchValue = searchValue.toLowerCase().trim()
        return name.toLowerCase().contains(formattedSearchValue)
                || value?.toLowerCase()?.contains(formattedSearchValue) == true
                || attributes.any { it.key.toLowerCase().contains(formattedSearchValue) || it.value.toLowerCase().contains(formattedSearchValue) }
    }

    override fun toString(): String {
        return "<$name ($id)>$value</$name>"
    }
}
