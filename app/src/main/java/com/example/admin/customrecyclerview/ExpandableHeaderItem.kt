package com.example.admin.customrecyclerview

import com.xwray.groupie.ExpandableGroup
import com.xwray.groupie.ExpandableItem
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.item_expandable_header.*

class ExpandableHeaderItem(private val title: String) : Item(), ExpandableItem {

    lateinit var expandableGr: ExpandableGroup


    override fun setExpandableGroup(onToggleListener: ExpandableGroup) {
        expandableGr = onToggleListener
    }

    override fun bind(viewHolder: ViewHolder, position: Int) {
        viewHolder.item_expandable_header_title.text = title
        viewHolder.item_expandable_header_icon.setImageResource(getRotatedIconsId())

        viewHolder.item_expandable_header_root.setOnClickListener {
            expandableGr.onToggleExpanded()
            viewHolder.item_expandable_header_icon.setImageResource(getRotatedIconsId())
        }
    }

    override fun getLayout()= R.layout.item_expandable_header


    private fun getRotatedIconsId() =
            if(expandableGr.isExpanded)
                R.drawable.ic_keyboard_arrow_up_black_24dp
            else
                R.drawable.ic_keyboard_arrow_down_black_24dp
}